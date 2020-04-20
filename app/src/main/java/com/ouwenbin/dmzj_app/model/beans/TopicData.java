package com.ouwenbin.dmzj_app.model.beans;

public class TopicData {

    /**
     * id : 390
     * title : 新漫周刊第78期 一周新漫推荐
     * short_title : 新漫周刊七十八期
     * create_time : 1574432122
     * small_cover : https://images.dmzj.com/subject/390/small_cover_1574432122.jpg
     * page_type : 3
     * sort : 3900
     * page_url : xinmanzhoukan78
     */

    private int id;
    private String title;
    private String short_title;
    private int create_time;
    private String small_cover;
    private int page_type;
    private int sort;
    private String page_url;

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

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public String getSmall_cover() {
        return small_cover;
    }

    public void setSmall_cover(String small_cover) {
        this.small_cover = small_cover;
    }

    public int getPage_type() {
        return page_type;
    }

    public void setPage_type(int page_type) {
        this.page_type = page_type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }
}
