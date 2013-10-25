package com.stormgens.volleyexamples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.stormgens.volleyexamples.app.MyVolley;

public class ImageLoadActivity extends Activity implements OnClickListener {
	Button mRequestBtn;
	Button mRequestErrorBtn;
	ImageView mIv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_load);
		mRequestBtn = (Button) findViewById(R.id.request_btn);
		mRequestErrorBtn = (Button) findViewById(R.id.request_error_btn);
		mIv=(ImageView) findViewById(R.id.image_iv);
		mRequestBtn.setOnClickListener(this);
		mRequestErrorBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_load, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.request_btn:
			ImageLoader mImageLoader = MyVolley.getImageLoader();
			mImageLoader
					.get("http://www.blogcdn.com/cn.engadget.com/media/2013/09/android-kit-kat.jpg",
							ImageLoader
									.getImageListener(mIv, R.drawable.no_image,
											R.drawable.error_image));
			break;
		case R.id.request_error_btn:
			ImageLoader mImageLoader2=MyVolley.getImageLoader();
			mImageLoader2
			.get("http://www.blogcdn.com/cn.engadget.com/media/2013/09/android-kit-katt.jpg",
					ImageLoader
							.getImageListener(mIv, R.drawable.no_image,
									R.drawable.error_image));
			break;
		default:
			break;
		}

	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	
}
