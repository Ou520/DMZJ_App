package com.ouwenbin.dmzj_app.model.repository;


import com.ouwenbin.dmzj_app.model.beans.ClassifyData;
import com.ouwenbin.dmzj_app.model.beans.ComicDetailData;
import com.ouwenbin.dmzj_app.model.beans.LatestData;
import com.ouwenbin.dmzj_app.model.beans.NewsBannerData;
import com.ouwenbin.dmzj_app.model.beans.NewsData;
import com.ouwenbin.dmzj_app.model.beans.NovelData;
import com.ouwenbin.dmzj_app.model.beans.RecommendData;
import com.ouwenbin.dmzj_app.model.beans.TopicData;
import com.ouwenbin.dmzj_app.model.httpservice.DataCallback;
import com.ouwenbin.dmzj_app.model.httpservice.WebService;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 数据仓库，为view model提供数据来源
 * 网络请求数据的总类
 */
public class DataRepository {

    private final WebService mwebService;

    @Inject
    public DataRepository(WebService mwebService) {
        this.mwebService = mwebService;

    }

    /**
     * 获取推荐页的数据
     *
     * @param dataCallback 通用回调接口
     */
    public void loadData(DataCallback<List<RecommendData>> dataCallback) {
        mwebService.getRecommendData().enqueue(new Callback<List<RecommendData>>() {
            @Override
            public void onResponse(Call<List<RecommendData>> call, Response<List<RecommendData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<RecommendData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 获取更新页的数据
     */
    public void loadLatestData(DataCallback<List<LatestData>> dataCallback) {
        mwebService.getLatestData().enqueue(new Callback<List<LatestData>>() {
            @Override
            public void onResponse(Call<List<LatestData>> call, Response<List<LatestData>> response) {
                dataCallback.success(response.body());

            }

            @Override
            public void onFailure(Call<List<LatestData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 获取分类页的数据
     */
    public void loadClassifyData(DataCallback<List<ClassifyData>> dataCallback) {
        mwebService.getClassifyData().enqueue(new Callback<List<ClassifyData>>() {
            @Override
            public void onResponse(Call<List<ClassifyData>> call, Response<List<ClassifyData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<ClassifyData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 获取专题页的数据
     */
    public void loadTopicData(DataCallback<List<TopicData>> dataCallback) {
        mwebService.getTopicData().enqueue(new Callback<List<TopicData>>() {
            @Override
            public void onResponse(Call<List<TopicData>> call, Response<List<TopicData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<TopicData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 获取新闻页的banner与新闻列表数据
     */
    public void loadNewsBannerData(DataCallback<NewsBannerData> dataCallback) {
        mwebService.getNewsBannerData().enqueue(new Callback<NewsBannerData>() {
            @Override
            public void onResponse(Call<NewsBannerData> call, Response<NewsBannerData> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<NewsBannerData> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    public void loadNewsData(DataCallback<List<NewsData>> dataCallback) {
        mwebService.getNewsData().enqueue(new Callback<List<NewsData>>() {
            @Override
            public void onResponse(Call<List<NewsData>> call, Response<List<NewsData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<NewsData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 小说数据加载
     */

    public void loadNovelData(DataCallback<List<NovelData>> dataCallback) {
        mwebService.getNovelData().enqueue(new Callback<List<NovelData>>() {
            @Override
            public void onResponse(Call<List<NovelData>> call, Response<List<NovelData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<NovelData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 漫画详情页数据加载
     */

    public void loadComicDetailData(DataCallback<ComicDetailData> dataDataCallback, int obj_id) {
        mwebService.getComicDetailData(obj_id).enqueue(new Callback<ComicDetailData>() {
            @Override
            public void onResponse(Call<ComicDetailData> call, Response<ComicDetailData> response) {
                dataDataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<ComicDetailData> call, Throwable t) {
                dataDataCallback.failed(t.toString());
            }
        });
    }


}
