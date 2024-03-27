package com.turkcell.customerservice.core.exception.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails {
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setType("https://turkcell.com/exceptions/validation");
    }

    private String[] errors;
}
