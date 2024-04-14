package org.example.Services;

import org.example.Models.Person;
import org.example.Repositories.PersonRepository;
import org.example.util.Optionalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Component
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Transactional
    public void addPerson(Person person){
        personRepository.save(person);
    }
    @Transactional
    public void updatePerson(int id,Person updperson,boolean b){
        if(b){
        Person newPerson = Optionalizer.getPerson(getPerson(id));
        newPerson.setName(updperson.getName());
        newPerson.setyearofbirth(updperson.getyearofbirth());
        personRepository.save(newPerson);}
    }
    public Optional<Person> getPerson(int id)
    {
        return personRepository.findById(id);
    }
    public List<Person> getPersons()
    {
        return personRepository.findAll();
    }
    @Transactional
    public void deletePerson(int id)
    {
        personRepository.deleteById(id);
    }
}
