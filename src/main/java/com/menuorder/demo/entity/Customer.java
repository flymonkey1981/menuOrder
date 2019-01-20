package com.menuorder.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

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

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;


    private Customer() {}

    public Customer(String lastName, String firstName, String email, String phoneNumber,
                    String addressLin1, String addressLine2, String suburb, String state, String country, String postCode, String userName, String password){
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressLin1 = addressLin1;
        this.addressLine2 = addressLine2;
        this.suburb = suburb;
        this.state = state;
        this.country = country;
        this.postCode = postCode;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getUserName() {return this.userName;}

    public String getPassword() {return this.password;}
}
