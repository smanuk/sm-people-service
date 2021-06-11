package net.manikiam.ws.peopleservice.person.boundary.exceptions.handler;

import net.manikiam.ws.peopleservice.person.boundary.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleObjectNotFoundException(ObjectNotFoundException exception, WebRequest request) {

        String details = String.format("%s, %s", ((ServletWebRequest)request).getRequest().getMethod(), request.getDescription(false));
        ErrorDetails errorDetails = new ErrorDetails(formatter.format(new Date()), exception.getMessage(), details);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
