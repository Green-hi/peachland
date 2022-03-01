package com.greenhi.peachland.service.impl;

import com.greenhi.peachland.entity.User;
import com.greenhi.peachland.mapper.UserMapper;
import com.greenhi.peachland.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
