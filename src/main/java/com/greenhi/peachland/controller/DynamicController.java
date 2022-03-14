package com.greenhi.peachland.controller;


import com.greenhi.peachland.entity.Dynamic;
import com.greenhi.peachland.service.DynamicService;
import com.greenhi.peachland.service.DynamicService;
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
 * @since 2022-03-13
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {
    @Autowired
    private DynamicService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody Dynamic dynamic){
        return service.add(dynamic);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneById",method = RequestMethod.GET)
    public Result selectOneById(Integer id){
        return service.selectDynamicOne(id) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Dynamic dynamic){
        return service.update(dynamic);
    }

    @RequestMapping(value = "/selectByUid",method = RequestMethod.GET)
    public Result selectByUid(Integer uid){
        return service.selectByUid(uid) ;
    }

    @RequestMapping(value = "/selectFocusByUid",method = RequestMethod.GET)
    public Result selectFocusByUid(Integer uid){
        return service.selectFocusByUid(uid) ;
    }

    @RequestMapping(value = "/addLikeById",method = RequestMethod.POST)
    public Result addLikeById(Integer id){
        return service.addLikeById(id) ;
    }

    @RequestMapping(value = "/addCommById",method = RequestMethod.POST)
    public Result addCommById(Integer id){
        return service.addCommById(id) ;
    }
}

