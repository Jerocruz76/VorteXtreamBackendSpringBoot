package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.CRUD;

public interface Update<ID, Entity>{
    public Entity update(ID id, Entity entity);
}
