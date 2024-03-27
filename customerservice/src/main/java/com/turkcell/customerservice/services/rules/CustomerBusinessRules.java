package com.turkcell.customerservice.services.rules;

import com.turkcell.customerservice.core.exception.types.BusinessException;
import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.repositories.CustomerRepository;
import com.turkcell.customerservice.services.messages.CustomerMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerBusinessRules
{
    private final CustomerRepository customerRepository;


    public void customerWithSameNationalityIdCanNotExist(int nationalityId)
    {
        Optional<Customer> customer = customerRepository.findByNationalityId(nationalityId);

        if(customer.isPresent())
            throw new BusinessException(CustomerMessages.customerExistsWithSameNationalityId);
    }
}
