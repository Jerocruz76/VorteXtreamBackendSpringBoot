package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.CategoriesRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.ICategoriesService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
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
    @Transactional
    public boolean delete(String s) {
        try{
            categoriesRepository.deleteById(s);
            return categoriesRepository.findById(s).isPresent();
        }catch (Exception e){
            throw new RuntimeException("Cannot delete by Id");
        }
    }

    @Override
    @Transactional
    public Categories getById(String s) {
        try{
            return categoriesRepository.findById(s).orElseThrow();
        }catch (Exception e){
            throw new RuntimeException("Cannot find category");
        }
    }

    @Override
    @Transactional
    public Categories getByName(String s) {
        try{
            return categoriesRepository.findByName(s).orElseThrow();
        }catch (Exception e){
            throw new RuntimeException("Cannot find category");
        }
    }
}
