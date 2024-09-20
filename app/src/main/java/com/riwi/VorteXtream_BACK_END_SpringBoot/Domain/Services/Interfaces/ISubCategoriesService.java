package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.SubCategories;

import java.util.List;

public interface ISubCategoriesService {

    SubCategories create(SubCategories subCategories);

    List<SubCategories> readAll() throws Exception;

    boolean getDeleteById(Long SubCategoriesId) throws Exception;

    boolean getDeleteByName(String SubCategoriesName) throws Exception;

}
