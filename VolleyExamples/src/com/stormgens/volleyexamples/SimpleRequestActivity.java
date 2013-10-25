package com.stormgens.volleyexamples;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.stormgens.volleyexamples.app.MyVolley;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SimpleRequestActivity extends Activity implements OnClickListener{
	Button mBtnRequest;
	TextView mTvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_request);
		mTvResult=(TextView) findViewById(R.id.request_result);
		mBtnRequest=(Button) findViewById(R.id.request_btn);
		mBtnRequest.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_request, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		RequestQueue queue=MyVolley.getRequestQueue();
		StringRequest request=new StringRequest("http://www.baidu.com", createSucessListener(), createErrorListener());
		queue.add(request);
	}
	
	private Response.Listener<String> createSucessListener(){
		return new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				mTvResult.setText(response);
				
			}
		};
	}
	
	private Response.ErrorListener createErrorListener(){
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				mTvResult.setText(error.getMessage());
			}
		};
	}

}
