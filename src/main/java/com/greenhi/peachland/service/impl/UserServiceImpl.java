package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.peachland.controller.UserController;
import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.mapper.UserMapper;
import com.greenhi.peachland.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.peachland.unit.Result;
import com.greenhi.peachland.unit.ResultEnum;
import com.greenhi.peachland.unit.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${uploadDir_head}")
    private String uploadDir_head;

    @Override
    public Result add(User user) {
        if (getOne(new QueryWrapper<User>()
                .eq("id", user.getId())
        ) == null) {
            save(user);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("msg","用户数据添加成功");
            resultMap.put("id",user.getId());
            return ResultUtil.success(resultMap);
        } else {
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }
    }

    @Override
    public Result delete(String uid) {
        if (getOne(new QueryWrapper<User>()
                .eq("id", uid)
        ) != null) {
            baseMapper.delete(new QueryWrapper<User>().eq("id",uid));
            return ResultUtil.success("用户数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        }
    }

    @Override
    public Result addFunsById(Integer id, boolean add) {
        try {
            if(add){
                baseMapper.addFunsById(id);
            }else {
                baseMapper.subFunsById(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(), ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success();
    }

    @Override
    public Result addFocusById(Integer id, boolean add) {
        try {
            if(add){
                baseMapper.addFocusById(id);
            }else {
                baseMapper.subFocusById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(), ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success();
    }

    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<User> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.orderByAsc("id");
        IPage<User> userIPage = page(mPage, wrapper);
        if(userIPage != null){
            return ResultUtil.success(userIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    @Override
    public Result selectOneByUid(String uid) {
        User userBase = getOne(new QueryWrapper<User>()
                .eq("uid", uid));
        if (userBase == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(userBase);
        }
    }

    @Override
    public Result selectOneById(String id) {
        User userBase = getOne(new QueryWrapper<User>()
                .eq("id", id));
        if (userBase == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(userBase);
        }
    }

    @Override
    public Result update(User user) {
        if (getOne(new QueryWrapper<User>()
                .eq("id", user.getId())
        ) != null) {
            baseMapper.update(user, new QueryWrapper<User>()
                    .eq("id", user.getId()));
            return ResultUtil.success("用户数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }

    @Override
    public Result uploadFile(Integer id, MultipartFile file) {
        if(id == null){
            return ResultUtil.error(ResultEnum.ID_NOT_EXISTS.getCode(), ResultEnum.ID_NOT_EXISTS.getMsg());
        }
        if (getOne(new QueryWrapper<User>()
                .eq("id", id)
        ) == null){
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        }
        if (file.isEmpty()) {
            return ResultUtil.error(ResultEnum.FILE_NOT_EXISTS.getCode(), ResultEnum.FILE_NOT_EXISTS.getMsg());
        }
        //logger.info("上传的文件名为：" + fileName);
        // 上传时的文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件的后缀名
//        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //logger.info("上传的后缀名为：" + suffixName);
        // 解决中文问题，linux下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(uploadDir_head + id + ".png");
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            logger.info("~~~~~~~~~该目录不存在，新建~~~~~~~~");
            dest.getParentFile().mkdirs();
        }
        logger.info("Absolute directory: "+dest.getParentFile().getAbsoluteFile());
        //上传文件到dest
        try {
            file.transferTo(dest.getAbsoluteFile());
            logger.info("上传成功后的文件路径为：" + dest);
            return ResultUtil.success("文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.FILE_NOT_UPLOADS.getCode(), ResultEnum.FILE_NOT_UPLOADS.getMsg());
        }
    }

}
