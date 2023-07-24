package com.twave.myapplication.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.twave.myapplication.entity.User;
import com.twave.myapplication.mapper.UserMapper;
import com.twave.myapplication.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author TWAVE
 * @description 针对表【tb_user】的数据库操作Service实现
 * @createDate 2023-07-22 16:53:55
 */
@Service
public class UserServiceImpl implements IUserService {

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
    public PageInfo<User> getAllUser(String phone, String nickName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (phone.length() == 0 && nickName.length() == 0) {
            return new PageInfo<>();
        }
        List<User> allUser = userMapper.getAllUser(phone, nickName);
        return new PageInfo<>(allUser);
    }
}




