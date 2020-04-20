package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.adapter.UpdateRecycleViewAdapter;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import javax.inject.Inject;
import dagger.android.support.DaggerFragment;

/*
* 首页的更新页面
* */

public class UpdateFragment extends DaggerFragment {

    @Inject
    UpdateViewModel mViewModel;

    private boolean rvTypeSwitch = false;
    private RecyclerView recyclerView;
    private ImageView imageView_rvSwitch;
    private View view;
    private UpdateRecycleViewAdapter adapter;
    private ProgressBar UpdateFragment_pb;
    SmartRefreshLayout refreshLayout;

    public static UpdateFragment newInstance() {
        return new UpdateFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.update_fragment, container, false);
        initView(view);
        initListener();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
    }


    private void initView(View view) {
        recyclerView = view.findViewById(R.id.comicList_rv);
        imageView_rvSwitch = view.findViewById(R.id.rv_switch_image);
        UpdateFragment_pb = view.findViewById(R.id.UpdateFragment_pb);
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


    private void initListener() {
        imageView_rvSwitch.setOnClickListener(v -> {
            if (v == imageView_rvSwitch) {
                if (rvTypeSwitch == false) {
                    rvTypeSwitch = true;
                    changeLayout(true);
                } else {
                    rvTypeSwitch = false;
                    changeLayout(false);
                }
            }
        });
    }



    @SuppressLint("FragmentLiveDataObserve")
    private void setData() {
        adapter = new UpdateRecycleViewAdapter(requireContext(),1);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        mViewModel.getListMutableLiveData().observe(this, latestData -> {
            adapter.setLatestData(latestData);
            adapter.notifyDataSetChanged();
            if (latestData !=null){
                UpdateFragment_pb.setVisibility(View.GONE);
            }else {
                UpdateFragment_pb.setVisibility(View.VISIBLE);
            }
        });
    }


    @SuppressLint("FragmentLiveDataObserve")
    private void changeLayout(boolean isChange) {
        if (isChange) {
            UpdateRecycleViewAdapter adapter2 = new UpdateRecycleViewAdapter(requireContext(),2);
            imageView_rvSwitch.setImageResource(R.drawable.rv_switch_two);
            recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
            recyclerView.setAdapter(adapter2);
            mViewModel.getListMutableLiveData().observe(this, latestData -> {
                adapter2.setLatestData(latestData);
                adapter2.notifyDataSetChanged();
                if (latestData !=null){
                    UpdateFragment_pb.setVisibility(View.GONE);
                }else {
                    UpdateFragment_pb.setVisibility(View.VISIBLE);
                }
            });
        } else {
            imageView_rvSwitch.setImageResource(R.drawable.rv_switch_one);
            UpdateRecycleViewAdapter adapter3 = new UpdateRecycleViewAdapter(requireContext(),1);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
            recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(adapter3);
            mViewModel.getListMutableLiveData().observe(this, latestData -> {
                adapter3.setLatestData(latestData);
                adapter3.notifyDataSetChanged();
                if (latestData !=null){
                    UpdateFragment_pb.setVisibility(View.GONE);
                }else {
                    UpdateFragment_pb.setVisibility(View.VISIBLE);
                }

            });

        }
    }

}
