package org.example.Models;


import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;
@Entity
@Table(name = "perslis")
public class Person {
    @Column(name = "idp")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idp;
    @OneToMany(mappedBy = "person")
    private List<Book> bookList;
    @Column(name = "name")
    @Length(message = "Имя должно содержать минимум 1 символ", min = 1)
    private String name;
    @Column(name = "yearofbirth")
    private int yearofbirth;


    public void setyearofbirth(int yearofbirth) {
        this.yearofbirth = yearofbirth;
    }

    public Person(String name, int yearofbirth) {
        this.name = name;
        this.yearofbirth = yearofbirth;

    }

    public Person() {
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int id) {
        this.idp = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getyearofbirth() {
        return yearofbirth;
    }



    public String getName() {
        return name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
