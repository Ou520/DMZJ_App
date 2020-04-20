package com.ouwenbin.dmzj_app.dagger;


import com.ouwenbin.dmzj_app.controller.activity.MainActivity;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.ClassifyFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.RecommendFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.RecommendViewModel;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.TopicFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.UpdateFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.fragment.UpdateViewModel;
import com.ouwenbin.dmzj_app.controller.fragmemt.ComicFragment.ComicDetailFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.NewsFragment.NewsFragment;
import com.ouwenbin.dmzj_app.controller.fragmemt.NovelFragment.NovelFragment;



import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 通过@contributesAndroidInjector注解来标记哪个类需要使用依赖注入功能
 */
@Module
abstract class RepositoryModule {
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract RecommendFragment contributeRecommendFragment();

    @ContributesAndroidInjector
    abstract RecommendViewModel contributeRecommendViewModel();

    @ContributesAndroidInjector
    abstract UpdateFragment contributeUpdateFragment();

    @ContributesAndroidInjector
    abstract UpdateViewModel contributeUpdateViewModel();

    @ContributesAndroidInjector
    abstract ClassifyFragment contributeClassify();

    @ContributesAndroidInjector
    abstract TopicFragment topicFragment();

    @ContributesAndroidInjector
    abstract NewsFragment contributeNewsFragment();

    @ContributesAndroidInjector
    abstract NovelFragment contributeNovelFragment();

    @ContributesAndroidInjector
    abstract ComicDetailFragment contributeComicDetailFragment();


}
