package com.fiap.person.covid.data.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DateRange {
    private String startDate;
    private String endDate;
}