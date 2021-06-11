package net.manikiam.ws.peopleservice.person.boundary.exceptions.handler;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorDetails {

    private String timestamp;
    private String message;
    private String details;

    public ErrorDetails(String timestamp, String message, String details) {

        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
