package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Categories;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD.*;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ICastService extends
        Create<Cast, Cast>,
        Update<String, Cast>,
        GetByName<Cast, String>,
        GetById<Cast, String>,
        Delete<String>{
    @Transactional
    List<Cast> readAll() throws Exception;
}
