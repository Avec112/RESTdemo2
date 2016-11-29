package no.avec.repository;

import no.avec.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by avec on 25/11/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByLastName(String lastName);
    List<Person> findByFirstName(String firstName);

}
