package com.ouwenbin.dmzj_app.model.beans;

import java.util.List;

public class NovelData {
    /**
     * category_id : 57
     * sort : 0
     * title : 轮番图
     * data : [{"id":3414,"obj_id":534,"title":"[完结]翼之归处","cover":"https://images.dmzj.com/tuijian/xiaoshuo/750-480/295.jpg","url":"","type":2,"sub_title":"","status":"已完结"},{"id":3413,"obj_id":2602,"title":"从同居开始的宅女友养成方法 第4卷","cover":"https://images.dmzj.com/tuijian/xiaoshuo/750-480/293.jpg","url":"","type":2,"sub_title":"","status":"连载中"},{"id":3448,"obj_id":2771,"title":"[短篇]高崎涂鸦","cover":"https://images.dmzj.com/tuijian/xiaoshuo/750-480/292.jpg","url":"","type":2,"sub_title":"","status":"已完结"},{"id":3449,"obj_id":2772,"title":"你喜欢有点xx又bt的公主殿下吗？","cover":"https://images.dmzj.com/tuijian/xiaoshuo/750-480/291.jpg","url":"","type":2,"sub_title":"","status":"连载中"},{"id":3315,"obj_id":1872,"title":"尼特族的异世界就职记 第5卷","cover":"https://images.dmzj.com/tuijian/xiaoshuo/750-480/290.jpg","url":"","type":2,"sub_title":"","status":"连载中"}]
     */

    private int category_id;
    private int sort;
    private String title;
    private List<DataBean> data;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3414
         * obj_id : 534
         * title : [完结]翼之归处
         * cover : https://images.dmzj.com/tuijian/xiaoshuo/750-480/295.jpg
         * url :
         * type : 2
         * sub_title :
         * status : 已完结
         */

        private int id;
        private int obj_id;
        private String title;
        private String cover;
        private String url;
        private int type;
        private String sub_title;
        private String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getObj_id() {
            return obj_id;
        }

        public void setObj_id(int obj_id) {
            this.obj_id = obj_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

