package com.turkcell.orderservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
public class OrdersController
{
    @GetMapping
    public int getCustomerIdByOrderId(@RequestParam String orderId)
    {
        //TODO: Mongodb'e gidip query ile çek.
        System.out.println("İşlem yapılıyor..");
        try{
            Thread.sleep(10000);
        }
        catch(Exception e){}
        return 10;
    }
}
