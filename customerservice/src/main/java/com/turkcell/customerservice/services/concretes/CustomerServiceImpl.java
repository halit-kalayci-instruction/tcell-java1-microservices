package com.turkcell.customerservice.services.concretes;

import com.turkcell.customerservice.repositories.CustomerRepository;
import com.turkcell.customerservice.services.abstracts.CustomerService;
import com.turkcell.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.customerservice.services.dtos.responses.SearchCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
// 8:55
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final WebClient.Builder webClient;
    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        var result = webClient.build()
                .get()
                .uri("http://localhost:8081/api/orders?orderId="+request.getOrderNumber())
                .retrieve()
                .bodyToMono(Integer.class)
                .block(); // async durumu sync hale getiren fonk.
        System.out.println("Order servisten gelen sonuç:"+result);
        return customerRepository.search(request);
    }
}
// 9:20