
package polycomputer;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import polycomputer.entity.Account;
import polycomputer.service.AccountService;


@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Autowired
AccountService accountservice;
@Autowired
@Lazy
private BCryptPasswordEncoder pe;


/*
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception{
 */
/*
 * auth.inMemoryAuthentication()
 * .withUser("user1").password(pe.encode("123")).roles("GUEST") .and()
 * .withUser("user2").password(pe.encode("123")).roles("USER ","GUEST") .and()
 * .withUser("user3").password(pe.encode("123")).roles("ADMIN ","USER ","GUEST")
 * ;
 * 
 * }
 */

// cung cấp dữ liệu đăng nhập

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	  auth.inMemoryAuthentication()
//	   .withUser("user1").password(pe.encode("123")).roles("USER") .and()
//	  .withUser("user3").password(pe.encode("123")).roles("STAFF ","USER ") .and()
//	 .withUser("user4").password(pe.encode("123")).roles("STAFF","DIRE");
	auth.userDetailsService(username -> {
		try {
			Account user = accountservice.findById(username);
			String password = user.getPassword();
			String [] roles = user.getAuthorities().stream()
					.map(er -> er.getRole().getRoleId())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username).password(password).roles(roles).build();
			
		} catch (NoSuchElementException e) {
throw new UsernameNotFoundException(username + "Not found !");

		}
	});
}
 
	// phân quyền
@Override
protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/order/**").authenticated() // order thi phai dang nhap(authenticated())
		.antMatchers("/admin/**").hasAnyRole("STAFF","DIRE") // phan quyen giam doc nhan vien khach hang
		.antMatchers("/rest/authorities").hasRole("DIRE")
		// tất cả các req khác thì cho phép thông
		.anyRequest().permitAll();
		
		http.formLogin()
		.loginPage("/security/login/form")
		.loginProcessingUrl("/security/login")
		//khi lgin thành công thì chuyển page
		.defaultSuccessUrl("/security/login/success",false)
		.failureUrl("/security/login/error");
		
		http.rememberMe() 
		.tokenValiditySeconds(86400);
		
		http.exceptionHandling()
		.accessDeniedPage("/security/unauthoried");
		
		http.logout()
		.logoutUrl("/security/logoff")
	
		.logoutSuccessUrl("/security/logoff/success");
		
		http.oauth2Login()
		.loginPage("/security/login/form")
		.defaultSuccessUrl("/security2/login/success",true)
		.failureUrl("/security/login/error")
		.authorizationEndpoint()
		//base dùng để khai vào link đăng nhập
		.baseUri("/security2/authorization");
		

}

// co che ma hoa mat khau
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

		// CHO PHEP TRUY XUAT RESTAPT TU BEN NGOAI (DOMAIN KHAC)
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}

}
