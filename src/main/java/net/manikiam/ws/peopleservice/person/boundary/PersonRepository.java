package net.manikiam.ws.peopleservice.person.boundary;

import net.manikiam.ws.peopleservice.person.entiry.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
