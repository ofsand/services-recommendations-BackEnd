package org.capgemini.servicesrecommendationbackEnd.exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorsMessage {
    NOT_FOUD_USER("user not found",
            HttpStatus.NOT_FOUND);



    private String message;
    private HttpStatus httpStatus;

    ErrorsMessage(String message, HttpStatus status) {
        this.message=message;
        this.httpStatus=status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
