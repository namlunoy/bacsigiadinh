package com.th10.bacsigiadinh.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import com.google.android.gms.maps.model.LatLng;
import com.th10.bacsigiadinh.helpers.Helper;
import com.th10.bacsigiadinh.helpers.MapConfig;

public class PlaceController {
	private LatLng position;

	public PlaceController(LatLng position) {
		this.position = position;
	}

	public String getJSON() {
		StringBuilder builder = new StringBuilder();
		URL url;
		String line;
		URLConnection connection = null;
		BufferedReader reader;
		try {
			url = new URL(MapConfig.getQueryString(position));
			connection = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = reader.readLine()) != null)
				builder.append(line);
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Helper.Log("getJSON", "MalformedURLException - " + e.getMessage());
		} catch (IOException e) {
			Helper.Log("getJSON", "IOException - " + e.getMessage());
			e.printStackTrace();
		}

		return builder.toString();
	}
}
