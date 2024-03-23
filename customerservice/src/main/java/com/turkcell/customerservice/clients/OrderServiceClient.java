package com.turkcell.customerservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="orderservice")
public interface OrderServiceClient
{
    @GetMapping("/api/orders")
    int getCustomerIdByOrderId(@RequestParam("orderId") String orderId);
}
// Projeye docker-compose entegrasyonu
// Tüm sistemlerin service-discovery ile çalışması
// API GATEWAY araştırma
// 9:30-10:30