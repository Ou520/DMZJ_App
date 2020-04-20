package com.ouwenbin.dmzj_app.controller.fragmemt.NovelFragment;

import android.util.Log;

import com.ouwenbin.dmzj_app.model.beans.NovelData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.repository.DataRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import java.util.List;

import javax.inject.Inject;

public class NovelViewModel extends ViewModel implements DataCallback<List<NovelData>> {

    @Inject
    DataRepository repository;

    private MutableLiveData<List<NovelData>> mutableLiveData;

    @Inject
    public NovelViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<NovelData>> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            repository.loadNovelData(this);
        }
        return mutableLiveData;
    }

    @Override
    public void success(List<NovelData> data) {
        this.mutableLiveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }
}
