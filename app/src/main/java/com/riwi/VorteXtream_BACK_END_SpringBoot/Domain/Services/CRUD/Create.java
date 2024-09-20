package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.CRUD;

public interface Create<EntityRequest, Entity>{
    public Entity create(EntityRequest entity);
}
