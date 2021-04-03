package com.fiap.person.covid.data.infrastructure.service;

import com.fiap.person.covid.data.domain.Person;
import com.fiap.person.covid.data.domain.SymptomsData;
import com.fiap.person.covid.data.infrastructure.repository.PersonCovidDataRepository;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonCovidDataService {

    PersonCovidDataRepository personCovidDataRepository;

    PersonCovidDataService(PersonCovidDataRepository personCovidDataRepository){
        this.personCovidDataRepository = personCovidDataRepository;
    }

    public List<Person> getAllPersons() {
        return personCovidDataRepository.findAll();
    }
    @SneakyThrows
    public Person getPersonByRegister(String register){
        return personCovidDataRepository.findFirstByRegister(register)
                .map(person -> person)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
    @SneakyThrows
    public Person getPersonByDocument(String document) {
        return personCovidDataRepository.findById(document)
                .map(person -> person)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @SneakyThrows
    public Person getPersonsByRegister(String document) {
        return personCovidDataRepository.findFirstByRegister(document)
                .map(person -> person)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Person postPerson(Person person) {
        return personCovidDataRepository.save(person);
    }

    @SneakyThrows
    public Person postPerson(Person updatedPerson, String document) {
        Person person = personCovidDataRepository.findById(document)
                .map(actualPerson -> actualPerson)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        person.setBirthday(updatedPerson.getBirthday());
        for(SymptomsData symptomsData : person.getCovidData().getSymptomsData()){
            updatedPerson.getCovidData().getSymptomsData().add(symptomsData);
        }

        person.setCovidData(updatedPerson.getCovidData());

        return personCovidDataRepository.save(updatedPerson);
    }
}
