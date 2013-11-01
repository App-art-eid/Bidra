package gui.bidra;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Price extends View{

	private ImageView image;
	private TextView text;
	
	public Price(Context context, String text, int resource) {
		super(context);
		getText().setText(text);
		getImage().setImageResource(resource);
	}

	public ImageView getImage() {
		return image;
	}
	
	public void setImage(int resource) {
		image.setImageResource(resource);
	}
	
	public TextView getText() {
		return text;
	}
	
	public void setText(TextView text) {
		this.text = text;
	}
}
