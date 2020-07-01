package it.simonecelia.ws.service;

import it.simonecelia.ws.entity.Person;
import it.simonecelia.ws.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("personService")
@Transactional
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Optional<Person> getById(int id) {
		return personRepository.findById(id);
	}
}
