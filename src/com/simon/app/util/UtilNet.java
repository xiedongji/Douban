package com.simon.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class UtilNet {
	
	//获取图像验证码
	public static Bitmap getImage(String imgUrl) throws IOException{
		URL url = new URL(imgUrl);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		InputStream is = conn.getInputStream();
		return BitmapFactory.decodeStream(is);
	}

}
