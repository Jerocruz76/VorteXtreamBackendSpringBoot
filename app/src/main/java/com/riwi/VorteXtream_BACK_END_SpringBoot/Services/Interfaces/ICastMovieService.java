package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.CastMovie;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Directors;

import java.util.List;

public interface ICastMovieService {

    List<CastMovie> readAll() throws Exception;

    Directors update(Long movieId, Directors updatedDirectors);

}
