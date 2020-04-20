package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.adapter;

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
import com.ouwenbin.dmzj_app.model.beans.ClassifyData;
import com.ouwenbin.dmzj_app.utils.RefererUtil;


import java.util.ArrayList;
import java.util.List;

public class ClassifyRecyclerViewAdapter extends RecyclerView.Adapter<ClassifyRecyclerViewAdapter.ClassifyViewHolder> implements View.OnClickListener {

    private Context context;
    private List<ClassifyData> list = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setList(List<ClassifyData> list) {
        this.list = list;
    }

    public ClassifyRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ClassifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_rv_item, parent, false);
        view.setOnClickListener(this);//设置监听器
        return new ClassifyViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassifyViewHolder holder, int position) {
        holder.textView_title.setText(list.get(position).getTitle());


        Glide.with(context).load(RefererUtil.buildeGlideUrl(list.get(position).getCover()))
                .apply(RefererUtil.getOptions(300,300))
                .into(holder.imageView_cover);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }

    static class ClassifyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_cover;
        TextView textView_title;

        ClassifyViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            initView(itemView);
            initListener(itemView,onItemClickListener);

        }

        private void initView(View itemView) {
            imageView_cover = itemView.findViewById(R.id.imageView_cover);
            textView_title = itemView.findViewById(R.id.textView_title);
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
