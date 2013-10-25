package com.stormgens.volleyexamples;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.stormgens.volleyexamples.app.MyVolley;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class JsonRequestActivity extends Activity implements OnClickListener {
	Button mBtnRequest;
	TextView mTvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json_request);
		mBtnRequest = (Button) findViewById(R.id.request_btn);
		mTvResult=(TextView) findViewById(R.id.request_result);
		mBtnRequest.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.json_request, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		JsonObjectRequest mRequest = new JsonObjectRequest(Method.GET,
				"http://echo.jsontest.com/key/value/one/two", null,
				createMyReqSuccessListener(), createMyReqErrorListener());
		MyVolley.getRequestQueue().add(mRequest);
	}

	private ErrorListener createMyReqErrorListener() {
		// TODO Auto-generated method stub
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	private Listener<JSONObject> createMyReqSuccessListener() {
		return new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
				try {
					mTvResult.setText(response.getString("one"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
}
