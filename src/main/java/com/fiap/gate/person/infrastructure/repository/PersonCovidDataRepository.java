package com.fiap.gate.person.infrastructure.repository;


import com.fiap.gate.person.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonCovidDataRepository extends MongoRepository<Person, String> {

    Optional<Person> findFirstByDocument(String document);

}

