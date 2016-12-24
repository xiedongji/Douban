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
	private static final int WELCOME_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        //���ð汾���
        versionNumber.setText(this.getVersion());
        
        //�жϵ�ǰ����״̬
        if (isNetworkConnected()) {
			//��һ������������������
        	AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        	aa.setDuration(WELCOME_TIME);
        	mLLWelcome.setAnimation(aa);
        	mLLWelcome.startAnimation(aa);
        	//ͨ��handler ��ʱ2�� ִ������
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
    
    //�����������ӶԻ���
    private void showSetNetworkDialog(){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setTitle("��������");
    	builder.setMessage("�������!��������״̬");
    	
    	builder.setPositiveButton("��������", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//����һ��Ҫ�������� ���Android 4.0����ƺ�������Ŷ
//				Intent intent = new Intent();
//				intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
				
				//Android5.0�İ汾����ʹ��
				Intent intent = new Intent("android.settings.WIFI_SETTINGS");
				startActivity(intent);
				finish();
			}
		});
    	
    	builder.setNegativeButton("ȡ��", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
    	
    	builder.create().show();
    }
    
    //��ȡAPP�汾
    private String getVersion(){
    	try {
			PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
			return "Version "+info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "Version";
		}
    }
    
    //�ж�����״̬
    private boolean isNetworkConnected(){
    	ConnectivityManager conMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    	NetworkInfo info = conMgr.getActiveNetworkInfo();
    	
    	//�ж��Ƿ�����Wifi
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
