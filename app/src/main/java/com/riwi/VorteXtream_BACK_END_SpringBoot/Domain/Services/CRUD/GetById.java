package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.CRUD;

public interface GetById<Entity, ID>{
    public Entity getById(ID id);
}
