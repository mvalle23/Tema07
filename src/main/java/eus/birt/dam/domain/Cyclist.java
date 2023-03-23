package eus.birt.dam.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cyclist")
public class Cyclist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_date")
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	private String nationality;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn (name = "team_id")
	private Team team;

	//Añade propiedad teamName a JSON 
	@JsonProperty("teamName")
	public String getTeamName() {
	    return team != null ? team.getName() : null;
	}

	public Cyclist(String firstName, String lastName, LocalDate birthDate, String nationality, Team team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.team = team;
	}
}
