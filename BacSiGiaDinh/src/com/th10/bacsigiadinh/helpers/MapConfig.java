package com.th10.bacsigiadinh.helpers;

import com.google.android.gms.maps.model.LatLng;

public class MapConfig {
	public static String API_KEY = "AIzaSyD2a5WyrDzNV_nxUdmmATumKAxZZJoaR_k";
	public static int RADIUS = 5000;
	public static String TYPES = "health|hospital|benh vien";
	public static boolean SENSOR = false;

	public static String getQueryString(LatLng position) {
		String url = "https://maps.googleapis.com/maps/api/place/search/json?"
				+ "types="+ TYPES 
				+ "&location=" + position.latitude + ","+position.longitude
				+ "&radius="+RADIUS
				+ "&sensor="+SENSOR
				+ "&key="+API_KEY;
		MyHelper.Log("MapConfig.getQueryString", url);
		return "https://maps.googleapis.com/maps/api/place/search/json?location=" + position.latitude + "," + position.longitude + "&radius=1000&sensor=true&key=AIzaSyD2a5WyrDzNV_nxUdmmATumKAxZZJoaR_k";// + GOOGLE_KEY;
	}
}
