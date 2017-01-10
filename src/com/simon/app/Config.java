package com.simon.app;

public class Config {

	// ===========调试开发部分===================
	public static final boolean isShowLog = true;// 是否打印Log
	public static final boolean isTagSame = false;// 所有的TAG标签都一样
	public static final String TagName = "IBlog";// 所有的TAG标签都一样
	
	// =========== API接口请求状态部分===================
	public static final  int API_SUCCESS = 10;
	public static final  int API_FAIL = 20;
	public static final  int API_ERROR = 30;

	// =============服务器请求地址===============//
	public static final String URL_ROOT = "http://dev.blog.com";
	
	public static final String URL_HTTP_ROOT = URL_ROOT+"/index.php/api";

	public static final String URL_LOGIN = URL_HTTP_ROOT + "/login/doin";
	public static final String URL_CAPTCHA = URL_HTTP_ROOT + "/verify";
	public static final String URL_BOOK_LIST = URL_HTTP_ROOT + "/verify";
	
}