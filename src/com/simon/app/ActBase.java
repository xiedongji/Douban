package com.simon.app;

import android.app.Activity;
import android.os.Bundle;


public abstract class ActBase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initView();
        this.setListener();
    }
    
    //��ͼ�����ʼ��
    protected abstract void initView();
    
    //�󶨼�����
    protected abstract void setListener();
}
