package com.turkcell.customerservice.controllers;

import com.turkcell.customerservice.services.abstracts.CustomerService;
import com.turkcell.customerservice.services.dtos.requests.AddCustomerRequest;
import com.turkcell.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.customerservice.services.dtos.responses.AddCustomerResponse;
import com.turkcell.customerservice.services.dtos.responses.SearchCustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @PostMapping("search")
    public List<SearchCustomerResponse> search(@RequestBody SearchCustomerRequest request)
    {
        return customerService.search(request);
    }
    @PostMapping
    public AddCustomerResponse add(@RequestBody @Valid AddCustomerRequest request)
    {
        return customerService.add(request);
    }
}
