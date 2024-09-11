package com.riwi.VorteXtream_BACK_END_SpringBoot.Controllers;


import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl.TypeStreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type-streaming")
public class TypeStreamingController {

    private final TypeStreamingService typeStreamingService;

    public TypeStreamingController(TypeStreamingService typeStreamingService){
        this.typeStreamingService = typeStreamingService;
    }

    @PostMapping("/create")
    public ResponseEntity<TypeStreaming> createTypeStreaming(@RequestBody TypeStreaming typeStreaming) {
        try {
            TypeStreaming newTypeStreaming = typeStreamingService.create(typeStreaming);
            return new ResponseEntity<>(newTypeStreaming, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/readAll")
    public ResponseEntity<List<TypeStreaming>> getAllTypeStreamings() {
        try {
            List<TypeStreaming> typeStreamings = typeStreamingService.readAll();
            return new ResponseEntity<>(typeStreamings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeStreaming> updateTypeStreaming(@PathVariable("id") Long typeStreamingId,
                                                             @RequestBody TypeStreaming updatedTypeStreaming) {
        try {
            TypeStreaming updated = typeStreamingService.update(typeStreamingId, updatedTypeStreaming);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTypeStreaming(@PathVariable("id") Long typeStreamingId) {
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
