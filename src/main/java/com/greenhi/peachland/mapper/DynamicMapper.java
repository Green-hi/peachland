package com.greenhi.peachland.mapper;

import com.greenhi.peachland.entity.Dynamic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greenhi.peachland.item.ItemFocusDynamic;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 */
public interface DynamicMapper extends BaseMapper<Dynamic> {

    List<Dynamic> selectByUid(Integer uid) throws Exception;

    List<ItemFocusDynamic> selectFocusByUidPaging(Integer uid, Integer index, Integer pageSize) throws Exception;

    void addLikeById(Integer id) throws Exception;

    void addCommById(Integer id) throws Exception;

    void subLikeById(Integer id) throws Exception;

    void subCommById(Integer id) throws Exception;

    void setImgCount(Integer id, Integer count);

    List<ItemFocusDynamic> selectPaging(Integer index, Integer pageSize) throws Exception;

}
