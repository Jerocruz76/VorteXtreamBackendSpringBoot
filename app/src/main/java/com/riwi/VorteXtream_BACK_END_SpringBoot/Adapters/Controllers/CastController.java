package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.CastService;
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
    public ResponseEntity<Cast> create(@RequestBody Cast cast){
        try{
            Cast newCast = castService.create(cast);
            return new ResponseEntity<>(newCast, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Cast>> readAll(){
        try{
            List<Cast> allCasts = castService.readAll();
            return new ResponseEntity<>(allCasts, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Cast> getById(@PathVariable("id") Long castId){
        try{
            Cast casts = castService.getById(castId);
            return new ResponseEntity<>(casts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Cast> getByName(@PathVariable("name") String name){
        try{
            Cast casts = castService.getByName(name);
            return new ResponseEntity<>(casts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cast> update(@PathVariable("id") Long castId, @RequestBody Cast updatedCast){
        try{
            Cast update = castService.update(castId, updatedCast);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
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
