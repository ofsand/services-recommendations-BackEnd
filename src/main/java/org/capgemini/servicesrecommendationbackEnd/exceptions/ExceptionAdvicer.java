package org.capgemini.servicesrecommendationbackEnd.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class ExceptionAdvicer {
    Logger logger = Logger.getAnonymousLogger();

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiExceptionError> handleNotFoundException(BusinessException exception, HttpServletRequest request){
        ApiExceptionError error=new ApiExceptionError(exception.errorsMessage.getHttpStatus().value()
                ,exception.errorsMessage.getMessage()
                ,request.getServletPath());
        logger.log(Level.SEVERE,"no such element exception "+exception.getMessage(),exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiExceptionError> handleMethodArgNotValid (MethodArgumentNotValidException exception, HttpServletRequest request){
        ApiExceptionError error=new ApiExceptionError(400,exception.getMessage(),request.getServletPath());
        logger.log(Level.SEVERE,"Method argument not valid exception "+exception.getMessage(),exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
