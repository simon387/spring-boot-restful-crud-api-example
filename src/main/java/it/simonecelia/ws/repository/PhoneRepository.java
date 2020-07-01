package it.simonecelia.ws.repository;

import it.simonecelia.ws.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {
}
