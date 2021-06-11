package net.manikiam.ws.peopleservice.person.control;

import lombok.extern.slf4j.Slf4j;
import net.manikiam.ws.peopleservice.person.boundary.PersonRepository;
import net.manikiam.ws.peopleservice.person.boundary.exceptions.ObjectNotFoundException;
import net.manikiam.ws.peopleservice.person.entiry.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
    
    public Person newPerson(Person person) {

        return personRepository.save(person);
    }
}
