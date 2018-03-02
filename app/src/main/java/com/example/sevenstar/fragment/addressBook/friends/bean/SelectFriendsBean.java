package com.example.sevenstar.fragment.addressBook.friends.bean;

/**
 * Created by j on 18.2.28.
 */

public class SelectFriendsBean {
    /**
     * result : {"createTime":1516982400000,"email":"15711454219@163.com","id":4,"nickName":"孙亚轲","phone":"15711454219"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * createTime : 1516982400000
         * email : 15711454219@163.com
         * id : 4
         * nickName : 孙亚轲
         * phone : 15711454219
         */

        private long createTime;
        private String email;
        private int id;
        private String nickName;
        private String phone;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "createTime=" + createTime +
                    ", email='" + email + '\'' +
                    ", id=" + id +
                    ", nickName='" + nickName + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SelectFriendsBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
