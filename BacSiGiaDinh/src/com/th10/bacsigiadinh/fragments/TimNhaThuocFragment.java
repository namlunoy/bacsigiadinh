package com.th10.bacsigiadinh.fragments;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.th10.bacsigiadinh.R;
import com.th10.bacsigiadinh.controllers.PlaceController;
import com.th10.bacsigiadinh.helpers.Helper;
import com.th10.bacsigiadinh.helpers.MyGPS;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class TimNhaThuocFragment extends Fragment implements OnMapReadyCallback, ConnectionCallbacks, OnConnectionFailedListener {

	public static View rootView = null;
	MapFragment mapFragment;
	GoogleMap map;
	MyGPS myGPS;
	private GoogleApiClient mGoogleApiClient;
	PlaceController placeController;
	
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
		mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
		
		//Lấy googlemap trong fragment (OnMapReadyCallback)	
		mapFragment.getMapAsync(this);
		
		  mGoogleApiClient = new GoogleApiClient
		            .Builder(getActivity())
		            .addApi(Places.GEO_DATA_API)
		            .addApi(Places.PLACE_DETECTION_API)
		            .addConnectionCallbacks(this)
		            .addOnConnectionFailedListener(this)
		            .build();
		  
		return rootView;
	}

	void CauHinhMap()
	{
		map.setMyLocationEnabled(true);
		map.getUiSettings().setZoomControlsEnabled(true);
		//map.getUiSettings().set
	}
	
	@Override
	public void onMapReady(GoogleMap map) {
		this.map = map;
		CauHinhMap();
		
		Helper.Toast(getActivity(), "onMapReady");
		
		//Tìm và hiển thị vị trí hiện tại
		myGPS = new MyGPS(getActivity());
		LatLng myLocation = myGPS.getMyLocation();
		if(myLocation != null)
		{
			MarkerOptions option = new MarkerOptions();
			option.title("Title");
			option.snippet("snippet");
			option.position(myLocation);
			
			Marker currentMarker= map.addMarker(option);
			currentMarker.showInfoWindow();
			CameraPosition cameraPosition = new CameraPosition.Builder().target(myLocation).zoom(15).build();
	 
	map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

		}else{
			Helper.Log("onMapReady", "myLocation is NULL");
		}
		Helper.Log("onMapReady", "");
		
		placeController = new PlaceController(myLocation);
	//	Helper.Log("mylog",placeController.getJSON());
	}

	@Override
	public void onStart() {
		super.onStart();
		 mGoogleApiClient.connect();
	}

	@Override
	public void onStop() {
		 mGoogleApiClient.disconnect();
		super.onStop();
	}

	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionSuspended(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
