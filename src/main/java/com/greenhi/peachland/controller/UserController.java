package com.greenhi.peachland.controller;


import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.service.UserService;
import com.greenhi.peachland.unit.Result;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        return service.add(user);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(String uid){
        return service.delete(uid);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneByUid",method = RequestMethod.GET)
    public Result selectOneByUid(String uid){
        return service.selectUserOne(uid) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody User user){
        return service.update(user);
    }

    @RequestMapping(value = "/uploadHead",method = RequestMethod.POST)
    public Result uploadHead(Integer id, @RequestParam(value = "head") MultipartFile head){
        return service.uploadFile(id, head);
    }

}

