package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;


import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.MediaEntity;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.MediaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Create media", description = "an endpoint to create a media")
    @ApiResponse(responseCode = "201", description = "media created successfuly")
    public ResponseEntity<MediaEntity> create(@RequestBody MediaEntity media){
        try{
            MediaEntity newMedia = mediaService.create(media);
            return new ResponseEntity<>(newMedia, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    @Operation(summary = "Read all media", description = "an endpoint to read all media")
    @ApiResponse(responseCode = "200", description = "Read all media elements successfully")
    public ResponseEntity<List<MediaEntity>> readAll(){
        try {
            List<MediaEntity> mediaList = mediaService.readAll();
            return new ResponseEntity<>(mediaList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByTitle/{title}")
    @Operation(summary = "find media by title", description = "an endpoint to find media by title")
    @ApiResponse(responseCode = "200", description = "the elements was find by title successfully")
    public ResponseEntity<MediaEntity> getByTitle(@PathVariable("title") String title){
        try{
            MediaEntity media = mediaService.getByTitle(title);
            return new ResponseEntity<>(media, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findById/{id}")
    @Operation(summary = "find media by Id", description = "an endpoint to find media by Id")
    @ApiResponse(responseCode = "200", description = "the elements was find by Id successfully")
    public ResponseEntity<MediaEntity> getById(@PathVariable("id")Integer id){
        try {
            MediaEntity media = mediaService.getById(id);
            return new ResponseEntity<>(media, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update media by Id", description = "an endpoint to Update media by Id")
    @ApiResponse(responseCode = "200", description = "the elements was Update by Id successfully")
    public ResponseEntity<MediaEntity> update(@PathVariable("id") Integer id, @RequestBody MediaEntity mediaToUpdate){
        try{
            MediaEntity updatedMedia = mediaService.update(id, mediaToUpdate);
            return new ResponseEntity<>(updatedMedia, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByTitle/{title}")
    @Operation(summary = "Delete media by title", description = "an endpoint to Delete media by title")
    @ApiResponse(responseCode = "204", description = "Delete the elements by title successfully")
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
