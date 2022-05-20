package org.capgemini.servicesrecommendationbackEnd.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiExceptionError {
    int status;
    String message;
    long timestamp;
    String path;

    public ApiExceptionError(int status, String message, String path){
        super();
        this.status=status;
        this.message=message;
        this.path=path;
        this.timestamp=new Date().getTime();
    }

}
