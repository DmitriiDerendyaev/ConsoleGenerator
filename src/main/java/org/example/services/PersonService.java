package org.example.services;

import org.example.models.Person;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person findByLogin(String login) {
        return personRepository.findByLogin(login);
    }

//    public boolean checkPassword(String login, String password) {
//        Person person = personRepository.findByLogin(login);
//        if (person != null) {
//            return person.getPassword().equals(password);
//        }
//        return false;
//    }

    public boolean existsByLogin(String login) {
        return personRepository.existsByLogin(login);
    }
}