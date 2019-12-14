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

    @Column(name = "description", length = 500)
    private String description;

    public SubCategory() {
    }

    public SubCategory(Integer categoryId, String description) {
        this.categoryId = categoryId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}