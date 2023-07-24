package com.twave.myapplication.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    // @Test
    // public void getAllUser() {
    //     System.out.println(userMapper.getAllUser());
    // }
}