package com.greenhi.peachland.controller;

import com.greenhi.peachland.entity.Comment;
import com.greenhi.peachland.service.CommentService;
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
 * @since 2022-03-14
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody Comment comment){
        return service.add(comment);
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
        return service.selectCommentOne(id) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Comment comment){
        return service.update(comment);
    }

    @RequestMapping(value = "/selectByDid",method = RequestMethod.GET)
    public Result selectByDid(Integer did){
        return service.selectByDid(did);
    }
}

