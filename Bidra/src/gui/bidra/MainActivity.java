package gui.bidra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	private static final String TAG = "CAMERA_ACTIVITY";
	private static final int NUMBER_OF_PAGES = 2;

	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private String[] challenges;
	
	private ViewPager mViewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        
        challenges = getResources().getStringArray(R.array.challenges);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.custome_challenge, challenges));
        mDrawerList.setOnItemClickListener(new DrawerItemListener());
        
        Button challengesButton = (Button)findViewById(R.id.challenges_button);
        challengesButton.setOnClickListener(new OpenDrawerWithButton());
        
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
	
	protected class OpenDrawerWithButton implements OnClickListener{

		@Override
		public void onClick(View v) {
			mDrawerLayout.openDrawer(mDrawerList);
			
		}
	}
	
	protected class DrawerItemListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			//TODO: Add what's happening here.
			mDrawerLayout.closeDrawer(mDrawerList);			
		}
		
	}
	
	protected class MainPagerAdapter extends FragmentPagerAdapter{
		private Fragment[] fragments = new Fragment[]{new CameraFragment(), new RatingFragment()};
		
		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		


		@Override
		public int getCount() {
			return NUMBER_OF_PAGES;
		}

		@Override
		public android.support.v4.app.Fragment getItem(int arg0) {
			return fragments[arg0];
		}

		
	}
	
}

	