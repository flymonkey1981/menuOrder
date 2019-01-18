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


    public Administrator(){}

    public Administrator(String lastName, String firstName, String userName, String phoneNumber, String password){
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
