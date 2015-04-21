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

public class BuyerSignUpFragment extends Fragment{

	private View view;
	private HandleActionBar listener;

	private Button buttonFB;
	private Button btnSignUp;

	private EditText etEmail;
	private EditText etPassword;
	private EditText etFirstName;
	private EditText etLastName;


	private TextView tvAlreadySignIn;
	private TextView tvOr;
	private TextView textSignUp;

	private CommonLoginFragment fragLogin;
	private FragmentManager fm;
	private FragmentTransaction ft;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		listener = (HandleActionBar)activity;
	}
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		listener.setActionBar(Constants.choice_back);
//	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		inflater = LayoutInflater.from(getActivity());
		view = inflater.inflate(R.layout.fragment_signup_buyer, container,false);

		textSignUp = (TextView)view.findViewById(R.id.textSignUp);
		buttonFB = (Button)view.findViewById(R.id.buttonFB);
		tvOr = (TextView)view.findViewById(R.id.tvOr);
		etPassword = (EditText)view.findViewById(R.id.etPassword);
		etEmail = (EditText)view.findViewById(R.id.etEmail);
		etFirstName = (EditText)view.findViewById(R.id.etFirstName);
		etLastName = (EditText)view.findViewById(R.id.etLastName);

		btnSignUp = (Button)view.findViewById(R.id.btnSignUp);
		tvAlreadySignIn = (TextView)view.findViewById(R.id.tvAlreadySignIn);
		listener.setActionBar(Constants.choice_back);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		tvAlreadySignIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				getActivity().getSupportFragmentManager().popBackStack();
			}
		});		
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		
		textSignUp  = null;
		buttonFB  = null;
		tvOr  = null;
		etPassword  = null;
		etEmail  = null;
		etFirstName  = null;
		etLastName  = null;
		btnSignUp  = null;
		tvAlreadySignIn  = null; 
		
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

}
