package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Repositories;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.SubCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubCategoriesRepository extends JpaRepository<SubCategories, Long> {

    void deleteByName(String name);
    Optional<SubCategories> findByName(String name);

}



