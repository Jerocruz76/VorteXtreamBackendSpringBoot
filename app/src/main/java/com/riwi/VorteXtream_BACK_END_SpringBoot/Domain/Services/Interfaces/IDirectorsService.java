package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Directors;

import java.util.List;

public interface IDirectorsService {

    Directors create(Directors directors);

    Directors update(Long directorsId, Directors updatedDirectors);

    List<Directors> readAll() throws Exception;

    Directors getById(Long directorId) throws Exception;

    Directors getByName(String name) throws Exception;

    boolean getDeleteById(Long directorsId);

}
