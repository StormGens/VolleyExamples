package com.stormgens.volleyexamples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.stormgens.volleyexamples.app.MyVolley;
import com.stormgens.volleyexamples.misc.MyClass;
import com.stormgens.volleyexamples.misc.MyClass2;
import com.stormgens.volleyexamples.toolbox.GsonRequest;
import com.stormgens.volleyexamples.toolbox.JsonRequest;

public class GsonActivity extends Activity implements OnClickListener {
	Button mBtnGsonRequest;
	Button mBtnFastJsonRequest;
	TextView mTvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gson);
		mBtnGsonRequest=(Button) findViewById(R.id.request_btn);
		mBtnFastJsonRequest=(Button) findViewById(R.id.request_btn2);
		mTvResult=(TextView) findViewById(R.id.request_result);
		mBtnGsonRequest.setOnClickListener(this);
		mBtnFastJsonRequest.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gson, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.request_btn:
			GsonRequest<MyClass> mReqest = new GsonRequest<MyClass>(Method.GET,
					"http://validate.jsontest.com/?json={'key':'value'}",
					MyClass.class, createSuccessListener(), createErrorListener());
			MyVolley.getRequestQueue().add(mReqest);
			break;
		case R.id.request_btn2:
			JsonRequest<MyClass2> mReqest2 = new JsonRequest<MyClass2>(Method.GET,
					"http://validate.jsontest.com/?json={'key':'value'}",
					MyClass2.class, createSuccessListener2(), createErrorListener());
			MyVolley.getRequestQueue().add(mReqest2);
			break;

		default:
			break;
		}
		
	}

	private Listener<MyClass2> createSuccessListener2() {
		return new Listener<MyClass2>() {

			@Override
			public void onResponse(MyClass2 response) {
				// TODO Auto-generated method stub
				mTvResult.setText(""+response.getParse_time_nanoseconds());
			}
		};
	}

	private Response.Listener<MyClass> createSuccessListener() {
		// TODO Auto-generated method stub
		return new Listener<MyClass>() {

			@Override
			public void onResponse(MyClass response) {
				// TODO Auto-generated method stub
				mTvResult.setText(""+response.getNanoseconds());
			}
		};
	}

	private Response.ErrorListener createErrorListener() {
		// TODO Auto-generated method stub
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				mTvResult.setText(error.getMessage());
			}
		};
	}

}
