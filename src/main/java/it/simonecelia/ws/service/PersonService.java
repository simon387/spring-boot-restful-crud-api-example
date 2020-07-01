package it.simonecelia.ws.service;

import it.simonecelia.ws.entity.Person;
import it.simonecelia.ws.entity.Phone;
import it.simonecelia.ws.repository.PersonRepository;
import it.simonecelia.ws.repository.PhoneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("personService")
@Transactional
public class PersonService {

	private final PersonRepository personRepository;
	private final PhoneRepository phoneRepository;

	public PersonService(PersonRepository personRepository, PhoneRepository phoneRepository) {
		this.personRepository = personRepository;
		this.phoneRepository = phoneRepository;
	}

	public Optional<Person> getById(int id) {
		return personRepository.findById(id);
	}

	public void deleteById(int id) {
		personRepository.deleteById(id);
	}

	public Optional<Person> add(String name, String phone) {
		Person personEntity = new Person();
		Phone phoneEntity = new Phone();

		phoneEntity.setPerson(personEntity);
		phoneEntity.setPhone(phone);
		personEntity.setPhones(new ArrayList<>());
		personEntity.getPhones().add(phoneEntity);
		personEntity.setName(name);

		personRepository.save(personEntity);
		phoneRepository.save(phoneEntity);

		return Optional.of(personEntity);
	}

	public Optional<Person> edit(int id, String name, String phone) {
		Optional<Person> personOptional = personRepository.findById(id);
		if (personOptional.isPresent()) {
			Person personEntity = personOptional.get();
			if (null != name) {
				personEntity.setName(name);
				personRepository.save(personEntity);
			}
			if (null != phone) {
				Phone phoneEntity = new Phone();
				phoneEntity.setPhone(phone);
				phoneEntity.setPerson(personEntity);
				List<Phone> phones = personEntity.getPhones();
				phones.add(phoneEntity);
				personRepository.save(personEntity);
				phoneRepository.save(phoneEntity);
			}
		}
		return personRepository.findById(id);
	}
}
