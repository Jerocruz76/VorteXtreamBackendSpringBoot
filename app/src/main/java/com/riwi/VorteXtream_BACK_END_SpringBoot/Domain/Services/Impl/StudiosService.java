package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Studios;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories.StudiosRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces.IStudiosService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudiosService implements IStudiosService {

    private final StudiosRepository studiosRepository;

    public StudiosService(StudiosRepository studiosRepository){
        this.studiosRepository = studiosRepository;
    }

    @Override
    @Transactional
    public Studios create(Studios studios) {
        try{
            Studios studiosCreated = Studios.builder()
                    .name(studios.getName())
                    .country(studios.getCountry())
                    .foundationYear(studios.getFoundationYear())
                    .build();
            return studiosRepository.save(studiosCreated);

        }catch (Exception e){
            throw new RuntimeException("ERROR: Studio not be created", e);

        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<Studios> readAll() throws Exception {
        try{
            return studiosRepository.findAll();

        }catch (DataAccessException e){
            throw new Exception("ERROR: Studio not have obtain from DATABASE");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Studios getByName(String name) throws Exception {
        try {
            Optional<Studios> studios = studiosRepository.findByName(name);

            if (studios.isPresent()) {
                return studios.get();
            } else {
                throw new RuntimeException("ERROR: Studios not found with name " + name);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve Studios with name " + name, e);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public Studios getById(Long studioId) throws Exception {
        try {
            Optional<Studios> studios = studiosRepository.findById(studioId);

            if (studios.isPresent()) {
                return studios.get();
            } else {
                throw new RuntimeException("ERROR: Studio not found with ID " + studioId);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve Studio with ID " + studioId, e);
        }
    }

    @Override
    @Transactional
    public Studios update(Long studiosId, Studios updatedStudios) {
        try {
            Optional<Studios> existingStudios = studiosRepository.findById(studiosId);

            if (existingStudios.isPresent()) {
                Studios studiosToUpdate = existingStudios.get();

                studiosToUpdate.setName(updatedStudios.getName());
                studiosToUpdate.setCountry(updatedStudios.getCountry());
                studiosToUpdate.setFoundationYear(updatedStudios.getFoundationYear());

                return studiosRepository.save(studiosToUpdate);
            } else {
                throw new RuntimeException("ERROR: Studio not found for update");
            }

        } catch (Exception e) {
            throw new RuntimeException("ERROR: Could not update Studio", e);
        }
    }

    @Override
    @Transactional
    public boolean getDeleteById(Long studiosId) {
        try{
            studiosRepository.deleteById(studiosId);
            if (studiosRepository.findById(studiosId) != null){
                return true;
            }
            return false;

        }catch (Exception e){
            throw new RuntimeException("ERROR: Studio was not delete by ID");
        }

    }

}
