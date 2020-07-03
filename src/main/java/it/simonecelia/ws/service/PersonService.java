package it.simonecelia.ws.service;

import it.simonecelia.ws.entity.PersonEntity;
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

	public Optional<PersonEntity> getById(int id) {
		return personRepository.findById(id);
	}

	public void deleteById(int id) {
		personRepository.deleteById(id);
	}

	public Optional<PersonEntity> add(String name, String phone) {
		PersonEntity personEntity = new PersonEntity();
		Phone phoneEntity = new Phone();

		phoneEntity.setPersonEntity(personEntity);
		phoneEntity.setPhone(phone);
		personEntity.setPhones(new ArrayList<>());
		personEntity.getPhones().add(phoneEntity);
		personEntity.setName(name);

		personRepository.save(personEntity);
		phoneRepository.save(phoneEntity);

		return Optional.of(personEntity);
	}

	public Optional<PersonEntity> edit(int id, String name, String phone) {
		Optional<PersonEntity> personOptional = personRepository.findById(id);
		if (personOptional.isPresent()) {
			PersonEntity personEntity = personOptional.get();
			if (null != name) {
				personEntity.setName(name);
				personRepository.save(personEntity);
			}
			if (null != phone) {
				Phone phoneEntity = new Phone();
				phoneEntity.setPhone(phone);
				phoneEntity.setPersonEntity(personEntity);
				List<Phone> phones = personEntity.getPhones();
				phones.add(phoneEntity);
				personRepository.save(personEntity);
				phoneRepository.save(phoneEntity);
			}
		}
		return personRepository.findById(id);
	}
}
