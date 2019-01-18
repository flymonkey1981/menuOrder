package com.menuorder.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "chef")
public class Chef {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@GeneratedValue
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

    //@ManyToOne(optional = true)
   // @JoinColumn(name="order_id")
   // private Order order;

    public Chef(){

    }

    public Chef(String lastName, String firstName, String userName, String phoneNumber, String password){
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    //public void setOrder(Order order){
   //     this.order = order;
   // }

}
