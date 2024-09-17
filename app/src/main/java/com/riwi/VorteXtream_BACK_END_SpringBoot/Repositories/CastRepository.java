package com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CastRepository extends JpaRepository<Cast, String> {
    Optional<Cast> findByName(String name);
}
