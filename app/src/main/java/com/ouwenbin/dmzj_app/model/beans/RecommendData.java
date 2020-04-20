package com.ouwenbin.dmzj_app.model.beans;

import java.util.List;

public class RecommendData {
    /**
     * category_id : 46
     * title : 大图推荐
     * sort : 1
     * data : [{"cover":"https://images.dmzj.com/tuijian/750_480/191223shuizhinvshen03.jpg","title":"恋爱吧，我的水之女神","sub_title":"恋爱吧，我的水之女神","type":1,"url":"","obj_id":47099,"status":"连载中","is_dot":"0"},{"cover":"https://images.dmzj.com/tuijian/750_480/191024syjhssjx3.jpg","title":"觉醒死神之魂，尸魂界由你主宰！","sub_title":"《净化：死神觉醒》热血动漫全新卡牌对战手游","type":6,"url":"https://zt.dmzj.com/jinghuasishenjuexing/index.html","obj_id":0,"status":"","is_dot":"1"},{"cover":"https://images.dmzj.com/tuijian/750_480/191220xinwentj2.jpg","title":"欢乐向编辑部·有个好东西给你康康！","sub_title":"欢乐向编辑部·有个好东西给你康康！","type":7,"url":"https://v2api.dmzj.com/article/show/v2/65952.html","obj_id":65952,"status":"","is_dot":"0"},{"cover":"https://images.dmzj.com/tuijian/750_480/191220yequtj2.jpg","title":"夜曲·搞完满足之后的安眠","sub_title":"夜曲·搞完满足之后的安眠","type":1,"url":"","obj_id":49874,"status":"连载中","is_dot":"0"},{"cover":"https://images.dmzj.com/tuijian/750_480/191220shijichutj2.jpg","title":"世纪初小子·在2000年当小孩","sub_title":"世纪初小子·在2000年当小孩","type":1,"url":"","obj_id":51404,"status":"连载中","is_dot":"0"}]
     */

    private int category_id;
    private String title;
    private int sort;
    private List<DataBean> data;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cover : https://images.dmzj.com/tuijian/750_480/191223shuizhinvshen03.jpg
         * title : 恋爱吧，我的水之女神
         * sub_title : 恋爱吧，我的水之女神
         * type : 1
         * url :
         * obj_id : 47099
         * status : 连载中
         * is_dot : 0
         */

        private String cover;
        private String title;
        private String sub_title;
        private int type;
        private String url;
        private int obj_id;
        private String status;
        private String is_dot;
        private int id;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getObj_id() {
            return obj_id;
        }

        public void setObj_id(int obj_id) {
            this.obj_id = obj_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_dot() {
            return is_dot;
        }

        public void setIs_dot(String is_dot) {
            this.is_dot = is_dot;
        }

        public int getId() {
            return id;
        }
    }
}
