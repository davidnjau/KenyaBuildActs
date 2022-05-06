package com.bendave.kenyabuildacts.service;

import com.bendave.kenyabuildacts.DbActDetails;
import com.bendave.kenyabuildacts.Results;
import com.bendave.kenyabuildacts.entity.ActDetailsEntity;
import com.bendave.kenyabuildacts.repository.ActDetailsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActDetailsEntityServiceImpl {

    @Autowired
    private ActDetailsEntityRepository actDetailsEntityRepository;

    public Results saveActDetails(DbActDetails dbActDetails){

        ActDetailsEntity actDetailsEntity = new ActDetailsEntity();
        actDetailsEntity.setName(dbActDetails.getName());
        actDetailsEntity.setDescription(dbActDetails.getDesc());
        actDetailsEntity.setActId(dbActDetails.getActId());

        if (dbActDetails.getDesc() != null){
            actDetailsEntity.setDescription(dbActDetails.getDesc());
        }else {
            actDetailsEntity.setDescription("");
        }

        if (actDetailsEntityRepository.save(actDetailsEntity) != null){
            return new Results(200, "The data has been added successfully.");
        }else {
            return new Results(400, "The data could not be saved. Try again");
        }

    }

    public List<ActDetailsEntity> getAllActDetailsEntity(String id){
        return actDetailsEntityRepository.findByActId(id);
    }

    public ActDetailsEntity getActDetailsEntity(String id){
        Optional<ActDetailsEntity> optionalActDetailsEntity = actDetailsEntityRepository.findById(id);
        return optionalActDetailsEntity.orElse(null);
    }
}
