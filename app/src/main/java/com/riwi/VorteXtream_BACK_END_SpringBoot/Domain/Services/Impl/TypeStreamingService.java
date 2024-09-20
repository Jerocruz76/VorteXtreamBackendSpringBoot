package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.TypeStreaming;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories.TypeStreamingRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces.ITypeStreamingService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class TypeStreamingService implements ITypeStreamingService {

    private final TypeStreamingRepository typeStreamingRepository;

    public TypeStreamingService(TypeStreamingRepository typeStreamingRepository){
        this.typeStreamingRepository = typeStreamingRepository;
    }


    @Override
    @Transactional
    public TypeStreaming create(TypeStreaming typeStreaming) {
        try{
            TypeStreaming typeStreamingCreated = TypeStreaming.builder()
                    .name(typeStreaming.getName())
                    .build();
            return typeStreamingRepository.save(typeStreamingCreated);

        }catch (Exception e){
            throw new RuntimeException("ERROR: Type streaming not be created", e);

        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeStreaming> readAll() throws Exception {
        try{
            return typeStreamingRepository.findAll();

        }catch (DataAccessException e){
            throw new Exception("ERROR: TypeStreaming not have obtain from DATABASE");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public TypeStreaming getByName(String name) throws Exception {
        try {
            Optional<TypeStreaming> typeStreaming = typeStreamingRepository.findByName(name);

            if (typeStreaming.isPresent()) {
                return typeStreaming.get();
            } else {
                throw new RuntimeException("ERROR: TypeStreaming not found with name " + name);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve TypeStreaming with name " + name, e);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public TypeStreaming getById(Long typeStreamingId) throws Exception {
        try {
            Optional<TypeStreaming> typeStreaming = typeStreamingRepository.findById(typeStreamingId);

            if (typeStreaming.isPresent()) {
                return typeStreaming.get();
            } else {
                throw new RuntimeException("ERROR: TypeStreaming not found with ID " + typeStreamingId);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve TypeStreaming with ID " + typeStreamingId, e);
        }
    }


    @Override
    @Transactional
    public TypeStreaming update(Long typeStreamingId, TypeStreaming updatedTypeStreaming) {
        try {
            Optional<TypeStreaming> existingTypeStreaming = typeStreamingRepository.findById(typeStreamingId);

            if (existingTypeStreaming.isPresent()) {
                TypeStreaming typeStreamingToUpdate = existingTypeStreaming.get();

                typeStreamingToUpdate.setName(updatedTypeStreaming.getName());

                return typeStreamingRepository.save(typeStreamingToUpdate);
            } else {
                throw new RuntimeException("ERROR: TypeStreaming not found for update");
            }

        } catch (Exception e) {
            throw new RuntimeException("ERROR: Could not update TypeStreaming", e);
        }
    }

    @Override
    @Transactional
    public boolean getDeleteById(Long typeStreamingId) {
        try{
            typeStreamingRepository.deleteById(typeStreamingId);
            if (typeStreamingRepository.findById(typeStreamingId) != null){
                return true;
            }
            return false;

        }catch (Exception e){
            throw new RuntimeException("ERROR: TypeStreaming was not delete by ID");
        }

    }
}
