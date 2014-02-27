package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.Basic;
import com.advpower.android.utilities.CONSTANT;
import com.advpower.android.utilities.messagefactory.messageFactory_maker;
import com.krislq.sliding.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class basic_config extends Activity{
	
	static int DC_Current = -1;
	static int Throttle_low = -1;
	static int Phase_current = -1;
	static int Throttle_mid = -1;
	static int High_voltage = -1;
	static int Throttle_high = -1;
	static int High_voltage_recover = -1;
	static int Max_speed = -1;
	static int Low_voltage = -1;
	static int ECO_speed = -1;
	static int Low_voltage_recover = -1;
	static int NAN_error = 0;
	
	static EditText DC_current_edit;
	static EditText Phase_current_edit;
	static EditText High_voltage_edit;
	static EditText High_voltage_recover_edit;
	static EditText Low_voltage_edit;
	static EditText Low_voltage_recover_edit;
	static EditText Throttle_low_edit;
	static EditText Throttle_mid_edit;
	static EditText Throttle_high_edit;
	static EditText Max_speed_edit;
	static EditText ECO_speed_edit;
	
	final Activity activity = this;
	static Toast toast;
	
	public static Handler basic_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{
			Basic basic_received = (Basic)msg.obj;
			DC_Current = basic_received.DC_current;
			Throttle_low = basic_received.Throttle_low;
			Phase_current = basic_received.Phase_current;
			Throttle_mid = basic_received.Throttle_mid;
			High_voltage = basic_received.High_voltage;
			Throttle_high = basic_received.Throttle_high;
			High_voltage_recover = basic_received.High_voltage_recover;
			Max_speed = basic_received.Max_speed;
			Low_voltage = basic_received.Low_voltage;
			ECO_speed = basic_received.ECO_speed;
			Low_voltage_recover = basic_received.Low_voltage_recover;

			DC_current_edit.setText(Integer.toString(DC_Current));
			Throttle_low_edit.setText(Integer.toString(Throttle_low));
			Phase_current_edit.setText(Integer.toString(Phase_current));
			Throttle_mid_edit.setText(Integer.toString(Throttle_mid));
			High_voltage_edit.setText(Integer.toString(High_voltage));
			Throttle_high_edit.setText(Integer.toString(Throttle_high));
			High_voltage_recover_edit.setText(Integer.toString(High_voltage_recover));
			Max_speed_edit.setText(Integer.toString(Max_speed));
			Low_voltage_edit.setText(Integer.toString(Low_voltage));
			ECO_speed_edit.setText(Integer.toString(ECO_speed));
			Low_voltage_recover_edit.setText(Integer.toString(Low_voltage_recover));
		}
	};
	
			
	public static Handler basic_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.BASIC_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic);
		toast = Toast.makeText(basic_config.this,"basic_config写入成功",Toast.LENGTH_LONG);
		DC_current_edit = (EditText)findViewById(R.id.editText_dc);
		Phase_current_edit = (EditText)findViewById(R.id.editText_pc);
		 High_voltage_edit = (EditText)findViewById(R.id.editText_hv);
		 High_voltage_recover_edit = (EditText)findViewById(R.id.editText_hvr);
		 Low_voltage_edit = (EditText)findViewById(R.id.editText_lv);
		 Low_voltage_recover_edit = (EditText)findViewById(R.id.editText_lvr);
		 Throttle_low_edit = (EditText)findViewById(R.id.editText_tl);
		 Throttle_mid_edit = (EditText)findViewById(R.id.editText_tm);
		 Throttle_high_edit = (EditText)findViewById(R.id.editText_th);
		 Max_speed_edit = (EditText)findViewById(R.id.editText_ms);
		 ECO_speed_edit = (EditText)findViewById(R.id.editText_es);
		
		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.BASIC_READ));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		write.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				Basic basic_write = new Basic();
				try
				{
				basic_write.DC_current = Integer.parseInt(DC_current_edit.getText().toString());
				basic_write.Throttle_low = Integer.parseInt(Throttle_low_edit.getText().toString());
				basic_write.Phase_current = Integer.parseInt(Phase_current_edit.getText().toString());
				basic_write.Throttle_mid = Integer.parseInt(Throttle_mid_edit.getText().toString());
				basic_write.High_voltage = Integer.parseInt(High_voltage_edit.getText().toString());
				basic_write.Throttle_high = Integer.parseInt(Throttle_high_edit.getText().toString());
				basic_write.High_voltage_recover = Integer.parseInt(High_voltage_recover_edit.getText().toString());
				basic_write.Max_speed = Integer.parseInt(Max_speed_edit.getText().toString());
				basic_write.Low_voltage = Integer.parseInt(Low_voltage_edit.getText().toString());
				basic_write.ECO_speed = Integer.parseInt(ECO_speed_edit.getText().toString());
				basic_write.Low_voltage_recover = Integer.parseInt(Low_voltage_recover_edit.getText().toString());
				NAN_error = 0;
				}
				
				catch(NumberFormatException e)
				{
					Toast NAN = Toast.makeText(basic_config.this,"请输入有效的值",Toast.LENGTH_LONG);
					NAN.show();
					NAN_error = 1;
				}
				
				if(NAN_error == 0)
				{
				try {
					StartActivity.myblueTooth.write(basic_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				}
			}
		});
}
}
