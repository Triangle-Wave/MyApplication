package com.twave.myapplication.Mapper;

import com.twave.myapplication.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author TWAVE
 * @description 针对表【tb_user】的数据库操作Mapper
 * @createDate 2023-07-22 16:53:55
 * @Entity com.twave.myapplication.Entity.User
 */
@Mapper
public interface UserMapper {
    /**
     * 获取所有用户
     *
     * @return 所有用户的列表
     */
    List<User> getAllUser(String phone, String nickName);

}




