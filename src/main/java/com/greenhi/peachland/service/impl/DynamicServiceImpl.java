package com.greenhi.peachland.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.peachland.controller.DynamicController;
import com.greenhi.peachland.controller.UserController;
import com.greenhi.peachland.entity.Dynamic;
import com.greenhi.peachland.item.ItemFocusDynamic;
import com.greenhi.peachland.mapper.DynamicMapper;
import com.greenhi.peachland.service.DynamicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.peachland.unit.Result;
import com.greenhi.peachland.unit.ResultEnum;
import com.greenhi.peachland.unit.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 */
@Service
public class DynamicServiceImpl extends ServiceImpl<DynamicMapper, Dynamic> implements DynamicService {

    private static final Logger logger = LoggerFactory.getLogger(DynamicController.class);

    @Value("${uploadDir_dynamic}")
    private String uploadDir_dynamic;

    @Override
    public Result add(Dynamic dynamic) {
        if (getOne(new QueryWrapper<Dynamic>()
                .eq("id", dynamic.getId())
        ) == null) {
            save(dynamic);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("msg","动态数据添加成功");
            resultMap.put("id",dynamic.getId());
            return ResultUtil.success(resultMap);
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    @Override
    public Result delete(Integer id) {
        if (getOne(new QueryWrapper<Dynamic>()
                .eq("id", id)
        ) != null) {
            baseMapper.delete(new QueryWrapper<Dynamic>().eq("id", id));
            return ResultUtil.success("动态数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<Dynamic> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<Dynamic> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        IPage<Dynamic> DynamicIPage = page(mPage, wrapper);
        if (DynamicIPage != null) {
            return ResultUtil.success(DynamicIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    @Override
    public Result selectPaging(Integer pageNo, Integer pageSize){
        List<ItemFocusDynamic> dynamics = null;
        try {
            dynamics = baseMapper.selectPaging((pageNo-1)*pageSize,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(), ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success(dynamics);
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
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(), ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success(dynamics);
    }

    @Override
    public Result selectFocusByUidPaging(Integer uid, Integer pageNo, Integer pageSize) {
        List<ItemFocusDynamic> dynamics = null;
        try {
            dynamics = baseMapper.selectFocusByUidPaging(uid, (pageNo-1)*pageSize, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(), ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success(dynamics);
    }

    @Override
    public Result addLikeById(Integer id, boolean add) {
        try {
            if(add){
                baseMapper.addLikeById(id);
            }else {
                baseMapper.subLikeById(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(), ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success();
    }

    @Override
    public Result addCommById(Integer id, boolean add) {
        try {
            if(add){
                baseMapper.addCommById(id);
            }else {
                baseMapper.subCommById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SQL_EXCEPTION.getCode(), ResultEnum.SQL_EXCEPTION.getMsg());
        }
        return ResultUtil.success();
    }

    @Override
    public Result uploadImgs(Integer id, MultipartFile[] imgs) {
        int i = 0;
        if (id == null) {
            return ResultUtil.error(ResultEnum.ID_NOT_EXISTS.getCode(), ResultEnum.ID_NOT_EXISTS.getMsg());
        }
        if (getOne(new QueryWrapper<Dynamic>()
                .eq("id", id)
        ) == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
        if (imgs.length == 0) {
            return ResultUtil.error(ResultEnum.FILE_NOT_EXISTS.getCode(), ResultEnum.FILE_NOT_EXISTS.getMsg());
        }
        try {
            for (MultipartFile file : imgs) {
                // 上传时的文件名
                String originalFilename = file.getOriginalFilename();
                // 获取文件的后缀名
//                String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
                File dest = new File(uploadDir_dynamic + id + '_' + (++i) + ".png");
                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    logger.info("~~~~~~~~~该目录不存在，新建~~~~~~~~");
                    dest.getParentFile().mkdirs();
                }
                logger.info("Absolute directory: " + dest.getParentFile().getAbsoluteFile());
                //上传文件到dest
                file.transferTo(dest.getAbsoluteFile());
                logger.info("上传成功后的文件路径为：" + dest);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.FILE_NOT_UPLOADS.getCode(), ResultEnum.FILE_NOT_UPLOADS.getMsg());
        }
        baseMapper.setImgCount(id, imgs.length);
        return ResultUtil.success("动态图片上传成功");
    }

}
