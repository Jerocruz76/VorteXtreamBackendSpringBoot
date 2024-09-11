package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import java.util.List;


public interface ITypeStreamingService {

    TypeStreaming create(TypeStreaming typeStreaming);

    TypeStreaming update(Long typeStreamingId, TypeStreaming updatedTypeStreaming);

    List <TypeStreaming> readAll() throws Exception;

    boolean getDeleteById(Long typeStreamingId);

}

