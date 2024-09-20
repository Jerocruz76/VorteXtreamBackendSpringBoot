package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Directors;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories.DirectorsRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces.IDirectorsService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorsService implements IDirectorsService {

    private final DirectorsRepository directorsRepository;

    public DirectorsService(DirectorsRepository directorsRepository){
        this.directorsRepository = directorsRepository;
    }

    @Override
    @Transactional
    public Directors create(Directors directors) {
        try{
            Directors directorsCreated = Directors.builder()
                    .name(directors.getName())
                    .age(directors.getAge())
                    .synopsis(directors.getSynopsis())
                    .nationality(directors.getNationality())
                    .build();
            return directorsRepository.save(directorsCreated);

        }catch (Exception e){
            throw new RuntimeException("ERROR: Director not be created", e);

        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<Directors> readAll() throws Exception {
        try{
            return directorsRepository.findAll();

        }catch (DataAccessException e){
            throw new Exception("ERROR: Director not have obtain from DATABASE");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Directors getByName(String name) throws Exception {
        try {
            Optional<Directors> directors = directorsRepository.findByName(name);

            if (directors.isPresent()) {
                return directors.get();
            } else {
                throw new RuntimeException("ERROR: Director not found with name " + name);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve Director with name " + name, e);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public Directors getById(Long directorId) throws Exception {
        try {
            Optional<Directors> directors = directorsRepository.findById(directorId);

            if (directors.isPresent()) {
                return directors.get();
            } else {
                throw new RuntimeException("ERROR: Studio not found with ID " + directorId);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve Studio with ID " + directorId, e);
        }
    }


    @Override
    @Transactional
    public Directors update(Long directorsId, Directors updatedDirectors) {
        try {
            Optional<Directors> existingDirectors = directorsRepository.findById(directorsId);

            if (existingDirectors.isPresent()) {
                Directors directorToUpdate = existingDirectors.get();

                directorToUpdate.setName(updatedDirectors.getName());
                directorToUpdate.setAge(updatedDirectors.getAge());
                directorToUpdate.setSynopsis(updatedDirectors.getSynopsis());
                directorToUpdate.setNationality(updatedDirectors.getNationality());

                return directorsRepository.save(directorToUpdate);
            } else {
                throw new RuntimeException("ERROR: Director not found for update");
            }

        } catch (Exception e) {
            throw new RuntimeException("ERROR: Could not update director", e);
        }
    }

    @Override
    @Transactional
    public boolean getDeleteById(Long directorsId) {
        try{
            directorsRepository.deleteById(directorsId);
            if (directorsRepository.findById(directorsId) != null){
                return true;
            }
            return false;

        }catch (Exception e){
            throw new RuntimeException("ERROR: Director was not delete by ID");
        }

    }

}
