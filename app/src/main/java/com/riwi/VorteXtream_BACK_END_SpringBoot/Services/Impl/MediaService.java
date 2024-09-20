package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Impl;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.MediaEntity;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories.MediaRepository;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces.IMediaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService  implements IMediaService {

    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    @Transactional
    public MediaEntity create(MediaEntity mediaEntity) {
        try{
            MediaEntity createdMedia = MediaEntity.builder()
                    .title(mediaEntity.getTitle())
                    .description(mediaEntity.getDescription())
                    .publicationDate(mediaEntity.getPublicationDate())
                    .cast(mediaEntity.getCast())
                    .categories(mediaEntity.getCategories())
                    .directors(mediaEntity.getDirectors())
                    .imageEntity(mediaEntity.getImageEntity())
                    .studios(mediaEntity.getStudios())
                    .subCategories(mediaEntity.getSubCategories())
                    .typeStreaming(mediaEntity.getTypeStreaming())
                    .build();
            return mediaRepository.save(createdMedia);
        }catch (Exception e){
            throw new RuntimeException("Cannot create media", e);
        }
    }

    @Override
    @Transactional
    public MediaEntity update(Integer mediaId, MediaEntity updatedMedia) {
        try{
            Optional<MediaEntity> existingMedia = mediaRepository.findById(mediaId);

            if (existingMedia.isPresent()){
                MediaEntity mediaToUpdate = existingMedia.get();

                mediaToUpdate.setTitle(updatedMedia.getTitle());
                mediaToUpdate.setDescription(updatedMedia.getDescription());
                mediaToUpdate.setPublicationDate(updatedMedia.getPublicationDate());
                mediaToUpdate.setCast(updatedMedia.getCast());
                mediaToUpdate.setCategories(updatedMedia.getCategories());
                mediaToUpdate.setDirectors(updatedMedia.getDirectors());
                mediaToUpdate.setImageEntity(updatedMedia.getImageEntity());
                mediaToUpdate.setSubCategories(updatedMedia.getSubCategories());
                mediaToUpdate.setTypeStreaming(updatedMedia.getTypeStreaming());

                return mediaRepository.save(mediaToUpdate);
            }else {
                throw new RuntimeException("Cannot find media");
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot update media", e);
        }
    }

    @Override
    @Transactional
    public List<MediaEntity> readAll() throws Exception {
        try{
            return mediaRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Cannot find media from database", e);
        }
    }

    @Override
    @Transactional
    public MediaEntity getById(Integer mediaId) throws Exception {
        try{
            Optional<MediaEntity> media = mediaRepository.findById(mediaId);

            if (media.isPresent()){
                return media.get();
            }else {
                throw new RuntimeException("Cannot find media with id: " + mediaId);
            }
        }catch (Exception e){
            throw new RuntimeException("Internal connection error", e);
        }
    }

    @Override
    @Transactional
    public MediaEntity getByTitle(String title) {
        try{
            Optional<MediaEntity> media = mediaRepository.findByTitle(title);
            if (media.isPresent()){
                return media.get();
            }else {
                throw new RuntimeException("Cannot find media with title: " + title);
            }
        }catch (Exception e){
            throw new RuntimeException("Internal connection error", e);
        }
    }

    @Override
    @Transactional
    public boolean getDeleteTitle(String title) {
        try{
            mediaRepository.findByTitle(title);
            if (mediaRepository.findByTitle(title).isPresent()){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException("Internal connection error", e);
        }
    }
}
