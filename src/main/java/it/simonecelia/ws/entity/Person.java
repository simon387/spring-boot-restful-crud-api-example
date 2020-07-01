package it.simonecelia.ws.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@SuppressWarnings("unused")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String name;
	@OneToMany(mappedBy = "person")
	private List<Phone> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
