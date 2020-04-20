package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.adapter.TopicRecycleViewAdapter;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/*
* 首页的专题页面
* */

public class TopicFragment extends DaggerFragment {
    @Inject
    TopicViewModel mViewModel;
    private RecyclerView topic_rv;
    private View view;
    private ProgressBar TopicFragment_pb;
    private SmartRefreshLayout refreshLayout;
    private TopicRecycleViewAdapter adapter;

    public static TopicFragment newInstance() {
        return new TopicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.topic_fragment, container, false);
        initView(view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
    }


    private void initView(View view) {
        topic_rv = view.findViewById(R.id.topic_rv);
        TopicFragment_pb = view.findViewById(R.id.TopicFragment_pb);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        //设置RefreshLayout的属性
        //设置 Header 样式:
        refreshLayout.setRefreshHeader(new BezierCircleHeader(getContext()));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));

        //下拉刷新的监听
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                Toast.makeText(getContext(), "刷新成功！！", Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败

            }
        });

        //上拉加载的监听
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                Toast.makeText(getContext(), "加载成功！！", Toast.LENGTH_SHORT).show();
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }



    @SuppressLint("FragmentLiveDataObserve")
    private void setData() {
        topic_rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        topic_rv.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        adapter = new TopicRecycleViewAdapter(requireContext());
        mViewModel.getListMutableLiveData().observe(this, (dataList) -> {
            adapter.setDataList(dataList);
            topic_rv.setAdapter(adapter);

            if (dataList !=null){
                TopicFragment_pb.setVisibility(View.GONE);
            }else {
                TopicFragment_pb.setVisibility(View.VISIBLE);
            }
        });
    }

}
