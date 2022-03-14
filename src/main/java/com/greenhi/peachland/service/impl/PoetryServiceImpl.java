package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.peachland.entity.Poetry;
import com.greenhi.peachland.mapper.PoetryMapper;
import com.greenhi.peachland.service.PoetryService;
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
public class PoetryServiceImpl extends ServiceImpl<PoetryMapper, Poetry> implements PoetryService {
    @Override
    public Result add(Poetry Poetry) {
        if (getOne(new QueryWrapper<Poetry>()
                .eq("Poetry_id", Poetry.getId())
        ) == null) {
            save(Poetry);
            return ResultUtil.success("诗歌数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    @Override
    public Result delete(String poetryId) {
        if (getOne(new QueryWrapper<Poetry>()
                .eq("Poetry_id", poetryId)
        ) != null) {
            baseMapper.delete(new QueryWrapper<Poetry>().eq("Poetry_id",poetryId));
            return ResultUtil.success("诗歌数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<Poetry> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<Poetry> wrapper = new QueryWrapper<>();
//        wrapper.orderByAsc("id");
        IPage<Poetry> PoetryIPage = page(mPage, wrapper);
        if(PoetryIPage != null){
            return ResultUtil.success(PoetryIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    @Override
    public Result selectPoetryOne(String poetryId) {
        Poetry PoetryBase = getOne(new QueryWrapper<Poetry>()
                .eq("Poetry_id", poetryId));
        if (PoetryBase == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(PoetryBase);
        }
    }

    @Override
    public Result update(Poetry Poetry) {
        if (getOne(new QueryWrapper<Poetry>()
                .eq("poetryId", Poetry.getId())
        ) != null) {
            baseMapper.update(Poetry, new QueryWrapper<Poetry>()
                    .eq("poetryId", Poetry.getId()));
            return ResultUtil.success("诗歌数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
