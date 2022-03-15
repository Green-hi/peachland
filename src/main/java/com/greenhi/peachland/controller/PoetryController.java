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
    public Result delete(String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Result selectById(String id){
        return service.selectPoetryOne(id) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Poetry poetry){
        return service.update(poetry);
    }

    @RequestMapping(value = "/selectByTitleBase",method = RequestMethod.GET)
    public Result selectByTitleBase(String title){
        return service.selectByTitleBase(title) ;
    }

    @RequestMapping(value = "/getTitleByAuthor",method = RequestMethod.GET)
    public Result getTitleByAuthor(String author){
        return service.selectTitleByAuthor(author) ;
    }

    @RequestMapping(value = "/getTitleByTheme",method = RequestMethod.GET)
    public Result getTitleByTheme(String theme){
        return service.selectTitleByTheme(theme) ;
    }

    @RequestMapping(value = "/getTitleByDiff",method = RequestMethod.GET)
    public Result getTitleByDiff(String diff){
        return service.selectTitleByDiff(diff) ;
    }

    @RequestMapping(value = "/getTitleByDynasty",method = RequestMethod.GET)
    public Result getTitleByDynasty(String dynasty){
        return service.selectTitleByDynasty(dynasty) ;
    }

    @RequestMapping(value = "/getTransByTitle",method = RequestMethod.GET)
    public Result getTransByTitle(String title){
        return service.getTransByTitle(title) ;
    }

}

