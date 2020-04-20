package com.ouwenbin.dmzj_app.model.httpservice;

public interface DataCallback<T> {

    void success(T data);

    void failed(String result);
}
