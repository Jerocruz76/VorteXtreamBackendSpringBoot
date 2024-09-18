package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Directors;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Studios;

import java.util.List;

public interface IDirectorsService {

    Directors create(Directors directors);

    Directors update(Long directorsId, Directors updatedDirectors);

    List<Directors> readAll() throws Exception;

    Directors getById(Long directorId) throws Exception;

    Directors getByName(String name) throws Exception;

    boolean getDeleteById(Long directorsId);

}
