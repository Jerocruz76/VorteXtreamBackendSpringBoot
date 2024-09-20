package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.CastMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CastMovieRepository extends JpaRepository<CastMovie, Long> {
}
