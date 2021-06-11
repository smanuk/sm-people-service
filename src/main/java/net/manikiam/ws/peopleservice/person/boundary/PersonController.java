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
    public Person getPerson(@PathVariable("id") Long id) {

        return personService.getPerson(id);
    }

    @PostMapping
    public Person newPerson(@RequestBody Person person) {

        return personService.newPerson(person);
    }

    @PutMapping("{id}")
    public Person updatePerson(@PathVariable("id")Long id, @RequestBody Person person) {

        return personService.updatePerson(id, person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id")Long id) {

        personService.detelePerson(id);
    }
}
