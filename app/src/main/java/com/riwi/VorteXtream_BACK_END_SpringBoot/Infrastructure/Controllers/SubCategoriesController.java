package com.riwi.VorteXtream_BACK_END_SpringBoot.Infrastructure.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.SubCategories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.SubCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subCategories")
public class SubCategoriesController {

    private final SubCategoriesService subCategoriesService;

    @Autowired
    public SubCategoriesController(SubCategoriesService subCategoriesService) {
        this.subCategoriesService = subCategoriesService;
    }

    @PostMapping("/create")
    public ResponseEntity<SubCategories> createSubCategories(@RequestBody SubCategories subCategories) {
        try {
            SubCategories createdSubCategories = subCategoriesService.create(subCategories);
            return new ResponseEntity<>(createdSubCategories, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);  // If name allready exist
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // other problems
        }
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<SubCategories>> getAllSubCategories() {
        try {
            List<SubCategories> subCategories = subCategoriesService.readAll();
            return new ResponseEntity<>(subCategories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // error get data
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteSubCategoriesById(@PathVariable Long id) {
        try {
            boolean isDeleted = subCategoriesService.getDeleteById(id);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // fine delete
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // id not found
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Subcategory not found o predefinit
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // delete error
        }
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Void> deleteSubCategoriesByName(@PathVariable String name) {
        try {
            boolean isDeleted = subCategoriesService.deleteByName(name);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // fine delete
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // name not found
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Subcategory not found o predefinit
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // delete error
        }
    }
}

