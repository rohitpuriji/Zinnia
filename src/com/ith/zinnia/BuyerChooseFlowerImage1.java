package com.ith.zinnia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BuyerChooseFlowerImage1 extends Fragment{

	private View view;
	private static BuyerChooseFlowerImage1 fragInfo = null;

	public static BuyerChooseFlowerImage1 getInstance(){
		if(fragInfo == null) {
			fragInfo = new BuyerChooseFlowerImage1();
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
