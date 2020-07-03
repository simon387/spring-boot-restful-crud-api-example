package it.simonecelia.ws.repository;

import it.simonecelia.ws.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
}
