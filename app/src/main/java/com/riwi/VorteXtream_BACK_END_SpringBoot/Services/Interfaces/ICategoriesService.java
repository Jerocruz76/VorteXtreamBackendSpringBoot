package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD.*;

public interface ICategoriesService extends
        Create<Categories, Categories>,
    Update<Categories, Categories>,
    GetByName<Categories, String>,
    GetById<Categories, String>,
        Delete<String> {
}
