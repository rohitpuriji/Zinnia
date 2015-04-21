
package com.ith.adapters;

import java.util.ArrayList;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ith.zinnia.BuyerChooseCustomFlowerFragment;
import com.ith.zinnia.BuyerChooseFlowerImage1;
import com.ith.zinnia.BuyerChooseFlowerImage2;

public class FlowerPagerAdapter extends FragmentPagerAdapter{

	private ArrayList<Fragment> pagerItems;

	
	public FlowerPagerAdapter(FragmentManager fm) {
		super(fm);
		pagerItems = new ArrayList<Fragment>();
		pagerItems.add(BuyerChooseFlowerImage1.getInstance());
		pagerItems.add(BuyerChooseFlowerImage2.getInstance());
		pagerItems.add(BuyerChooseCustomFlowerFragment.getInstance());
		
	}


	@Override
	public Fragment getItem(int num) {
		 if (num == 0) {
             return new BuyerChooseFlowerImage1();
         }
		 else if(num == 1) {
             return new BuyerChooseFlowerImage2();
         }
         else{
             return new BuyerChooseCustomFlowerFragment();
         }
	}
	@Override
	public int getCount() {
		return pagerItems.size();
	}
		
	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
	    //super.restoreState(state, loader);
	}
}
