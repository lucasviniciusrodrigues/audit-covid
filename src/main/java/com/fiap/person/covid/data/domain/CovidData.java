package com.fiap.person.covid.data.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document
public class CovidData {
        private boolean alreadyInfected;
        private boolean contactWithInfectedRecently;
        private boolean alreadyVaccinated;
        private ArrayList<String> vaccinatedDates;
        ArrayList<SymptomsData> symptomsData = new ArrayList<>();
}
