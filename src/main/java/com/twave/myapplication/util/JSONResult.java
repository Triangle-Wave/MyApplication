package com.twave.myapplication.util;

import java.io.Serializable;

/**
 * 使用JSON格式的数据进行响应
 *
 * @author TWAVE
 */
public class JSONResult<E> implements Serializable {
    // 状态码
    private Integer state;
    // 描述信息
    private String message;
    // 用泛型来表示数据，因为不确定其类型
    private E data;

    // 无参构造方法
    public JSONResult() {
    }

    public JSONResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JSONResult(Integer state) {
        this.state = state;
    }

    public JSONResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JSONResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
