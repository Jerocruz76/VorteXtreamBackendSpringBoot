package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.ImageEntity;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public List<ImageEntity> List(){
        return imageRepository.findByOrderById();
    }

    public Optional<ImageEntity> getOne(int id){
        return imageRepository.findById(id);
    }

    public void save(ImageEntity imageEntity){
        imageRepository.save(imageEntity);
    }

    public void delete(int id){
        imageRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imageRepository.existsById(id);
    }
}
