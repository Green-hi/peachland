package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.mapper.UserMapper;
import com.greenhi.peachland.service.UserService;
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
 * @since 2022-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Result add(User user) {
        if (getOne(new QueryWrapper<User>()
                .eq("id", user.getId())
        ) == null) {
            save(user);
            return ResultUtil.success("用户数据添加成功");
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
    public Result selectUserOne(String uid) {
        User userBase = getOne(new QueryWrapper<User>()
                .eq("id", uid));
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
}
