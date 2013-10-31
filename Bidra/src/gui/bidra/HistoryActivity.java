package gui.bidra;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HistoryActivity extends Activity {

	private static final String TAG="";
	private ProgressBar pb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_history);
		
		pb = (ProgressBar)findViewById(R.id.progressbar);
		pb.setProgress(60);
		
		Drawable customDrawable = getResources().getDrawable(R.layout.custom_progressbar);
		pb.setProgressDrawable(customDrawable);
		

		
		//http://www.learnandroideasily.blogspot.in/2013/05/custom-progress-bar-in-android.html
		
	}
	
	/** 
	 * Called by onClick event
	 * @param view
	 */
	public void changeView(View view){
//		Intent intent = new Intent(getApplicationContext(), PriceActivity.class);
		int source = view.getId();
		
		switch (source) {
		case R.id.myViewButton:
			System.out.println("Du trykket for å bytte til mine bidrag");
			break;
		case R.id.kollektivViewButton:
			System.out.println("Du trykket for å bytte til kollektivets bidrag");
			break;
			
		case R.id.chronograpicViewButton:
			System.out.println("Du trykket for å sortere på dato");
			break;
			
		case R.id.ratingViewButton:
			System.out.println("Du trykket for å sortere etter rating");
			break;
			
		case R.id.priceViewButton:
			System.out.println("Du trykket for å gå til premieoversikten");
			break;
		case R.id.progressbar:
			System.out.println("Du trykket for å gå tilbake via progressbaren");
			break;

		default:
			break;
		}
		
	}
	

}
