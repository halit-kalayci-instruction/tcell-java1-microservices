package com.turkcell.customerservice.core.exception.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BusinessProblemDetails extends ProblemDetails
{
    public BusinessProblemDetails() {
        setType("https://turkcell.com/exceptions/business");
        setTitle("Business Rule Violation");
    }
}
