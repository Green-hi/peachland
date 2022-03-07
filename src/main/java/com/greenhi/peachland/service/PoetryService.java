package com.greenhi.peachland.service;

import com.greenhi.peachland.entity.Poetry;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.unit.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
public interface PoetryService extends IService<Poetry> {

    Result add(Poetry poetry);

    Result delete(String poetryId);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectPoetryOne(String poetryId);

    Result update(Poetry poetry);

}
