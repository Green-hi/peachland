package com.greenhi.peachland.service;

import com.greenhi.peachland.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.peachland.unit.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2022-04-25
 */
public interface CourseService extends IService<Course> {

    Result add(Course course);

    Result delete(Integer id);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectCourseOne(Integer id);

    Result update(Course course);

}
