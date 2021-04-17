package com.fiap.person.covid.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

        @JsonIgnore
        private LocalDate insertDate;

        @JsonIgnore
        private LocalDate updateDate;

        public void setInsertDateNow() {
                this.insertDate = LocalDate.now();
        }

        public void setUpdateDateNow() {
                this.updateDate = LocalDate.now();
        }

}
