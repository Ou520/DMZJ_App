
package com.ouwenbin.dmzj_app.controller.activity;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.ouwenbin.dmzj_app.R;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.index_bottom_navigation);
        navigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);//3个以内的默认图片加文字，3个以上需要设置该属性
        NavController navController = Navigation.findNavController(this, R.id.fragment2);
        //注释掉app顶部的导航栏
//        AppBarConfiguration configuration = new AppBarConfiguration.Builder(navigationView.getMenu()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }
}
