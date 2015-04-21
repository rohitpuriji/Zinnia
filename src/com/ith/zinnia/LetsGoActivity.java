package com.ith.zinnia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LetsGoActivity extends Activity {

	private Intent intent ;
	private Button btnLetsGo;
	private int timeOut=2000;
	private Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_lets_go);
		
		btnLetsGo = (Button)findViewById(R.id.btnLetsGo);
		
		 handler = new Handler();
		    handler.postDelayed(new Runnable() {
				public void run() {
				btnLetsGo.setVisibility(View.VISIBLE);
				}

			}, timeOut);
		    
		btnLetsGo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				intent = new Intent(LetsGoActivity.this, DashboardFragmentActivity.class);
				startActivity(intent);
				finish();	
			    overridePendingTransition(0, 0);

			}
		});
	}

}
