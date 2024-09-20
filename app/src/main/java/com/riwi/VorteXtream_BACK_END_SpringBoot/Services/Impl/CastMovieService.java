package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.CastMovie;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.CastMovieRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.TypeStreamingRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.ICastMovieService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CastMovieService implements ICastMovieService {

    private final CastMovieRepository castMovieRepository;

    public CastMovieService(CastMovieRepository castMovieRepository){
        this.castMovieRepository = castMovieRepository;
    }


    @Override
    @Transactional
    public CastMovie create(CastMovie castMovie) {
        try{
            CastMovie castMovieCreated = CastMovie.builder()
                    .studioId(castMovie.getStudioId())
                    .castId(castMovie.getCastId())
                    .directorId(castMovie.getDirectorId())
                    .mediaId(castMovie.getMediaId())
                    .build();
            return castMovieRepository.save(castMovieCreated);

        }catch (Exception e){
            throw new RuntimeException("ERROR: Cast movie not be created", e);

        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<CastMovie> readAll() throws Exception {
        try{
            return castMovieRepository.findAll();

        }catch (DataAccessException e){
            throw new Exception("ERROR: Cast movie not have obtain from DATABASE");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public CastMovie getByName(String name) throws Exception {
        try {
            Optional<CastMovie> castMovie = castMovieRepository.findByName(name);

            if (castMovie.isPresent()) {
                return castMovie.get();
            } else {
                throw new RuntimeException("ERROR: Cast movie not found with name " + name);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve cast movie with name " + name, e);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public CastMovie getById(Long castMovieId) throws Exception {
        try {
            Optional<CastMovie> castMovie = castMovieRepository.findById(castMovieId);

            if (castMovie.isPresent()) {
                return castMovie.get();
            } else {
                throw new RuntimeException("ERROR: Cast movie not found with ID " + castMovieId);
            }

        } catch (Exception e) {
            throw new Exception("ERROR: Could not retrieve cast movie with ID " + castMovieId, e);
        }
    }


    @Override
    @Transactional
    public CastMovie update(Long castMovieId, CastMovie updatedCastMovie) {
        try {
            Optional<CastMovie> existingCastMovie = castMovieRepository.findById(castMovieId);

            if (existingCastMovie.isPresent()) {
                CastMovie castMovieToUpdate = existingCastMovie.get();

                castMovieToUpdate.setName(updatedCastMovie.getName());

                return castMovieRepository.save(castMovieToUpdate);
            } else {
                throw new RuntimeException("ERROR: Cast movie not found for update");
            }

        } catch (Exception e) {
            throw new RuntimeException("ERROR: Could not update cast movie", e);
        }
    }

    @Override
    @Transactional
    public boolean getDeleteById(Long castMovieId) {
        try{
            castMovieRepository.deleteById(castMovieId);
            if (castMovieRepository.findById(castMovieId) != null){
                return true;
            }
            return false;

        }catch (Exception e){
            throw new RuntimeException("ERROR: Cast movie was not delete by ID");
        }

    }
}
