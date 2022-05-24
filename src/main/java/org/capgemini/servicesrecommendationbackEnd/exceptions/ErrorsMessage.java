package org.capgemini.servicesrecommendationbackEnd.exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorsMessage {
    NOT_FOUND_USER("user not found",
            HttpStatus.NOT_FOUND),
    NOT_FOUND_ID("Id not found",
            HttpStatus.NOT_FOUND),
    ARGUMENT_NOT_VALID("argument not valid",
            HttpStatus.BAD_REQUEST),
    METHOD_MISMATCH_EXCEPTION("method mismatch exception",
            HttpStatus.BAD_REQUEST);



    private final String message;
    private final HttpStatus httpStatus;

    ErrorsMessage(String message, HttpStatus status) {
        this.message=message;
        this.httpStatus=status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }



    public String getMessage() {
        return message;
    }


}
