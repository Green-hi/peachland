package com.greenhi.peachland.mapper;

import com.greenhi.peachland.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2022-03-14
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> selectByDid(Integer did) throws Exception;
}
