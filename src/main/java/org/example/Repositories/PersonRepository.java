package org.example.Repositories;

import org.example.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("personRepository")
    public interface PersonRepository extends JpaRepository<Person,Integer> {
}
