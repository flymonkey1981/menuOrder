package com.menuorder.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "address_line1")
    private String addressLin1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "post_code")
    private String postCode;

    private Address(){}

    public Address(String addressLin1, String addressLine2, String suburb, String state, String country, String postCode){
        this.addressLin1 = addressLin1;
        this.addressLine2 = addressLine2;
        this.suburb = suburb;
        this.state = state;
        this.country = country;
        this.postCode = postCode;
    }




}
