package com.greenhi.peachland.service;

import com.greenhi.peachland.entity.Comment;
import com.greenhi.peachland.entity.Dynamic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.peachland.unit.Result;
import org.springframework.web.multipart.MultipartFile;

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

    Result selectPaging(Integer pageNo, Integer pageSize);

    Result selectDynamicOne(Integer id);

    Result update(Dynamic dynamic);

    Result selectByUid(Integer uid);

    Result selectFocusByUidPaging(Integer uid, Integer pageNo, Integer pageSize);

    Result addLikeById(Integer id, boolean add);

    Result addCommById(Integer id, boolean add);

    Result uploadImgs(Integer id, MultipartFile[] imgs);

}
