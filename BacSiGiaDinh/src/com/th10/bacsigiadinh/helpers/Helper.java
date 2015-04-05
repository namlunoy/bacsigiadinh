package com.th10.bacsigiadinh.helpers;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Helper {
	public static void Log(String tag, String mess)
	{
		Log.d(tag, mess);
	}
	
	public static void Toast(Context context,String mess)
	{
		Toast.makeText(context, mess, 0).show();
	
	}
}
