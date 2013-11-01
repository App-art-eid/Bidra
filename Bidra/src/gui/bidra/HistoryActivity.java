package gui.bidra;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class HistoryActivity extends Activity {

//	private static final String TAG="";
	private ProgressBar pb;
	private int progressBarProgress;
	private Handler progressBarHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_history);
		
		//http://www.learnandroideasily.blogspot.in/2013/05/custom-progress-bar-in-android.html
		pb = (ProgressBar)findViewById(R.id.progressbar);		
		Drawable customDrawable = getResources().getDrawable(R.layout.custom_progressbar);
		pb.setProgressDrawable(customDrawable);
		
		
		//reset progress bar status
		progressBarProgress = 1;

		//TODO finne et bra sted å ha denne koden
        new Thread(new Runnable() {
	        public void run() {
	        	System.out.println("1");
	               while (progressBarProgress < 100) {
	            	   progressBarProgress = progressStatus();
	            	   System.out.println("2");
	
	      //  sleep 1 second to show the progress
	      try {
	              Thread.sleep(1000);
	              System.out.println("3");
	          }
	      catch (InterruptedException e) {
	              e.printStackTrace();
	          }
	
	      // Update the progress bar
	      progressBarHandler.post(new Runnable() {
	          public void run() {
	        	  System.out.println("4");
	              pb.setProgress(progressBarProgress);
	          }
	      });
	  }
	
	  // when, file is downloaded 100%,
	  if (progressBarProgress >= 100) {
		  System.out.println("5");
	      // sleep for  2 seconds, so that you can see the 100% of file download
	      try {
	          Thread.sleep(2000);
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
	
	  }
	  System.out.println("Premietid!");
}
}).start();
        
	}
	
	// Method to change status of the progressbar
    public int progressStatus()
    {
    	int totalNewHearts=progressBarProgress;
    	System.out.println("6");
        while (totalNewHearts <= 100) {

            if (totalNewHearts == 1) {
                return 10;
            } else if (totalNewHearts == 10) {
                return 20;
            } else if (totalNewHearts == 20) {
                return 30;
            } else if (totalNewHearts == 30) {
                return 40;
            } else if (totalNewHearts == 40) {
                return 50;
            } else if (totalNewHearts == 50) {
                return 60;
            } else if (totalNewHearts == 60) {
                return 70;
            } else if (totalNewHearts == 70) {
                return 80;
            } else if (totalNewHearts == 80) {
                return 90;
            } else if (totalNewHearts == 90) {
                return 100;
            } 

        }

        return totalNewHearts;

    }
	
	
	/** 
	 * Called by onClick event
	 * @param view
	 */
	public void changeView(View view){
		Intent intent;
		int source = view.getId();
		
		switch (source) {
		case R.id.myViewButton:
			System.out.println("Du trykket for å bytte til mine bidrag");
//			setContentView(R.layout.activity_history);
			break;
		case R.id.kollektivViewButton:
			System.out.println("Du trykket for å bytte til kollektivets bidrag");
//			setContentView(R.layout.activity_history);
			break;
			
		case R.id.chronograpicViewButton:
			System.out.println("Du trykket for å sortere på dato");
//			setContentView(R.layout.activity_history);
			break;
			
		case R.id.ratingViewButton:
			System.out.println("Du trykket for å sortere etter rating");
//			setContentView(R.layout.activity_history);
			break;
			
		case R.id.priceViewButton:
			System.out.println("Du trykket for å gå til premieoversikten");
			intent= new Intent(this, PricesActivity.class);
			startActivity(intent);
			break;
		case R.id.progressbar:
			System.out.println("Du trykket for å gå tilbake via progressbaren");
			
			break;

		default:
			break;
		}
		
	}
	

}
