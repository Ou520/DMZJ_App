package com.ouwenbin.dmzj_app.controller.fragmemt.NewsFragment;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.ouwenbin.dmzj_app.model.beans.NewsBannerData;
import com.ouwenbin.dmzj_app.model.beans.NewsData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.repository.DataRepository;


import java.util.List;

import javax.inject.Inject;

public class NewsViewModel extends ViewModel implements DataCallback {
    private MutableLiveData<List<NewsData>> listMutableLiveData;
    private MutableLiveData<NewsBannerData> mutableLiveData;

    @Inject
    DataRepository repository;

    @Inject
    public NewsViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<NewsData>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            repository.loadNewsData(this);
        }
        return listMutableLiveData;
    }

    public MutableLiveData<NewsBannerData> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            repository.loadNewsBannerData(this);
        }
        return mutableLiveData;
    }

    @Override
    public void success(Object data) {
        if (data instanceof List) {
            this.listMutableLiveData.setValue((List<NewsData>) data);
        } else {
            this.mutableLiveData.setValue((NewsBannerData) data);
        }

    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }
}
