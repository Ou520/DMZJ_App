package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import com.ouwenbin.dmzj_app.model.beans.RecommendData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.repository.DataRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import java.util.List;

import javax.inject.Inject;

public class RecommendViewModel extends ViewModel implements DataCallback<List<RecommendData>> {

    private MutableLiveData<List<RecommendData>> liveData;

    
    DataRepository repository;

    @Inject
    public RecommendViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<RecommendData>> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            repository.loadData(this);
        }
        return liveData;
    }

    @Override
    public void success(List<RecommendData> data) {
        this.liveData.setValue(data);

    }

    @Override
    public void failed(String result) {

    }
}
