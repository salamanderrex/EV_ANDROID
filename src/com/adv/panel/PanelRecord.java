package com.adv.panel;

import com.krislq.sliding.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class PanelRecord extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.panel_record,null);
		Button reset = (Button)view.findViewById(R.id.button1);
		final TextView new_distance = (TextView)view.findViewById(R.id.textView2);
	    reset.setOnClickListener(new OnClickListener()
	    {
	    	public void onClick(View v)
	    	{
	    		AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
	    		ad.setTitle("警告");
	    		ad.setMessage("是否重置最新一次续航里程");
	    		ad.setPositiveButton("确定",new DialogInterface.OnClickListener()
	    		{
	    			public void onClick(DialogInterface dialog, int i)
	    			{
	    				new_distance.setText("0km");
	    			}
	    			
	    		});
	    		ad.setNegativeButton("取消",new DialogInterface.OnClickListener()
	    		{

					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
	    			
	    		});
	    		ad.show();
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
