package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.CRUD.*;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ICategoriesService extends
        Create<Categories, Categories>,
        Update<Long, Categories>,
        GetByName<Categories, String>,
        GetById<Categories, Long>,
        Delete<Long> {
    @Transactional
    List<Categories> readAll() throws Exception;
}
