package com.ith.zinnia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentDialog extends DialogFragment{
	
	BuyerPickupFragment frag;
	FragmentManager fm;
	FragmentTransaction ft;
	

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlertDialog.Builder(getActivity())
		.setMessage(getResources().getString(R.string.text_dialog_choice))
		.setCancelable(true)
		.setPositiveButton(getResources().getString(R.string.text_dialog_pickup), new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(frag == null){
					frag = new BuyerPickupFragment();
				}
				handleFragments(frag);
				}
		})
		
		.setNeutralButton(getResources().getString(R.string.text_dialog_delivery),new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
		
			}
		}).create();
	}
	private void handleFragments(Fragment fragment){

		fm = getActivity().getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.replace(R.id.frame_container, fragment);
		ft.addToBackStack(null);
		ft.commit();
	}
}
