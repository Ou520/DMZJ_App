package com.ouwenbin.dmzj_app.controller.fragmemt.NovelFragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.model.beans.NovelData;
import com.ouwenbin.dmzj_app.utils.RefererUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class NovelRecycleViewAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_ONE = 1;//一行三列
    private static final int VIEW_TYPE_TWO = 2;//两行三列
    private static final int VIEW_TYPE_THIRD = 4;//排行榜
    private static final int VIEW_TYPE_BANNER = 3;//轮播图
    private Context context;
    private List<NovelData> dataList = new ArrayList<>();

    public NovelRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setDataList(List<NovelData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_BANNER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_rv_item_banner, parent, false);
            BannerViewHolder viewHolder = new BannerViewHolder(view);
            viewHolder.novel_banner.setDelayTime(3000)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load(RefererUtil.buildeGlideUrl((String) path))
                                    .apply(RefererUtil.getOptions(750, 400))
                                    .into(imageView);
                        }
                    });
            List<String> titles = new ArrayList<>();
            List<String> images = new ArrayList<>();
            for (NovelData.DataBean data : dataList.get(0).getData()
            ) {
                titles.add(data.getTitle());
                images.add(data.getCover());
            }
            viewHolder.novel_banner.setImages(images)
                    .setBannerTitles(titles)
                    .start();

            //设置轮播图的监听
            viewHolder.novel_banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context, "点击了"+position, Toast.LENGTH_SHORT).show();
                }
            });

            return viewHolder;
        } else if (viewType == VIEW_TYPE_ONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_rv_item_type_two, parent, false);
            return new NovelTypeOneViewHolder(view);
        } else if (viewType == VIEW_TYPE_TWO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_rv_item_third, parent, false);
            return new NovelTypeTwoViewHolder(view);
        } else if (viewType == VIEW_TYPE_THIRD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_rv_item_type_one, parent, false);
            return new NovelTypeThirdViewHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NovelTypeOneViewHolder) {
            NovelTypeOneViewHolder viewHolder = (NovelTypeOneViewHolder) holder;
            viewHolder.textView_title.setText(dataList.get(position - 1).getTitle());
            viewHolder.textView_title_first.setText(dataList.get(position - 1).getData().get(0).getTitle());
            viewHolder.textView_title_second.setText(dataList.get(position - 1).getData().get(1).getTitle());
            viewHolder.textView_title_third.setText(dataList.get(position - 1).getData().get(2).getTitle());
            if (dataList.get(position - 1).getData().get(0).getSub_title() != null) {
                viewHolder.textView_tv_one.setText(dataList.get(position - 1).getData().get(0).getSub_title());
                viewHolder.textView_tv_two.setText(dataList.get(position - 1).getData().get(1).getSub_title());
                viewHolder.textView_tv_third.setText(dataList.get(position - 1).getData().get(2).getSub_title());
            } else {
                viewHolder.textView_tv_one.setVisibility(View.GONE);
                viewHolder.textView_tv_two.setVisibility(View.GONE);
                viewHolder.textView_tv_third.setVisibility(View.GONE);
            }
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(0).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_first);
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(1).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_second);
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(2).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_third);
        } else if (holder instanceof NovelTypeTwoViewHolder) {
            NovelTypeTwoViewHolder viewHolder = (NovelTypeTwoViewHolder) holder;
            viewHolder.textView_title.setText(dataList.get(position - 1).getTitle());

            viewHolder.textView_title_first.setText(dataList.get(position - 1).getData().get(0).getTitle());
            viewHolder.textView_title_second.setText(dataList.get(position - 1).getData().get(1).getTitle());
            viewHolder.textView_title_third.setText(dataList.get(position - 1).getData().get(2).getTitle());
            viewHolder.textView_title_fourth.setText(dataList.get(position - 1).getData().get(3).getTitle());
            viewHolder.textView_title_fifth.setText(dataList.get(position - 1).getData().get(4).getTitle());
            viewHolder.textView_title_sixth.setText(dataList.get(position - 1).getData().get(5).getTitle());

            viewHolder.textView_tv_one.setText(dataList.get(position - 1).getData().get(0).getSub_title());
            viewHolder.textView_tv_two.setText(dataList.get(position - 1).getData().get(1).getSub_title());
            viewHolder.textView_tv_third.setText(dataList.get(position - 1).getData().get(2).getSub_title());
            viewHolder.textView_tv_fourth.setText(dataList.get(position - 1).getData().get(3).getSub_title());
            viewHolder.textView_tv_fifth.setText(dataList.get(position - 1).getData().get(4).getSub_title());
            viewHolder.textView_tv_sixth.setText(dataList.get(position - 1).getData().get(5).getSub_title());

            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(0).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_first);
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(1).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_second);
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(2).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_third);
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(3).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_fourth);
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(4).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_fifth);
            Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position - 1).getData().get(5).getCover()))
                    .apply(RefererUtil.getOptions(270, 360))
                    .into(viewHolder.imageView_sixth);
        }


        //设置item的监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_BANNER;
        } else if (position == 1) {
            return VIEW_TYPE_THIRD;
        } else if (dataList.get(position - 1).getData().size() == 3) {
            return VIEW_TYPE_ONE;
        } else if (dataList.get(position - 1).getData().size() == 6) {
            return VIEW_TYPE_TWO;
        } else {
            return super.getItemViewType(position);
        }
    }

    /**
     * banner的布局
     */
    static class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner novel_banner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            novel_banner = itemView.findViewById(R.id.novel_banner);
        }
    }

    /**
     * 查找，追小说的视图
     */
    static class NovelTypeThirdViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, imageView6, imageView8;
        TextView textView2, textView3, textView4;

        public NovelTypeThirdViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            imageView6 = itemView.findViewById(R.id.imageView6);
            imageView8 = itemView.findViewById(R.id.imageView8);

            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
        }
    }

    /**
     * 一行三列的布局
     */
    static class NovelTypeOneViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_first, imageView_second, imageView_third;
        TextView textView_title_first, textView_title_second, textView_title_third,
                textView_tv_one, textView_tv_two, textView_tv_third, textView_title;

        public NovelTypeOneViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_first = itemView.findViewById(R.id.imageView_novel_cover_first);
            imageView_second = itemView.findViewById(R.id.imageView_novel_cover_second);
            imageView_third = itemView.findViewById(R.id.imageView_novel_cover_third);
            textView_title_first = itemView.findViewById(R.id.novel_rv_item_two_title_one);
            textView_title_second = itemView.findViewById(R.id.novel_rv_item_two_title_two);
            textView_title_third = itemView.findViewById(R.id.novel_rv_item_two_title_third);
            textView_tv_one = itemView.findViewById(R.id.textView_novel__tv_one);
            textView_tv_two = itemView.findViewById(R.id.textView_novel_tv_two);
            textView_tv_third = itemView.findViewById(R.id.textView_novel_tv_third);
            textView_title = itemView.findViewById(R.id.novel_rv_item_two_title);
        }
    }

    /**
     * 两行三列的布局
     */
    static class NovelTypeTwoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_first, imageView_second, imageView_third, imageView_fourth, imageView_fifth, imageView_sixth;
        TextView textView_title_first, textView_title_second, textView_title_third, textView_title_fourth, textView_title_fifth, textView_title_sixth,
                textView_tv_one, textView_tv_two, textView_tv_third, textView_tv_fourth, textView_tv_fifth, textView_tv_sixth, textView_title;

        public NovelTypeTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_first = itemView.findViewById(R.id.imageView_cover_first);
            imageView_second = itemView.findViewById(R.id.imageView_cover_second);
            imageView_third = itemView.findViewById(R.id.imageView_cover_third);
            imageView_fourth = itemView.findViewById(R.id.imageView_cover_fourth);
            imageView_fifth = itemView.findViewById(R.id.imageView_cover_fifth);
            imageView_sixth = itemView.findViewById(R.id.imageView_cover_sixth);
            textView_title_first = itemView.findViewById(R.id.textView_novel_title_first);
            textView_title_second = itemView.findViewById(R.id.textView_novel_title_second);
            textView_title_third = itemView.findViewById(R.id.textView_novel_title_third);
            textView_title_fourth = itemView.findViewById(R.id.textView_novel_title_fourth);
            textView_title_fifth = itemView.findViewById(R.id.textView_novel_title_fifth);
            textView_title_sixth = itemView.findViewById(R.id.textView_novel_title_sixth);

            textView_tv_one = itemView.findViewById(R.id.textView_novel_author_first);
            textView_tv_two = itemView.findViewById(R.id.textView_novel_author_second);
            textView_tv_third = itemView.findViewById(R.id.textView_novel_author_third);
            textView_tv_fourth = itemView.findViewById(R.id.textView_novel_author_fourth);
            textView_tv_fifth = itemView.findViewById(R.id.textView_novel_author_fifth);
            textView_tv_sixth = itemView.findViewById(R.id.textView_novel_author_sixth);

            textView_title = itemView.findViewById(R.id.textView_title);
        }
    }

}
