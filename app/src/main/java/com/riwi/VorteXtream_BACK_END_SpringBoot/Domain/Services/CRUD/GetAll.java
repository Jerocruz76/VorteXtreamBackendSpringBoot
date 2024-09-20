package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.CRUD;

import java.util.List;

public interface GetAll<Entity>{
    public List<Entity> getAll();
}
