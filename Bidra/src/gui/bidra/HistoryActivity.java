package gui.bidra;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class HistoryActivity extends Activity {

	private static final String TAG="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_history);
		
		

	}
	
	/** 
	 * Called by onClick event
	 * @param view
	 */
	public void changeView(View view){
//		Intent intent = new Intent(getApplicationContext(), PriceActivity.class);
		if(view.getId()==R.id.myViewButton){
			System.out.println("Du trykket for å bytte til fra mine bidrag");
		}
		else if(view.getId()==R.id.kollektivViewButton){
			System.out.println("Du trykket for å bytte til kollektivets bidrag");
		}
		else if(view.getId()==R.id.chronograpicViewButton){
			System.out.println("Du trykket for å sortere på dato");
		}
		else if(view.getId()==R.id.ratingViewButton){
			System.out.println("Du trykket for å sortere etter rating");
		}
	}
	
	private Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection connection = aURL.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
       } catch (IOException e) {
           Log.e(TAG, "Error getting bitmap", e);
       }
       return bm;
    } 
	
}
