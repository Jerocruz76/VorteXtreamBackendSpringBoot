package com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeStreamingRepository extends JpaRepository <TypeStreaming, Long> {
    Optional<TypeStreaming> findByName(String name);
}
