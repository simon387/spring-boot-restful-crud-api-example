package it.simonecelia.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.simonecelia.ws.entity.Person;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@SuppressWarnings("unused")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(targetEntity = Person.class)
	@JsonIgnore
	private Person person;
	private String phone;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

