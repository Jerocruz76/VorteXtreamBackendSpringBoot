package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.TypeStreaming;
import java.util.List;


public interface ITypeStreamingService {

    TypeStreaming create(TypeStreaming typeStreaming);

    TypeStreaming update(Long typeStreamingId, TypeStreaming updatedTypeStreaming);

    List <TypeStreaming> readAll() throws Exception;

    TypeStreaming getById(Long typeStreamingId) throws Exception;

    TypeStreaming getByName(String name) throws Exception;

    boolean getDeleteById(Long typeStreamingId);

}

