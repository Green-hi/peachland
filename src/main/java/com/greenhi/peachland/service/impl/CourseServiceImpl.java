package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.peachland.entity.Course;
import com.greenhi.peachland.entity.Course;
import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.mapper.CourseMapper;
import com.greenhi.peachland.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.peachland.service.UserService;
import com.greenhi.peachland.unit.Result;
import com.greenhi.peachland.unit.ResultEnum;
import com.greenhi.peachland.unit.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2022-04-25
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private UserService service;

    @Override
    public Result add(Course Course) {
        if (service.getOne(new QueryWrapper<User>()
                .eq("id", Course.getAuthorId())
        ) != null) {
            save(Course);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("msg","课程数据添加成功");
            resultMap.put("id",Course.getId());
            return ResultUtil.success(resultMap);
        } else {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        }
    }

    @Override
    public Result delete(Integer id) {
        if (getOne(new QueryWrapper<Course>()
                .eq("id", id)
        ) != null) {
            baseMapper.delete(new QueryWrapper<Course>().eq("id",id));
            return ResultUtil.success("课程数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<Course> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
//        wrapper.orderByAsc("id");
        IPage<Course> CourseIPage = page(mPage, wrapper);
        if(CourseIPage != null){
            return ResultUtil.success(CourseIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    @Override
    public Result selectCourseOne(Integer id) {
        Course CourseBase = getOne(new QueryWrapper<Course>()
                .eq("id", id));
        if (CourseBase == null) {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        } else {
            return ResultUtil.success(CourseBase);
        }
    }

    @Override
    public Result update(Course Course) {
        if (getOne(new QueryWrapper<Course>()
                .eq("id", Course.getId())
        ) != null) {
            baseMapper.update(Course, new QueryWrapper<Course>()
                    .eq("id", Course.getId()));
            return ResultUtil.success("课程数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }

}
