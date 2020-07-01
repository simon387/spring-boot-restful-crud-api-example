package boot;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ashamsutdinov on 02.08.2017.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
