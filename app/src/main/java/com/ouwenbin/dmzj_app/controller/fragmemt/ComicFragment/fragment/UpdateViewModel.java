package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import android.util.Log;

import com.ouwenbin.dmzj_app.model.beans.LatestData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.repository.DataRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import java.util.List;

import javax.inject.Inject;

public class UpdateViewModel extends ViewModel implements DataCallback<List<LatestData>> {
    private MutableLiveData<List<LatestData>> listMutableLiveData;

    @Inject
    DataRepository repository;

    @Inject
    public UpdateViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<LatestData>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            repository.loadLatestData(this);
        }
        return listMutableLiveData;
    }

    @Override
    public void success(List<LatestData> data) {
        this.listMutableLiveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }
}
