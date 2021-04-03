package com.fiap.person.covid.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document
public class Person {

        @Id
        private String register;
        private String document;
        private String name;
        private String birthday;
        private CovidData covidData = new CovidData();
}
