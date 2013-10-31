package gui.bidra;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class PricesActivity extends Activity implements OnTouchListener{

	ViewFlipper animationFlipper;
	ViewFlipper animationFlipperWinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_prices);
		animationFlipper = (ViewFlipper)findViewById(R.id.viewFlipper1);
		animationFlipperWinner = (ViewFlipper)findViewById(R.id.viewFlipper2);
		TextView txtWheelOfFortuneButton = (TextView)findViewById(R.id.txtWheelOfFortuneButton);
		
		
		txtWheelOfFortuneButton.setOnTouchListener(this);
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
			animationFlipper.setFlipInterval(400);
			animationFlipperWinner.setFlipInterval(200);
			animationFlipper.startFlipping();
//			if(animationFlipper.isFlipping()){
//				if(animationFlipper.get){
//					animationFlipper.stopFlipping();
//					animationFlipper.setVisibility(SurfaceView.VISIBLE);
//					animationFlipperWinner.setVisibility(SurfaceView.VISIBLE);
//					animationFlipperWinner.showNext();
//					animationFlipperWinner.showNext();
//					animationFlipperWinner.showNext();
//					animationFlipperWinner.showNext();
//					animationFlipperWinner.showNext();
//					animationFlipperWinner.showNext();
//				}
//			}
		
		return false;
	}
}
