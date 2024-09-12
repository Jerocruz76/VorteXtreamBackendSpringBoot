package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD;

public interface Update<EntityRequest, Entity>{
    public Entity update(EntityRequest entity);
}
