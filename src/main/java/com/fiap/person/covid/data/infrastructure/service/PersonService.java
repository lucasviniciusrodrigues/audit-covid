package com.fiap.person.covid.data.infrastructure.service;

import com.fiap.person.covid.data.domain.Person;
import com.fiap.person.covid.data.domain.SymptomsData;
import com.fiap.person.covid.data.infrastructure.repository.PersonCovidDataRepository;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    PersonCovidDataRepository personCovidDataRepository;

    PersonService(PersonCovidDataRepository personCovidDataRepository){
        this.personCovidDataRepository = personCovidDataRepository;
    }

    public List<Person> getAllPersons() {
        return personCovidDataRepository.findAll();
    }

    public List<Person> getAllRecentlyPersons() {
        List<Person> persons = personCovidDataRepository.findAll();
        return persons.stream()
                .filter(it -> it.getInsertDate().compareTo(LocalDate.now()) == 0)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public Person getPersonByDocument(String document) {
        return personCovidDataRepository.findFirstByDocument(document)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @SneakyThrows
    public Person getPersonsByRegister(String register) {
        return personCovidDataRepository.findById(register)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Person postPerson(Person person) {
        person.setInsertDateNow();
        return personCovidDataRepository.save(person);
    }

    @SneakyThrows
    public Person updatePerson(Person updatedPerson, String document) {
        Person person = personCovidDataRepository.findById(document)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        for(SymptomsData symptomsData : person.getCovidData().getSymptomsData()){
            updatedPerson.getCovidData().getSymptomsData().add(symptomsData);
        }

        updatedPerson.setUpdateDateNow();
        updatedPerson.setInsertDate(person.getInsertDate());

        return personCovidDataRepository.save(updatedPerson);
    }

    public void deletePerson(String register) {
        personCovidDataRepository.deleteById(register);
    }
}
