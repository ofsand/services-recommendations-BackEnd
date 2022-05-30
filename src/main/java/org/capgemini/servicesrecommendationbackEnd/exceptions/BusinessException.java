package org.capgemini.servicesrecommendationbackEnd.exceptions;

public class BusinessException extends RuntimeException{

    ErrorsMessage errorsMessage;
    public BusinessException(ErrorsMessage errorsMessage){
             this.errorsMessage=errorsMessage;
    }

    public ErrorsMessage getErrorsMessage() {
        return errorsMessage;
    }
}
