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
import android.widget.EditText;
import android.widget.TextView;

import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class BuyerPickupFragment extends Fragment{

	private View view;
	private HandleActionBar listener;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private TextView textPickup;
	private TextView textWho;
	private TextView textWhen;
	private TextView textDateDD;
	private TextView tvDateMM;
	private TextView tvDate2;
	private TextView textTime;
	private TextView tvTime;
	private EditText etName;
	private Button btnNext;
	private BuyerMapAndListFragment listFrag;


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
		view = inflater.inflate(R.layout.fragment_pickup_buyer, container,false);
		tvTime = (TextView)view.findViewById(R.id.tvTime);
		btnNext = (Button)view.findViewById(R.id.btnNext);
		listener.setActionBar(Constants.choice_back);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tvTime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(tvTime.getText().toString().equals(getResources().getString(R.string.text_time1))){
					tvTime.setText(getResources().getString(R.string.text_time2));
				}
				else{
					tvTime.setText(getResources().getString(R.string.text_time1));
				}
			}
		});

		btnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(listFrag == null){
					listFrag = new BuyerMapAndListFragment();
				}
				handleFragments(listFrag);
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

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}


	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

}
