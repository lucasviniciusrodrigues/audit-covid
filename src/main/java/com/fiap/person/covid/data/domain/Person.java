package com.fiap.person.covid.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Person {

        @Id
        private String register;

        @Indexed(unique=true)
        private String document;
        private String name;
        private String birthday;
        private CovidData covidData = new CovidData();

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private LocalDate insertDate;

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private LocalDate updateDate;

        public void setInsertDateNow() {
                this.insertDate = LocalDate.now();
        }

        public void setUpdateDateNow() {
                this.updateDate = LocalDate.now();
        }

}
