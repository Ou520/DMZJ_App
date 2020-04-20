package com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.adapter;

import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.ClassifyFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.RecommendFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.TopicFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.UpdateFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;



/**
 * 首页的viewpager2的适配器
 */
public class RecommendFragmentAdapter extends FragmentStateAdapter {

    private Fragment fragment;

    public RecommendFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     *
     * @param position 位置
     * @return 返回对应位置的fragment
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                fragment = new UpdateFragment();//更新页面
                break;
            case 2:
                fragment = new ClassifyFragment();//分类页面
                break;
            case 3:
                fragment = new TopicFragment();//专题页面
                break;
            default:
                fragment = new RecommendFragment();//推荐是默认第一页
        }
        return fragment;
    }

    /**
     *
     * @return 返回页面的个数
     */
    @Override
    public int getItemCount() {
        return 4;
    }
}
