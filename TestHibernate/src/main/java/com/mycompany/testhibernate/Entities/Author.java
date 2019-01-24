/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testhibernate.Entities;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author admin
 */
@Entity
@Table (name="AUTHOR")
public class Author {
       
    @Id
    @Column(name="id")
    @GeneratedValue
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    

    public Author() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
