package org.example.DAO;

import jakarta.transaction.Transactional;
import org.example.Models.Book;
import org.example.Models.Person;
import org.example.util.Optionalizer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataBase {
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory;
//    @Autowired
//    public DataBase(LocalEntityManagerFactoryBean entityManagerFactory)
//    {
//        this.entityManagerFactory = sessionFactory;
//    }
//
//
//    @Transactional
//    public Optional<Person> getPerson(int id)
//    {
//            try(Session session = entityManagerFactory.getCurrentSession()){
//            Person person = session.get(Person.class,id);
//            return Optional.ofNullable(person);}
//    }
//    @Transactional
//    public List<Person> getPersons()
//    {
//            Session session = entityManagerFactory.getCurrentSession();
//            List<Person> persons = session.createQuery("FROM Person",Person.class).getResultList();
//            return persons;
//
//    }
//
//    public void deletePerson(int id)
//    {
//        Person person = Optionalizer.getPerson(getPerson(id));
//        try(Session session = entityManagerFactory.openSession()){
//            session.remove(person);
//        }
//    }
//    @Transactional
//    public void updatePerson(int id, Person person, boolean b)
//    {
//        if(b){
//            Person newPerson = Optionalizer.getPerson(getPerson(id));
//            try(Session session = entityManagerFactory.openSession())
//        {
//            newPerson.setName(person.getName());
//            newPerson.setyearofbirth(person.getyearofbirth());
//            session.merge(newPerson);
//        }
//        }
//    }
//    public void addPerson(Person person)
//    {
//        try(Session session = entityManagerFactory.openSession())
//        {
//            session.persist(person);
//        }
//    }
//    public void addBook(Book book)
//    {
//        try(Session session = entityManagerFactory.getCurrentSession())
//        {
//            session.beginTransaction();
//            session.persist(book);
//            session.getTransaction().commit();
//        }
//    }
//    public Optional<Book> getBook(int id)
//    {
//        try(Session session = entityManagerFactory.getCurrentSession()){
//            session.beginTransaction();
//            Book book = session.get(Book.class,id);
//            session.getTransaction().commit();
//            return Optional.ofNullable(book);
//        }
//    }
//    public List<Book> getBooks()
//    {
//        try(Session session = entityManagerFactory.getCurrentSession())
//        {
//            session.beginTransaction();
//            List<Book> books = session.createQuery("FROM Book ",Book.class).getResultList();
//            session.getTransaction().commit();
//            return books;
//        }
//    }
//    public List <Book> getBooks(int id)
//    {
//        try(Session session = entityManagerFactory.getCurrentSession())
//        {
//            session.beginTransaction();
//            Query query = session.createQuery("FROM Book WHERE person.id =:id",Book.class);
//            query.setParameter("id",id);
//            List<Book> books = query.getResultList();
//            session.getTransaction().commit();
//            return books;
//        }
//    }
//    public void deleteBook(int id)
//    {
//        Book book = Optionalizer.getBook(getBook(id));
//        try(Session session = entityManagerFactory.getCurrentSession()){
//            session.beginTransaction();
//            session.remove(book);
//            session.getTransaction().commit();
//        }
//    }
//    public void updateBook(int id, Book book, boolean b)
//    {
//        if(b){
//            Book newBook = Optionalizer.getBook(getBook(id));
//            try(Session session = entityManagerFactory.getCurrentSession())
//            {
//                session.beginTransaction();
//                newBook.setYear(book.getYear());
//                newBook.setTitle(book.getTitle());
//                newBook.setAuthor(book.getAuthor());
//                session.merge(newBook);
//                session.getTransaction().commit();
//            }
//        }
//    }
//    public void addOwner(Book book,Person person,boolean b)
//    {
//        if(b) {
//            try (Session session = entityManagerFactory.getCurrentSession()) {
//                session.beginTransaction();
//                book.setPerson(person);
//                session.merge(book);
//                session.getTransaction().commit();
//            }
//        }
//
//    }
//    public void deleteOwner(Book book,boolean b)
//    {
//        if(b){
//            try(Session session = entityManagerFactory.getCurrentSession()){
//                session.beginTransaction();
//                book.setPerson(null);
//                session.merge(book);
//                session.getTransaction().commit();
//            }
//        }
//    }
//
//
//
//





}








    


