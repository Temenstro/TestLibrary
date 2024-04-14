package org.example.Repositories;

import org.example.Models.Book;
import org.example.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book> findByPerson(Person person);
}
