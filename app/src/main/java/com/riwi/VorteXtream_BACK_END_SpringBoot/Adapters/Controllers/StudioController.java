package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Studios;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.StudiosService;
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
    public ResponseEntity<Studios> createStudio(@RequestBody Studios studios) {
        try {
            Studios newStudio = studiosService.create(studios);
            return new ResponseEntity<>(newStudio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Studios>> getAllStudios() {
        try {
            List<Studios> studios = studiosService.readAll();
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Studios> getById(@PathVariable("id") Long studioId) {
        try {
            Studios studios = studiosService.getById(studioId);
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Studios> getByName(@PathVariable("name") String name) {
        try {
            Studios studios = studiosService.getByName(name);
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
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
