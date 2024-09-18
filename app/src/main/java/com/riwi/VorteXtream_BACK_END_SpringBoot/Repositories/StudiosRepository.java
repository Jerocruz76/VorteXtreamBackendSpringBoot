package com.riwi.VorteXtream_BACK_END_SpringBoot.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Studios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudiosRepository extends JpaRepository <Studios, Long> {
    Optional<Studios> findByName(String name);
}
