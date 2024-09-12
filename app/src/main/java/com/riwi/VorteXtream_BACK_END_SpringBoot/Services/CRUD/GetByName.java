package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD;

public interface GetByName<Entity, Name>{
    public Entity getByName(Name name);
}
