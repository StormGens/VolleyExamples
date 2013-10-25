package com.stormgens.volleyexamples;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
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

public class HeaderRequestActivity extends Activity implements OnClickListener {
	
	Button mRequestBtn;
	TextView mResultTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_header_request);
		mResultTv=(TextView) findViewById(R.id.request_result);
		mRequestBtn=(Button) findViewById(R.id.request_btn);
		mRequestBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.header_request, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		StringRequest mRequest = new StringRequest(Method.GET,
				"http://headers.jsontest.com/", createSuccessListener(),
				createErrorListener()){
			@Override
			public Map<String, String> getHeaders()
					throws AuthFailureError {
				Map<String, String> headers=new HashMap<String, String>();
				headers.put("from", "Android");
				return headers;
			}
		};
		MyVolley.getRequestQueue().add(mRequest);
	}

	private ErrorListener createErrorListener() {
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				mResultTv.setText(error.getMessage());
			}
		};
	}

	private Listener<String> createSuccessListener() {
		return new Listener<String>() {

			@Override
			public void onResponse(String response) {
				mResultTv.setText(response);
			}
		};
	}

}
