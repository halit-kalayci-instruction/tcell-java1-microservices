package com.turkcell.orderservice.controllers;

import com.turkcell.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController
{
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    @GetMapping
    public int getCustomerIdByOrderId(@RequestParam String orderId)
    {
        //TODO: Mongodb'e gidip query ile çek.
        System.out.println("İşlem yapılıyor..");
        /*try{
            Thread.sleep(10000);
        }
        catch(Exception e){}*/
        return 10;
    }
    @PostMapping
    public String addOrder()
    {
        kafkaTemplate.send("orderTopic","NewOrderEvent", new OrderCreatedEvent(1, LocalDateTime.now()));
        return "Sipariş eklendi..";
    }
}
