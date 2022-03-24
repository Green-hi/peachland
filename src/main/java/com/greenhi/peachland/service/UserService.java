package com.greenhi.peachland.service;

import com.greenhi.peachland.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.peachland.unit.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
public interface UserService extends IService<User> {
    Result add(User userBase);

    Result delete(String uid);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectUserOne(String uid);

    Result update(User userBase);

    Result uploadFile(Integer id, MultipartFile file);
}
