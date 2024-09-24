package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Directors;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.DirectorsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/directors")
public class DirectorController {

    @Autowired
    private DirectorsService directorsService;

    @PostMapping("/create")
    @Operation(summary = "Create directors", description = "an endpoint to create a directors")
    @ApiResponse(responseCode = "201", description = "directors created successfuly")
    public ResponseEntity<Directors> create(@RequestBody Directors directors) {
        try {
            Directors newDirector = directorsService.create(directors);
            return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    @Operation(summary = "Read all directors", description = "an endpoint to read all directors")
    @ApiResponse(responseCode = "200", description = "Read directors elements by Id successfully")
    public ResponseEntity<List<Directors>> getAll() {
        try {
            List<Directors> directors = directorsService.readAll();
            return new ResponseEntity<>(directors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "find directors by Id", description = "an endpoint to find directors by Id")
    @ApiResponse(responseCode = "200", description = "the elements was find by Id successfully")
    public ResponseEntity<Directors> getById(@PathVariable("id") Long directorId) {
        try {
            Directors directors = directorsService.getById(directorId);
            return new ResponseEntity<>(directors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName/{name}")
    @Operation(summary = "find directors by name", description = "an endpoint to find directors by name")
    @ApiResponse(responseCode = "200", description = "the elements was find by name successfully")
    public ResponseEntity<Directors> getByName(@RequestParam("name") String name) {
        try {
            Directors directors = directorsService.getByName(name);
            return new ResponseEntity<>(directors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update directors by Id", description = "an endpoint to Update directors by Id")
    @ApiResponse(responseCode = "200", description = "the elements was Update by Id successfully")
    public ResponseEntity<Directors> update(@PathVariable("id") Long directorId,
                                                @RequestBody Directors updatedDirector) {
        try {
            Directors updated = directorsService.update(directorId, updatedDirector);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete directors by Id", description = "an endpoint to Delete directors by Id")
    @ApiResponse(responseCode = "204", description = "Delete the elements by Id successfully")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long directorId) {
        try {
            boolean deleted = directorsService.getDeleteById(directorId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
