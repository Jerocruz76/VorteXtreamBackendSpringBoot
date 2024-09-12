package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD;

public interface GetById<Entity, ID>{
    public Entity getById(ID id);
}
