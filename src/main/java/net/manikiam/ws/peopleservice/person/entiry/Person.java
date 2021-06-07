package net.manikiam.ws.peopleservice.person.entiry;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String countryCode;
}
