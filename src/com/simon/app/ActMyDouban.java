package com.simon.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActMyDouban extends ActBase implements OnItemClickListener {
	private ListView mListView;
	private SharedPreferences mSharedPreferences;
	private static final String[] arrList = { "我读", "我看", "我听", "我评", "我的日记",
			"我的资料", "小组" };
	
	@Override
	protected void proLogic() {
		
	}

	@Override
	protected void initView() {
		setContentView(R.layout.act_mydouban);
		mSharedPreferences = getSharedPreferences("config",Context.MODE_PRIVATE);
		mListView = (ListView) findViewById(R.id.lvMy);
		mListView.setAdapter(new ArrayAdapter<String>(this,R.layout.act_mydouban_lv_item, R.id.tvTitle, arrList));
		mListView.setOnItemClickListener(this);
	}

	// 判断用户是否获取到了授权
	private boolean isUserLogin() {
		String accessToken = mSharedPreferences.getString("accessToken", null);
		String tokenSecret = mSharedPreferences.getString("tokenSecret", null);

		if (accessToken == null || tokenSecret == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		if (isUserLogin()) {
			// 进入到对应界面
		} else {
			// 跳转到登陆界面
			Intent intent = new Intent(this, ActLogin.class);
			startActivity(intent);
		}
	}

	@Override
	protected void setListener() {

	}

	

}
