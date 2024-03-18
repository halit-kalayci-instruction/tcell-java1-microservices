package com.turkcell.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="customers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id; // 1,2,3,4

    @Column(name="customer_id")
    private String customerId; // ABC014

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="nationality_id")
    private int nationalityId;

    @Column(name="gsm_number")
    private String gsmNumber;

    @Column(name="first_name")
    private String firstName;
    // Halit Enes

    @Column(name="last_name")
    private String lastName;

    @Column(name="second_name")
    private String secondName;
}
