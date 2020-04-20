package com.ouwenbin.dmzj_app.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ouwenbin.dmzj_app.R;

public class LauncherActivity extends Activity {

    private ImageView iv_Icon;
    private Button bntJump;
    private boolean biaoji =true;
    private int index=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        initView();
        initData();
        setData();
        setListener();
    }

    private void initView() {
        iv_Icon=findViewById(R.id.iv_Icon);
        bntJump=findViewById(R.id.bntJump);
    }

    //通过Handler()方法来接收子线程传回来的消息（Message），并在相应的组件上显示
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1)//通过msg.what判断消息是来自那个字线程的，并在UI线程的组件显示或者其他操作
            {
                int index=msg.arg1;//获取消息携带的属性值
                bntJump.setText("跳转："+index);
            }

        }
    };


    private void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (biaoji){
                    Intent intent =new Intent(LauncherActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000);
    }

    private void setData() {
        startThread();
    }

    private void startThread() {
        //创建子线程，实现子线程（Thread）里的Runnable接口并实现接口里的run()方法
        new Thread(() -> {
            while (index>=1)
            {
                Message msg=new Message();//创建Message对象
                //给对象指定参数
                msg.what=1;//标志（整型变量），用来判断消息是来自那个字线程
                msg.arg1=index;//拿来传整型（int）数据和msg.arg2一样
                handler.sendMessage(msg);//发送信息
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index--;
            }
        }).start();
    }

    private void setListener() {
        bntJump.setOnClickListener(new MyOnClickListener());
    }


    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            biaoji=false;
            Intent intent =new Intent(LauncherActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
