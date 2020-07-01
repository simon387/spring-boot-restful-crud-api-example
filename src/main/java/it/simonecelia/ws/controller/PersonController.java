package it.simonecelia.ws.controller;

import it.simonecelia.ws.entity.Person;
import it.simonecelia.ws.entity.Phone;
import it.simonecelia.ws.repository.PersonRepository;
import it.simonecelia.ws.repository.PhoneRepository;
import it.simonecelia.ws.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class PersonController {

	private final PersonRepository personRepository;

	private final PhoneRepository phoneRepository;

	private final PersonService personService;

	public PersonController(PersonRepository personRepository, PhoneRepository phoneRepository, PersonService personService) {
		this.personRepository = personRepository;
		this.phoneRepository = phoneRepository;
		this.personService = personService;
	}

	@GetMapping(path = "/get")
	@ResponseBody
	public Optional<Person> get(@RequestParam int id) {
		return personService.getById(id);
	}

	@GetMapping(path = "/delete")
	@ResponseBody
	public void delete(@RequestParam int id) {
		personRepository.deleteById(id);
	}

	@GetMapping(path = "/add")
	@ResponseBody
	public Optional<Person> add(@RequestParam(value = "name") String name, @RequestParam(value = "phone", required = false) String phone) {
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

	@GetMapping(path = "/edit")
	@ResponseBody
	public Optional<Person> edit(@RequestParam(value = "id") int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "phone", required = false) String phone) {
		Optional<Person> personOptional = personRepository.findById(id);
		if (personOptional.isPresent()) {
			Person personEntity = personOptional.get();
			if (name != null) {
				personEntity.setName(name);
				personRepository.save(personEntity);
			}
			if (phone != null) {
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
