package it.simonecelia.ws.dto;

import it.simonecelia.ws.entity.Phone;

import java.util.List;


public class PersonDTO {
	private int id;
	private String name;
	private List<Phone> phones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
