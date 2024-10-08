package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories.CastRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces.ICastService;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastService implements ICastService {

    private final CastRepository castRepository;

    public CastService(CastRepository castRepository){
        this.castRepository = castRepository;
    }

    @Override
    @Transactional
    public Cast create(Cast cast) {
        try{
            Cast createdCast = Cast.builder()
                    .name(cast.getName())
                    .build();
            return castRepository.save(createdCast);
        }catch (Exception e){
            throw new RuntimeException("Cannot create cast", e);
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try{
            castRepository.deleteById(id);
            return castRepository.findById(id).isPresent();
        }catch (Exception e){
            throw new RuntimeException("Cannot delete cast", e);
        }
    }

    @Override
    @Transactional
    public List<Cast> readAll() throws Exception {
        try{
            return castRepository.findAll();
        }catch (DataAccessException e){
            throw new Exception("ERROR: Director not have obtain from DATABASE");
        }

    }

    @Override
    @Transactional
    public Cast getById(Long id) {
        try{
            return castRepository.findById(id).orElseThrow();
        }catch (Exception e){
            throw new RuntimeException("Cannot get cast", e);
        }
    }

    @Override
    @Transactional
    public Cast getByName(String name) {
        try{
            return castRepository.findByName(name).orElseThrow();
        }catch (Exception e){
            throw new RuntimeException("Cannot get cast by name", e);
        }
    }

    @Override
    @Transactional
    public Cast update(Long id, Cast cast) {
        try{
            Optional<Cast> existingCast = castRepository.findById(id);
            if (existingCast.isPresent()){
                Cast castToUpdate = existingCast.get();
                castToUpdate.setName(cast.getName());
                return castRepository.save(castToUpdate);
            }else{
                throw new RuntimeException("Can't find cast or can't update");
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot update cast", e);
        }
    }
}
