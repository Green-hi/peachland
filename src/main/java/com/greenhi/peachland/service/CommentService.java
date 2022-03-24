package com.greenhi.peachland.service;

import com.greenhi.peachland.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.unit.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 * @since 2022-03-14
 */
public interface CommentService extends IService<Comment> {
    Result add(Comment comment);

    Result delete(Integer id);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectCommentOne(Integer id);

    Result update(Comment comment);

    Result selectByDid(Integer did);
}
