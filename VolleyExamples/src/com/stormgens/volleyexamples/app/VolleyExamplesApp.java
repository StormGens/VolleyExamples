package com.stormgens.volleyexamples.app;

import android.app.Application;

public class VolleyExamplesApp extends Application {
	@Override
	public void onCreate() {
		init();
		super.onCreate();
	}
	
	private void init() {
		MyVolley.init(this);
	}

}
