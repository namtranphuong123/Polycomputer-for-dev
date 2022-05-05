package polycomputer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import polycomputer.entity.ChipDoHoa;
import polycomputer.service.BrandService;
import polycomputer.service.CPUSerieService;
import polycomputer.service.CategoryService;
import polycomputer.service.ChipDoHoaService;
import polycomputer.service.ColorService;
import polycomputer.service.RAMService;


@Component
public class GlobalInterceptor implements HandlerInterceptor{
@Autowired
CategoryService categoryservice;
@Autowired
 CPUSerieService cpu;
@Autowired
ChipDoHoaService chip;
@Autowired
RAMService ram;
@Autowired
ColorService cl;
@Autowired
BrandService br;
@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
request.setAttribute("cates", categoryservice.findAll());
request.setAttribute("cpu", cpu.findAll());
request.setAttribute("chips", chip.findAll());
request.setAttribute("rams", ram.findAll());
request.setAttribute("colors", cl.findAll());
request.setAttribute("brand", br.findAll());
}


}
