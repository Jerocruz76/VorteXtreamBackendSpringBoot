package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.CategoriesRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.ICategoriesService;
import jakarta.transaction.Transactional;

import java.util.Optional;

public class CategoriesService implements ICategoriesService {

    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    @Transactional
    public Categories create(Categories categories){
        try{
            Categories createdCategory = Categories.builder()
                    .name(categories.getName())
                    .description(categories.getDescription())
                    .build();
            return categoriesRepository.save(createdCategory);
        }catch (Exception e){
            throw new RuntimeException("Category not be created", e);
        }
    }

    @Override
    @Transactional
    public Categories update(Categories categories){
        try{
            Categories categoryToUpdate = categoriesRepository.getReferenceById(categories.getId());
            categoryToUpdate.setName(categories.getName());
            categoryToUpdate.setDescription(categories.getDescription());
            return categoriesRepository.save(categoryToUpdate);
        }catch (Exception e){
            throw new RuntimeException("Cannot update category");
        }
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Categories getById(String s) {
        return null;
    }

    @Override
    public Categories getByName(String s) {
        return null;
    }
}
