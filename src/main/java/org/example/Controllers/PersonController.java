package org.example.Controllers;

import jakarta.validation.Valid;
import org.example.DAO.DataBase;
import org.example.Models.Person;
import org.example.Services.BookService;
import org.example.Services.PersonService;
import org.example.util.Optionalizer;
import org.example.util.Validators.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("persons")
public class PersonController {
    private final PersonService personService;
    private final BookService bookService;
    private final PersonValidator validator;
    @Autowired
    public PersonController(PersonService personService, BookService bookService, @Qualifier("personValidator") PersonValidator validator) {
        this.personService = personService;
        this.bookService = bookService;
        this.validator = validator;
    }

    @GetMapping()
    public String getPersons(Model model)
    {
        model.addAttribute("personslist",personService.getPersons());
        return "personv/persons";
    }
    @GetMapping({"{id}"})
    public String getPerson(@PathVariable("id") int id,Model model)
    {
        if(personService.getPerson(id).isPresent()){
            Person person = personService.getPerson(id).get();
            person.setBookList(bookService.getBooks(id));
            model.addAttribute("person",person);
            return "personv/person";
        }
        return "redirect:/persons";
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
    @GetMapping("new")
    public String addPerson(Model model)
    {
        model.addAttribute("pers",new Person());
        return "personv/new";
    }
    @PostMapping()
    public String postAdding(@ModelAttribute("pers") @Valid Person person, BindingResult bindingResult)
    {
        validator.validate(person,bindingResult);
        if(bindingResult.hasErrors()){
            return "personv/new";
        }
        personService.addPerson(person);
        return "redirect:/persons";
    }
    @GetMapping("{id}/update")
    public String update(@PathVariable("id") int id,Model model)
    {
        Person person = Optionalizer.getPerson(personService.getPerson(id));
        if(baseFlag(person)){
        model.addAttribute("pers",personService.getPerson(id).get());
            return "personv/update";
        }
        return "redirect:/persons";
    }
    @PatchMapping("{id}")
    public String postUpdate(@PathVariable("id") int id ,
                             @ModelAttribute("pers") @Valid Person person,
                             BindingResult bindingResult)
    {
        validator.validate(person,bindingResult);
        if(bindingResult.hasErrors()){
            return "personv/update";
        }
        personService.updatePerson(id,person,baseFlag(person));
        return "redirect:/persons";
    }
    private boolean baseFlag(Person person){
        if(person.getyearofbirth()==-1000)
        {
            return false;
        }
        return true;
    }

}
