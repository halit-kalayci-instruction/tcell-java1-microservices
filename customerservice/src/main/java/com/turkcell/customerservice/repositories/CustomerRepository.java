package com.turkcell.customerservice.repositories;

import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.customerservice.services.dtos.responses.SearchCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("Select new com.turkcell.customerservice.services.dtos.responses." +
            "SearchCustomerResponse(c.customerId, c.firstName, c.lastName, c.secondName, c.nationalityId)" +
            " from Customer c" +
            " where ( :#{#request.getNationalityId()} <= 0 or c.nationalityId= :#{#request.getNationalityId()})" +
            " and ( :#{#request.getCustomerId()} is null or c.customerId= :#{#request.getCustomerId()})")
    List<SearchCustomerResponse> search(SearchCustomerRequest request);

    Optional<Customer> findByNationalityId(int nationalityId);
}
