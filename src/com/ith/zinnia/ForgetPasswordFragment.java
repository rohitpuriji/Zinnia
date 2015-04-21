package com.ith.zinnia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class ForgetPasswordFragment extends Fragment{

	private View view;
	private HandleActionBar listener;
	private TextView textForget;
	private Button btnSubmit;
	private EditText etEmail;


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
		view = inflater.inflate(R.layout.fragment_password_forget, container,false);

		textForget = (TextView)view.findViewById(R.id.textForget);
		btnSubmit = (Button)view.findViewById(R.id.btnSubmit);
		etEmail = (EditText)view.findViewById(R.id.etEmail);
		listener.setActionBar(Constants.choice_back);

		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		
		textForget = null;
		btnSubmit = null;
		etEmail = null;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

}

