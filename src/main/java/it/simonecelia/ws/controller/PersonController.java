package it.simonecelia.ws.controller;

import it.simonecelia.ws.entity.Person;
import it.simonecelia.ws.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
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
		personService.deleteById(id);
	}

	@GetMapping(path = "/add")
	@ResponseBody
	public Optional<Person> add(@RequestParam(value = "name") String name, @RequestParam(value = "phone", required = false) String phone) {
		return personService.add(name, phone);
	}

	@GetMapping(path = "/edit")
	@ResponseBody
	public Optional<Person> edit(@RequestParam(value = "id") int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "phone", required = false) String phone) {
		return personService.edit(id, name, phone);
	}
}
