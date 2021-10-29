package com.alibilgihan.todolist.exception;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus
public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(String message) {
        super(message);
    }

    public ResourcesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
