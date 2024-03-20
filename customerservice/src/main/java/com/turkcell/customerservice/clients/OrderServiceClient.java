package com.turkcell.customerservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// TODO: Use discovery server (araştırma ve uygulama)
// TODO: Load balancing (araştırma)
@FeignClient(name="orderservice", url="http://localhost:8081")
public interface OrderServiceClient
{
    @GetMapping("/api/orders")
    int getCustomerIdByOrderId(@RequestParam("orderId") String orderId);
}
