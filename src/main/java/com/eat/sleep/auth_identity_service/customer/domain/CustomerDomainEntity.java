package com.eat.sleep.auth_identity_service.customer.domain;


import lombok.Getter;

import java.util.UUID;

@Getter
public class CustomerDomainEntity {

    private UUID id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String cui;
    private int loyaltyPoints;

    public CustomerDomainEntity(UUID id, String fullName, String email, String phone, String address, String cui, int loyaltyPoints) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cui = cui;
        this.loyaltyPoints = loyaltyPoints;
    }

    public CustomerDomainEntity(String fullName, String email, String phone, String address, String cui, int loyaltyPoints) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cui = cui;
        this.loyaltyPoints = loyaltyPoints;
    }
}
