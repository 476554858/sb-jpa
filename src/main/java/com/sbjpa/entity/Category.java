package com.sbjpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019/3/2.
 */
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JoinTable(name = "category_item",joinColumns = {@JoinColumn(name = "categoryId",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "itemId",referencedColumnName = "id")})
    @ManyToMany
    private Set<Item> items = new HashSet<Item>();

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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
