package com.greenhi.peachland.service;

import com.greenhi.peachland.entity.Comment;
import com.greenhi.peachland.entity.Dynamic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.peachland.unit.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 */
public interface DynamicService extends IService<Dynamic> {
    Result add(Dynamic dynamic);

    Result delete(Integer id);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectDynamicOne(Integer id);

    Result update(Dynamic dynamic);
}
