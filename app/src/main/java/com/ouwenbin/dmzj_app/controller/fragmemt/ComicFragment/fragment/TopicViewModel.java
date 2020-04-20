package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import android.util.Log;

import com.ouwenbin.dmzj_app.model.beans.TopicData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.repository.DataRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;
import javax.inject.Inject;

public class TopicViewModel extends ViewModel implements DataCallback<List<TopicData>> {
    private MutableLiveData<List<TopicData>> listMutableLiveData;

    @Inject
    DataRepository repository;

    @Inject
    public TopicViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<TopicData>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            repository.loadTopicData(this);
        }
        return listMutableLiveData;
    }

    @Override
    public void success(List<TopicData> data) {
        this.listMutableLiveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }
}
