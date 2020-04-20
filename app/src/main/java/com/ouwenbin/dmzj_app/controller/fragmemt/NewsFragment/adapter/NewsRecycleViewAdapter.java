package com.ouwenbin.dmzj_app.controller.fragmemt.NewsFragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.controller.fragmemt.base.OnItemClickListener;
import com.ouwenbin.dmzj_app.model.beans.NewsData;
import com.ouwenbin.dmzj_app.utils.RefererUtil;

import java.util.ArrayList;
import java.util.List;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> implements View.OnClickListener {
    private Context context;
    private List<NewsData> newsDataList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public NewsRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setNewsDataList(List<NewsData> newsDataList) {
        this.newsDataList = newsDataList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item, parent, false);
        view.setOnClickListener(this);//设置监听器
        return new NewsViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.textView_user.setText(newsDataList.get(position).getNickname());
        holder.textView_title.setText(newsDataList.get(position).getTitle());
        holder.textView_tv_good.setText(String.valueOf(newsDataList.get(position).getMood_amount()));
        holder.textView_tv_comment.setText(String.valueOf(newsDataList.get(position).getComment_amount()));

        Glide.with(context).load(RefererUtil.buildeGlideUrl(newsDataList.get(position).getRow_pic_url()))
                .apply(RefererUtil.getOptions(360, 225))
                .into(holder.imageView_news_cover);
        Glide.with(context).load(RefererUtil.buildeGlideUrl(newsDataList.get(position).getCover()))
                .apply(RefererUtil.getOptions(120, 120))
                .into(holder.imageView_news_user_cover);

    }

    @Override
    public int getItemCount() {
        return newsDataList.size();
    }

    @Override
    public void onClick(View view) {

    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_news_cover, imageView_news_user_cover;
        TextView textView_title, textView_tv_good, textView_tv_comment, textView_user;

         NewsViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            initView(itemView);
            initListener(itemView,onItemClickListener);

        }


        private void initView(View itemView) {
            imageView_news_cover = itemView.findViewById(R.id.news_rv_cover);
            imageView_news_user_cover = itemView.findViewById(R.id.news_rv_user_cover);
            textView_title = itemView.findViewById(R.id.news_rv_tv_title);
            textView_tv_good = itemView.findViewById(R.id.news_rv_tv_good_number);
            textView_tv_comment = itemView.findViewById(R.id.news_rv_tv_comment_number);
            textView_user = itemView.findViewById(R.id.news_rc_tv_user);
        }

        private void initListener(View itemView, OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    int position = getAdapterPosition();
                    //确保position有数值
                    if (position != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(view, position);
                    }
                }
            });
        }
    }
}
