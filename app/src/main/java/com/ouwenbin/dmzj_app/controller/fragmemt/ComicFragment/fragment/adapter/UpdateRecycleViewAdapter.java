package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.model.beans.LatestData;
import com.ouwenbin.dmzj_app.utils.DateCovertUtil;


import java.util.ArrayList;
import java.util.List;

public class UpdateRecycleViewAdapter extends RecyclerView.Adapter {
    private int rv_viewType;

    private List<LatestData> latestData = new ArrayList<>();//必须初始化
    private Context context;

    public UpdateRecycleViewAdapter(Context context, int rv_viewType) {
        this.context = context;
        this.rv_viewType = rv_viewType;
    }

    public void setLatestData(List<LatestData> latestData) {
        this.latestData = latestData;
    }

    private GlideUrl buildGlideUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        } else {
            return new GlideUrl(url, new LazyHeaders.Builder()
                    .addHeader("Referer", "https://v3api.dmzj.com/")
                    .build());
        }
    }

    private RequestOptions getOptions() {
        RoundedCorners roundedCorners = new RoundedCorners(20);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        return options;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (rv_viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.updata_rv_item_type_one, parent, false);
            LinearViewHolder linearViewHolder = new LinearViewHolder(view);
            return linearViewHolder;
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.updata_rv_item_type_two, parent, false);
            GridViewHolder gridViewHolder = new GridViewHolder(view);
            return gridViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LinearViewHolder) {
            LinearViewHolder viewHolder = (LinearViewHolder) holder;
            viewHolder.textView_updata_title.setText(latestData.get(position).getTitle());
            viewHolder.textView_updata_author.setText(latestData.get(position).getAuthors());
            viewHolder.textView_updata_tag.setText(latestData.get(position).getTypes());
            viewHolder.textView_updata_time.setText(DateCovertUtil.getDate(latestData.get(position).getLast_updatetime()));
            viewHolder.textView_updata_number.setText(latestData.get(position).getLast_update_chapter_name());
            Glide.with(context).load(buildGlideUrl(latestData.get(position).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_cover);
        } else {
            GridViewHolder viewHolder = (GridViewHolder) holder;
            viewHolder.textView_two_number.setText(latestData.get(position).getLast_update_chapter_name());
            viewHolder.textView_two_title.setText(latestData.get(position).getTitle());
            Glide.with(context).load(buildGlideUrl(latestData.get(position).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_two_cover);
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
        return latestData.size();
    }

    static class LinearViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_cover;
        TextView textView_updata_title, textView_updata_author, textView_updata_tag,
                textView_updata_time, textView_updata_number;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_cover = itemView.findViewById(R.id.rv_updata_image_cover);
            textView_updata_title = itemView.findViewById(R.id.rv_updata_tv_title);
            textView_updata_author = itemView.findViewById(R.id.rv_updata_tv_author);
            textView_updata_tag = itemView.findViewById(R.id.rv_updata_tv_tag);
            textView_updata_time = itemView.findViewById(R.id.rv_updata_tv_time);
            textView_updata_number = itemView.findViewById(R.id.rv_updata_tv_number);
        }
    }

    static class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_two_cover;
        TextView textView_two_title, textView_two_number;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_two_cover = itemView.findViewById(R.id.rv_updata_two_cover);
            textView_two_title = itemView.findViewById(R.id.rv_updata_tv_two_title);
            textView_two_number = itemView.findViewById(R.id.rv_updata_tv_two_number);

        }
    }
}
