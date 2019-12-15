package com.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private Integer id;

    @Column(name = "category_id",nullable = false, updatable = false)
    private Integer categoryId;

    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "description", length = 500)
    private String description;


    public SubCategory() {
    }

    public SubCategory(Integer categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}