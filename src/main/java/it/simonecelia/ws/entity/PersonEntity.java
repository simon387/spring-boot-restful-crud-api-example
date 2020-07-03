package it.simonecelia.ws.entity;

import javax.persistence.*;
import java.util.List;

import static it.simonecelia.ws.constants.Constants.*;

@Entity
@Table(name = PERSON)
@SuppressWarnings("unused")
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID)
	private int id;

	@Column(name = NAME)
	private String name;

	@OneToMany(mappedBy = PERSON)
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
