package com.simon.app;

import android.app.Activity;
import android.os.Bundle;


public abstract class ActBase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initView();
        this.setListener();
        this.proLogic();
    }
    
    //处理业务逻辑
    protected abstract void proLogic();
    
    //视图组件初始化
    protected abstract void initView();
    
    //绑定监听器
    protected abstract void setListener();
}
