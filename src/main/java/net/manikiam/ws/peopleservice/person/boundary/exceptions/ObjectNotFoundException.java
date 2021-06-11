package net.manikiam.ws.peopleservice.person.boundary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String type;
    private Object key;

    public ObjectNotFoundException(Class<?> type, Object key) {
        super("Object with key [" + key + "] class [" + type.getSimpleName() + "] not found");
        this.type = type.getSimpleName();
        this.key = key;
    }

    public ObjectNotFoundException(Class<?> type, Object key, String message) {
        super(message);
        this.type = type.getSimpleName();
        this.key = key;
    }

    public ObjectNotFoundException(Class<?> type, Object key, Throwable cause) {
        super("Object with key [" + key + "] class [" + type.getSimpleName() + "] not found", cause);
        this.type = type.getSimpleName();
        this.key = key;
    }

    public ObjectNotFoundException(Class<?> type, Object key, String message, Throwable cause) {
        super(message, cause);
        this.type = type.getSimpleName();
        this.key = key;
    }

    public Object getKey() {
        return this.key;
    }

    public String getType() {
        return this.type;
    }

}
