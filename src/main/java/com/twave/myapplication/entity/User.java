package com.twave.myapplication.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author TWAVE
 * @TableName tb_user
 */
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 密码，加密存储
     */
    private String password;

    /**
     * 昵称，默认是用户id
     */
    private String nickName;

    /**
     * 人物头像
     */
    private String icon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}