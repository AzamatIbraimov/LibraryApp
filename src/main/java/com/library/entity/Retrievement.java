package com.library.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "retrievement")
public class Retrievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retrievement_id")
    private Integer id;

    @Column(name = "retrievement_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retrievementDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "user_email",nullable = false, updatable = false)
    private String userEmail;

    @Column(name = "books")
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Book> books;

    public Retrievement() {
    }

    public Retrievement(Date retrievementDate, Date returnDate, String comment, String userEmail, List<Book> books) {
        this.retrievementDate = retrievementDate;
        this.returnDate = returnDate;
        this.comment = comment;
        this.userEmail = userEmail;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRetrievementDate() {
        return retrievementDate;
    }

    public void setRetrievementDate(Date retrievementDate) {
        this.retrievementDate = retrievementDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
