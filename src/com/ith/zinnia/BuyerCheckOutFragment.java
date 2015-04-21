package com.ith.zinnia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class BuyerCheckOutFragment extends Fragment{

	private View view;
	private HandleActionBar listener;
	private Button btnBuyNow;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BuyerThanksFragment frag;


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (HandleActionBar)activity;

	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater = LayoutInflater.from(getActivity());
		view = inflater.inflate(R.layout.fragment_checkout_buyer, container,false);
		btnBuyNow = (Button)view.findViewById(R.id.btnBuyNow);
		listener.setActionBar(Constants.choice_back);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		btnBuyNow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(frag == null){
					frag = new BuyerThanksFragment();
				}
				handleFragments(frag);
			}
		});
	}
	
	private void handleFragments(Fragment fragment){

		fm = getActivity().getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.replace(R.id.frame_container, fragment,"thanks");
		ft.addToBackStack(null);
		ft.commit();

	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

}
