package com.stormgens.volleyexamples.toolbox;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

public class MyRequest extends StringRequest {
	public MyRequest(int method, String url, Listener<String> listener,
			ErrorListener errorListener) {
		super(method, url, listener, errorListener);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		Map<String, String> map=new HashMap<String, String>();
		map.put("from", "android");
		map.put("app_name", "new_broker");
		return map;
	}
	
	@Override
	public RetryPolicy getRetryPolicy() {
		RetryPolicy mRetryPolicy=new DefaultRetryPolicy(20*10,1,1.0f); //TODO 这里第三个参数“网络退避”是什么啊？
		
		return mRetryPolicy;
	}
	
}
