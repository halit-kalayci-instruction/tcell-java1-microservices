package com.turkcell.customerservice.services.abstracts;

import com.turkcell.customerservice.services.dtos.requests.AddCustomerRequest;
import com.turkcell.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.customerservice.services.dtos.responses.AddCustomerResponse;
import com.turkcell.customerservice.services.dtos.responses.SearchCustomerResponse;

import java.util.List;

public interface CustomerService
{
    List<SearchCustomerResponse> search(SearchCustomerRequest request);
    AddCustomerResponse add(AddCustomerRequest request);
}
