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


/**Volleyʹ�õķ�װ�࣬��Application�е���init()��ʼ����
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
	/** ��ʼ��
	 * @param context ������
	 */
	static void init(Context context){
		mRequestQueue=Volley.newRequestQueue(context);
		
		int memClass=((ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		int cacheSize=memClass*1024*1024/8; //ʹ�����ڴ��1/8
		mImageLoader=new ImageLoader(mRequestQueue,new BitmapLruCache(cacheSize));
	}
	
	/**���ͼƬ������
	 * @return
	 */
	public static ImageLoader getImageLoader(){
		if (mImageLoader!=null) {
			return mImageLoader;
		}else{
			throw new IllegalStateException("ImageLoader not initialized");
		}
	}
	
	/**���Volley���������
	 * @return
	 */
	public static RequestQueue getRequestQueue(){
		if (mRequestQueue!=null) {
			return mRequestQueue;
		}else{
			throw new IllegalStateException("ImageLoader not initialized");
		}
	}
	
	/**��������������������ʹ�ò���tagΪ��ǩ
	 * @param req Ҫ�ӽ�ȥ������
	 * @param tag ��ǩ
	 */
	public static <T> void addtoRequestQueue(Request<T> req,String tag){
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        VolleyLog.d("Adding request to queue: %s", req.getUrl());
        getRequestQueue().add(req);
	}
	
	/** ��������������������ʹ��Ĭ�ϱ�ǩ
	 * @param req Ҫ�ӽ�ȥ������
	 */
	public static <T> void addtoRequestQueue(Request<T> req){
		req.setTag(TAG);
		getRequestQueue().add(req);
	}
	
	/** ȡ��RequestQueue�������б�ǩΪtag������
	 * @param tag ��Ҫȡ������Щ����ı�ǩ
	 */
	public void cancelPendingRequests(Object tag) {  
		if (mRequestQueue!=null) {
			mRequestQueue.cancelAll(tag);
		}
	}
	
	

}
