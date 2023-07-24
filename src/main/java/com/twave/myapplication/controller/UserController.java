package com.twave.myapplication.controller;

import com.github.pagehelper.PageInfo;
import com.twave.myapplication.entity.User;
import com.twave.myapplication.service.impl.UserServiceImpl;
import com.twave.myapplication.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.twave.myapplication.constants.Constants.REQUEST_SUCCESS;

/**
 * @author TWAVE
 * @date 2023/7/22 9:36
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    // @RequestBody: 接收前端传递给后端的json字符串中的数据，转换为java对象

    /**
     * 获取满足条件的全部用户<p>
     * 如果不带参数，则不返回任何结果
     *
     * @param phone    电话号码
     * @param nickName 昵称
     * @return 满足条件的用户列表
     */
    @GetMapping("/getuser")
    JSONResult<PageInfo<User>> getUser(
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam(value = "nickName", defaultValue = "") String nickName,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        PageInfo<User> allUser = userService.getAllUser(phone, nickName, pageNum, pageSize);
        return new JSONResult<>(REQUEST_SUCCESS, allUser);
    }
}
