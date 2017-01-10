package com.simon.app.ui;

import java.net.CookieStore;

import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.simon.app.Config;
import com.simon.app.R;
import com.simon.app.util.HttpUtils;
import com.simon.app.util.ILog;
import com.simon.app.util.ITips;

public class ActLogin extends ActBase implements OnClickListener {
	
	private EditText mUsernameET, mPwdET, mCaptchaET;
	private Button mLoginBtn, mExitBtn;
	private ImageView mCaptchaIV;

	private ProgressDialog mProgressDialog;

	@Override
	protected void proLogic() {

	}

	@Override
	protected void initView() {
		setContentView(R.layout.act_login);
		mUsernameET = (EditText) findViewById(R.id.unameET);
		mPwdET = (EditText) findViewById(R.id.pwdET);
		mCaptchaET = (EditText) findViewById(R.id.captchaET);

		mCaptchaIV = (ImageView) findViewById(R.id.captchaIV);

		mLoginBtn = (Button) findViewById(R.id.btnLogin);
		mExitBtn = (Button) findViewById(R.id.btnExit);
	}

	@Override
	protected void setListener() {
		mLoginBtn.setOnClickListener(this);
		mExitBtn.setOnClickListener(this);

		mCaptchaIV.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin:
			final String name = mUsernameET.getText().toString();
			final String pwd = mPwdET.getText().toString();
			

			if ("".equals(name) || "".equals(pwd)) {
				ITips.toast(this, "用户名或者密码不能为空");
				return;
			} else {
				this.login(name, pwd);
			}
			break;

		case R.id.btnExit:
			finish();
			break;

		case R.id.captchaIV:
			ITips.toast(this, "test");
			this.getCaptcha();
			break;
		}
	}

	// 密码登陆
	private void login(final String name, final String pwd) {
		mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setMessage("正在登陆");
		mProgressDialog.show();

		new Thread() {
			@Override
			public void run() {
				// 发送登陆请求
				ILog.show("HTTP", Config.URL_LOGIN);
				// 拼装数据
				String paramStr = "uname="+name+"&pwd="+pwd;
				ILog.show("HTTP","param:"+paramStr);
				
				String httpRes = HttpUtils.doPost(Config.URL_LOGIN, paramStr);
				ILog.show("HTTP","httpRes:"+httpRes);
				
				try {
					JSONTokener jsonParser = new JSONTokener(httpRes);
					JSONObject loginRes = (JSONObject) jsonParser.nextValue();
				
	                String code = loginRes.getString("code");
	                String msg = loginRes.getString("msg");
	                
	                Message handlerMsg = new Message();
	                if ("10".equals(code)) {
	                    handlerMsg.what = Config.API_SUCCESS;
	                }else{
	                    handlerMsg.what = Config.API_FAIL;
	                }
	                handlerMsg.obj = msg;
	                handler.sendMessage(handlerMsg);
                
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	// 获取图形验证码
	private void getCaptcha() {
		String loginUrl = getResources().getString(R.string.loginUrl);
		ILog.show("HTTP","xmlURL:"+loginUrl);
	}
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			mProgressDialog.dismiss();
			
			switch (msg.what) {
				case Config.API_SUCCESS:
					ITips.toast(ActLogin.this, msg.obj.toString());
					break;
				case Config.API_FAIL:
					ITips.toast(ActLogin.this, msg.obj.toString());
					break;
			}
		}
	};

}
