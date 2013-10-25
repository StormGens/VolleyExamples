package com.stormgens.volleyexamples;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.stormgens.volleyexamples.app.MyVolley;
import com.stormgens.volleyexamples.toolbox.MyRequest;

public class HeaderParamsRequestActivity extends Activity implements OnClickListener {
	Button mRequestBtn;
	Button mRequestBtn2;
	TextView mResultTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_header_params);
		mResultTv=(TextView) findViewById(R.id.request_result);
		mRequestBtn=(Button) findViewById(R.id.request_btn);
		mRequestBtn2=(Button) findViewById(R.id.request_params_btn);
		mRequestBtn.setOnClickListener(this);
		mRequestBtn2.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.header_params, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.request_btn:
			MyRequest mRequest=new MyRequest(Method.GET, "http://headers.jsontest.com/", createSucessListener(), createErrorListener());
			MyVolley.getRequestQueue().add(mRequest);
			break;
		case R.id.request_params_btn:
			MyRequest mRequest2=new MyRequest(Method.POST, "http://ave.bolyartech.com/params.php", createSucessListener(), createErrorListener()){
				@Override
				protected Map<String, String> getParams()
						throws AuthFailureError {
					Map<String, String> map=new HashMap<String, String>();
					map.put("param1", "1");
					map.put("param2", "2");
					
					return map;
				}
			};
			MyVolley.getRequestQueue().add(mRequest2);
			break;
		default:
			break;
		}
	}

	private ErrorListener createErrorListener() {
		// TODO Auto-generated method stub
		return new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				mResultTv.setText(error.getMessage());
			}
		};
	}

	private Listener<String> createSucessListener() {
		return new Listener<String>() {

			@Override
			public void onResponse(String response) {
				mResultTv.setText(response);
			}
		};
	}

}
