package com.twave.myapplication.Controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.twave.myapplication.Entity.User;
import com.twave.myapplication.Service.Impl.UserServiceImpl;
import com.twave.myapplication.Util.JSONResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import static com.twave.myapplication.Constants.Constants.REQUEST_SUCCESS;

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
    JSONResult<List<User>> getUser(
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam(value = "nickName", defaultValue = "") String nickName
    ) {
        List<User> allUser = userService.getAllUser(phone, nickName);
        return new JSONResult<>(REQUEST_SUCCESS, allUser);
    }
}
