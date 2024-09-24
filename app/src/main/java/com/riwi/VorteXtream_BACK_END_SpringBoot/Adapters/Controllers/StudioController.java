package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Studios;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.StudiosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/studios")
public class StudioController {

    @Autowired
    private StudiosService studiosService;

    @PostMapping("/create")
    @Operation(summary = "Create studios", description = "an endpoint to create a studios")
    @ApiResponse(responseCode = "201", description = "studios created successfuly")
    public ResponseEntity<Studios> createStudio(@RequestBody Studios studios) {
        try {
            Studios newStudio = studiosService.create(studios);
            return new ResponseEntity<>(newStudio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/readAll")
    @Operation(summary = "Read all studios", description = "an endpoint to read all studios")
    @ApiResponse(responseCode = "200", description = "Read all studios elements successfully")
    public ResponseEntity<List<Studios>> getAllStudios() {
        try {
            List<Studios> studios = studiosService.readAll();
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "find studios by Id", description = "an endpoint to find studios by Id")
    @ApiResponse(responseCode = "200", description = "the elements was find by Id successfully")
    public ResponseEntity<Studios> getById(@PathVariable("id") Long studioId) {
        try {
            Studios studios = studiosService.getById(studioId);
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName/{name}")
    @Operation(summary = "find studios by name", description = "an endpoint to find studios by name")
    @ApiResponse(responseCode = "200", description = "the elements was find by name successfully")
    public ResponseEntity<Studios> getByName(@PathVariable("name") String name) {
        try {
            Studios studios = studiosService.getByName(name);
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update studios by Id", description = "an endpoint to Update studios by Id")
    @ApiResponse(responseCode = "200", description = "the elements was Update by Id successfully")
    public ResponseEntity<Studios> updateStudio(@PathVariable("id") Long studiosId,
                                                @RequestBody Studios updatedStudios) {
        try {
            Studios updated = studiosService.update(studiosId, updatedStudios);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete studios by Id", description = "an endpoint to Delete studios by Id")
    @ApiResponse(responseCode = "204", description = "Delete the elements by Id successfully")
    public ResponseEntity<HttpStatus> deleteStudio(@PathVariable("id") Long studiosId) {
        try {
            boolean deleted = studiosService.getDeleteById(studiosId);
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
