package net.manikiam.ws.peopleservice.person.boundary;

import net.manikiam.ws.peopleservice.person.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
