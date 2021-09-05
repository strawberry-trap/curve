package com.learning.curve.v1.value;

public class Result {

    private String msg;
    private CommonValues.Code code;
    private Object data;

    public Result() {}

    public Result(String msg, CommonValues.Code code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    // getter & setter
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CommonValues.Code getCode() {
        return code;
    }

    public void setCode(CommonValues.Code code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
