package com.turkcell.customerservice.core.exception.handlers;

import com.turkcell.customerservice.core.exception.details.BusinessProblemDetails;
import com.turkcell.customerservice.core.exception.details.ProblemDetails;
import com.turkcell.customerservice.core.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException)
    {
        // TODO: Message sistemini
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(businessException.getMessage());
        return problemDetails;
    }
    // TODO : Validation Exception

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleOtherExceptions(){
        ProblemDetails problemDetails = new
                ProblemDetails("Internal Server Error","Some error occured.","https://turkcell.com/exceptions/internal");
        return problemDetails;
    }
}
