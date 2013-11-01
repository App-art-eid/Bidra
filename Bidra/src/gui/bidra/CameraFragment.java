package gui.bidra;

import gui.bidra.R.id;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class CameraFragment extends Fragment {
	
	private static final String TAG = "CAMERAFRAGMENT";
	
	private Camera mCamera;
	private Preview mPreview;
	private int pictureNumber, flashMode, numberOfFlashModes;
	private List<String> flashModes;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mCamera = getCameraInstance();
        mPreview = new Preview(this.getActivity(), mCamera);
        pictureNumber = 0;
        
        Camera.Parameters parameters = mCamera.getParameters();
        flashModes = parameters.getSupportedFlashModes();
        parameters.setFlashMode(flashModes.get(0));
        numberOfFlashModes = flashModes.size() - 1;
        flashMode = 0;
        
        mCamera.setParameters(parameters);
        
        
        

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_camera, container, false);
		
		FrameLayout preview = (FrameLayout) view.findViewById(R.id.camera_preview);
		preview.addView(mPreview);
		
		Button captureButton = (Button) view.findViewById(id.button_capture_photo);
        captureButton.setOnClickListener(new CapturePicture());
        
        Button flashButton = (Button) view.findViewById(id.button_flash);
        flashButton.setOnClickListener(new FlashButton());
		
        return view;
	}
	
	@Override
	public void onPause() {
		super.onPause();
		releaseCamera();
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
    
    private void releaseCamera(){
        if (mCamera != null){
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
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
	
	@SuppressLint("SimpleDateFormat") 
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
	
	protected class FlashButton implements OnClickListener{

		@Override
		public void onClick(View v) {
			changeFlash();
			mCamera.getParameters().setFlashMode(flashModes.get(flashMode));
		}
		
	}
	
	protected class CapturePicture implements OnClickListener{

		@Override
		public void onClick(View v) {
			mCamera.takePicture(null, null, mPicture);
		}
		
	}
	
}
