package com.twave.myapplication.service;

import com.twave.myapplication.entity.User;

import java.util.List;

/**
 * @author TWAVE
 * @description 针对表【tb_user】的数据库操作Service
 * @createDate 2023-07-22 16:53:55
 */
public interface UserService {
    /**
     * 获取所有用户
     *
     * @return 所有用户的列表
     */
    List<User> getAllUser(String phone, String nickName);

}
