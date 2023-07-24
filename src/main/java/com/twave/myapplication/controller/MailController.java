package com.twave.myapplication.controller;

import com.twave.myapplication.service.ISendMailService;
import com.twave.myapplication.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.twave.myapplication.constants.StatusCode.REQUEST_SUCCESS;

/**
 * @author : twave
 * @date : 2023/7/24 15:52
 */
@RestController
@RequestMapping("mail")
public class MailController extends BaseController {
    @Autowired
    ISendMailService sendMailService;

    @GetMapping("/sendmail")
    JSONResult<String> sendMail(@RequestParam(value = "username") String userName) {
        sendMailService.sendMail(userName);
        return new JSONResult<>(REQUEST_SUCCESS, "邮件发送成功");
    }
}
