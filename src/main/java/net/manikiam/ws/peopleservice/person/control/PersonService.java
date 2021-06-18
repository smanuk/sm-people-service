package net.manikiam.ws.peopleservice.person.control;

import lombok.extern.slf4j.Slf4j;
import net.manikiam.ws.peopleservice.person.boundary.PersonRepository;
import net.manikiam.ws.peopleservice.person.boundary.exceptions.ObjectNotFoundException;
import net.manikiam.ws.peopleservice.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPeople() {

        Iterable<Person> people = personRepository.findAll();

        List<Person> peopleList = new ArrayList<>();
        people.forEach(peopleList::add);

        return peopleList;
    }

    public Person getPerson(Long id) {

        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }

        throw new ObjectNotFoundException(Person.class, id);
    }

    public Person newPerson(Person person) {

        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person person) {

        getPerson(id);
        //TODO we can put JaVers in here to check if the entity has changed
        return personRepository.save(person);
    }

    public void detelePerson(Long id) {

        personRepository.delete(getPerson(id));
    }

}
