package com.fiap.person.covid.data.infrastructure.repository;


import com.fiap.person.covid.data.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonCovidDataRepository extends MongoRepository<Person, String> {

    public Optional<Person> findFirstByRegister(String register);

}

