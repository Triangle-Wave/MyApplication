package com.twave.myapplication.entity;

import lombok.Data;

/**
 * @author TWAVE
 * @date 2023/8/15 11:55
 */
@Data
public class ExcelEntity {
    Integer orderId;
    float customerId;
    Integer orderDate;
    Integer orderStatus;
    String receiverName;
    String receiverPhone;
    String receiverAddress;
    String productDetail;
    String others;
}
