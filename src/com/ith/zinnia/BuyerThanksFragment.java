package com.ith.zinnia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class BuyerThanksFragment extends Fragment{

	private View view;
	private HandleActionBar listener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		listener = (HandleActionBar)activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		listener.setActionBar(Constants.choice_home);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater = LayoutInflater.from(getActivity());
		view = inflater.inflate(R.layout.fragment_thanks_buyer, container,false);
		return view;
	}

}