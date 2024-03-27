package com.turkcell.customerservice.services.concretes;

import com.turkcell.customerservice.clients.OrderServiceClient;
import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.repositories.CustomerRepository;
import com.turkcell.customerservice.services.abstracts.CustomerService;
import com.turkcell.customerservice.services.dtos.requests.AddCustomerRequest;
import com.turkcell.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.customerservice.services.dtos.responses.AddCustomerResponse;
import com.turkcell.customerservice.services.dtos.responses.SearchCustomerResponse;
import com.turkcell.customerservice.services.rules.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderServiceClient orderServiceClient;

    private final CustomerBusinessRules customerBusinessRules;

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        int result = orderServiceClient.getCustomerIdByOrderId(request.getOrderNumber());
        return customerRepository.search(request);
    }
    @Override
    public AddCustomerResponse add(AddCustomerRequest request) {
        customerBusinessRules.customerWithSameNationalityIdCanNotExist(request.getNationalityId());

        Customer customer = new Customer(); // TODO: Automap
        customer.setFirstName(request.getFirstName());
        customer.setSecondName(request.getSecondName());
        customer.setLastName(request.getLastName());
        customer.setNationalityId(request.getNationalityId());

        Customer savedCustomer = customerRepository.save(customer);

        AddCustomerResponse response = new
                AddCustomerResponse(savedCustomer.getId(), savedCustomer.getCustomerId(), savedCustomer.getNationalityId(), savedCustomer.getGsmNumber(), savedCustomer.getFirstName(), savedCustomer.getLastName(), savedCustomer.getSecondName());
        return response;
    }
}
