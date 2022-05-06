package com.bendave.kenyabuildacts.service;

import com.bendave.kenyabuildacts.DbActs;
import com.bendave.kenyabuildacts.Results;
import com.bendave.kenyabuildacts.entity.ActsEntity;
import com.bendave.kenyabuildacts.repository.ActsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActsServiceImpl implements ActsService{

    @Autowired
    private ActsEntityRepository actsEntityRepository;

    @Override
    public Results createAct(DbActs dbActs) {

       ActsEntity actsEntity = addAct(dbActs.getActName());
       String actNameTxt = actsEntity.getActName() + " has been added.";
       return new Results(201, actNameTxt);

    }

    @Override
    public Results getActs() {

        return getAllActs();
    }

    public List<ActsEntity> getAllActsData(){
        return actsEntityRepository.findAll();
    }



    private Results getAllActs(){

        List<ActsEntity> actsEntityList = actsEntityRepository.findAll();
        return new Results(200, actsEntityList);

    }

    private ActsEntity addAct(String actName){

        ActsEntity actsEntity = new ActsEntity();
        actsEntity.setActName(actName);

        return actsEntityRepository.save(actsEntity);

    }
}
