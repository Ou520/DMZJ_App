package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ouwenbin.dmzj_app.R;
import com.ouwenbin.dmzj_app.model.beans.RecommendData;
import com.ouwenbin.dmzj_app.widget.MyBanner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RecommendRecycleViewAdapter extends RecyclerView.Adapter {
    private final int VIEW_TYPE_ONE = 1;
    private final int VIEW_TYPE_TWO = 2;
    private final int VIEW_TYPE_THREE = 3;
    private final int VIEW_TYPE_BANNER = 0;
    private Context context;
    private List<RecommendData> recommendData = new ArrayList<>();

    public void setRecommendData(List<RecommendData> recommendData) {
        this.recommendData = recommendData;
    }

    public RecommendRecycleViewAdapter(Context context) {
        this.context = context;
    }

    /**
     * 为glide添加一个header，绕过防盗链
     *
     * @param url 图片url
     * @return 返回加了header的新的请求
     */
    private GlideUrl buildGlideUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        } else {
            return new GlideUrl(url, new LazyHeaders.Builder()
                    .addHeader("Referer", "https://v3api.dmzj.com/")
                    .build());
        }
    }

    /**
     * 通过glide设置圆角
     *
     * @return
     */
    private RequestOptions getOptions() {
        RoundedCorners roundedCorners = new RoundedCorners(20);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        return options;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_ONE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_rv_item_one, parent, false);
            RecommendDataListViewHolder viewHolder = new RecommendDataListViewHolder(view);
            NavController navController = Navigation.findNavController(parent);
            Bundle bundle = new Bundle(1);
            viewHolder.imageView_first.setOnClickListener(v -> {
                if ((Integer) viewHolder.itemView.getTag(R.id.TAG_SORT) == 3) {
                    bundle.putInt("obj_id", (Integer) viewHolder.itemView.getTag(R.id.TAG_ONE));
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    return;
                }
            });
            viewHolder.imageView_second.setOnClickListener(v -> {
                if ((Integer) viewHolder.itemView.getTag(R.id.TAG_SORT) == 3) {
                    bundle.putInt("obj_id", (Integer) viewHolder.itemView.getTag(R.id.TAG_SECOND));
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    return;
                }

            });
            viewHolder.imageView_third.setOnClickListener(v -> {
                if ((Integer) viewHolder.itemView.getTag(R.id.TAG_SORT) == 3) {
                    bundle.putInt("obj_id", (Integer) viewHolder.itemView.getTag(R.id.TAG_THIRD));
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    return;
                }
            });

            return viewHolder;
        } else if (viewType == VIEW_TYPE_TWO) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_rv_item_two, parent, false);
            return new GameDataViewHolder(view);
        } else if (viewType == VIEW_TYPE_THREE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_rv_item_third, parent, false);
            ThirdViewHolder viewHolder = new ThirdViewHolder(view);
            NavController navController = Navigation.findNavController(parent);
            Bundle bundle = new Bundle(1);
/**这里最后一个是 id 而不是 obj_id*，各个图片控件的点击事件*/
//            viewHolder.itemView.setOnClickListener(v -> {
//                if (recommendData.get(viewHolder.getAdapterPosition()).getData().get(0).getId() != 0) {
//                    bundle.putInt("obj_id",recommendData.get(viewHolder.getAdapterPosition()).getData().get());
//                }
//            });

            viewHolder.imageView_rv_one.setOnClickListener(view1 -> {
                int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
                if (recommendData.get(position).getData().get(0).getId() != 0) {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(0).getId());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(0).getObj_id());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                }
            });
            viewHolder.imageView_rv_two.setOnClickListener(view1 -> {
                int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
                if (recommendData.get(position).getData().get(0).getId() != 0) {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(1).getId());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(1).getObj_id());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                }
            });
            viewHolder.imageView_rv_three.setOnClickListener(view1 -> {
                int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
                if (recommendData.get(position).getData().get(0).getId() != 0) {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(2).getId());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(2).getObj_id());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                }
            });
            viewHolder.imageView_rv_four.setOnClickListener(view1 -> {
                int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
                if (recommendData.get(position).getData().get(0).getId() != 0) {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(3).getId());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(3).getObj_id());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                }
            });
            viewHolder.imageView_rv_five.setOnClickListener(view1 -> {
                int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
                if (recommendData.get(position).getData().get(0).getId() != 0) {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(4).getId());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(4).getObj_id());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                }
            });
            viewHolder.imageView_rv_six.setOnClickListener(view1 -> {
                int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
                if (recommendData.get(position).getData().get(0).getId() != 0) {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(5).getId());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                } else {
                    bundle.putInt("obj_id", recommendData.get(position).getData().get(5).getObj_id());
                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
                }
            });

