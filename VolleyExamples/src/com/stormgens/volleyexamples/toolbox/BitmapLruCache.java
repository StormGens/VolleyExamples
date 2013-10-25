package com.stormgens.volleyexamples.toolbox;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;
//TODO 这个图片缓存类还不足以满足我们的需求，后期我们可以扩展此类来优化。
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
