package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.peachland.entity.Comment;
import com.greenhi.peachland.mapper.CommentMapper;
import com.greenhi.peachland.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.peachland.unit.Result;
import com.greenhi.peachland.unit.ResultEnum;
import com.greenhi.peachland.unit.ResultUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override
    public Result add(Comment Comment) {
        if (getOne(new QueryWrapper<Comment>()
                .eq("id", Comment.getId())
        ) == null) {
            save(Comment);
            return ResultUtil.success("评论数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    @Override
    public Result delete(Integer id) {
        if (getOne(new QueryWrapper<Comment>()
                .eq("id", id)
        ) != null) {
            baseMapper.delete(new QueryWrapper<Comment>().eq("id",id));
            return ResultUtil.success("评论数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<Comment> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
//        wrapper.orderByAsc("id");
        IPage<Comment> CommentIPage = page(mPage, wrapper);
        if(CommentIPage != null){
            return ResultUtil.success(CommentIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    @Override
    public Result selectCommentOne(Integer id) {
        Comment CommentBase = getOne(new QueryWrapper<Comment>()
                .eq("id", id));
        if (CommentBase == null) {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        } else {
            return ResultUtil.success(CommentBase);
        }
    }

    @Override
    public Result update(Comment Comment) {
        if (getOne(new QueryWrapper<Comment>()
                .eq("id", Comment.getId())
        ) != null) {
            baseMapper.update(Comment, new QueryWrapper<Comment>()
                    .eq("id", Comment.getId()));
            return ResultUtil.success("评论数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
