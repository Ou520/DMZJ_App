package com.ouwenbin.dmzj_app;



import com.ouwenbin.dmzj_app.dagger.DaggerRepositoryComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * 继承DaggerApplication类，并在在applicationInjector方法中创建了一个注射器
 */
public class MyApplication extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerRepositoryComponent.builder().application(this).build();

    }
}
