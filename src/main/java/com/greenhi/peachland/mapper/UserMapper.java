package com.greenhi.peachland.mapper;

import com.greenhi.peachland.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
public interface UserMapper extends BaseMapper<User> {
    void addFunsById(Integer id) throws Exception;

    void addFocusById(Integer id) throws Exception;

    void subFunsById(Integer id) throws Exception;

    void subFocusById(Integer id) throws Exception;
}
