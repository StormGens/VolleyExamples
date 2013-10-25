package com.stormgens.volleyexamples;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.stormgens.volleyexamples.app.MyVolley;
import com.stormgens.volleyexamples.toolbox.VolleyErrorHelper;

public class ParamsRequestActivity extends Activity implements OnClickListener {
	EditText mEtParam1;
	EditText mEtParam2;

	TextView mTvResult;

	Button mBtnGetRequest;
	Button mBtnPostRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_params_request);
		mTvResult = (TextView) findViewById(R.id.request_result);
		mEtParam1 = (EditText) findViewById(R.id.param1_et);
		mEtParam2 = (EditText) findViewById(R.id.param2_et);
		mBtnGetRequest = (Button) findViewById(R.id.request_get_btn);
		mBtnPostRequest = (Button) findViewById(R.id.request_post_btn);
		mBtnGetRequest.setOnClickListener(this);
		mBtnPostRequest.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.params_request, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.request_get_btn:
			final String num_1 = mEtParam1.getText().toString();
			final String num_2 = mEtParam2.getText().toString();
			if (!TextUtils.isEmpty(num_1) && !TextUtils.isEmpty(num_2)) {
				String uri = String
						.format("http://ave.bolyartech.com/params.php?param1=%1$s&param2=%2$s",
								num_1, num_2);
				StringRequest mQueue = new StringRequest(Method.GET, uri,
						createSuccessListener(), createErrorListener());
				MyVolley.addtoRequestQueue(mQueue);
			}
			break;
		case R.id.request_post_btn:
			final String num1 = mEtParam1.getText().toString();
			final String num2 = mEtParam2.getText().toString();
			if (!TextUtils.isEmpty(num1) && !TextUtils.isEmpty(num2)) {
				StringRequest mRequest = new StringRequest(Method.POST,
						"http://ave.bolyartech.com/params.php",
						createSuccessListener(), createErrorListener()) {
					@Override
					protected Map<String, String> getParams()
							throws AuthFailureError {
						Map<String, String> params = new HashMap<String, String>();
						params.put("param1", num1);
						params.put("param2", num2);
						return params;
					}
				};
				MyVolley.addtoRequestQueue(mRequest);
			} else {
				Toast.makeText(this, "ÃÓ∫√‘Ÿ∏„¬Ô", Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
	}

	private ErrorListener createErrorListener() {
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				mTvResult.setText(VolleyErrorHelper.getMessage(error, ParamsRequestActivity.this));
			}
		};
	}

	private Listener<String> createSuccessListener() {
		return new Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				Log.v("Volley", response);
				mTvResult.setText(response);
			}
		};
	}

}
