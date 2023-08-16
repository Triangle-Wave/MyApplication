package com.twave.myapplication.entity;

import lombok.Data;

/**
 * 店铺实体类
 *
 * @author : twave
 * @date : 2023/7/25 10:06
 */


@Data
public class Shop {
    private String area;
    private String openHours;
    private Integer sold;
    private String images;
    private String address;
    private Integer comments;
    private Integer avgPrice;
    private Long updateTime;
    private Integer score;
    private Long createTime;
    private String name;
    private Double x;
    private Double y;
    private Integer typeId;
    private Integer id;
}
