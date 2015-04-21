package com.ith.zinnia;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ith.extra.Constants;
import com.ith.extra.HandleActionBar;

public class DashboardFragmentActivity extends FragmentActivity implements HandleActionBar{

	private View actionView;
	private LayoutInflater inflate;

	private ImageButton imageButton;
	private ImageButton imageBack;
	private ImageButton imageHome;

	private DrawerLayout mDrawerLayout;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BuyerDashboardFragment frag; 
	private CommonLoginFragment fragLogin;

	private RelativeLayout relative_slidermenu;
	private ImageView imgTitle;
	private RelativeLayout relativeSignIn2;
	private TextView tvLogin;
	private RelativeLayout relativeFlorist2;
	private TextView tvFlorist;
	private RelativeLayout relativeAboutZinnia;
	private ImageView imgUser;
	private TextView tvUsername;
	private TextView tvAbout;
	private HandleActionBar listener;
	private FrameLayout frame_container;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard_fragment);

		listener = (HandleActionBar)this;
		listener.setActionBar(Constants.choice_menu);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		relativeSignIn2 = (RelativeLayout)findViewById(R.id.relativeSignIn2);
		relativeFlorist2 = (RelativeLayout)findViewById(R.id.relativeFlorist2);
		relativeAboutZinnia = (RelativeLayout)findViewById(R.id.relativeAboutZinnia);
		tvLogin = (TextView)findViewById(R.id.tvLogin);
		tvFlorist = (TextView)findViewById(R.id.tvFlorist);
		tvUsername = (TextView)findViewById(R.id.tvUsername);
		tvAbout = (TextView)findViewById(R.id.tvAbout);
		relative_slidermenu = (RelativeLayout)findViewById(R.id.relative_slidermenu);
		frame_container = (FrameLayout)findViewById(R.id.frame_container);

		mDrawerLayout.setDrawerListener(new DrawerListener() {

			@Override
			public void onDrawerStateChanged(int arg0) {

			}

			@Override
			public void onDrawerSlide(View arg0, float arg1) {

			}

			@Override
			public void onDrawerOpened(View arg0) {
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				params.addRule(RelativeLayout.CENTER_VERTICAL);
				params.setMargins(20,0,0,0);
				imageButton.setLayoutParams(params);

				if(frag.isVisible()){

					frag.imgBday.setClickable(false);
					frag.imgBecause.setClickable(false);
					frag.imgSympathy.setClickable(false);
					frag.imgWell.setClickable(false);

				}
			}

			@Override
			public void onDrawerClosed(View arg0) {
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				params.addRule(RelativeLayout.CENTER_VERTICAL);
				params.setMargins(0,0,20,0);
				imageButton.setLayoutParams(params);
				if(frag.isVisible()){
					frag.imgBday.setClickable(true);
					frag.imgBecause.setClickable(true);
					frag.imgSympathy.setClickable(true);
					frag.imgWell.setClickable(true);
				}
			}
		});

		relativeSignIn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(fragLogin == null){
					fragLogin = new CommonLoginFragment();	
				}
				handleFragments(fragLogin);
				mDrawerLayout.closeDrawer(Gravity.END);

			}
		});


		if(frag == null){
			frag = new BuyerDashboardFragment();		
		}
		setDefaultFragments(frag);

	}

	private void setDefaultFragments(Fragment fragment){

		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.add(R.id.frame_container, fragment);
		ft.commit();
	}

	private void handleFragments(Fragment fragment){

		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.replace(R.id.frame_container, fragment);
		ft.addToBackStack(null);
		ft.commit();

	}

	@Override
	public void onBackPressed() {
		int count = getSupportFragmentManager().getBackStackEntryCount();
		Fragment frag = getSupportFragmentManager().findFragmentByTag("thanks");
		
		if(count == 0){
			super.onBackPressed();
		}
		else if(frag instanceof BuyerThanksFragment){
			getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

		}
		else if(count > 0){
			getSupportFragmentManager().popBackStack();
		}
		
		

	}

	@Override
	public void setActionBar(String choice) {

		inflate = LayoutInflater.from(this);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		relative_slidermenu = (RelativeLayout)findViewById(R.id.relative_slidermenu);

		ActionBar mActionBar=getActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);    
		mActionBar.setDisplayUseLogoEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowCustomEnabled(true);
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 

		ActionBar.LayoutParams params = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT,
				Gravity.CENTER);

		if(choice.equals(Constants.choice_menu)){
			actionView = inflate.inflate(R.layout.custom_actionbar_with_menu, null,false);
			mActionBar.setCustomView(actionView, params);

			imageButton = (ImageButton)actionView.findViewById(R.id.imageButton);
			imgTitle = (ImageView)actionView.findViewById(R.id.imgTitle);

			mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, relative_slidermenu);

			imageButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if(mDrawerLayout.isDrawerOpen(Gravity.END)){
						mDrawerLayout.closeDrawer(Gravity.END);
					}
					else{
						mDrawerLayout.openDrawer(Gravity.END);
					}
				}
			});
		}
		else if(choice.equals(Constants.choice_back)){
			actionView = inflate.inflate(R.layout.custom_actionbar_with_back, null,false);
			mActionBar.setCustomView(actionView, params);

			imageBack = (ImageButton)actionView.findViewById(R.id.imageBack);
			imgTitle = (ImageView)actionView.findViewById(R.id.imgTitle);
			mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, relative_slidermenu);

			imageBack.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					getSupportFragmentManager().popBackStack();
				}
			});
		}
		else if(choice.equals(Constants.choice_home)){
			actionView = inflate.inflate(R.layout.custom_actionbar_with_home, null,false);
			mActionBar.setCustomView(actionView, params);
			imageHome = (ImageButton)actionView.findViewById(R.id.imageHome);
			imgTitle = (ImageView)actionView.findViewById(R.id.imgTitle);
			mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, relative_slidermenu);

			imageHome.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				}
			});
		}
		else if(choice.equals(Constants.choice_back_home)){
			actionView = inflate.inflate(R.layout.custom_actionbar_with_back_home, null,false);
			mActionBar.setCustomView(actionView, params);
			mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, relative_slidermenu);

			imageHome = (ImageButton)actionView.findViewById(R.id.imageHome);
			imageBack = (ImageButton)actionView.findViewById(R.id.imageBack);
			imgTitle = (ImageView)actionView.findViewById(R.id.imgTitle);

			imageBack.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					getSupportFragmentManager().popBackStack();
				}
			});
			imageHome.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					NavUtils.navigateUpFromSameTask(DashboardFragmentActivity.this);
				}
			});

		}
	}
}
