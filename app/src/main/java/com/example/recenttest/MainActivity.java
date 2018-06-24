package com.example.recenttest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends Activity {
	
	public static int mImageBtnId[] =
	{
		R.id.btn_0,
		R.id.btn_1,
		R.id.btn_2,
		R.id.btn_3,
		R.id.btn_4,
		R.id.btn_5,
		R.id.btn_6,
		R.id.btn_7,
		R.id.btn_8,
		R.id.btn_9,
	};
	
	public static int mRecentViewId[] =
	{
		R.id.recent_0,
		R.id.recent_1,
		R.id.recent_2,
		R.id.recent_3,
		R.id.recent_4,
	};
	
	public static int mImageBtnRes[] =
	{
		R.drawable.image_0,
		R.drawable.image_1,
		R.drawable.image_2,
		R.drawable.image_3,
		R.drawable.image_4,
		R.drawable.image_5,
		R.drawable.image_6,
		R.drawable.image_7,
		R.drawable.image_8,
		R.drawable.image_9,
	};
	
	private ImageButton mImageBtn[];
	private ImageView mRecentView[];
	private RecentImageManager mRecentImageManager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mRecentImageManager = new RecentImageManager();
        
        initRecentView();
        initImageBtn();
    }

    private void initRecentView() {
    	mRecentView = new ImageView[mRecentViewId.length];
    	
    	for( int index = 0; index < mRecentView.length; index++ ) {
    		mRecentView[index] = (ImageView) findViewById(mRecentViewId[index]);
    	}
    }
    
    private void initImageBtn() {    	
    	mImageBtn = new ImageButton[mImageBtnId.length];
    	
    	for( int index = 0; index < mImageBtn.length; index++ ) {
    		mImageBtn[index] = (ImageButton) findViewById(mImageBtnId[index]);
    		final int btnIndex = index;
    		
    		mImageBtn[index].setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {					
					Bitmap bitmap = mRecentImageManager.getBitmap(mImageBtnId[btnIndex]);
					
					if( bitmap == null ) {
						BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(mImageBtnRes[btnIndex]);
						bitmap = drawable.getBitmap();
	
						mRecentImageManager.setBitmap(mImageBtnId[btnIndex], bitmap);
					}
					updateImageView();
				}
			});
    	}
    }
    
    private void updateImageView() {
    	for( int index = 0; index < mRecentImageManager.getCount(); index++ ) {
   			mRecentView[index].setImageBitmap(mRecentImageManager.getBitmapForIndex(index));
    	}    	
    }

}
