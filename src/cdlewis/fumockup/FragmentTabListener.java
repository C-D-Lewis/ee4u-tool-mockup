package cdlewis.fumockup;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;

public class FragmentTabListener<T extends Fragment> implements ActionBar.TabListener {
	//Other members
	private Fragment tabFragment;
	private final Activity activity;
	private final String tabTag;
	private final Class<T> tabClass;
	
	public FragmentTabListener(Activity parent, String tag, Class<T> clz) {
		activity = parent;
		tabTag = tag;
		tabClass = clz;
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		//Has the fragment been instantiated?
		if(tabFragment == null) {
			tabFragment = Fragment.instantiate(activity, tabClass.getName());
			ft.add(android.R.id.content, tabFragment, tabTag);
		} else {
			//It's already instantiated
			ft.attach(tabFragment);
		}
	}
	
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if(tabFragment != null) {
			//Detach fragment
			ft.detach(tabFragment);
		}
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}
}
