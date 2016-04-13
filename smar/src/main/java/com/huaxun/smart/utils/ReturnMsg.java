package com.huaxun.smart.utils;

/**
 * Created by zhangyingdong on 2015.10.29.
 * 统一的消息定义
 */
public class ReturnMsg {
    private boolean operation = true;//操作成功与否
    private String data = "";//数据
    private String message = "";//消息
    private int code = -1;

    public ReturnMsg() {
    }

    public ReturnMsg(boolean operation, String data, String message) {
        this.operation = operation;
        this.data = data;
        this.message = message;
    }

    public ReturnMsg(boolean operation, String data, String message, int code) {
        this(operation, data, message);
        this.code = code;
    }

    public boolean getOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
