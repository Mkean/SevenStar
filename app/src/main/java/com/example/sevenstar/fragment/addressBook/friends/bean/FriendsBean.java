package com.example.sevenstar.fragment.addressBook.friends.bean;

import java.util.List;

/**
 * Created by 子非鱼 on 2018/2/26.
 */

public class FriendsBean {

    /**
     * result : [{"id":2,"img":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg","nickName":"钱重帆"},{"id":3,"img":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg","nickName":"王财荣"}]
     * message : 查询成功
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
         * id : 2
         * img : https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg
         * nickName : 钱重帆
         */

        private int id;
        private String img;
        private String nickName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}
