package com.turkcell.orderservice.repositories;

import com.turkcell.orderservice.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository  extends MongoRepository<Order, String>
{
}
