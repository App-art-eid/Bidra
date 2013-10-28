package gui.bidra;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

public class Preview extends SurfaceView implements SurfaceHolder.Callback{
	private static final String TAG = "PREVIEW";

	private SurfaceView mSurfaceView;
	private SurfaceHolder mHolder;
	private Camera mCamera;
	
	public Preview(Context context, Camera camera) {
		super(context);
		mCamera = camera;
		
//		mSurfaceView = new SurfaceView(context);
//		addView(mSurfaceView);
		
		mHolder = this.getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
	}
	
	

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		mCamera.setDisplayOrientation(Configuration.ORIENTATION_PORTRAIT);
		//Skjerm skal ikke rotere så ikke noe å gjøre her!
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			mCamera.setDisplayOrientation(Configuration.ORIENTATION_PORTRAIT);
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
		} catch (IOException e) {
		Log.d(TAG, "Error setting camera preview: " + e.getMessage());
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		
	}
	
}
