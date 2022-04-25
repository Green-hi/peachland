package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.greenhi.peachland.entity.Comment;
import com.greenhi.peachland.entity.Focus;
import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.mapper.FocusMapper;
import com.greenhi.peachland.service.FocusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.peachland.unit.Result;
import com.greenhi.peachland.unit.ResultEnum;
import com.greenhi.peachland.unit.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-14
 */
@Service
public class FocusServiceImpl extends ServiceImpl<FocusMapper, Focus> implements FocusService {

    @Override
    public Result add(Integer uid,Integer fid) {
        if (getOne(new QueryWrapper<Focus>()
                .eq("uid", uid)
                .eq("fid",fid)
        ) == null) {
            Focus focus = new Focus();
            focus.setUid(uid);
            focus.setFid(fid);
            save(focus);
            return ResultUtil.success("关注数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    @Override
    public Result delete(Integer uid, Integer fid) {
        if (getOne(new QueryWrapper<Focus>()
                .eq("uid", uid)
                .eq("fid", fid)
        ) == null){
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
        baseMapper.deleteByUidAndFid(uid,fid);
        return ResultUtil.success("关注数据已经删除");
    }

    @Override
    public Result selectByUid(Integer uid) {
        List<User> users = baseMapper.selectByUid(uid);
        return ResultUtil.success(users);
    }

    @Override
    public Result selectByFid(Integer fid) {
        List<User> users = baseMapper.selectByFid(fid);
        return ResultUtil.success(users);
    }

    @Override
    public Result selectOne(Integer uid, Integer fid) {
        if (getOne(new QueryWrapper<Focus>()
                .eq("uid", uid)
                .eq("fid", fid)
        ) == null){
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
        return ResultUtil.success();
    }
}
