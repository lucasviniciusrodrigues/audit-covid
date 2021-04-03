package com.fiap.person.covid.data.adapter.controller.base;

import com.fiap.person.covid.data.domain.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("person/covid/data/v1")
public interface IPersonCovidDataController {

    @Operation(summary = "Get all data from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) })}) // How set return list?
    @GetMapping()
    public List<Person> getAllPersonCovidData();

    @Operation(summary = "Get data from database by register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "404", description = "Register not found", content = @Content)})
    @GetMapping(value = "register/{register}")
    public Person getPersonCovidDataByRegister(@PathVariable("register") String register) throws ChangeSetPersister.NotFoundException;

    @Operation(summary = "Get data from database by document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "404", description = "Register not found", content = @Content)})
    @GetMapping(value = "document/{document}")
    public Person getPersonCovidDataByDocument(@PathVariable("document") String document);

    @Operation(summary = "Insert data at database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created resource",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) })})
    @PostMapping()
    public ResponseEntity<Person> postPersonCovidData(@RequestBody Person Person);

    @Operation(summary = "Update data from database by document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "404", description = "document not found", content = @Content)})
    @PutMapping(value = "/{document}")
    public Person updatePersonCovidData(@RequestBody Person Person, @PathVariable("document") String register);
}
