package com.krislq.sliding.fragment;

import com.krislq.sliding.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author <a href="mailto:kris@krislq.com">Kris.lee</a>
 * @since Mar 12, 2013
 * @version 1.0.0
 */
@SuppressLint("ValidFragment")
@SuppressWarnings("deprecation")
public class ContentFragment extends Fragment {
	private int width;
    String text = null;

    public ContentFragment() {
    }

    public ContentFragment(String text) {
        Log.e("Krislq", text);
        this.text = text;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.e("Krislq", "onCreate:"+text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("Krislq", "onCreateView:"+ text);
        //inflater the layout 
        View view = inflater.inflate(R.layout.fragment_text, null);
        //ImageView arrow = (ImageView)view.findViewById(R.id.arrow);
        TextView goRight = (TextView)view.findViewById(R.id.right);
        AbsoluteLayout.LayoutParams rightParams = 
        	    (AbsoluteLayout.LayoutParams)goRight.getLayoutParams();
        rightParams.x = getActivity().getWindowManager().getDefaultDisplay().getWidth()/3+180;
        rightParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight()/2-200;
        ImageView arrow = (ImageView)view.findViewById(R.id.arrow);
        AbsoluteLayout.LayoutParams arrowParams = 
        	    (AbsoluteLayout.LayoutParams)arrow.getLayoutParams();
        arrowParams.x = getActivity().getWindowManager().getDefaultDisplay().getWidth()/3;
        arrowParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight()/2-100;
        arrow.setLayoutParams(arrowParams);
        TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, (float) 0.0, Animation.RELATIVE_TO_SELF,(float) arrowParams.x/250, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        anim.setDuration(1500);
        anim.setRepeatCount(-1);
        arrow.setAnimation(anim);
        
        anim.startNow();
        //Animation translate=AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.arrow);
        //arrow.startAnimation(translate);
        if(!TextUtils.isEmpty(text)) {
            goRight.setText(text);
        }
        return view;
    }

    @Override
    public void onDestroy() {
        Log.e("Krislq", "onDestroy:"+ text);
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("Krislq", "onDetach:"+ text);
        super.onDetach();
    }

    @Override
    public void onPause() {
        Log.e("Krislq", "onPause:"+ text);
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.e("Krislq", "onResume:"+ text);
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.e("Krislq", "onStart:"+ text);
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.e("Krislq", "onStop:"+ text);
        super.onStop();
    }
    
}
