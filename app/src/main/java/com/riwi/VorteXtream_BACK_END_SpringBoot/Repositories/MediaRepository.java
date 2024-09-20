package com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<MediaEntity, Integer> {
    Optional<MediaEntity> findByTitle(String title);
}
