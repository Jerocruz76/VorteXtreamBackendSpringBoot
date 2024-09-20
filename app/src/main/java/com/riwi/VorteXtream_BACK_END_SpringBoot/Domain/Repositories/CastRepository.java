package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CastRepository extends JpaRepository<Cast, Long> {
    Optional<Cast> findByName(String name);
}
