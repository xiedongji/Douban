package com.simon.app;

public class AppConfig {

	// ===========调试开发部分===================
	public static final boolean isShowLog = true;// 是否打印Log
	public static final boolean isTagSame = false;// 所有的TAG标签都一样
	public static final String TagName = "IBlog";// 所有的TAG标签都一样

	// =============服务器请求地址===============//
	public static final String URL_ROOT = "http://dev.blog.com/";
	public static final String URL_HTTP_ROOT = URL_ROOT;

	public static final String URL_LOGIN = URL_HTTP_ROOT + "doIn";
	public static final String URL_CAPTCHA = URL_HTTP_ROOT + "verify";
	
	// ===========系统保存钥匙===================
		public static final String SP_KEY  = "simonKey";//SharedPreferences保存的钥匙
		public static final String SESSION_ID  = "session_id";//SharedPreferences保存的钥匙
}