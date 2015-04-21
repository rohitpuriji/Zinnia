package com.ith.zinnia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ith.adapters.FlowerPagerAdapter;
import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class BuyerChooseFlowerFragment extends Fragment{

	private View view;
	private HandleActionBar listener;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private ViewPager pager;
	private TextView tvBlisful;
	private TextView tvBlissfulPrice;
	private Button btnIndicator1;
	private Button btnIndicator2;
	private Button btnIndicator3;
	private Button btnSendThatFlower;
	private FlowerPagerAdapter pageAdapter;
	private BuyerWriteNoteFragment noteFrag;

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
		view = inflater.inflate(R.layout.fragment_choose_flower_buyer, container,false);

		pager = (ViewPager)view.findViewById(R.id.viewpager);
		btnIndicator1 = (Button)view.findViewById(R.id.btnIndicator1);
		btnIndicator2 = (Button)view.findViewById(R.id.btnIndicator2);
		btnIndicator3 = (Button)view.findViewById(R.id.btnIndicator3);
		btnSendThatFlower = (Button)view.findViewById(R.id.btnSendThatFlower);
		listener.setActionBar(Constants.choice_back);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		pageAdapter = new FlowerPagerAdapter(getActivity().getSupportFragmentManager());
		pager.setAdapter(pageAdapter);

		btnIndicator1.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_selected));
		btnIndicator2.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));
		btnIndicator3.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));

		btnSendThatFlower.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(noteFrag == null){
					noteFrag = new BuyerWriteNoteFragment();
				}
				handleFragments(noteFrag);
			}
		});

		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				if(arg0 == 0){
					btnIndicator1.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_selected));
					btnIndicator2.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));
					btnIndicator3.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));

				}
				else if (arg0 == 1) {
					btnIndicator1.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));
					btnIndicator2.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_selected));
					btnIndicator3.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));

				}
				else{
					btnIndicator1.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));
					btnIndicator2.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_unselected));
					btnIndicator3.setBackground(getResources().getDrawable(R.drawable.custom_circle_choose_flower_indicator_selected));

				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

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
		pager = null;
		btnIndicator1 = null;
		btnIndicator2 = null;
		btnIndicator3 = null;
		btnSendThatFlower = null;

	}

	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}
}
