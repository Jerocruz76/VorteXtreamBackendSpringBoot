package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.CastMovie;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Directors;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICastMovieService {

    CastMovie create(CastMovie castMovie);

    CastMovie update(Long castMovieId, CastMovie updatedCastMovie);

    List <CastMovie> readAll() throws Exception;

    CastMovie getById(Long castMovieId) throws Exception;

    CastMovie getByName(String name) throws Exception;

    boolean getDeleteById(Long castMovieId);

}
