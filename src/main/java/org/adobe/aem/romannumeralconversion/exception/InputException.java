package org.adobe.aem.romannumeralconversion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception class is to handle the use-case where we have non-integer input
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputException extends RuntimeException{

    public InputException(String message) {
        super(message);
    }
}
