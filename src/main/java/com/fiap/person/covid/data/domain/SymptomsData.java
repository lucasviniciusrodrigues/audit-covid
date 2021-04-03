package com.fiap.person.covid.data.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document
public class SymptomsData {
        ArrayList<String> symptoms = new ArrayList<String>();
        private SymptonsSeverity symptomsSeverity;
        private boolean symptomsRemainedAfterRecovery;
        DateRange dateRangeSymptoms = new DateRange();
}
