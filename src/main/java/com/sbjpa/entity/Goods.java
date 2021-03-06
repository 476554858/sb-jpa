package com.sbjpa.entity;

import javax.persistence.*;

@Entity
@Table
public class Goods {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JoinColumn(name = "customerId")
    @ManyToOne
    Customer customer;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
