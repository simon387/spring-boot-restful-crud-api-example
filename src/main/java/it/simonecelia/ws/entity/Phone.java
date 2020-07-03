package it.simonecelia.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static it.simonecelia.ws.constants.Constants.ID;
import static it.simonecelia.ws.constants.Constants.PHONE;

@Entity
@Table(name = PHONE)
@SuppressWarnings("unused")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID)
	private int id;

	@ManyToOne(targetEntity = PersonEntity.class)
	@JsonIgnore
	private PersonEntity personEntity;
	private String phone;

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

