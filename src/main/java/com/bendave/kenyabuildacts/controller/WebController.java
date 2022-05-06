package com.bendave.kenyabuildacts.controller;

import com.bendave.kenyabuildacts.entity.ActDetailsEntity;
import com.bendave.kenyabuildacts.entity.ActsEntity;
import com.bendave.kenyabuildacts.service.ActDetailsEntityServiceImpl;
import com.bendave.kenyabuildacts.service.ActsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ActsServiceImpl actsService;

    @Autowired
    private ActDetailsEntityServiceImpl actDetailsEntityService;

    @RequestMapping("/")
    public ModelAndView getHome(){

        ModelAndView modelAndView = new ModelAndView("index");
        List<ActsEntity> actsEntityList = actsService.getAllActsData();

        modelAndView.addObject("actsEntityList", actsEntityList);
        modelAndView.addObject("total", actsEntityList.size());


        return modelAndView;

    }

    @GetMapping("/act-details/{actId}")
    public ModelAndView actDetails(@PathVariable(value = "actId") String actId) {

        ModelAndView modelAndView = new ModelAndView("act_details");
        List<ActDetailsEntity> actDetailsEntityList = actDetailsEntityService.getAllActDetailsEntity(actId);
        modelAndView.addObject("actDetailsEntityList", actDetailsEntityList);
        modelAndView.addObject("total", actDetailsEntityList.size());

        return modelAndView;


    }

}
