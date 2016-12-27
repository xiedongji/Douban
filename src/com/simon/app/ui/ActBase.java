package com.simon.app.ui;

import android.app.Activity;
import android.content.Intent;
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
    
    //跳转界面 带参数
    protected void redirectTo(Class<? extends Activity> targetAct, String actionName) {
		Intent intent = new Intent(this, targetAct);
		intent.putExtra("action", actionName);
		startActivity(intent);
		finish();
	}
    
    //跳转界面 不带参数
    protected void redirectTo(Class<? extends Activity> targetAct) {
		Intent intent = new Intent(this, targetAct);
		startActivity(intent);
		finish();
	}
}
