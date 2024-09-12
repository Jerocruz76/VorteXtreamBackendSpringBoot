package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.TypeStreamingRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.ITypeStreamingService;
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
