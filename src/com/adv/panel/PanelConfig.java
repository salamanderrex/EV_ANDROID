package com.adv.panel;

import com.adv.config.basic_config;
import com.adv.config.control_config;
import com.adv.config.dc_current_calibration_config;
import com.adv.config.flux_weaken_config;
import com.adv.config.motor_config;
import com.adv.config.other_config;
import com.adv.config.protection_config;
import com.adv.config.reference_config;
import com.adv.config.torque_config;
import com.krislq.sliding.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class PanelConfig extends Fragment {
	private int reset_flag = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.panel_config,null);
		ListView list = (ListView)view.findViewById(R.id.mylist);
		String[] cfg_items = {"basic","Reference","Motor","Control","Torque PID","Protection","Other","Flux weaken","DC Current Calibration"};
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, cfg_items);
		list.setAdapter(arrayAdapter);
		
		list.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent;
				switch((int)arg3)
				{
				case 0:
					intent = new Intent(getActivity(),basic_config.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(getActivity(),reference_config.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(getActivity(),motor_config.class);
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(getActivity(),control_config.class);
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(getActivity(),torque_config.class);
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(getActivity(),protection_config.class);
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(getActivity(),other_config.class);
					startActivity(intent);
					break;
				case 7:
					intent = new Intent(getActivity(),flux_weaken_config.class);
					startActivity(intent);
					break;
				case 8:
					intent = new Intent(getActivity(),dc_current_calibration_config.class);
					startActivity(intent);
					break;
				default:
					Toast error = Toast.makeText(getActivity(),"发生未知错误",Toast.LENGTH_LONG);
					error.show();
					break;
				}
			}			
		});
		
		
		return view;

	}
	 @Override
	    public void onPause() {
	        super.onPause();
	    }

	    @Override
	    public void onResume() {
	        super.onResume();
	    }


	    @Override
	    public void onStop() {
	        super.onStop();
	    }
}
