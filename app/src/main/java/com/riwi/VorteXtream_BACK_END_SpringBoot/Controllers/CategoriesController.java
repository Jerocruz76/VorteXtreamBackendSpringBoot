package com.riwi.VorteXtream_BACK_END_SpringBoot.Controllers;


import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/create")
    public ResponseEntity<Categories> create(@RequestBody Categories categories){
        try{
            Categories newCategory = categoriesService.create(categories);
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Categories>> getAll(){
        try{
            List<Categories> categories = categoriesService.readAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Categories>> getById(@PathVariable("id") String categoriesId){
        try{
            List<Categories> categories = (List<Categories>) categoriesService.getById(categoriesId);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Categories>> getByName(@PathVariable("name") String categoriesName){
        try{
            List<Categories> categories = (List<Categories>) categoriesService.getByName(categoriesName);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categories> update(@PathVariable("id") String categoriesId, @RequestBody Categories updatedCategory){
        try{
            Categories update = categoriesService.update(categoriesId,updatedCategory);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") String categoryId){
        try{
            boolean deleted = categoriesService.delete(categoryId);
            if (deleted){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}