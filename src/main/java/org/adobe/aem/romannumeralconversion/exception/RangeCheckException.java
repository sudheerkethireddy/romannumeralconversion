package org.adobe.aem.romannumeralconversion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This java class is to handle the exception to check if input integer number
 * is within the range.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class RangeCheckException extends  RuntimeException{

    public RangeCheckException(String errorMessage) {
        super(errorMessage);
    }
}
