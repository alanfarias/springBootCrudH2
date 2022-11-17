package br.alan.friends.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", length = 75, nullable = false)
	@NotEmpty(message = "É necessário informar o campo nome.")
	private String name;
	
	@Column(name = "birth", nullable = false)
	@NotNull(message = "É necessário informar o campo nascimento.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	
	@Column(name = "gender", nullable = false)
	@NotNull(message = "É necessário informar o campo sexo.")
	private Character gender;
	
	@Column(name = "position", nullable = false)
	@NotNull(message = "É necessário informar o campo cargo.")
	private String position;
	
	@Column(name = "office", nullable = false)
	@NotNull(message = "É necessário informar o campo escritório.")	
	private String office; 
	
	@PrePersist @PreUpdate
	private void prePersistPreUpdate() {
		this.name = this.name.toUpperCase();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
	
}
