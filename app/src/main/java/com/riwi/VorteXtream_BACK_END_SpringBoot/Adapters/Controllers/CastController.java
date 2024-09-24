package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.CastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/casts")
public class CastController {

    @Autowired
    private CastService castService;

    @PostMapping("/create")
    @Operation(summary = "Create a cast", description = "an endpoint to create a cast")
    @ApiResponse(responseCode = "201", description = "cast created successfuly")
    public ResponseEntity<Cast> create(@RequestBody Cast cast){
        try{
            Cast newCast = castService.create(cast);
            return new ResponseEntity<>(newCast, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    @Operation(summary = "Read all cast", description = "an endpoint to read all cast")
    @ApiResponse(responseCode = "200", description = "Read all elements successfully")
    public ResponseEntity<List<Cast>> readAll(){
        try{
            List<Cast> allCasts = castService.readAll();
            return new ResponseEntity<>(allCasts, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Read cast by Id ", description = "an endpoint to read cast by ID")
    @ApiResponse(responseCode = "200", description = "read the elements by Id successfully")
    public ResponseEntity<Cast> getById(@PathVariable("id") Long castId){
        try{
            Cast casts = castService.getById(castId);
            return new ResponseEntity<>(casts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByName/{name}")
    @Operation(summary = "Read cast by name ", description = "an endpoint to read cast by name ")
    @ApiResponse(responseCode = "200", description = "read the elements by name successfully")
    public ResponseEntity<Cast> getByName(@PathVariable("name") String name){
        try{
            Cast casts = castService.getByName(name);
            return new ResponseEntity<>(casts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update cast by Id", description = "an endpoint to Update cast by Id")
    @ApiResponse(responseCode = "200", description = "Update the elements by Id successfully")
    public ResponseEntity<Cast> update(@PathVariable("id") Long castId, @RequestBody Cast updatedCast){
        try{
            Cast update = castService.update(castId, updatedCast);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete cast by Id", description = "an endpoint to Delete cast by Id")
    @ApiResponse(responseCode = "204", description = "Delete the elements by Id successfully")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id")Long castId){
        try{
            boolean deleted = castService.delete(castId);
            if (deleted){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
