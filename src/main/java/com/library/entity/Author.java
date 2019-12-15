package com.library.entity;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer id;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "contact_number", length = 100)
    private String contact;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName =" author_id")
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String contact, List<Book> books) {
        this.name = name;
        this.contact = contact;
        this.books = books;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}