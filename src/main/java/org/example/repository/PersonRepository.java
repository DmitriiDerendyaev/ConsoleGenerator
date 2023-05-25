package org.example.repository;

import org.example.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Дополнительные методы репозитория, если необходимо
    Person save(Person person);
}