package it.simonecelia.ws.controller;

import it.simonecelia.ws.dto.PersonDTO;
import it.simonecelia.ws.entity.Person;
import it.simonecelia.ws.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import static it.simonecelia.ws.constants.Constants.*;

@Controller
@RequestMapping(path = "/api")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping(path = "/get")
	@ResponseBody
	public Optional<PersonDTO> get(@RequestParam int id) {
		Optional<Person> optional = personService.getById(id);

		if (optional.isPresent()) {
			Person person = optional.get();
			return Optional.of(person.getDTO());
		} else {
			return null;
		}
	}

	@GetMapping(path = "/delete")
	@ResponseBody
	public void delete(@RequestParam int id) {
		personService.deleteById(id);
	}

	@GetMapping(path = "/add")
	@ResponseBody
	public Optional<Person> add(@RequestParam(value = NAME) String name, @RequestParam(value = PHONE, required = false) String phone) {
		return personService.add(name, phone);
	}

	@GetMapping(path = "/edit")
	@ResponseBody
	public Optional<Person> edit(@RequestParam(value = ID) int id, @RequestParam(value = NAME, required = false) String name, @RequestParam(value = PHONE, required = false) String phone) {
		return personService.edit(id, name, phone);
	}
}
