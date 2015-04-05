package com.th10.bacsigiadinh.fragments;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.th10.bacsigiadinh.R;
import com.th10.bacsigiadinh.helpers.Helper;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class TimNhaThuocFragment extends Fragment implements OnMapReadyCallback {

	public static View rootView = null;
	MapFragment mapFragment;
	GoogleMap map;
	
	public TimNhaThuocFragment() {
		Helper.Log("xxx", "Ham tao!");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Helper.Log("xxx", "onCreateView");
	
		//Máp chỉ được phép load 1 lần duy nhất
		if(rootView == null)
			rootView = inflater.inflate(R.layout.fragment_timnhathuoc,
				container, false);
		
		//Lấy con trỏ fragment
		mapFragment = (MapFragment) getFragmentManager()
			    .findFragmentById(R.id.map);
		
		//Lấy googlemap trong fragment (OnMapReadyCallback)	
		mapFragment.getMapAsync(this);
		
		
		return rootView;
	}

	@Override
	public void onMapReady(GoogleMap map) {
		this.map = map;
		Helper.Toast(getActivity(), "onMapReady");
		
		//Tìm và hiển thị vị trí hiện tại
		
	}

}
