package com.greenhi.peachland.service.impl;

import com.greenhi.peachland.entity.Comment;
import com.greenhi.peachland.mapper.CommentMapper;
import com.greenhi.peachland.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
