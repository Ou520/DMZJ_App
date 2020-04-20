package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.adapter.RecommendRecycleViewAdapter;
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
* 首页的推荐页面
* */
public class RecommendFragment extends DaggerFragment {


    private RecyclerView recyclerView;
    private View view;
    private RecommendRecycleViewAdapter adapter;
    private ProgressBar RecommendFragment_pb;
    private SmartRefreshLayout refreshLayout;

    @Inject
    RecommendViewModel viewModel;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recommend_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.rv_list_data_recommend);
        RecommendFragment_pb = view.findViewById(R.id.RecommendFragment_pb);
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
        adapter = new RecommendRecycleViewAdapter(requireActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        viewModel.getLiveData().observe(this, recommendData -> {
            adapter.setRecommendData(recommendData);
            adapter.notifyDataSetChanged();

            if (recommendData !=null){
                RecommendFragment_pb.setVisibility(View.GONE);
            }else {
                RecommendFragment_pb.setVisibility(View.VISIBLE);
            }
        });
    }


}
