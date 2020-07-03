package it.simonecelia.ws.repository;

import it.simonecelia.ws.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
