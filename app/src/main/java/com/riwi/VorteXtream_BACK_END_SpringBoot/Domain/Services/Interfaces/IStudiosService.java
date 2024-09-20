package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Studios;

import java.util.List;

public interface IStudiosService {

    Studios create(Studios studios);

    Studios update(Long studiosId, Studios updatedStudios);

    List<Studios> readAll() throws Exception;

    Studios getById(Long studioId) throws Exception;

    Studios getByName(String name) throws Exception;

    boolean getDeleteById(Long studiosId);

}
