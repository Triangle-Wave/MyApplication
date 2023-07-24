package com.twave.myapplication.mapper;

import com.twave.myapplication.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TWAVE
 * @description 针对表【tb_user】的数据库操作Mapper
 * @createDate 2023-07-22 16:53:55
 * @Entity com.twave.myapplication.entity.User
 */
@Mapper
public interface UserMapper {
    /**
     * 获取符合条件的所有用户
     *
     * @return 用户列表
     */
    List<User> getAllUser(
            @Param("phone") String phone,
            @Param("nickName") String nickName
    );

}




