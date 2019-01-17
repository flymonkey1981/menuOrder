package com.menuorder.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="stock")
    private int stock;

    @Column(name="price", precision=10, scale=2)
    private double price;

    @ManyToMany(mappedBy = "foods")
    private List<Order> orders = new ArrayList<>();

    public Food() {

    }

    public Food(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
