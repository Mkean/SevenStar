package com.example.sevenstar.fragment.addressBook.friends.bean;

import java.util.List;

/**
 * Created by j on 18.2.27.
 */

public class NewFriendInformBean {

    /**
     * result : [{"content":"石逸生解除了和您的好友关系","createTime":1517241600000,"id":0,"notice":"删除好友"},{"content":"石逸生请求添加您为好友","createTime":1517673600000,"id":0,"notice":"添加好友"}]
     * message : 请求成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 石逸生解除了和您的好友关系
         * createTime : 1517241600000
         * id : 0
         * notice : 删除好友
         */

        private String content;
        private long createTime;
        private int id;
        private String notice;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }
}
