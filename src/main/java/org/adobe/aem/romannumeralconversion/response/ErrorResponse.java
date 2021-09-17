package org.adobe.aem.romannumeralconversion.response;

import org.springframework.http.HttpStatus;

/**
 * This POJO class holds the error details that needs to be rendered
 */
public class ErrorResponse {

    //http status code
    private HttpStatus status;

    // customer error message to the client API
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}