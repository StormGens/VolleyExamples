package com.stormgens.volleyexamples.toolbox;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;
//TODO ���ͼƬ�����໹�������������ǵ����󣬺������ǿ�����չ�������Ż���
public class BitmapLruCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache{
	

	public BitmapLruCache(int maxSize) {
		super(maxSize);
	}
	

	@Override
	public Bitmap getBitmap(String url) {
		return get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		put(url, bitmap);
	}

}
