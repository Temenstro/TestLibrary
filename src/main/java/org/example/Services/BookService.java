package org.example.Services;

import org.example.Models.Book;
import org.example.Models.Person;
import org.example.Repositories.BookRepository;
import org.example.Repositories.PersonRepository;
import org.example.util.Optionalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Component
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;
    private final PersonRepository personRepository;
    @Autowired
    public BookService(BookRepository bookRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }

    public Optional<Book> getBook(int id)
    {
        return bookRepository.findById(id);
    }
    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }
    public List<Book> getBooks(int id)
    {
        Person person = Optionalizer.getPerson(personRepository.findById(id));
        return bookRepository.findByPerson(person);
    }
    @Transactional
    public void addBook(Book book)
    {
        bookRepository.save(book);
    }
    @Transactional
    public void updateBook(int id,Book updbook,boolean b){
        if(b){
            Book newBook = Optionalizer.getBook(getBook(id));
            newBook.setTitle(updbook.getTitle());
            newBook.setYear(updbook.getYear());
            newBook.setAuthor(updbook.getAuthor());
            bookRepository.save(newBook);}
    }
    @Transactional
    public void deleteBook(int id)
    {
        bookRepository.deleteById(id);
    }
    @Transactional
    public void addOwner(Book book,Person person,boolean b)
    {
        if(b)
        {
            book.setPerson(person);
            bookRepository.save(book);
        }
    }
    @Transactional
    public void deleteOwner(Book book,boolean b)
    {
        if(b)
        {
            book.setPerson(null);
            bookRepository.save(book);
        }
    }

}
