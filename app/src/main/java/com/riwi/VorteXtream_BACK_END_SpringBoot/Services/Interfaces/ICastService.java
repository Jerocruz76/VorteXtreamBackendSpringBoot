package com.riwi.VorteXtream_BACK_END_SpringBoot.Services.Interfaces;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Entities.Cast;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Services.CRUD.*;

public interface ICastService extends
        Create<Cast, Cast>,
        Update<Cast, Cast>,
        GetByName<Cast, String>,
        GetById<Cast, String>,
        Delete<String> {
}
