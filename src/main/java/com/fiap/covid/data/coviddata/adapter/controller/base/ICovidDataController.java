package com.fiap.covid.data.coviddata.adapter.controller.base;

import com.fiap.covid.data.coviddata.adapter.model.CovidData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/covid/data")
public interface ICovidDataController {

    @Operation(summary = "Get all data from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CovidData.class)) }), // How set return list?
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)})
    @GetMapping()
    public CovidData getAllCovidData();

    @Operation(summary = "Get data from database by register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CovidData.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "404", description = "Register not found", content = @Content)})
    @GetMapping(value = "/{register}")
    public CovidData getCovidDataByRegister(String register);

    @Operation(summary = "Insert data at database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created resource",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CovidData.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)})
    @PostMapping()
    public CovidData postCovidData(CovidData covidData);

    @Operation(summary = "Update data from database by register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CovidData.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "404", description = "Register not found", content = @Content)})
    @PatchMapping(value = "/{register}")
    public CovidData updateCovidData(CovidData covidData, String register);
}
