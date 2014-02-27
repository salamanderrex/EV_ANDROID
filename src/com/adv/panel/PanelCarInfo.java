package com.adv.panel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.adv.StartActivity;
import com.advpower.android.utilities.messagefactory.messageFactory_maker;
import com.krislq.sliding.R;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class PanelCarInfo extends Fragment implements OnClickListener{
	private ImageView pointer1;
	private ImageView pointer2;
	private ImageView pointer2x;
	private ImageView pointer3;
	private ImageView pointer4;
	private ImageView pointer5;
	private ImageView warning;
	private RelativeLayout layout_rightx;
	private RelativeLayout layout_left;
	private RelativeLayout layout_right;
	private RelativeLayout layout_middle;
	private Timer Layout_Timer = new Timer();
	private float degree;
	
	private float speed;
	private float Iac_actual;
	private float Throttle_Vdc;
	private float Idc;
	private float Vdc;
	private boolean Backward;
	private boolean Forward;
	
	private boolean Hall;
	private boolean Under_vdc;
	private boolean Over_vdc;
	private boolean Over_heat;
	private boolean Over_iac;
	private boolean Over_load;
	private boolean Motor_lock;
	private boolean Motor_OH;

	private boolean Hall_history;
	private boolean Under_vdc_history;
	private boolean Over_vdc_history;
	private boolean Over_heat_history;
	private boolean Over_iac_history;
	private boolean Over_load_history;
	private boolean Motor_lock_history;
	private boolean Motor_OH_history;
	
	private float deg_1,deg_1_temp,deg_2,deg_2_temp,deg_2x,deg_2x_temp,deg_3,deg_3_temp,deg_4,deg_4_temp,deg_5,deg_5_temp;
	
	private int lastX;
	private int lastY;
	private TextView date;
	private TextView status;

	SharedPreferences preferences;
	
	private Handler data = new Handler()
	{
		public void handleMessage(Message msg)
		{	
			if(msg.what == 0x100)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.TIME_ROBORT_op());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("这里是"+StartActivity.myblueTooth.sys_RealTimeInfo.MotorT);
				speed = StartActivity.myblueTooth.sys_RealTimeInfo.Speed;
				Throttle_Vdc = StartActivity.myblueTooth.sys_RealTimeInfo.Throttle_vdc;
				Iac_actual = StartActivity.myblueTooth.sys_RealTimeInfo.Iac_actual;
				Vdc = StartActivity.myblueTooth.sys_RealTimeInfo.Vdc;
				Idc = StartActivity.myblueTooth.sys_RealTimeInfo.Idc;
				Backward = StartActivity.myblueTooth.sys_RealTimeInfo.Backward;
				Forward = StartActivity.myblueTooth.sys_RealTimeInfo.Forward;
			
				if(Backward == true)
				{
					status.setText("R");
				}
				
				if(Forward == true)
				{
					status.setText("D");
				}
				
				if((Backward == true && Forward == true )||(Backward == false && Forward == false ))
				{
					System.out.println("前进倒车状态错误");
				}

				if(Hall||Under_vdc||Over_vdc||Over_heat||Over_iac||Over_load||Motor_lock||Motor_OH||
						Hall_history||Under_vdc_history||Over_vdc_history||Over_heat_history||Over_iac_history||Over_load_history||Motor_lock_history||Motor_OH_history)
				{
					warning.setVisibility(View.VISIBLE);
				}
				else
				{
					warning.setVisibility(View.INVISIBLE);
				}
//				if(true)
//				{
//					warning.setVisibility(View.VISIBLE);
//				}
				
				
				deg_1 = (float) (speed*(-0.0142)+251);
				RotateAnimation animation = new RotateAnimation(deg_1_temp, 
						deg_1, Animation.RELATIVE_TO_SELF, 0.5f,
						Animation.RELATIVE_TO_SELF, 0.5f);
				animation.setDuration(2000);
				animation.setFillAfter(true);
				pointer1.startAnimation(animation);
				deg_1_temp = deg_1;
				
				
				RotateAnimation animation2 = new RotateAnimation(0, 
					0, Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
				animation2.setDuration(2000);
				animation2.setFillAfter(true);
				pointer2.startAnimation(animation2);
			
				deg_2x = (float) (Throttle_Vdc*-0.0221+300);
				RotateAnimation animation6 = new RotateAnimation(deg_2x_temp, 
					deg_2x, Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
				animation6.setDuration(2000);
				animation6.setFillAfter(true);
				pointer2x.startAnimation(animation6);
				deg_2x_temp = deg_2x;
				
				deg_3 = (float) (Iac_actual*-0.0142+251);
				RotateAnimation animation3 = new RotateAnimation(deg_3_temp, 
					deg_3, Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
				animation3.setDuration(2000);
				animation3.setFillAfter(true);
				pointer3.startAnimation(animation3);
				deg_3_temp = deg_3;
			
				deg_4 = (float) (Vdc*-0.0219+293);
				RotateAnimation animation4 = new RotateAnimation(deg_4_temp, 
					deg_4, Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
				animation4.setDuration(2000);
				animation4.setFillAfter(true);
				pointer4.startAnimation(animation4);
				deg_4_temp = deg_4;
				
				deg_5 = (float) (Idc*-0.0221+204);
				RotateAnimation animation5 = new RotateAnimation(deg_5_temp, 
					deg_5, Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
				animation5.setDuration(2000);
				animation5.setFillAfter(true);
				pointer5.startAnimation(animation5);
				deg_5_temp = deg_5;
			
			}
			
//			else if(msg.what == 0x778)
//			{
//				SimpleDateFormat myFmt2=new SimpleDateFormat("HH:mm");
//			    Date now = new Date();
//			    date.setText(myFmt2.format(now));
//			}
		}
	};
	
	
	View view;
	
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.panel_car_info,null);
		preferences = getActivity().getApplicationContext().getSharedPreferences("adv",getActivity().getApplicationContext().MODE_PRIVATE);
		final Editor editor = preferences.edit();
	    final int w_width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
	    final int w_height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
	    
		
	    date = (TextView)view.findViewById(R.id.textView2);
	    status = (TextView)view.findViewById(R.id.textView4);
	    warning = (ImageView)view.findViewById(R.id.ImageView9);
	    
	    
//	    AlphaAnimation appear = new AlphaAnimation(0,1);
//	    appear.setDuration(4000);
//	    appear.setRepeatCount(1);
//	    remind.startAnimation(appear);
//	    
//	    remind.setOnClickListener(new OnClickListener()
//	    {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				layout_left.layout(preferences.getInt("left_left",layout_left.getLeft()),preferences.getInt("left_top",layout_left.getTop()),preferences.getInt("left_right",layout_left.getRight()),preferences.getInt("left_bottom",layout_left.getBottom()));
//				layout_right.layout(preferences.getInt("right_left",layout_right.getLeft()),preferences.getInt("right_top",layout_right.getTop()),preferences.getInt("right_right",layout_right.getRight()),preferences.getInt("right_bottom",layout_right.getBottom()));
//				layout_rightx.layout(preferences.getInt("rightx_left",layout_rightx.getLeft()),preferences.getInt("rightx_top",layout_rightx.getTop()),preferences.getInt("rightx_right",layout_rightx.getRight()),preferences.getInt("rightx_bottom",layout_rightx.getBottom()));
//				remind.setAlpha(0);
//			}
//	    });
	    
	    
	    warning.setOnClickListener(new OnClickListener()
	    {
	    	public void onClick(View arg)
	    	{
	    		AlertDialog.Builder cuowu = new AlertDialog.Builder(getActivity());
	    		cuowu.setTitle("错误");
	    		String error_info = "";
	    		if(Hall == true)
	    		{
	    			error_info += "霍尔错误\n";
	    		}
	    		if(Under_vdc == true)
	    		{
	    			error_info += "电池欠压\n";
	    		}
	    		if(Over_vdc == true)
	    		{
	    			error_info += "电池过压\n";
	    		}
	    		if(Over_heat == true)
	    		{
	    			error_info += "控制器过热\n";
	    		}
	    		if(Over_iac == true)
	    		{
	    			error_info += "过相电流\n";
	    		}
	    		if(Over_load == true)
	    		{
	    			error_info += "系统过载\n";
	    		}
	    		if(Motor_lock == true)
	    		{
	    			error_info += "电机堵转\n";
	    		}
	    		if(Motor_OH == true)
	    		{
	    			error_info += "电机过热\n";
	    		}
	    		if(Hall_history == true)
	    		{
	    			error_info += "历史霍尔错误\n";
	    		}
	    		if(Under_vdc_history == true)
	    		{
	    			error_info += "历史电池欠压\n";
	    		}
	    		if(Over_vdc_history == true)
	    		{
	    			error_info += "历史电池过压\n";
	    		}
	    		if(Over_heat_history == true)
	    		{
	    			error_info += "历史控制器过热\n";
	    		}
	    		if(Over_iac_history == true)
	    		{
	    			error_info += "历史过相电流\n";
	    		}
	    		if(Over_load_history == true)
	    		{
	    			error_info += "历史系统过载\n";
	    		}
	    		if(Motor_lock_history == true)
	    		{
	    			error_info += "历史电机堵转\n";
	    		}
	    		if(Motor_OH_history == true)
	    		{
	    			error_info += "历史电机过热\n";
	    		}
	    		error_info += "请及时检查车辆，确保安全行驶";
	    		cuowu.setMessage(error_info);
	    		cuowu.setPositiveButton("确定",new DialogInterface.OnClickListener()
	    		{
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						}
	    		});
	    		cuowu.show();
	    	}
	    });
	    
		pointer1 = (ImageView)view.findViewById(R.id.imageView1);
		pointer2 = (ImageView)view.findViewById(R.id.imageView2);
		pointer2x = (ImageView)view.findViewById(R.id.imageView2x);
		pointer3 = (ImageView)view.findViewById(R.id.imageView3);
		pointer4 = (ImageView)view.findViewById(R.id.imageView4);
		pointer5 = (ImageView)view.findViewById(R.id.imageView5);
		
		layout_left = (RelativeLayout)view.findViewById(R.id.relativeLayout1);
		layout_right = (RelativeLayout)view.findViewById(R.id.relativeLayout2);
		layout_rightx = (RelativeLayout)view.findViewById(R.id.relativeLayout2x);
		layout_middle = (RelativeLayout)view.findViewById(R.id.relativeLayout3);
		
		OnMoveListener mOnTouchListener = new OnMoveListener();
						
//		pos_pt = (RelativeLayout.LayoutParams) pointer.getLayoutParams();
//		pos_pt.x = preferences.getInt("1.x",(int)(w_width*0.105));
//		pos_pt.y = preferences.getInt("1.y",0);
//		pointer.setLayoutParams(pos_pt);
//		
//		pos_pt2 = (RelativeLayout.LayoutParams) pointer2.getLayoutParams();
//		pos_pt2.x = preferences.getInt("2.x",(int)(w_width*0.077));
//		pos_pt2.y = preferences.getInt("2.y",(int)(w_height*0.057));
//		pointer2.setLayoutParams(pos_pt2);
//			
//		pos_pt3 = (RelativeLayout.LayoutParams) pointer3.getLayoutParams();
//		pos_pt3.x = preferences.getInt("3.x",(int)(w_width*0.653));
//		pos_pt3.y = preferences.getInt("3.y",pos_pt2.y);
//		pointer3.setLayoutParams(pos_pt3);
//			
//		Bitmap pointer4_o = BitmapFactory.decodeResource(getResources(), R.drawable.pointer3);
//		Bitmap pointer4_b = Bitmap.createScaledBitmap(pointer4_o, (int)(0.217*w_width),(int)(0.217*w_width), true);
//		pointer4.setImageBitmap(pointer4_b);
//		pos_pt4 = (RelativeLayout.LayoutParams)pointer4.getLayoutParams();
//		pos_pt4.x = preferences.getInt("4.x",(int)(w_width*0.39));
//		pos_pt4.y = preferences.getInt("4.y",(int)(w_height*0.28));
//		pointer4.setLayoutParams(pos_pt4);
//		
//		Bitmap pointer5_o = BitmapFactory.decodeResource(getResources(), R.drawable.pointer4);
//		Bitmap pointer5_b = Bitmap.createScaledBitmap(pointer5_o, (int)(0.15625*w_width),(int)(0.25*w_height), true);
//		pointer5.setImageBitmap(pointer5_b);
//		pos_pt5 = (RelativeLayout.LayoutParams) pointer5.getLayoutParams();
//		pos_pt5.x = preferences.getInt("5.x",(int)(w_width*0.418));
//		pos_pt5.y = preferences.getInt("5.y",(int)(w_height*0.52));
//		pointer5.setLayoutParams(pos_pt5);
//		
//		Bitmap pointer6_o = BitmapFactory.decodeResource(getResources(), R.drawable.pointer5);
//		Bitmap pointer6_b = Bitmap.createScaledBitmap(pointer6_o, (int)(0.3125*w_width),(int)(0.5*w_height), true);
//		pointer6.setImageBitmap(pointer6_b);
//		pos_pt6 = (RelativeLayout.LayoutParams) pointer6.getLayoutParams();
//		pos_pt6.x = preferences.getInt("6.x",(int)(w_width*0.34));
//		pos_pt6.y = preferences.getInt("6.y",(int)(w_height*0.395));
//		pointer6.setLayoutParams(pos_pt6);
		
		layout_left.setOnTouchListener(mOnTouchListener);
		layout_right.setOnTouchListener(mOnTouchListener);
		layout_rightx.setOnTouchListener(mOnTouchListener);
		layout_middle.setOnTouchListener(mOnTouchListener);
		Layout_Timer.schedule(new LayoutTask(),0,4000);
		//timer.schedule(new pointerTask(),10000);
		//DigitalClock dgClock = (DigitalClock)view.findViewById(R.id.textView2);
		return view;
	}
	
	@Override
    public void onPause() {
		Layout_Timer.cancel();
        super.onPause();
    }

    @Override
    public void onResume() {
    	super.onResume();
    }


    @Override
    public void onStop() {
        Layout_Timer.cancel();
        
        super.onStop();
    }
	
	
	
	public void onCreateOptionsMenu(Menu menu,MenuInflater inflater)
	{
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		return false;
		
	}
	
	class LayoutTask extends TimerTask
	{
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			Message msg = new Message();
//			msg.what = 0x778;
//			data.sendMessage(msg);
			
			Message msg2 = new Message();
			msg2.what = 0x100;
			data.sendMessage(msg2);
		}
	}
	
	
	
	private class OnMoveListener implements OnTouchListener{
			public boolean onTouch(View v, MotionEvent event) {    
                switch(event.getAction()){
    			case MotionEvent.ACTION_DOWN :
    				//   按下的时候距离屏幕左上角的距离
    				lastX = (int) event.getRawX();
    				lastY = (int) event.getRawY();				
    				break;
    			case MotionEvent.ACTION_MOVE :
    				//   移动的时候距离屏幕左上角的距离
    				int nowX = (int)event.getRawX();
    				int nowY = (int)event.getRawY();
    				// X轴和Y轴移动的距离
    				int moveX = nowX - lastX;
    				int moveY = nowY -lastY;
    				// 分别计算距离
    				int top = v.getTop() + moveY;
    				int bottom = v.getBottom() + moveY;
    				int left =  v.getLeft() + moveX;
    				int right = v.getRight() + moveX;
    				
    				// 这个地方是控制 那个轴固定的的 
    				v.layout(left, top, right, bottom);
    				lastX = (int) event.getRawX();
    				lastY = (int) event.getRawY();		

					Editor editor = preferences.edit();
    				if(v.getId()==R.id.relativeLayout1)
    				{
    					editor.putInt("left_left",left);
    					editor.putInt("left_top",top);
    					editor.putInt("left_right",right);
    					editor.putInt("left_bottom",bottom);
    					editor.commit();
    				}
    				else if(v.getId()==R.id.relativeLayout2)
    				{
    					editor.putInt("right_left",left);
    					editor.putInt("right_top",top);
    					editor.putInt("right_right",right);
    					editor.putInt("right_bottom",bottom);
    					editor.commit();
    				}
    				else if(v.getId()==R.id.relativeLayout2x)
    				{
    					editor.putInt("rightx_left",left);
    					editor.putInt("rightx_top",top);
    					editor.putInt("rightx_right",right);
    					editor.putInt("rightx_bottom",bottom);
    					editor.commit();
    				}
    				break;
    			case MotionEvent.ACTION_UP:
    				break;
    			}
			
			return false;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
}