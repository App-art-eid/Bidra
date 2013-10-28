package gui.bidra;

import gui.bidra.R.id;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

public class CameraActivity extends Activity {
	private static final String TAG = "CAMERA_ACTIVITY";

	
	private Camera mCamera; 
	private Preview mPreview;
	private int pictureNumber, flashMode, numberOfFlashModes;
	private List<String> flashModes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_camera);
        
        mCamera = getCameraInstance();
        mPreview = new Preview(this, mCamera);
        pictureNumber = 0;
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        
        Camera.Parameters parameters = mCamera.getParameters();
        flashModes = parameters.getSupportedFlashModes();
        parameters.setFlashMode(flashModes.get(0));
        numberOfFlashModes = flashModes.size() - 1;
        flashMode = 0;
        
        mCamera.setParameters(parameters);
        
        Button captureButton = (Button) findViewById(id.button_capture_photo);
        captureButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCamera.takePicture(null, null, mPicture);
			}
		});
        
        Button flashButton = (Button) findViewById(id.button_flash);
        flashButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				changeFlash();
				mCamera.getParameters().setFlashMode(flashModes.get(flashMode));
				
			}
		});
        
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	releaseCamera();
    	
    }
    
    private void releaseCamera(){
        if (mCamera != null){
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.camera, menu);
        return true;
    }

    
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
    
    private PictureCallback mPicture = new PictureCallback() {
		
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			
	        File pictureFile = getOutputMediaFile();
	        if (pictureFile == null){
	            Log.d(TAG, "Error creating media file, check storage permissions");
	            return;
	        }
	        try {
	            FileOutputStream fos = new FileOutputStream(pictureFile);
	            fos.write(data);
	            fos.close();
	            pictureNumber++;
	        } catch (FileNotFoundException e) {
	            Log.d(TAG, "File not found: " + e.getMessage());
	        } catch (IOException e) {
	            Log.d(TAG, "Error accessing file: " + e.getMessage());
	        }
	    }
	};
	
	private File getOutputMediaFile(){
	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "Bidra");
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("MyCameraApp", "failed to create directory");
	            return null;
	        }
	    }

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + pictureNumber + ".jpg");
	    return mediaFile;
	}
	
	private void changeFlash(){
		if (flashMode == numberOfFlashModes) {
			flashMode = 0;
		} else {
			flashMode++;
		}
	}
	
}
