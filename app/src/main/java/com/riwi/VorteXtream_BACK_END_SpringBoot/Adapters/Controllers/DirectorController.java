package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Directors;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.DirectorsService;
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
    public ResponseEntity<Directors> create(@RequestBody Directors directors) {
        try {
            Directors newDirector = directorsService.create(directors);
            return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Directors>> getAll() {
        try {
            List<Directors> directors = directorsService.readAll();
            return new ResponseEntity<>(directors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Directors> getById(@PathVariable("id") Long directorId) {
        try {
            Directors directors = directorsService.getById(directorId);
            return new ResponseEntity<>(directors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Directors> getByName(@RequestParam("name") String name) {
        try {
            Directors directors = directorsService.getByName(name);
            return new ResponseEntity<>(directors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
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
