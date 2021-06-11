package net.manikiam.ws.peopleservice.person.boundary;

import lombok.extern.slf4j.Slf4j;
import net.manikiam.ws.peopleservice.person.control.PersonService;
import net.manikiam.ws.peopleservice.person.entiry.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getPeople() {

        return personService.getPeople();
    }

    @GetMapping("{id}")
    public Person getPerson(@PathVariable("id") String id) {

        return Person.builder()
                .firstName("James")
                .lastName("Kirk")
                .dateOfBirth(LocalDate.of(2233, 3, 22))
                .countryCode("us")
                .build();
    }


    @PostMapping
    public Person newPerson(Person person) {

        return person;
    }
}
