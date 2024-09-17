package com.riwi.VorteXtream_BACK_END_SpringBoot.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl.CastService;
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
            return new ResponseEntity<>(HttpStatus.CREATED);
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

    @GetMapping("/{id}")
    public ResponseEntity<List<Cast>> getById(@PathVariable("id") String castId){
        try{
            List<Cast> casts = (List<Cast>) castService.getById(castId);
            return new ResponseEntity<>(casts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Cast>> getByName(@PathVariable("name") String castName){
        try{
            List<Cast> casts = (List<Cast>) castService.getByName(castName);
            return new ResponseEntity<>(casts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cast> update(@PathVariable("id") String castId, @RequestBody Cast updatedCast){
        try{
            Cast update = castService.update(castId, updatedCast);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id")String castId){
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
