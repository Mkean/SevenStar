package com.example.sevenstar.bean;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class SMSBean {

    /**
     * message : 短信已发送
     * status : 0000
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
