package gui.bidra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class RatingFragment extends Fragment{
	private int rating;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rating = 0;
		
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_ratingen, container, false);
		changeAlphaAcceptButton(0.5f, view);
		
		ImageView h1 = (ImageView)view.findViewById(R.id.rater_bar).findViewById(R.id.rater_heart1);
		h1.setOnClickListener(new HeartListener1());
		
		ImageView h2 = (ImageView)view.findViewById(R.id.rater_bar).findViewById(R.id.rater_heart2);
		h2.setOnClickListener(new HeartListener2());
		
		ImageView h3 = (ImageView)view.findViewById(R.id.rater_bar).findViewById(R.id.rater_heart3);
		h3.setOnClickListener(new HeartListener3());
		
		ImageView h4 = (ImageView)view.findViewById(R.id.rater_bar).findViewById(R.id.rater_heart4);
		h4.setOnClickListener(new HeartListener4());
		
		ImageView h5 = (ImageView)view.findViewById(R.id.rater_bar).findViewById(R.id.rater_heart5);
		h5.setOnClickListener(new HeartListener5());
		
		ImageView acceptButton = (ImageView)view.findViewById(R.id.rater_bar).findViewById(R.id.rater_accept);
		acceptButton.setOnClickListener(new acceptButtonListener());
		
		return view;
	}
	
	public void changeAlphaAcceptButton(float alpha, View v){
		ImageView button = (ImageView)v.findViewById(R.id.rater_bar).findViewById(R.id.rater_accept);
		button.setAlpha(alpha);
	}
	
	protected class HeartListener1 implements OnClickListener{

		@Override
		public void onClick(View v) {
			rating = 1;
			changeAlphaAcceptButton(1, v);
		}
		
	}
	
	
	
	protected class HeartListener2 implements OnClickListener{

		@Override
		public void onClick(View v) {
			rating = 2;
			changeAlphaAcceptButton(1, v);
		}
		
	}
	
	protected class HeartListener3 implements OnClickListener{

		@Override
		public void onClick(View v) {
			rating = 3;
			changeAlphaAcceptButton(1, v);
		}
		
	}
	
	protected class HeartListener4 implements OnClickListener{

		@Override
		public void onClick(View v) {
			rating = 4;
			changeAlphaAcceptButton(1, v);
		}
		
	}
	
	protected class HeartListener5 implements OnClickListener{

		@Override
		public void onClick(View v) {
			rating = 5;
			changeAlphaAcceptButton(1, v);
		}
		
	}
	
	protected class acceptButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			if (v.getAlpha() != 1) {
				System.out.println("Must rate first");
			} else {
				
			}
			
		}
		
	}
	
	protected class nextRatingListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			//TODO Switch bilde;
		}
		
	}
	
}
