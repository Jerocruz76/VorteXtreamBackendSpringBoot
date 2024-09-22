package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.TypeStreaming;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.TypeStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/typeStreaming")
public class TypeStreamingController {

    @Autowired
    private TypeStreamingService typeStreamingService;

    @PostMapping("/create")
    public ResponseEntity<TypeStreaming> create(@RequestBody TypeStreaming typeStreaming) {
        try {
            TypeStreaming newTypeStreaming = typeStreamingService.create(typeStreaming);
            return new ResponseEntity<>(newTypeStreaming, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/readAll")
    public ResponseEntity<List<TypeStreaming>> readAll() {
        try {
            List<TypeStreaming> typeStreamings = typeStreamingService.readAll();
            return new ResponseEntity<>(typeStreamings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TypeStreaming> getById(@PathVariable("id") Long typeStreamingId) {
        try {
            TypeStreaming typeStreaming = typeStreamingService.getById(typeStreamingId);
            return new ResponseEntity<>(typeStreaming, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<TypeStreaming> getByName(@RequestParam("name") String name) {
        try {
            TypeStreaming typeStreaming = typeStreamingService.getByName(name);
            return new ResponseEntity<>(typeStreaming, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeStreaming> update(@PathVariable("id") Long typeStreamingId,
                                                             @RequestBody TypeStreaming updatedTypeStreaming) {
        try {
            TypeStreaming updated = typeStreamingService.update(typeStreamingId, updatedTypeStreaming);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long typeStreamingId) {
        try {
            boolean deleted = typeStreamingService.getDeleteById(typeStreamingId);
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
