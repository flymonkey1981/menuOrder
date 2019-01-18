package com.menuorder.demo.entity;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "pickup_date")
    @Temporal(TemporalType.DATE)
    private Date pickupDate;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "order_item",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "food_id") }
    )
    private List<Food> foods = new ArrayList<>();

    //@OneToMany(mappedBy="order", cascade = { CascadeType.ALL }, orphanRemoval = true)
    @OneToMany(cascade = { CascadeType.MERGE }, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<Chef> chefs;

    public Order(){

    }

    public Order(Date orderDate, int quantity, Date pickupDate, List<Food> foods) {
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.pickupDate = pickupDate;
        this.foods = foods;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }














}
