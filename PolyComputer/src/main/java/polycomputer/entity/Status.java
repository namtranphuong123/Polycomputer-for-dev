package polycomputer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "Status")
public class Status implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer statusId;
	String statusName;	
//	String imageStatus;
//	String description;	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "created_At")
//	Date createdAt = new Date();	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "updated_At")
//	Date updatedAt = new Date();
	@JsonIgnore
	@OneToMany(mappedBy = "statusId", fetch = FetchType.LAZY)
	 List<Order> orders; 

}