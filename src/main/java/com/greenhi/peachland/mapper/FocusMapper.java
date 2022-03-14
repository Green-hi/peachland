package com.greenhi.peachland.mapper;

import com.greenhi.peachland.entity.Focus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greenhi.peachland.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 */
public interface FocusMapper extends BaseMapper<Focus> {
    void deleteByUidAndFid(Integer uid, Integer fid);
    List<User> selectByUid(Integer uid);
    List<User> selectByFid(Integer fid);
}
