package eus.birt.dam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="team")
public class Team implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String city;
	
	private String nationality;
	
	private String manager;
	
	@JsonManagedReference
	@OneToMany (mappedBy = "team",cascade = CascadeType.ALL)
	List <Cyclist> cyclists = new ArrayList<>();

	public Team(String name, String city, String nationality, String manager) {
		super();
		this.name = name;
		this.city = city;
		this.nationality = nationality;
		this.manager = manager;
	}
	
	
}
