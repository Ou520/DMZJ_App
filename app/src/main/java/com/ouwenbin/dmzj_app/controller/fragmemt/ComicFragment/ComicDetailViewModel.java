package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment;

import android.util.Log;

import com.ouwenbin.dmzj_app.model.beans.ComicDetailData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.repository.DataRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import javax.inject.Inject;

public class ComicDetailViewModel extends ViewModel implements DataCallback<ComicDetailData> {
    @Inject
    DataRepository repository;

    @Inject
    public ComicDetailViewModel(DataRepository repository) {
        this.repository = repository;
    }

    private MutableLiveData<ComicDetailData> liveData;

    public MutableLiveData<ComicDetailData> getLiveData(int obj_id) {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            repository.loadComicDetailData(this, obj_id);
        }
        return liveData;
    }

    @Override
    public void success(ComicDetailData data) {
        this.liveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }


}
