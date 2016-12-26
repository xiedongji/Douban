package com.simon.app.util;

import android.content.Context;
import android.widget.Toast;

public class ITips {
	private static Toast mToast;

	// ============Toast系列===============
	public static void toast(Context context, String text, int duration) {

		if (mToast == null) {
			mToast = Toast.makeText(context, text, duration);
		} else {
			mToast.setText(text);
			mToast.setDuration(duration);
		}
		mToast.show();

	}

	public static void toast(Context context, String text) {

		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();

	}

	public static void toast(Context context, int text) {

		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();

	}
}
