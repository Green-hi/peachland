package com.greenhi.peachland.controller;

import com.greenhi.peachland.entity.Course;
import com.greenhi.peachland.service.CourseService;
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
 * @since 2022-04-25
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody Course course){
        return service.add(course);
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
        return service.selectCourseOne(id) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Course course){
        return service.update(course);
    }

}

