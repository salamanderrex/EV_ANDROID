package com.krislq.sliding.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;

import com.adv.panel.PanelCarInfo;
import com.adv.panel.PanelConfig;
import com.adv.panel.PanelHelp;
import com.adv.panel.PanelInfo;
import com.adv.panel.PanelRecord;
import com.adv.panel.PanelUpdate;
import com.krislq.sliding.MainActivity;
import com.krislq.sliding.R;
/**
 * menu fragment ，主要是用于显示menu菜单
 * @author <a href="mailto:kris@krislq.com">Kris.lee</a>
 * @since Mar 12, 2013
 * @version 1.0.0
 */
public class MenuFragment extends PreferenceFragment implements OnPreferenceClickListener{
    int index = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        //set the preference xml to the content view
        addPreferencesFromResource(R.xml.menu);
        //add listener
        findPreference("a").setOnPreferenceClickListener(this);
        findPreference("b").setOnPreferenceClickListener(this);
        findPreference("c").setOnPreferenceClickListener(this);
        findPreference("d").setOnPreferenceClickListener(this);
        findPreference("e").setOnPreferenceClickListener(this);
        findPreference("f").setOnPreferenceClickListener(this);
        
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
       
        if("a".equals(key)) {
            if(index == 0) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 0;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("A");
            fragmentManager.beginTransaction().replace(R.id.content, new PanelCarInfo()).commit();
        }
        
        else if("b".equals(key)) {
            if(index == 1) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 1;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("B");
            fragmentManager.beginTransaction().replace(R.id.content, new PanelRecord()).commit();
        }else if("c".equals(key)) {

            if(index == 2) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 2;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("C");
            fragmentManager.beginTransaction()
            .replace(R.id.content, new PanelInfo())
            .commit();
        }
        else if("d".equals(key)) {

            if(index == 3) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 3;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("D");
            fragmentManager.beginTransaction()
            .replace(R.id.content, new PanelUpdate())
            .commit();
        }
        else if("e".equals(key)) {

            if(index == 4) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 4;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("E");
            fragmentManager.beginTransaction()
            .replace(R.id.content, new PanelConfig())
            .commit();
        }
        else if("f".equals(key)) {

            if(index == 5) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 5;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("F");
            fragmentManager.beginTransaction()
            .replace(R.id.content, new PanelHelp())
            .commit();
        }
        //anyway , show the sliding menu
        ((MainActivity)getActivity()).getSlidingMenu().toggle();
        return false;
    }
}
