package com.simon.app.ui;

import com.simon.app.AppConfig;
import com.simon.app.R;
import com.simon.app.R.id;
import com.simon.app.R.layout;
import com.simon.app.util.ITips;

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
		mSharedPreferences = getSharedPreferences(AppConfig.SP_KEY,Context.MODE_PRIVATE);
	}

	@Override
	protected void initView() {
		setContentView(R.layout.act_mydouban);
		
		mListView = (ListView) findViewById(R.id.lvMy);
		mListView.setAdapter(new ArrayAdapter<String>(this,R.layout.act_mydouban_lv_item, R.id.tvTitle, arrList));
		mListView.setOnItemClickListener(this);
	}

	// 判断用户是否获取到了授权
	private boolean isUserLogin() {
		String accessToken = mSharedPreferences.getString(AppConfig.SESSION_ID, null);

		if (accessToken == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		if (isUserLogin()) {
			// 进入到对应界面
			redirectTo(ActMyInfo.class);
		} else {
			// 跳转到登陆界面
			redirectTo(ActLogin.class);
		}
	}

	@Override
	protected void setListener() {

	}

	

}
