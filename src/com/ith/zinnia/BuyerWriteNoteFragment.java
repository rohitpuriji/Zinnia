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

public class BuyerWriteNoteFragment extends Fragment{

	private View view;
	private HandleActionBar listener;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private Button btnNext;
	private BuyerCheckOutFragment frag;


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		listener = (HandleActionBar)activity;
	}

//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		listener.setActionBar(Constants.choice_back);
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater = LayoutInflater.from(getActivity());
		view = inflater.inflate(R.layout.fragment_write_note_buyer, container,false);
		btnNext = (Button)view.findViewById(R.id.btnNext);
		listener.setActionBar(Constants.choice_back);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		btnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(frag == null){
					frag = new BuyerCheckOutFragment();
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


}
