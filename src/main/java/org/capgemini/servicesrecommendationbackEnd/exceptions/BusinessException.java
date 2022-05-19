package org.capgemini.servicesrecommendationbackEnd.exceptions;

public class BusinessException extends RuntimeException{

    ErrorsMessage errorsMessage;
    public BusinessException(String message){
        super(message);
    }
}
