package com.sbjpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019/3/2.
 */
@Entity
@Table
public class Item {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    @ManyToMany(mappedBy = "items")
    private Set<Category> categories = new HashSet<Category>();

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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
