package com.turkcell.customerservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCustomerResponse
{
    private int id;
    private String customerId;
    private int nationalityId;
    private String gsmNumber;
    private String firstName;
    private String lastName;
    private String secondName;
}
