package com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.CastMovie;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.TypeStreaming;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CastMovieRepository extends JpaRepository<CastMovie, Long> {
    Optional<CastMovie> findByName(String name);
}
