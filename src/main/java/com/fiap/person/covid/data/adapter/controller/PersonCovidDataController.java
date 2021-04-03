package com.fiap.person.covid.data.adapter.controller;

import com.fiap.person.covid.data.adapter.controller.base.IPersonCovidDataController;
import com.fiap.person.covid.data.domain.Person;
import com.fiap.person.covid.data.infrastructure.service.PersonCovidDataService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonCovidDataController implements IPersonCovidDataController {

    private PersonCovidDataService personCovidDataService;

    public PersonCovidDataController(PersonCovidDataService personCovidDataService){
        this.personCovidDataService = personCovidDataService;
    }

    public List<Person> getAllPersonCovidData(){
        return personCovidDataService.getAllPersons();
    }

    @SneakyThrows
    public Person getPersonCovidDataByRegister(String register) {
        return personCovidDataService.getPersonsByRegister(register);
    }

    @SneakyThrows
    public Person getPersonCovidDataByDocument(String document)
    {
        return personCovidDataService.getPersonByDocument(document);
    }

    public ResponseEntity<Person> postPersonCovidData(Person person)
    {
        return new ResponseEntity<Person>(personCovidDataService.postPerson(person), HttpStatus.CREATED);
    }

    public Person updatePersonCovidData(
            Person person,
            String document)
    {
        return personCovidDataService.postPerson(person, document);
    }

}
