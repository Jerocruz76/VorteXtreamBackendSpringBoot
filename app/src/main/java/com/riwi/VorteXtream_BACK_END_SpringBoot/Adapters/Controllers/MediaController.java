package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;


import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.MediaEntity;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    @PostMapping("/create")
    public ResponseEntity<MediaEntity> create(@RequestBody MediaEntity media){
        try{
            MediaEntity newMedia = mediaService.create(media);
            return new ResponseEntity<>(newMedia, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<MediaEntity>> readAll(){
        try {
            List<MediaEntity> mediaList = mediaService.readAll();
            return new ResponseEntity<>(mediaList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<MediaEntity> getByTitle(@PathVariable("title") String title){
        try{
            MediaEntity media = mediaService.getByTitle(title);
            return new ResponseEntity<>(media, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<MediaEntity> getById(@PathVariable("id")Integer id){
        try {
            MediaEntity media = mediaService.getById(id);
            return new ResponseEntity<>(media, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MediaEntity> update(@PathVariable("id") Integer id, @RequestBody MediaEntity mediaToUpdate){
        try{
            MediaEntity updatedMedia = mediaService.update(id, mediaToUpdate);
            return new ResponseEntity<>(updatedMedia, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByTitle/{title}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("title") String title){
        try{
            boolean mediaToDelete = mediaService.getDeleteTitle(title);
            if (mediaToDelete){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
