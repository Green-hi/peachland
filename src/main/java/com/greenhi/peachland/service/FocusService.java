package com.greenhi.peachland.service;

import com.greenhi.peachland.entity.Focus;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.peachland.unit.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-14
 */
public interface FocusService extends IService<Focus> {

    Result add(Integer uid,Integer fid);

    Result delete(Integer uid,Integer fid);

    Result selectByUid(Integer uid);

    Result selectByFid(Integer fid);

    Result selectOne(Integer uid, Integer fid);

}
