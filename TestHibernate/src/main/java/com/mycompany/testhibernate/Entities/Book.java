/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testhibernate.Entities;

import javax.persistence.*;

/**
 *
 * @author admin
 */
@Entity
@Table (name="BOOK")
public class Book {
    
    @Id
    @GeneratedValue
    @Column (name="id")
    private long id;
    
    @Column (name="name")
    private String name;
    
    @ManyToOne
    @JoinColumn (name="author")
    private Author author;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    
    
    
    
}
