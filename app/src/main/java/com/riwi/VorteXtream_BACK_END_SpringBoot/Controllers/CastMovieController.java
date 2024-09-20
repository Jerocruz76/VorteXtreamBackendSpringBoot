package com.riwi.VorteXtream_BACK_END_SpringBoot.Controllers;


import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.CastMovie;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl.CastMovieService;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl.TypeStreamingService;
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
    public ResponseEntity<CastMovie> create(@RequestBody CastMovie castMovie) {
        try {
            CastMovie newCastMovie = castMovieService.create(castMovie);
            return new ResponseEntity<>(newCastMovie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/readAll")
    public ResponseEntity<List<CastMovie>> readAll() {
        try {
            List<CastMovie> castMovies = castMovieService.readAll();
            return new ResponseEntity<>(castMovies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CastMovie> getById(@PathVariable("id") Long castMovieId) {
        try {
            CastMovie castMovie = castMovieService.getById(castMovieId);
            return new ResponseEntity<>(castMovie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<CastMovie> getByName(@RequestParam("name") String name) {
        try {
            CastMovie castMovie = castMovieService.getByName(name);
            return new ResponseEntity<>(castMovie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
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
