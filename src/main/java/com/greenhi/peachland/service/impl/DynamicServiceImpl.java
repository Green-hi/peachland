package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.peachland.entity.Dynamic;
import com.greenhi.peachland.mapper.DynamicMapper;
import com.greenhi.peachland.service.DynamicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.peachland.unit.Result;
import com.greenhi.peachland.unit.ResultEnum;
import com.greenhi.peachland.unit.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 */
@Service
public class DynamicServiceImpl extends ServiceImpl<DynamicMapper, Dynamic> implements DynamicService {
    @Override
    public Result add(Dynamic dynamic) {
        if (getOne(new QueryWrapper<Dynamic>()
                .eq("id", dynamic.getId())
        ) == null) {
            save(dynamic);
            return ResultUtil.success("动态数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    @Override
    public Result delete(Integer id) {
        if (getOne(new QueryWrapper<Dynamic>()
                .eq("id", id)
        ) != null) {
            baseMapper.delete(new QueryWrapper<Dynamic>().eq("id",id));
            return ResultUtil.success("动态数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<Dynamic> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<Dynamic> wrapper = new QueryWrapper<>();
//        wrapper.orderByAsc("id");
        IPage<Dynamic> DynamicIPage = page(mPage, wrapper);
        if(DynamicIPage != null){
            return ResultUtil.success(DynamicIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    @Override
    public Result selectDynamicOne(Integer id) {
        Dynamic DynamicBase = getOne(new QueryWrapper<Dynamic>()
                .eq("id", id));
        if (DynamicBase == null) {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        } else {
            return ResultUtil.success(DynamicBase);
        }
    }

    @Override
    public Result update(Dynamic dynamic) {
        if (getOne(new QueryWrapper<Dynamic>()
                .eq("id", dynamic.getId())
        ) != null) {
            baseMapper.update(dynamic, new QueryWrapper<Dynamic>()
                    .eq("id", dynamic.getId()));
            return ResultUtil.success("动态数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }

    @Override
    public Result selectByUid(Integer uid) {
        List<Dynamic> dynamics = null;
        try {
            dynamics = baseMapper.selectByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(),ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success(dynamics);
    }

    @Override
    public Result selectFocusByUid(Integer uid) {
        List<Dynamic> dynamics = null;
        try {
            dynamics = baseMapper.selectFocusByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(),ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success(dynamics);
    }

    @Override
    public Result addLikeById(Integer id) {
        try {
            baseMapper.addLikeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(),ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success();
    }

    @Override
    public Result addCommById(Integer id) {
        try {
            baseMapper.addCommById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(),ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success();
    }
}
