package com.stormgens.volleyexamples.app;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.stormgens.volleyexamples.toolbox.BitmapLruCache;


/**Volley使用的封装类，在Application中调用init()初始化。
 * @author zlq
 *
 */
public class MyVolley{
	private final static String TAG="MyVolley";
    private static RequestQueue mRequestQueue;
    private static ImageLoader mImageLoader;
	
	private MyVolley() {
		// TODO Auto-generated constructor stub
	}
	/** 初始化
	 * @param context 上下文
	 */
	static void init(Context context){
		mRequestQueue=Volley.newRequestQueue(context);
		
		int memClass=((ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		int cacheSize=memClass*1024*1024/8; //使用总内存的1/8
		mImageLoader=new ImageLoader(mRequestQueue,new BitmapLruCache(cacheSize));
	}
	
	/**获得图片加载器
	 * @return
	 */
	public static ImageLoader getImageLoader(){
		if (mImageLoader!=null) {
			return mImageLoader;
		}else{
			throw new IllegalStateException("ImageLoader not initialized");
		}
	}
	
	/**获得Volley的请求队列
	 * @return
	 */
	public static RequestQueue getRequestQueue(){
		if (mRequestQueue!=null) {
			return mRequestQueue;
		}else{
			throw new IllegalStateException("ImageLoader not initialized");
		}
	}
	
	/**往请求队列里面添加请求，使用参数tag为标签
	 * @param req 要加进去的请求
	 * @param tag 标签
	 */
	public static <T> void addtoRequestQueue(Request<T> req,String tag){
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        VolleyLog.d("Adding request to queue: %s", req.getUrl());
        getRequestQueue().add(req);
	}
	
	/** 往请求队列里面添加请求，使用默认标签
	 * @param req 要加进去的请求
	 */
	public static <T> void addtoRequestQueue(Request<T> req){
		req.setTag(TAG);
		getRequestQueue().add(req);
	}
	
	/** 取消RequestQueue里面所有标签为tag的请求
	 * @param tag 需要取消掉哪些请求的标签
	 */
	public void cancelPendingRequests(Object tag) {  
		if (mRequestQueue!=null) {
			mRequestQueue.cancelAll(tag);
		}
	}
	
	

}
