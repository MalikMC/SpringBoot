package com.machun.springbootexcption.vo;

import java.io.Serializable;

/**
 * @author machun1
 */
public class ResponseJsonData implements Serializable {
    /**
     * 状态编号
     */
    private String code;
    /**
     * 消息
     */
    private  String message;
    /**
     * 返回结构
     */
    private  Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseJsonData(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReponseJsonData{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
