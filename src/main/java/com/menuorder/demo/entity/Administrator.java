package com.menuorder.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Administrator {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

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


    public Administrator(){}

    public Administrator(String lastName, String firstName, String userName, String phoneNumber, String password,
    String addressLin1, String addressLine2, String suburb, String state, String country, String postCode ){
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.addressLin1 = addressLin1;
        this.addressLine2 = addressLine2;
        this.suburb = suburb;
        this.state = state;
        this.country = country;
        this.postCode = postCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

}
