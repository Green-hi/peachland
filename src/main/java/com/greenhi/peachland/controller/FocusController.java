package com.greenhi.peachland.controller;


import com.greenhi.peachland.entity.Comment;
import com.greenhi.peachland.entity.Focus;
import com.greenhi.peachland.service.CommentService;
import com.greenhi.peachland.service.FocusService;
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
@RequestMapping("/focus")
public class FocusController {

    @Autowired
    private FocusService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(Integer uid,Integer fid){
        return service.add(uid,fid);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(Integer uid,Integer fid){
        return service.delete(uid,fid);
    }

    @RequestMapping(value = "/selectByUid",method = RequestMethod.GET)
    public Result selectByUid(Integer uid){
        return service.selectByUid(uid) ;
    }

    @RequestMapping(value = "/selectByFid",method = RequestMethod.GET)
    public Result selectByFid(Integer fid){
        return service.selectByFid(fid) ;
    }

}

