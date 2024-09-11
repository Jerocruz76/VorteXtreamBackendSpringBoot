package com.riwi.VorteXtream_BACK_END_SpringBoot.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Directors;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl.DirectorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/directors")
public class DirectorController {

    private final DirectorsService directorsService;

    public DirectorController(DirectorsService directorsService){
        this.directorsService = directorsService;
    }

    @PostMapping("/create")
    public ResponseEntity<Directors> createDirector(@RequestBody Directors directors) {
        try {
            Directors newDirector = directorsService.create(directors);
            return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Directors>> getAllDirectors() {
        try {
            List<Directors> directors = directorsService.readAll();
            return new ResponseEntity<>(directors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Directors> updateDirector(@PathVariable("id") Long directorId,
                                                @RequestBody Directors updatedDirector) {
        try {
            Directors updated = directorsService.update(directorId, updatedDirector);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDirector(@PathVariable("id") Long directorId) {
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
