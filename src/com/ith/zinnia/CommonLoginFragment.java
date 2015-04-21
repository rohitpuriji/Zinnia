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

public class CommonLoginFragment extends Fragment{

	private View view;
	private HandleActionBar listener;
	private TextView tvLoginTitle;
	private Button buttonFB;
	private TextView tvOr;
	private EditText etEmail;
	private EditText etPassword;
	private Button btnSignIn;
	private TextView tvSignUp;
	private TextView tvForget;
	private BuyerSignUpFragment signUpFrag;
	private ForgetPasswordFragment forgetPasswordFrag;

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
		view = inflater.inflate(R.layout.fragment_common_login, container,false);

		tvLoginTitle = (TextView)view.findViewById(R.id.tvLogin);
		buttonFB = (Button)view.findViewById(R.id.buttonFB);
		tvOr = (TextView)view.findViewById(R.id.tvOr);
		etPassword = (EditText)view.findViewById(R.id.etPassword);
		etEmail = (EditText)view.findViewById(R.id.etEmail);
		btnSignIn = (Button)view.findViewById(R.id.btnSignIn);
		tvSignUp = (TextView)view.findViewById(R.id.tvSignUp);
		tvForget = (TextView)view.findViewById(R.id.tvForget);
		listener.setActionBar(Constants.choice_back);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		tvSignUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(signUpFrag == null){
					signUpFrag = new BuyerSignUpFragment();	
				}
				handleFragments(signUpFrag);
			}
		});
		
		tvForget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(forgetPasswordFrag == null){
					forgetPasswordFrag = new ForgetPasswordFragment();	
				}
				handleFragments(forgetPasswordFrag);
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
		tvLoginTitle = null;
		buttonFB = null;
		tvOr = null;
		etPassword = null;
		etEmail = null;
		btnSignIn = null;
		tvSignUp = null;
		tvForget = null;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}


}
