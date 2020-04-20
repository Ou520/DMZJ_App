package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import android.util.Log;

import com.ouwenbin.dmzj_app.model.beans.ClassifyData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.repository.DataRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import java.util.List;

import javax.inject.Inject;

public class ClassifyViewModel extends ViewModel implements DataCallback<List<ClassifyData>> {
    private MutableLiveData<List<ClassifyData>> listMutableLiveData;


    public MutableLiveData<List<ClassifyData>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            repository.loadClassifyData(this);
        }
        return listMutableLiveData;
    }

    @Inject
    DataRepository repository;

    @Inject
    public ClassifyViewModel(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void success(List<ClassifyData> data) {
        this.listMutableLiveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }

}
