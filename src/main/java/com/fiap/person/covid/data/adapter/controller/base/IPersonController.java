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

@RequestMapping("/v1/person")
public interface IPersonController {

    @Operation(summary = "Get all persons from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person[].class)) })})
    @GetMapping()
    List<Person> getAllPerson();

    @Operation(summary = "Get all person registered today")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person[].class)) })})
    @GetMapping("/recently")
    List<Person> getAllRecentlyPerson();

    @Operation(summary = "Get data from database by register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "404", description = "Register not found", content = @Content)})
    @GetMapping(value = "/{register}")
    Person getPersonByRegister(@PathVariable("register") String register) throws ChangeSetPersister.NotFoundException;

    @Operation(summary = "Get data from database by document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "404", description = "Register not found", content = @Content)})
    @GetMapping("/search")
    Person getPersonByDocument(@RequestParam(required = true) String document);

    @Operation(summary = "Insert data at database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created resource",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) })})
    @PostMapping()
    ResponseEntity<Person> postPerson(@RequestBody Person Person);

    @Operation(summary = "Update data from database by document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "404", description = "document not found", content = @Content)})
    @PutMapping()
    Person updatePerson(@RequestBody Person Person);

    @Operation(summary = "Delete data from database by register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return deleted data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "404", description = "register not found", content = @Content)})
    @DeleteMapping(value = "/{register}")
    ResponseEntity deletePerson(@PathVariable("register") String register);
}
