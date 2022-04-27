package com.greenhi.peachland.mapper;

import com.greenhi.peachland.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greenhi.peachland.item.ItemCourse;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2022-04-25
 */
public interface CourseMapper extends BaseMapper<Course> {

    List<ItemCourse> getAll() throws Exception;

}
