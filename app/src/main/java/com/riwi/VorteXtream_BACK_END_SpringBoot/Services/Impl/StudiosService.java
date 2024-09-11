package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Studios;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.StudiosRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.IStudiosService;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
