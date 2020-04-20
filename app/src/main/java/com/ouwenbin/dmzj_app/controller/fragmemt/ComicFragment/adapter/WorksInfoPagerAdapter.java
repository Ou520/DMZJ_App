package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ouwenbin.dmzj_app.R;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

/**
 * 漫画介绍标签tablayout的适配器
 */
public class WorksInfoPagerAdapter extends RecyclerView.Adapter {

    private List<String> strings = new ArrayList<>(3);
    private Context context;

    public void setStrings(List<String> strings, Context context) {
        this.strings = strings;
        this.context = context;
    }

    private boolean isExtend = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager2_item, parent, false);
        view.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));//不然会报错 Pages must fill the whole ViewPager2 (use match_parent)
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.textView.setOnClickListener(v -> {
            if (isExtend) {
                viewHolder.textView.setMaxLines(2);
                Drawable drawable = context.getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black, null);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                viewHolder.textView.setCompoundDrawables(null, null, drawable, null);
                isExtend = false;
            } else {
                viewHolder.textView.setMaxLines(10);
                Drawable drawable = context.getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_black, null);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                viewHolder.textView.setCompoundDrawables(null, null, drawable, null);
                isExtend = true;
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_txt);
        }
    }
}
