package org.example.Controllers;

import org.example.DAO.DataBase;
import org.example.Models.Book;
import org.example.Models.Person;
import org.example.Services.BookService;
import org.example.Services.PersonService;
import org.example.util.Optionalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("books")
public class BookController
{
    private final PersonService personService;
    private final BookService bookService;
    private final Validator validator;
    @Autowired
    public BookController(PersonService personService, BookService bookService, @Qualifier("bookValidator") Validator validator) {
        this.personService = personService;
        this.bookService = bookService;
        this.validator = validator;

    }

    @GetMapping()
    public String getBooks(Model model)
    {
        model.addAttribute("books",bookService.getBooks());
        return "booksv/books";
    }
    @GetMapping("{id}")
    public String getBook(@PathVariable("id") int id,Model model)
    {
        model.addAttribute("book", Optionalizer.getBook(bookService.getBook(id)));
        return "booksv/book";
    }
    @GetMapping("new")
    public String addBook(Model model)
    {
        model.addAttribute("newBook",new Book());
        return "booksv/new";
    }
    @PostMapping()
    public String postBook(@ModelAttribute("newBook") Book book, BindingResult bindingResult)
    {
        validator.validate(book,bindingResult);
        System.out.println(bindingResult.getModel());
        if(!bindingResult.hasErrors()){
        bookService.addBook(book);
        return "redirect:/books";}
        else return "booksv/new";
    }
    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable("id") int id)
    {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("{id}/update")
    public String updateBook(@PathVariable("id") int id,Model model)
    {
        model.addAttribute("updbook",Optionalizer.getBook(bookService.getBook(id)));
        return "booksv/updateBook";
    }
    @PatchMapping("{id}")
    public String postUpdate(@ModelAttribute("updbook") Book book,BindingResult bindingResult)
    {
        validator.validate(book,bindingResult);
        if(!bindingResult.hasErrors()){
        bookService.updateBook(book.getId(),book,baseFlag(book));
        return "redirect:/books";}
        else return "booksv/updateBook";
    }
    @GetMapping("{id}/owner")
    public String editOwner(@PathVariable("id") int id,Model model)
    {
        model.addAttribute("person",new Person());
        model.addAttribute("persons",personService.getPersons());
        model.addAttribute("book",Optionalizer.getBook(bookService.getBook(id)));
        return "booksv/owner";
    }
    @PatchMapping("{id}/owner")
    public String postOwner(@PathVariable("id") int id,Person person,@ModelAttribute("book")Book book, BindingResult bindingResult
                            , Model model)
    {
        book = Optionalizer.getBook(bookService.getBook(id));
        validator.validate(book,bindingResult);
        
        if(!bindingResult.hasErrors()){
            bookService.addOwner(book,person,baseFlag(book));
        return "redirect:/books/"+id;}
        else {        System.out.println(bindingResult.getModel());
            model.addAllAttributes(Map.of("persons",personService.getPersons()));
        return "booksv/owner";}
    }

    @DeleteMapping("{id}/owner")
    public String deleteOwner(@PathVariable("id") int id)
    {
        System.out.println(id);
        Book book = Optionalizer.getBook(bookService.getBook(id));
        bookService.deleteOwner(book,baseFlag(book));
        return "redirect:/books/"+id;
    }
    private boolean baseFlag(Book book)
    {
        if(book.getYear()==13290){
            return false;
        }
        else return true;
    }



   // @GetMapping("{id}/owner")
  //  public String owner(@PathVariable("id") int id,Model model)
   // {
     //   model.addAttribute(base.getBook(id).get());
    //    return "booksv/owner";
   // }

}
