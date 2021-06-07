package net.manikiam.ws.peopleservice.person.boundary.dto;

import net.manikiam.ws.peopleservice.person.entiry.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "v1/people")
public class PersonController {

    @GetMapping
    public List<Person> getPeople() {

        return Collections.emptyList();
    }
}
