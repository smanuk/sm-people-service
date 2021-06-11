package net.manikiam.ws.peopleservice.person.entiry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Id
    private Long id;

    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @NotNull(message = "Date of birth must not be null")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Country code must not be blank")
    private String countryCode;
}
