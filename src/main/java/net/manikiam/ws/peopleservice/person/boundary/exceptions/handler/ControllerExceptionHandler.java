package net.manikiam.ws.peopleservice.person.boundary.exceptions.handler;

import net.manikiam.ws.peopleservice.person.boundary.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class ControllerExceptionHandler {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetails handleObjectNotFoundException(ObjectNotFoundException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(getTimestamp(), exception.getMessage(), getDetails(request));
        return errorDetails;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ConstraintErrorDetails handleConstraintViolationException(MethodArgumentNotValidException exception, WebRequest request) {


        ConstraintErrorDetails errorDetails = new ConstraintErrorDetails(getTimestamp(), getDetails(request));

        for (ObjectError error : exception.getBindingResult().getAllErrors()) {

            String objectName = error.getObjectName();
            String message = error.getDefaultMessage();
            String field = "N/A";
            if (error instanceof FieldError) {
                field = ((FieldError)error).getField();
            }

            errorDetails.addDetails(objectName, field, message);
        }

        return errorDetails;
    }

    private String getDetails(WebRequest request) {

        return String.format("%s, %s", ((ServletWebRequest)request).getRequest().getMethod(), request.getDescription(false));
    }

    private String getTimestamp() {
        return LocalDateTime.now().format(formatter);
    }
}
