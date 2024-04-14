package org.example.util;

import org.example.Models.Book;
import org.example.Models.Person;

import java.util.Optional;

public class Optionalizer
{
    public static Person getPerson(Optional<Person> optionalPerson)
    {
        if(!optionalPerson.isPresent())
        {
            return new Person("хз",-1000);
        }
        return optionalPerson.get();
    }
    public static Book getBook(Optional<Book> optionalBook)
    {
        if(!optionalBook.isPresent())
        {
            return new Book(13290,"Неи-вестная книга","Temenstro");
        }
        return optionalBook.get();
    }
}
