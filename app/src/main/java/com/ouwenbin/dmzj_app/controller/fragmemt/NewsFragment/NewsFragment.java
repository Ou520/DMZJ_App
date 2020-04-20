package com.ouwenbin.dmzj_app.controller.fragmemt.NewsFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.controller.fragmemt.NewsFragment.adapter.NewsRecycleViewAdapter;
import com.ouwenbin.dmzj_app.model.beans.NewsBannerData;
import com.ouwenbin.dmzj_app.utils.RefererUtil;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class NewsFragment extends DaggerFragment {
    @Inject
    NewsViewModel mViewModel;

    private View view;
    private RecyclerView recyclerView;
    private Banner banner;
    private NewsRecycleViewAdapter adapter;
    private SmartRefreshLayout refreshLayout;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.news_fragment, container, false);
       initView(view );
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.news_recyclerView);
        banner = view.findViewById(R.id.news_banner);

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
    }


    @SuppressLint("FragmentLiveDataObserve")
    private void setData() {
        adapter = new NewsRecycleViewAdapter(requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setDelayTime(3000)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(RefererUtil.buildeGlideUrl((String) path)).into(imageView);
                    }
                });

        //设置轮播图的监听
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getContext(), "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        mViewModel.getListMutableLiveData().observe(this, newsData -> {
            adapter.setNewsDataList(newsData);
            adapter.setOnItemClickListener((view, position) -> {
                NavController navController = Navigation.findNavController(view);
                Bundle bundle = new Bundle(1);
                String page_url = newsData.get(position).getPage_url();
                bundle.putString("obj_url", page_url);
                navController.navigate(R.id.action_newsFragment_to_webFragment, bundle);
            });
            recyclerView.setAdapter(adapter);
        });
        mViewModel.getMutableLiveData().observe(this, newsBannerData -> {
            List<NewsBannerData.DataBean> dataBeans = newsBannerData.getData();
            List<String> stringList = new ArrayList<>();
            List<String> urlList = new ArrayList<>();
            for (NewsBannerData.DataBean dataBean : dataBeans) {
                stringList.add(dataBean.getTitle());
                urlList.add(dataBean.getPic_url());
            }
            banner.setImages(urlList);
            banner.setBannerTitles(stringList);
            banner.start();
        });
        requireActivity().findViewById(R.id.index_bottom_navigation).setVisibility(View.VISIBLE);

    }

}
