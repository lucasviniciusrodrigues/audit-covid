package com.fiap.covid.data.coviddata.adapter.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CovidData {
        private String document;
        private String registration;
        private String name;
        private float age;
        private boolean alreadyInfected;
        private boolean contactWithInfectedRecently;
        private boolean alreadyVaccinated;
        private String VaccinatedDate;
        private SymptonsSeverity symptomsSeverity;
        private boolean symptomsRemainedAfterRecovery;
        ArrayList<String> symptoms = new ArrayList<String>();
        ArrayList<DateRange> dateRangeSymptoms = new ArrayList<DateRange>();
        Location Location;

}
