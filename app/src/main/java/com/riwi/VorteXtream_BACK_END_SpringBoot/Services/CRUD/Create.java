package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD;

public interface Create<EntityRequest, Entity>{
    public Entity create(EntityRequest entity);
}
