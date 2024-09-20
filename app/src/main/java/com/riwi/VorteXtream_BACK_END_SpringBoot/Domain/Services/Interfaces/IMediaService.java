package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.MediaEntity;

import java.util.List;

public interface IMediaService {
    MediaEntity create(MediaEntity mediaEntity);

    MediaEntity update(Integer mediaId, MediaEntity updatedMedia);

    List<MediaEntity> readAll() throws Exception;

    MediaEntity getById(Integer mediaId) throws Exception;

    MediaEntity getByTitle(String name) throws Exception;

    boolean getDeleteTitle(String title);

}
