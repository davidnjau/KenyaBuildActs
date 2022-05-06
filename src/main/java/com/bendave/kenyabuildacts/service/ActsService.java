package com.bendave.kenyabuildacts.service;

import com.bendave.kenyabuildacts.DbActs;
import com.bendave.kenyabuildacts.Results;

public interface ActsService {

    Results createAct(DbActs dbActs);
    Results getActs();

}
