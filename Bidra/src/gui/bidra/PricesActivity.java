package gui.bidra;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class PricesActivity extends Activity implements OnTouchListener{

	ViewFlipper animationFlipper;
	ViewFlipper animationFlipperWinner;
	
	private Price premie1;
	private Price premie2;
	private Price premie3;
	private Price premie4;
	private Price premie5;
	private Price premie6;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_prices);
		
		TextView txtWheelOfFortuneButton = (TextView)findViewById(R.id.txtWheelOfFortuneButton);

		loadPrices();
		
	}
	
	private void loadPrices(){
		premie1= new Price(getApplicationContext(),"Fest for deg",R.drawable.bilde1);
		premie2= new Price(getApplicationContext(),"Massasje",R.drawable.bilde2);
		premie3= new Price(getApplicationContext(),"Lage middag",R.drawable.bilde3);
		premie4= new Price(getApplicationContext(),"Bake boller",R.drawable.bilde4);
		premie5= new Price(getApplicationContext(),"Vaske rommet ditt!",R.drawable.bilde5);
		premie6= new Price(getApplicationContext(),"Låne deg bilen",R.drawable.bilde6);
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void startAnimation(View view){
		
	}

}
