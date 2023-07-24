package com.twave.myapplication.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : twave
 * @date : 2023/7/24 15:32
 */
@Mapper
public interface MailMapper {
    int getLock(@Param("userName") String userName);

    int releaseLock(@Param("userName") String userName);
}
