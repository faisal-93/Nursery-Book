package com.androidcave.nurserybook;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainApp extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.container_fragment);
		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.container_framelayout, new MainAppContainerFragment())
				.commit();
	}

	@Override
	public void onBackPressed() {
		if (((BaseContainerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.container_framelayout)).isBack()) {
			finish();
		} else {
			((BaseContainerFragment) getSupportFragmentManager()
					.findFragmentById(R.id.container_framelayout))
					.popFragment();
		}
	}
}
