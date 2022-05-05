package polycomputer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "Stars")
public class Star implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer starId;
	String starName;
	String starImage;
//	String imageStatus;
//	String description;	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "created_At")
//	Date createdAt = new Date();	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "updated_At")
//	Date updatedAt = new Date();	
	@JsonIgnore
	@OneToOne(mappedBy = "star")
    Rating ratings;  
}