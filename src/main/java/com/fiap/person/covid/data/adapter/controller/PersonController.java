package com.fiap.person.covid.data.adapter.controller;

import com.fiap.person.covid.data.adapter.controller.base.IPersonController;
import com.fiap.person.covid.data.domain.Person;
import com.fiap.person.covid.data.infrastructure.service.PersonService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController implements IPersonController {

    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }
    
    public List<Person> getAllPerson(){
        return personService.getAllPersons();
    }

    public List<Person> getAllRecentlyPerson(){
        return personService.getAllRecentlyPersons();
    }

    @SneakyThrows
    public Person getPersonByRegister(String register) {
        return personService.getPersonsByRegister(register);
    }

    @SneakyThrows
    public Person getPersonByDocument(String document)
    {
        return personService.getPersonByDocument(document);
    }

    public ResponseEntity<Person> postPerson(Person person)
    {
        return new ResponseEntity<Person>(personService.postPerson(person), HttpStatus.CREATED);
    }

    public Person updatePerson(
            Person person,
            String register)
    {
        return personService.postPerson(person, register);
    }

    @Override
    public ResponseEntity deletePerson(String register) {
        personService.deletePerson(register);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
