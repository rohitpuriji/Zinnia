package com.ith.zinnia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BuyerChooseFlowerImage2 extends Fragment{

	private View view;
	
	private static BuyerChooseFlowerImage2 fragInfo = null;

	public static BuyerChooseFlowerImage2 getInstance(){
		if(fragInfo == null) {
			fragInfo = new BuyerChooseFlowerImage2();
		}
		return fragInfo;
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater = LayoutInflater.from(getActivity());
		view = inflater.inflate(R.layout.fragment_flowers_image_buyer, container,false);


		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	

}
