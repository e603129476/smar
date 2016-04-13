package com.huaxun.smart.utils;

import static com.huaxun.smart.utils.Message.*;

/**
 * Created by lhy on 2016-04-09.
 */
public class ReturnData {
    private String msg;
    private int code=-1;
    private Object data;
    private boolean operation=true;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }

    public ReturnData(String msg, int code, Object data, boolean operation) {

        this.msg = msg;
        this.code = code;
        this.data = data;
        this.operation = operation;
    }

    public ReturnData(String msg, int code, Object data) {

        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ReturnData(String msg, int code) {

        this.msg = msg;
        this.code = code;
    }

    @Override
    public String toString() {
        return JsonUtil.beanToJson(this);
    }
}
