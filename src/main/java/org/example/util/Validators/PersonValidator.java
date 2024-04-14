package org.example.util.Validators;

import org.example.Models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator
{

    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println(clazz.getClass());;return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Person person = (Person) target;
        if(person.getName().length()>15)
        {
            errors.rejectValue("name","","Имя должно содержать от 1 до 15 символов");
        }
        if(person.getyearofbirth()<1901||person.getyearofbirth()>2023){
            errors.rejectValue("yearofbirth","","Дата рождения должна быть между 1901 и 2023");
        }
    }
}
