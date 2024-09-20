package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.CastMovie;

import java.util.List;

public interface ICastMovieService {

    CastMovie create(CastMovie castMovie);

    CastMovie update(Long castMovieId, CastMovie updatedCastMovie);

    List <CastMovie> readAll() throws Exception;

    CastMovie getById(Long castMovieId) throws Exception;

    boolean getDeleteById(Long castMovieId);

}
