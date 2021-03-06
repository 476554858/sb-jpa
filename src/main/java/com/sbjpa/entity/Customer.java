package com.sbjpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<Goods> goodses = new HashSet<Goods>();


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

    public Set<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(Set<Goods> goodses) {
        this.goodses = goodses;
    }

}
