package com.example.sevenstar.fragment.addressBook.friends.bean;

/**
 * Created by j on 18.3.1.
 */

/**
 * message : 李少奇
 * status : 发送添加好友请求的Bean类
 */
public class SendAddFriendsNewsBean {
    /**
     * message : 发送成功
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
