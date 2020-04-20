package com.ouwenbin.dmzj_app.model.beans;

import java.util.List;

public class NewsBannerData {
    /**
     * code : 0
     * msg : 成功
     * data : [{"id":2907,"title":"【视频】jojo×男高，女装它不香吗？","pic_url":"https://images.dmzj.com/news/recommend/15772702109164.jpg","object_id":66002,"object_url":"https://v2api.dmzj.com/v3/article/show/66002.html"},{"id":2899,"title":"时代周刊评选十佳游戏 12月4周新闻汇总","pic_url":"https://images.dmzj.com/news/recommend/15772629221435.jpg","object_id":65974,"object_url":"https://v2api.dmzj.com/v3/article/show/65974.html"},{"id":2898,"title":"美图推荐\u2014\u2014圣诞特辑（三）","pic_url":"https://images.dmzj.com/news/recommend/15772628574965.jpg","object_id":65995,"object_url":"https://v2api.dmzj.com/v3/article/show/65995.html"},{"id":2018,"title":"【原创·同人】文章汇总入口","pic_url":"https://images.dmzj.com/news/recommend/15774359547017.jpg","object_id":46707,"object_url":"https://v2api.dmzj.com/v3/article/show/46707.html"},{"id":2897,"title":"PV公开 辉夜大小姐2期4月开播","pic_url":"https://images.dmzj.com/news/recommend/15772627908980.jpg","object_id":65961,"object_url":"https://v2api.dmzj.com/v3/article/show/65961.html"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2907
         * title : 【视频】jojo×男高，女装它不香吗？
         * pic_url : https://images.dmzj.com/news/recommend/15772702109164.jpg
         * object_id : 66002
         * object_url : https://v2api.dmzj.com/v3/article/show/66002.html
         */

        private int id;
        private String title;
        private String pic_url;
        private int object_id;
        private String object_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public int getObject_id() {
            return object_id;
        }

        public void setObject_id(int object_id) {
            this.object_id = object_id;
        }

        public String getObject_url() {
            return object_url;
        }

        public void setObject_url(String object_url) {
            this.object_url = object_url;
        }
    }
}
