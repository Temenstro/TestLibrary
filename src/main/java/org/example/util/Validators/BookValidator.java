package org.example.util.Validators;

import org.example.Models.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println(clazz.getClass());;
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if(book.getYear()<1502||book.getYear()>2024)
        {
            errors.rejectValue("year","","Книга дожна быть выпущена не раньше 1500" +
                    " и не позднее 2024 года");
        }
        if(book.getTitle().length()<3||book.getTitle().length()>50)
        {
            errors.rejectValue("title","","Название книги должно быть не короче 3 и не длиннее 50");
        }
        if(book.getPerson()!=null)
        {
            errors.rejectValue("person","","У книги может быть только 1 владелец");
        }
        if(book.getAuthor().length()<3||book.getAuthor().length()>50)
        {
            errors.rejectValue("author","","Имя автора должно быть не короче 3 и не длиннее 50");
        }
    }
}
