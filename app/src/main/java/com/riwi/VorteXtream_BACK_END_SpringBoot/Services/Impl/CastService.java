package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.CastRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.ICastService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
                    .urlImage(cast.getUrlImage())
                    .build();
            return castRepository.save(createdCast);
        }catch (Exception e){
            throw new RuntimeException("Cannot create cast");
        }
    }

    @Override
    @Transactional
    public boolean delete(String id) {
        try{
            castRepository.deleteById(id);
            return castRepository.findById(id).isPresent();
        }catch (Exception e){
            throw new RuntimeException("Cannot delete cast");
        }
    }

    @Override
    @Transactional
    public Cast getById(String id) {
        return null;
    }

    @Override
    @Transactional
    public Cast getByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public Cast update(Cast cast) {
        return null;
    }
}
