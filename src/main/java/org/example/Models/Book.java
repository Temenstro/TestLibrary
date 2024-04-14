package org.example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Column(name = "year")
    private int year;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "idp")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        this.person = newPerson;
    }


    public Book(int year, String title, String author) {
        this.year = year;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
