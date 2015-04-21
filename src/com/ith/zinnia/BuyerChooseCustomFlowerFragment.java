package com.ith.zinnia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BuyerChooseCustomFlowerFragment extends Fragment{

	private View view;
	
	private static BuyerChooseCustomFlowerFragment fragInfo = null;

	public static BuyerChooseCustomFlowerFragment getInstance(){
		if(fragInfo == null) {
			fragInfo = new BuyerChooseCustomFlowerFragment();
		}
		return fragInfo;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater = LayoutInflater.from(getActivity());
		view = inflater.inflate(R.layout.fragment_choose_custom_flower_buyer, container,false);


		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

}
