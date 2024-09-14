package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.SubCategories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.SubCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class SubCategoriesService {


    private final SubCategoriesRepository subCategoriesRepository;

    public SubCategoriesService(SubCategoriesRepository subCategoriesRepository) {
        this.subCategoriesRepository = subCategoriesRepository;
    }

    @Transactional
    public SubCategories create(SubCategories subCategory) {

        subCategory.setName(subCategory.getName());
        if (subCategoriesRepository.findByName(subCategory.getName()).isPresent()) {
            throw new IllegalArgumentException("A subcategory with that name already exists.");
        }
        return subCategoriesRepository.save(subCategory);
    }

    @Transactional
    public List<SubCategories> readAll() throws Exception {
        try{
            return subCategoriesRepository.findAll();

        }catch (DataAccessException e){
            throw new Exception("ERROR: Sub Categories not have obtain from DATABASE");
        }

    }

    @Transactional
    public boolean getDeleteById(Long subCategoriesId) {
        try {
            Optional<SubCategories> subCategoriesOpt = subCategoriesRepository.findById(subCategoriesId);

            if (subCategoriesOpt.isEmpty()) {
                throw new IllegalArgumentException("Sub category with ID " + subCategoriesId + " not found.");
            }

            SubCategories subCategories = subCategoriesOpt.get();
            if (subCategories.isPredefined()) {
                throw new IllegalArgumentException("You can´t delete a predefined subcategory.");
            }

            subCategoriesRepository.deleteById(subCategoriesId);
            return !subCategoriesRepository.findById(subCategoriesId).isPresent();
        } catch (Exception e) {
            throw new RuntimeException("ERROR: Subcategory could´t be deleted by ID", e);
        }

    }

    @Transactional
    public boolean deleteByName(String name) {
        try {
            Optional<SubCategories> subCategoryOpt = subCategoriesRepository.findByName(name);

            if (subCategoryOpt.isEmpty()) {
                throw new IllegalArgumentException("Subcategory with name '" + name + "' not found.");
            }

            SubCategories subCategories = subCategoryOpt.get();
            if (subCategories.isPredefined()) {
                throw new IllegalArgumentException("You can´t delete a predefined subcategory.");
            }

            subCategoriesRepository.delete(subCategories);
            return !subCategoriesRepository.findByName(name).isPresent();
        } catch (Exception e) {
            throw new RuntimeException("ERROR: Subcategory could´t be deleted by name", e);
        }
    }



}
