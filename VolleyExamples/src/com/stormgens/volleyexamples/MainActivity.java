package com.stormgens.volleyexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	Button mBtnSimpleRequest;
	Button mParamsRequest;
	Button mJsonRequest;
	Button mGsonRequest;
	Button mHeaderRequest;
	Button mHeaderParamsRequest;
	Button mImageLoadRequest;
	Button mHttpsRequest;
	Button mListRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSimpleRequest=(Button) findViewById(R.id.simple_request_btn);
        mParamsRequest=(Button) findViewById(R.id.get_post_param_request_btn);
        mJsonRequest=(Button) findViewById(R.id.json_request_btn);
        mGsonRequest=(Button) findViewById(R.id.gson_request_btn);
        mHeaderRequest=(Button) findViewById(R.id.header_request_btn);
        mHeaderParamsRequest=(Button) findViewById(R.id.header_params_request_btn);
        mImageLoadRequest=(Button) findViewById(R.id.image_load_request_btn);
        mHttpsRequest=(Button) findViewById(R.id.https_request_btn);
        mListRequest=(Button) findViewById(R.id.listview_request_btn);
        mBtnSimpleRequest.setOnClickListener(this);
        mParamsRequest.setOnClickListener(this);
        mJsonRequest.setOnClickListener(this);
        mGsonRequest.setOnClickListener(this);
        mHeaderRequest.setOnClickListener(this);
        mHeaderParamsRequest.setOnClickListener(this);
        mImageLoadRequest.setOnClickListener(this);
        mHttpsRequest.setOnClickListener(this);
        mListRequest.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.simple_request_btn:
			startActivity(new Intent(this, SimpleRequestActivity.class));
			break;
		case R.id.get_post_param_request_btn:
			startActivity(new Intent(this,ParamsRequestActivity.class));
			break;
		case R.id.json_request_btn:
			startActivity(new Intent(this, JsonRequestActivity.class));
			break;
		case R.id.gson_request_btn:
			startActivity(new Intent(this, GsonActivity.class));
			break;
		case R.id.header_request_btn:
			startActivity(new Intent(this, HeaderRequestActivity.class));
			break;
		case R.id.header_params_request_btn:
			startActivity(new Intent(this, HeaderParamsRequestActivity.class));
			break;
		case R.id.image_load_request_btn:
			startActivity(new Intent(this, ImageLoadActivity.class));
			break;
		case R.id.https_request_btn:
			startActivity(new Intent(this,HttpsActivity.class));
			break;
		case R.id.listview_request_btn:
			startActivity(new Intent(this,ListRequestActivity.class));
			break;
		default:
			break;
		}
	}
    
}
