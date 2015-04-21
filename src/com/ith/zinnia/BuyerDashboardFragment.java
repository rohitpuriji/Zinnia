package com.ith.zinnia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class BuyerDashboardFragment extends Fragment{

	public ImageButton imgBday;
	public ImageButton imgBecause;
	public ImageButton imgSympathy;
	public ImageButton imgWell;
	private View view;
	private HandleActionBar listener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (HandleActionBar)activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater = LayoutInflater.from(getActivity());

		listener.setActionBar(Constants.choice_menu);

		view = inflater.inflate(R.layout.fragment_dashboard_buyer, container, false);
		imgBday = (ImageButton)view.findViewById(R.id.imgBday);
		imgBecause = (ImageButton)view.findViewById(R.id.imgBecause);
		imgSympathy = (ImageButton)view.findViewById(R.id.imgSympathy);
		imgWell = (ImageButton)view.findViewById(R.id.imgWell);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		imgBday.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialogFragment();
			}
		});
		imgBecause.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialogFragment();
			}
		});
		imgSympathy.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialogFragment();
			}
		});
		imgWell.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialogFragment();
				Log.e("click", "yes");
			}
		});

	}

	private void showDialogFragment() {
		FragmentDialog frag = new FragmentDialog();
		frag.show(getFragmentManager(), getTag());
	}


	@Override
	public void onDestroyView() {
		super.onDestroyView();
		imgBday = null ;
		imgBecause = null;
		imgSympathy = null;
		imgWell = null;
		view = null;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}


}
