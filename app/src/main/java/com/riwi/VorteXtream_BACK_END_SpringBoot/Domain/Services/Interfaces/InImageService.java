package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.ImageEntity;

import java.util.List;

public interface InImageService {
    ImageEntity upload(ImageEntity imageEntity);
    List<ImageEntity> getById(String imageId);
    boolean deleteById(String imageId);
}
