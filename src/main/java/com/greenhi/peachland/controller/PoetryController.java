package com.greenhi.peachland.controller;


import com.greenhi.peachland.entity.Poetry;
import com.greenhi.peachland.service.PoetryService;
import com.greenhi.peachland.unit.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/poetry")
public class PoetryController {
    @Autowired
    private PoetryService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody Poetry Poetry){
        return service.add(Poetry);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(String poetryId){
        return service.delete(poetryId);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneById",method = RequestMethod.GET)
    public Result selectOneById(String poetryId){
        return service.selectPoetryOne(poetryId) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Poetry poetry){
        return service.update(poetry);
    }

}

