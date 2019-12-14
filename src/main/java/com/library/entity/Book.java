package com.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "aviability")
    private boolean aviability;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "rating", columnDefinition = "Integer(11) default '0'")
    private Integer rating = 0;

    @Column(name = "category")
    private Integer category;

    @Column(name = "sub_category")
    private Integer subCategory;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "year",length = 4)
    private Integer year;

    public Book() {
    }

    public Book(String name, boolean aviability, String description, Integer rating, Integer category, Integer subCategory, Integer authorId, Integer year) {
        this.name = name;
        this.aviability = aviability;
        this.description = description;
        this.rating = rating;
        this.category = category;
        this.subCategory = subCategory;
        this.authorId = authorId;
        this.year = year;
    }

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

    public boolean isAviability() {
        return aviability;
    }

    public void setAviability(boolean aviability) {
        this.aviability = aviability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Integer subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}