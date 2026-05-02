package com.example.Library_Management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
public class authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aId;

    @Column(nullable = false)
    private String fname;
    @Column(nullable = false)
    private String lname;
    private LocalDate dob;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Books> books;

    // Getters & Setters
    public Long getAId() {
        return aId;
    }

    public void setAId(Long aId) {
        this.aId = aId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
