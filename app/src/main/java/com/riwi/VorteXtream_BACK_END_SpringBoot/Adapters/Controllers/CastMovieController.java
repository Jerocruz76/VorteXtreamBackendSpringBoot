package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;


import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.CastMovie;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.CastMovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cast-movie")
public class CastMovieController {

    @Autowired
    private CastMovieService castMovieService;


    @PostMapping("/create")
    @Operation(summary = "Create a cast-movie", description = "an endpoint to create a cast-movie")
    @ApiResponse(responseCode = "201", description = "cast-movie created successfuly")
    public ResponseEntity<CastMovie> create(@RequestBody CastMovie castMovie) {
        try {
            CastMovie newCastMovie = castMovieService.create(castMovie);
            return new ResponseEntity<>(newCastMovie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/readAll")
    @Operation(summary = "Read all cast-movie", description = "an endpoint to read all cast-movie")
    @ApiResponse(responseCode = "200", description = "all elements of the cast-movie read correctly.")
    public ResponseEntity<List<CastMovie>> readAll() {
        try {
            List<CastMovie> castMovies = castMovieService.readAll();
            return new ResponseEntity<>(castMovies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Read cast-movie by Id ", description = "an endpoint to read cast-movie by ID")
    @ApiResponse(responseCode = "200", description = "Read cast-movie elements by Id successfully")
    public ResponseEntity<CastMovie> getById(@PathVariable("id") Long castMovieId) {
        try {
            CastMovie castMovie = castMovieService.getById(castMovieId);
            return new ResponseEntity<>(castMovie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update cast-movie by Id", description = "an endpoint to Update cast-movie by Id")
    @ApiResponse(responseCode = "200", description = "the elements was Update by Id successfully")
    public ResponseEntity<CastMovie> update(@PathVariable("id") Long castMovieId,
                                                @RequestBody CastMovie updatedCastMovie) {
        try {
            CastMovie updated = castMovieService.update(castMovieId, updatedCastMovie);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete cast-movie by Id", description = "an endpoint to Delete cast-movie by Id")
    @ApiResponse(responseCode = "204", description = "Delete the elements by Id successfully")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long castMovieId) {
        try {
            boolean deleted = castMovieService.getDeleteById(castMovieId);
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
