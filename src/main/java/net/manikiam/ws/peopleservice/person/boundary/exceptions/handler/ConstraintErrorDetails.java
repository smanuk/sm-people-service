package net.manikiam.ws.peopleservice.person.boundary.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ConstraintErrorDetails {

    private String timestamp;
    private String details;
    List<ConstraintErrorDetail> constraintErrorDetails;

    public ConstraintErrorDetails(String timestamp, String details) {

        this.timestamp = timestamp;
        this.details = details;
        constraintErrorDetails = new ArrayList<>();
    }

    public void addDetails(String object, String field, String message) {

        constraintErrorDetails.add(new ConstraintErrorDetail(object, field, message));
    }

    @AllArgsConstructor
    @Setter
    @Getter
    private class ConstraintErrorDetail {

        private String object;
        private String field;
        private String message;
    }
}