//                viewHolder.imageView_rv_one.setOnClickListener(view1 -> {
//                    int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
//                    bundle.putInt("obj_id", recommendData.get(position).getData().get(0).getObj_id());
//                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
//                });
//                viewHolder.imageView_rv_two.setOnClickListener(view1 -> {
//                    int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
//                    bundle.putInt("obj_id", recommendData.get(position).getData().get(1).getObj_id());
//                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
//                });
//                viewHolder.imageView_rv_three.setOnClickListener(view1 -> {
//                    int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
//                    bundle.putInt("obj_id", recommendData.get(position).getData().get(2).getObj_id());
//                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
//                });
//                viewHolder.imageView_rv_four.setOnClickListener(view1 -> {
//                    int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
//                    bundle.putInt("obj_id", recommendData.get(position).getData().get(3).getObj_id());
//                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
//                });
//                viewHolder.imageView_rv_five.setOnClickListener(view1 -> {
//                    int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
//                    bundle.putInt("obj_id", recommendData.get(position).getData().get(4).getObj_id());
//                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
//                });
//                viewHolder.imageView_rv_six.setOnClickListener(view1 -> {
//                    int position = (int) viewHolder.itemView.getTag(R.id.TAG_POSITION);
//                    bundle.putInt("obj_id", recommendData.get(position).getData().get(5).getObj_id());
//                    navController.navigate(R.id.action_comicFragment_to_comicDetailFragment, bundle);
//                });

            return viewHolder;
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_rv_banner, parent, false);
            BannerViewHolder viewHolder = new BannerViewHolder(view);
            //banner控件放在这里，因为banner控件自身有滑动属性，因此bindview中会异常，不会轮播
            viewHolder.rv_banner.setDelayTime(3000)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load(buildGlideUrl((String) path)).into(imageView);
                        }
                    });
            List<String> strings = new ArrayList<>(5);
            List<String> titles = new ArrayList<>(5);
            for (RecommendData.DataBean dataBean : recommendData.get(0).getData()
            ) {
                strings.add(dataBean.getCover());
                titles.add(dataBean.getTitle());
            }
            viewHolder.rv_banner.setImages(strings);
            viewHolder.rv_banner.setBannerTitles(titles);
            //banner的点击事件，由于类型不一，需要判断，准确送入下一层 ，它是通过type字段来分类 1代表漫画（不分国漫 日漫）,10是游戏中心，7是新闻（web），5是专题
            viewHolder.rv_banner.setOnBannerListener(position -> {

                Toast.makeText(context, "点击了"+position, Toast.LENGTH_SHORT).show();

            });
            viewHolder.rv_banner.start();
            return new BannerViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecommendDataListViewHolder) {
            RecommendDataListViewHolder viewHolder = (RecommendDataListViewHolder) holder;
            viewHolder.itemView.setTag(R.id.TAG_SORT, recommendData.get(position).getSort());
            viewHolder.itemView.setTag(R.id.TAG_ONE, recommendData.get(position).getData().get(0).getObj_id());//tag的key的值必须在资源文件里指定，不然报错！
            viewHolder.itemView.setTag(R.id.TAG_SECOND, recommendData.get(position).getData().get(1).getObj_id());
            viewHolder.itemView.setTag(R.id.TAG_THIRD, recommendData.get(position).getData().get(2).getObj_id());
            viewHolder.textView_top_title.setText(recommendData.get(position).getTitle());
            viewHolder.textView_first.setText(recommendData.get(position).getData().get(0).getTitle());
            viewHolder.textView_second.setText(recommendData.get(position).getData().get(1).getTitle());
            viewHolder.textView_third.setText(recommendData.get(position).getData().get(2).getTitle());
            viewHolder.textView_author_first.setText(recommendData.get(position).getData().get(0).getSub_title());
            viewHolder.textView_author_second.setText(recommendData.get(position).getData().get(1).getSub_title());
            viewHolder.textView_author_third.setText(recommendData.get(position).getData().get(2).getSub_title());
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(0).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_first);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(1).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_second);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(2).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_third);
        } else if (holder instanceof GameDataViewHolder) {
            GameDataViewHolder viewHolder = (GameDataViewHolder) holder;
            viewHolder.textView_item_two_title.setText(recommendData.get(position).getTitle());
            viewHolder.textView_one.setText(recommendData.get(position).getData().get(0).getTitle());
            viewHolder.textView_two.setText(recommendData.get(position).getData().get(1).getTitle());
            viewHolder.textView_third.setText(recommendData.get(position).getData().get(2).getTitle());
            viewHolder.textView_fourth.setText(recommendData.get(position).getData().get(3).getTitle());
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(0).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_one);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(1).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_two);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(2).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_third);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(3).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_fourth);
        } else if (holder instanceof ThirdViewHolder) {
            ThirdViewHolder viewHolder = (ThirdViewHolder) holder;
            viewHolder.itemView.setTag(R.id.TAG_POSITION, position);
            viewHolder.textView_third_title.setText(recommendData.get(position).getTitle());
            viewHolder.textView_rv_one.setText(recommendData.get(position).getData().get(0).getTitle());
            viewHolder.textView_rv_two.setText(recommendData.get(position).getData().get(1).getTitle());
            viewHolder.textView_rv_three.setText(recommendData.get(position).getData().get(2).getTitle());
            viewHolder.textView_rv_four.setText(recommendData.get(position).getData().get(3).getTitle());
            viewHolder.textView_rv_five.setText(recommendData.get(position).getData().get(4).getTitle());
            viewHolder.textView_rv_six.setText(recommendData.get(position).getData().get(5).getTitle());

            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(0).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_rv_one);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(1).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_rv_two);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(2).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_rv_three);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(3).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_rv_four);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(4).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_rv_five);
            Glide.with(context).load(buildGlideUrl(recommendData.get(position).getData().get(5).getCover()))
                    .apply(getOptions())
                    .into(viewHolder.imageView_rv_six);
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
        return recommendData.size();
    }

    /**
     * 用来返回recycle view的item的视图类型
     *
     * @param position item的下标
     * @return 返回试图的类型值，从0开始
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_BANNER;
        } else if (recommendData.get(position).getData().size() == 3) {
            return VIEW_TYPE_ONE;
        } else if (recommendData.get(position).getData().size() == 4) {
            return VIEW_TYPE_TWO;
        } else if (recommendData.get(position).getData().size() == 6) {
            return VIEW_TYPE_THREE;
        } else {
            return super.getItemViewType(position);
        }
    }


    /**
     * 第一个item的view holder 1*3
     */
    static class RecommendDataListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_first, imageView_second, imageView_third;
        TextView textView_first, textView_second, textView_third, textView_top_title,
                textView_author_first, textView_author_second, textView_author_third;

        public RecommendDataListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_first = itemView.findViewById(R.id.imageView_first);
            imageView_second = itemView.findViewById(R.id.imageView_second);
            imageView_third = itemView.findViewById(R.id.imageView_third);
            textView_first = itemView.findViewById(R.id.textView_title_first);
            textView_second = itemView.findViewById(R.id.textView_title_second);
            textView_third = itemView.findViewById(R.id.textView_title_third);
            textView_author_first = itemView.findViewById(R.id.textView_author_first);
            textView_author_second = itemView.findViewById(R.id.textView_author_second);
            textView_author_third = itemView.findViewById(R.id.textView_author_third);
            textView_top_title = itemView.findViewById(R.id.textView_top_title);
        }
    }

    /**
     * 第二个item的view holder 2*3
     */

    static class GameDataViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_one, imageView_two, imageView_third, imageView_fourth;
        TextView textView_one, textView_two, textView_third, textView_fourth, textView_item_two_title;

        public GameDataViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView_one = itemView.findViewById(R.id.imageView_one);
            imageView_two = itemView.findViewById(R.id.imageView_two);
            imageView_third = itemView.findViewById(R.id.imageView_thrid);
            imageView_fourth = itemView.findViewById(R.id.imageView_fourth);
            textView_one = itemView.findViewById(R.id.textView_title_one);
            textView_two = itemView.findViewById(R.id.textView_title_two);
            textView_third = itemView.findViewById(R.id.textView_title_third);
            textView_fourth = itemView.findViewById(R.id.textView_title_fourth);
            textView_item_two_title = itemView.findViewById(R.id.textView_item_two_title);
        }
    }

    /**
     * banner的view holder,这个banner时复写了那个的，需要屏蔽掉父控件的滑动拦截
     */
    static class BannerViewHolder extends RecyclerView.ViewHolder {
        MyBanner rv_banner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_banner = itemView.findViewById(R.id.rv_banner);
        }
    }

    /**
     * 第三个item的view holder 显示的是3*2的列表
     */
    static class ThirdViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_rv_one, imageView_rv_two, imageView_rv_three,
                imageView_rv_four, imageView_rv_five, imageView_rv_six;
        TextView textView_rv_one, textView_rv_two, textView_rv_three, textView_third_title,
                textView_rv_four, textView_rv_five, textView_rv_six;

        public ThirdViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_rv_one = itemView.findViewById(R.id.rv_third_one);
            imageView_rv_two = itemView.findViewById(R.id.rv_third_two);
            imageView_rv_three = itemView.findViewById(R.id.rv_third_three);
            imageView_rv_four = itemView.findViewById(R.id.rv_third_four);
            imageView_rv_five = itemView.findViewById(R.id.rv_third_five);
            imageView_rv_six = itemView.findViewById(R.id.rv_third_six);
            textView_rv_one = itemView.findViewById(R.id.rv_third_tv_one);
            textView_rv_two = itemView.findViewById(R.id.rv_third_tv_two);
            textView_rv_three = itemView.findViewById(R.id.rv_third_tv_three);
            textView_rv_four = itemView.findViewById(R.id.rv_third_tv_four);
            textView_rv_five = itemView.findViewById(R.id.rv_third_tv_five);
            textView_rv_six = itemView.findViewById(R.id.rv_third_tv_six);
            textView_third_title = itemView.findViewById(R.id.textView_item_third_title);
        }
    }
}
