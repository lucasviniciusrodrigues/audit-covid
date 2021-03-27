package com.fiap.covid.data.coviddata.adapter.controller;

import com.fiap.covid.data.coviddata.adapter.controller.base.ICovidDataController;
import com.fiap.covid.data.coviddata.adapter.model.CovidData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
public class CovidDataController implements ICovidDataController {

    public CovidData getAllCovidData(){
        return new CovidData();
    }

    public CovidData getCovidDataByRegister(@RequestParam("register") String register)
    {
        return new CovidData();
    }

    public CovidData postCovidData(@RequestBody CovidData covidData)
    {
        return new CovidData();
    }

    public CovidData updateCovidData(
            @RequestBody CovidData covidData,
            @RequestParam("register") String register)
    {
        return new CovidData();
    }

}
