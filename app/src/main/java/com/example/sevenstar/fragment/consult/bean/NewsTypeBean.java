package com.example.sevenstar.fragment.consult.bean;

import java.util.List;

/**
 * Created by 子非鱼 on 2018/2/28.
 */

public class NewsTypeBean {

    /**
     * message : 请求成功
     * status : 0000
     * newsTypes : [{"id":1,"name":"科技资讯"},{"id":2,"name":"开放创新"},{"id":3,"name":"主题活动"},{"id":4,"name":"生活"},{"id":5,"name":"美食天地"},{"id":6,"name":"娱乐"}]
     */

    private String message;
    private String status;
    private List<NewsTypesBean> newsTypes;

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

    public List<NewsTypesBean> getNewsTypes() {
        return newsTypes;
    }

    public void setNewsTypes(List<NewsTypesBean> newsTypes) {
        this.newsTypes = newsTypes;
    }

    public static class NewsTypesBean {
        /**
         * id : 1
         * name : 科技资讯
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
