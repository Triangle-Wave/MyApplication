package com.twave.myapplication.service;

import com.github.pagehelper.PageInfo;
import com.twave.myapplication.entity.User;

/**
 * @author TWAVE
 * @description 针对表【tb_user】的数据库操作Service
 * @createDate 2023-07-22 16:53:55
 */
public interface IUserService {
    /**
     * 获取所有用户
     *
     * @return 所有用户的列表
     */
    PageInfo<User> getAllUser(String phone, String nickName, int pageNum, int pageSize);

}
