package com.simon.app;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ActWelcome extends ActBase  {
	private TextView versionNumber;
	private LinearLayout mLLWelcome;
	private static final int WELCOME_TIME = 3000; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        //设置版本编号
        versionNumber.setText(this.getVersion());
        
        //判断当前网络状态
        if (isNetworkConnected()) {
			//做一个动画，进入主界面
        	AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        	aa.setDuration(WELCOME_TIME);
        	mLLWelcome.setAnimation(aa);
        	mLLWelcome.startAnimation(aa);
        	//通过handler 延时2秒 执行任务
        	new Handler().postDelayed(new RedirectActHomeTask(), WELCOME_TIME);
		}else{
			this.showSetNetworkDialog();
		}
    }
    
    private class RedirectActHomeTask implements Runnable{
		@Override
		public void run() {
				Intent intent = new Intent(ActWelcome.this, ActHome.class);
				startActivity(intent);
				finish();
		}
    }
    
    //弹出网络连接对话框
    private void showSetNetworkDialog(){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setTitle("设置网络");
    	builder.setMessage("网络错误!请检查网络状态");
    	
    	builder.setPositiveButton("设置网络", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//类名一定要包含包名 这个Android 4.0后的似乎不能用哦
//				Intent intent = new Intent();
//				intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
				
				//Android5.0的版本可以使用
				Intent intent = new Intent("android.settings.WIFI_SETTINGS");
				startActivity(intent);
				finish();
			}
		});
    	
    	builder.setNegativeButton("取消", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
    	
    	builder.create().show();
    }
    
    //获取APP版本
    private String getVersion(){
    	try {
			PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
			return "Version "+info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "Version";
		}
    }
    
    //判断网络状态
    private boolean isNetworkConnected(){
    	ConnectivityManager conMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    	NetworkInfo info = conMgr.getActiveNetworkInfo();
    	
    	//判断是否连接Wifi
//		WifiManager  wifimanager =  (WifiManager) getSystemService(WIFI_SERVICE);
//		wifimanager.isWifiEnabled();
//		wifimanager.getWifiState();
    	
    	return (info != null && info.isConnected());
    }

	@Override
	protected void initView() {
		setContentView(R.layout.act_welcome);
		
		mLLWelcome = (LinearLayout) findViewById(R.id.LLWelcome);
        versionNumber = (TextView) findViewById(R.id.versionCode);
	}

	@Override
	protected void setListener() {
		
	}

}
