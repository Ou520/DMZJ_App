package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.adapter.ClassifyRecyclerViewAdapter;
import com.ouwenbin.dmzj_app.controller.fragmemt.base.OnItemClickListener;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import javax.inject.Inject;
import dagger.android.support.DaggerFragment;

/*
* 首页的分类页面
* */

public class ClassifyFragment extends DaggerFragment {

    @Inject
    ClassifyViewModel mViewModel;

    private View view;
    private RecyclerView rv_classify;
    private ClassifyRecyclerViewAdapter adapter;
    private ProgressBar Classify_pb;
    SmartRefreshLayout refreshLayout;

    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.classify_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
    }

    @SuppressLint("FragmentLiveDataObserve")
    private void setData() {
        //设置RecyclerView的排列方式
        rv_classify.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        //初始化适配器
        adapter = new ClassifyRecyclerViewAdapter(requireContext());
        mViewModel.getListMutableLiveData().observe(this, classifyData -> {
            adapter.setList(classifyData);
            adapter.setOnItemClickListener((view, position) -> {
                Toast.makeText(getContext(), "点击了"+position, Toast.LENGTH_SHORT).show();
            });
            rv_classify.setAdapter(adapter);
            if (classifyData !=null){
                Classify_pb.setVisibility(View.GONE);
            }else {
                Classify_pb.setVisibility(View.VISIBLE);
            }

        });
    }

    private void initView(View view) {
        rv_classify = view.findViewById(R.id.classify_rv);
        Classify_pb = view.findViewById(R.id.Classify_pb);
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

}
