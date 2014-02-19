package cdlewis.fumockup;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar aBar = getActionBar();
		aBar.setTitle("HF Guidance Tool");
		aBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#43A7FA")));
		aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab t = aBar.newTab()
				.setText("User")
				.setTabListener(new FragmentTabListener<User>(this, "user", User.class));
		aBar.addTab(t);
		
		t = aBar.newTab()
				.setText("Environment")
				.setTabListener(new FragmentTabListener<User>(this, "env", User.class));
		aBar.addTab(t);
		
		t = aBar.newTab()
				.setText("Task")
				.setTabListener(new FragmentTabListener<User>(this, "task", User.class));
		aBar.addTab(t);
	}
}
