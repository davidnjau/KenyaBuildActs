package com.bendave.kenyabuildacts.controller;

import com.bendave.kenyabuildacts.*;
import com.bendave.kenyabuildacts.service.ActDetailsEntityServiceImpl;
import com.bendave.kenyabuildacts.service.ActsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/kenya-acts")
@RestController
public class ActsController {

    @Autowired
    private ActsServiceImpl actsService;
    @Autowired
    private ActDetailsEntityServiceImpl actDetailsEntityService;

    @RequestMapping(value = "/all")
    public ResponseEntity<?> getFacility(){

        Results results = actsService.getActs();
        return getResponse(results);

    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody DbActs dbActs){

        Results addedResults = actsService.createAct(dbActs);
        return getResponse(addedResults);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> saveActDetails(@RequestBody DbActDetails dbActDetails){

        Results addedResults = actDetailsEntityService.saveActDetails(dbActDetails);
        return getResponse(addedResults);

    }

    private ResponseEntity<?> getResponse(Results results){

        int code = results.getCode();

        if (code == 200 || code == 201){
            return new ResponseEntity(new ResponseMessage(results.getDetails()), HttpStatus.OK);
        }else {

            if (code == 400){
                return ResponseEntity.badRequest().body(new ResponseMessage(results.getDetails()));
            }else {
                return ResponseEntity.internalServerError().body(new ResponseMessage("There was an error with your request."));
            }

        }





    }

}
