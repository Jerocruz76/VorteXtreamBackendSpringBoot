package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD.*;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ICategoriesService extends
        Create<Categories, Categories>,
    Update<String, Categories>,
    GetByName<Categories, String>,
    GetById<Categories, String>,
        Delete<String> {
    @Transactional
    List<Categories> readAll() throws Exception;
}
