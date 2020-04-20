package com.ouwenbin.dmzj_app.dagger;



import com.ouwenbin.dmzj_app.MyApplication;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * 相当于一个注射器，之前定义的Modules就是被注射的类，使用@inject注入对象的地方就是接收者类
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        NetWorkModule.class,
        RepositoryModule.class})
public interface RepositoryComponent extends AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        RepositoryComponent build();

        @BindsInstance
        Builder application(MyApplication application);
    }
}
