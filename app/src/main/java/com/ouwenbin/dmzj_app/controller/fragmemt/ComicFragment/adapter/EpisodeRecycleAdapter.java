package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.model.beans.ComicDetailData;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class EpisodeRecycleAdapter extends RecyclerView.Adapter<EpisodeRecycleAdapter.CellViewHolder> {
    private List<ComicDetailData.ChaptersBean.DataBean> dataBeans;

    public EpisodeRecycleAdapter(List<ComicDetailData.ChaptersBean.DataBean> list) {
        this.dataBeans = list;
    }

    @NonNull
    @Override
    public CellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_item, parent, false);
        CellViewHolder holder = new CellViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CellViewHolder holder, int position) {
        holder.episode_text.setText(dataBeans.get(position).getChapter_title());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    static class CellViewHolder extends RecyclerView.ViewHolder {
        TextView episode_text;

        public CellViewHolder(@NonNull View itemView) {
            super(itemView);
            episode_text = itemView.findViewById(R.id.episode_text);
        }
    }
}
