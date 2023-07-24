package com.twave.myapplication.service.impl;


import com.twave.myapplication.entity.User;
import com.twave.myapplication.service.UserService;
import com.twave.myapplication.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TWAVE
 * @description 针对表【tb_user】的数据库操作Service实现
 * @createDate 2023-07-22 16:53:55
 */
@Service
public class UserServiceImpl implements UserService {

    // 注入Mapper接口对象
    @Resource
    private UserMapper userMapper;

    /**
     * 获取满足条件的全部用户<p>
     * 如果不带参数，则不返回任何结果
     *
     * @param phone    电话号码
     * @param nickName 昵称
     * @return 满足条件的用户列表
     */
    @Override
    public List<User> getAllUser(String phone, String nickName) {
        if (phone.length() == 0 && nickName.length() == 0) {
            return new ArrayList<>();
        }
        return userMapper.getAllUser(phone, nickName);
    }
}




