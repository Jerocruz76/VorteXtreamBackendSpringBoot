package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.CategoriesRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.ICategoriesService;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Categories> readAll() throws Exception {
        try{
            return categoriesRepository.findAll();
        }catch (DataAccessException e){
            throw new Exception("ERROR: Director not have obtain from DATABASE");
        }

    }

    @Override
    @Transactional
    public Categories update(Long id, Categories categories){
        try{
            Optional<Categories> existingCategory = categoriesRepository.findById(id);
            if (existingCategory.isPresent()){
                Categories categoryToUpdate = existingCategory.get();
                categoryToUpdate.setName(categories.getName());
                categoryToUpdate.setDescription(categories.getDescription());
                return categoriesRepository.save(categoryToUpdate);
            } else {
                throw new RuntimeException("Category not found or can't update");
            }

        }catch (Exception e){
            throw new RuntimeException("Category not found");
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try{
            categoriesRepository.deleteById(id);
            return categoriesRepository.findById(id).isPresent();
        }catch (Exception e){
            throw new RuntimeException("Cannot delete by Id");
        }
    }

    @Override
    @Transactional
    public Categories getById(Long id) {
        try{
            return categoriesRepository.findById(id).orElseThrow();
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
