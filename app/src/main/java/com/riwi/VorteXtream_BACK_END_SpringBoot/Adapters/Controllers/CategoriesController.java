package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.CategoriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Create categories", description = "an endpoint to create a categories")
    @ApiResponse(responseCode = "201", description = "categories created successfuly")
    public ResponseEntity<Categories> create(@RequestBody Categories categories){
        try{
            Categories newCategory = categoriesService.create(categories);
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    @Operation(summary = "Read all categories", description = "an endpoint to read all categories")
    @ApiResponse(responseCode = "200", description = "Read all categories elements successfully")
    public ResponseEntity<List<Categories>> getAll(){
        try{
            List<Categories> categories = categoriesService.readAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Read categories by Id", description = "an endpoint to Read categories by Id")
    @ApiResponse(responseCode = "200", description = "the elements was Read by Id successfully")
    public ResponseEntity<Categories> getById(@PathVariable("id") Long categoriesId){
        try{
            Categories categories = categoriesService.getById(categoriesId);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByName/{name}")
    @Operation(summary = "Read categories by name ", description = "an endpoint to read categories by name ")
    @ApiResponse(responseCode = "200", description = "the elements was Read by name successfully")
    public ResponseEntity<Categories> getByName(@PathVariable("name") String categoriesName){
        try{
            Categories categories = categoriesService.getByName(categoriesName);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update categories by Id", description = "an endpoint to Update categories by Id")
    @ApiResponse(responseCode = "200", description = "the elements was Update by Id successfully")
    public ResponseEntity<Categories> update(@PathVariable("id") Long categoriesId, @RequestBody Categories updatedCategory){
        try{
            Categories update = categoriesService.update(categoriesId,updatedCategory);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete categories by Id", description = "an endpoint to Delete categories by Id")
    @ApiResponse(responseCode = "204", description = "Delete the elements by Id successfully")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long categoryId){
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
