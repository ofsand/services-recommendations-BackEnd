package org.capgemini.servicesrecommendationbackEnd.exceptions;

public class BusinessException extends RuntimeException{

    ErrorsMessageException errorsMessage;
    public BusinessException(ErrorsMessageException errorsMessage){
             this.errorsMessage=errorsMessage;    }

    public ErrorsMessageException getErrorsMessage() {
        return errorsMessage;
    }
}
