package com.ith.zinnia;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ith.adapters.FloristAdapter;
import com.ith.beans.FloristItems;
import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class BuyerMapAndListFragment extends Fragment{

	private View view;
	private HandleActionBar listener;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private TextView textFlorists;
	private ImageView imgMap;
	private ImageView imgList;
	private ListView listviewPlaces;
	private FloristAdapter adapter;
	private ArrayList<FloristItems> items = new ArrayList<FloristItems>();
	private BuyerChooseFlowerFragment frag;
	private MapView mMapView;
	private GoogleMap mMap;	
	private Marker myMarker;
	private MarkerOptions markerOptions;
	private Bundle bundle;

	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (HandleActionBar)activity;

	}
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		listener.setActionBar(Constants.choice_back);
//		
//	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		inflater = LayoutInflater.from(getActivity());
		view = inflater.inflate(R.layout.fragment_list_and_map_buyer, container,false);
		textFlorists = (TextView)view.findViewById(R.id.textFlorists);
		imgMap = (ImageView)view.findViewById(R.id.imgMap);
		imgList = (ImageView)view.findViewById(R.id.imgList);
		listviewPlaces = (ListView)view.findViewById(R.id.listviewPlaces);
		mMapView = (MapView) view.findViewById(R.id.map);
		mMapView.onCreate(bundle);
		listviewPlaces.setVisibility(View.VISIBLE);
		listener.setActionBar(Constants.choice_back);

		return view;
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		imgList.setVisibility(View.GONE);
		imgMap.setVisibility(View.VISIBLE);
		listviewPlaces.setVisibility(View.VISIBLE);
		mMapView.setVisibility(View.GONE);
		
		for (int i = 0; i < 10; i++) {
			FloristItems florist = new FloristItems();
			florist.away = "3 miles away";
			florist.title = "Florist Flowers";
			florist.price = "$45";
			items.add(florist);
		}
		adapter = new FloristAdapter(getActivity().getApplicationContext(), items);
		listviewPlaces.setAdapter(adapter);

		
		MapsInitializer.initialize(getActivity());
		setUpMap(view);
		setDummyMarkers();
		
		imgList.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				imgList.setVisibility(View.GONE);
				imgMap.setVisibility(View.VISIBLE);
				listviewPlaces.setVisibility(View.VISIBLE);
				mMapView.setVisibility(View.GONE);
			}
		});
		imgMap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				imgList.setVisibility(View.VISIBLE);
				imgMap.setVisibility(View.GONE);
				listviewPlaces.setVisibility(View.GONE);
				mMapView.setVisibility(View.VISIBLE);
			}
		});
		
		listviewPlaces.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(frag == null){
					frag = new BuyerChooseFlowerFragment();
				}
				handleFragments(frag);				
			}
		});
		
	}
	
	private void handleFragments(Fragment fragment){

		fm = getActivity().getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.replace(R.id.frame_container, fragment);
		ft.addToBackStack(null);
		ft.commit();
	}

	
	private void setUpMap(View inflatedView) {
		mMap = ((MapView) inflatedView.findViewById(R.id.map)).getMap();
		mMap.getUiSettings().setCompassEnabled(true);
		mMap.getUiSettings().setZoomControlsEnabled(true);
		mMap.getUiSettings().setRotateGesturesEnabled(true);
		mMap.getUiSettings().setScrollGesturesEnabled(true);
		mMap.getUiSettings().setTiltGesturesEnabled(true);
		mMap.getUiSettings().setZoomGesturesEnabled(true);
	}
	
	public void setDummyMarkers(){

		markerOptions = new MarkerOptions();

		double lat = 28.613939;	            

		double lng = 77.209021;

		LatLng latLng = new LatLng(lat, lng);

		markerOptions.position(latLng);

		mMap.addMarker(markerOptions);   

		if (mMap != null) {
			mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());	
//			mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
//
//				@Override
//				public void onInfoWindowClick(Marker marker) { 
//					if(frag == null){
//						frag = new FragmentChooseFlower();
//					}
//					bundle.putString(Constants.key_login_for, loginFor);
//					fm = getFragmentManager();
//					ft = fm.beginTransaction();
//					ft.replace(R.id.login_frame, frag);
//					frag.setArguments(bundle);
//					ft.addToBackStack(frag.getClass().getName());
//					ft.commit();				
//				}
//			});
		}
	}
	
	private class CustomInfoWindowAdapter implements InfoWindowAdapter {

		private View view;
		public CustomInfoWindowAdapter() {
			view = getActivity().getLayoutInflater().inflate(R.layout.infowindow_layout,
					null);
		}

		@Override
		public View getInfoContents(Marker marker) {

			marker.showInfoWindow();
			return null;
		}

		@Override
		public View getInfoWindow(Marker marker) {

			final TextView tvTitle = ((TextView) view.findViewById(R.id.tvTitle));
			final TextView tvArrangements = ((TextView) view.findViewById(R.id.tvArrangements));
			final TextView tvPrice = ((TextView) view.findViewById(R.id.tvPrice));
			final com.ith.widget.CircleImageView imgInfo =  ((com.ith.widget.CircleImageView) view.findViewById(R.id.infoWindowPhoto));

			imgInfo.setImageDrawable(getResources().getDrawable(R.drawable.splash));
			return view;
		}
	}

	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		textFlorists = null;
		imgMap = null;
		imgList = null;
	}

	@Override
	public void onDetach() {
		super.onDetach();
        
        listener = null;
        
	}

}
