package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.Protection;
import com.advpower.android.utilities.CONSTANT;
import com.advpower.android.utilities.messagefactory.messageFactory_maker;
import com.krislq.sliding.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class protection_config extends Activity{
	static int Big_torque_time = -1;
	static int Iqref_1krpm = -1;
	static int Motor_lock_time = -1;
	static int Iqref_1_5krpm = -1;
	static int Motor_lock_Iac = -1;
	static int Iqref_2krpm = -1;
	static int Big_torque_Iac = -1;
	static int Iqref_2_5krpm = -1;
	static int Over_heat_point = -1;
	static int Iqref_3krpm = -1;
	static int Over_heat_recover = -1;
	static int Iqref_3_5krpm = -1;
	static int Temp_of_Iac_limit = -1;
	static int Iqref_4krpm = -1;
	static int Hall_calib_Iac = -1;
	static int Iqref_4_5krpm = -1;
	static int Flux_comp_to_Vdc = -1;

	static int NAN_error = 0;
	
	static EditText Big_torque_time_edit;
	static EditText Iqref_1krpm_edit;
	static EditText Motor_lock_time_edit;
	static EditText Iqref_1_5krpm_edit;
	static EditText Motor_lock_Iac_edit;
	static EditText Iqref_2krpm_edit;
	static EditText Big_torque_Iac_edit;
	static EditText Iqref_2_5krpm_edit;
	static EditText Over_heat_point_edit;
	static EditText Iqref_3krpm_edit;
	static EditText Over_heat_recover_edit;
	static EditText Iqref_3_5krpm_edit;
	static EditText Temp_of_Iac_limit_edit;
	static EditText Iqref_4krpm_edit;
	static EditText Hall_calib_Iac_edit;
	static EditText Iqref_4_5krpm_edit;
	static EditText Flux_comp_to_Vdc_edit;
	
	final Activity activity = this;
	static Toast toast;
	
	public static Handler protection_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{
			Protection reference_received = (Protection)msg.obj;
			Big_torque_time = reference_received.Big_torque_time;
			Iqref_1krpm= reference_received.Iqref_1krpm;
			Motor_lock_time= reference_received.Motor_lock_time;
			Iqref_1_5krpm= reference_received.Iqref_1_5krpm;
			Motor_lock_Iac= reference_received.Motor_lock_Iac;
			Iqref_2krpm= reference_received.Iqref_2krpm;
			Big_torque_Iac= reference_received.Big_torque_Iac;
			Iqref_2_5krpm= reference_received.Iqref_2_5krpm;
			Over_heat_point= reference_received.Over_heat_point;
			Iqref_3krpm= reference_received.Iqref_3krpm;
			Over_heat_recover= reference_received.Over_heat_recover;
			Iqref_3_5krpm= reference_received.Iqref_3_5krpm;
			Temp_of_Iac_limit= reference_received.Temp_of_Iac_limit;
			Iqref_4krpm = reference_received.Iqref_4krpm;
			Hall_calib_Iac = reference_received.Hall_calib_Iac;
			Iqref_4_5krpm = reference_received.Iqref_4_5krpm;
			Flux_comp_to_Vdc = reference_received.Flux_comp_to_Vdc;
			
			Big_torque_time_edit.setText(Integer.toString(Big_torque_time));
			Iqref_1krpm_edit.setText(Integer.toString(Iqref_1krpm));
			Motor_lock_time_edit.setText(Integer.toString(Motor_lock_time));
			Iqref_1_5krpm_edit.setText(Integer.toString(Iqref_1_5krpm));
			Motor_lock_Iac_edit.setText(Integer.toString(Motor_lock_Iac));
			Iqref_2krpm_edit.setText(Integer.toString(Iqref_2krpm));
			Big_torque_Iac_edit.setText(Integer.toString(Big_torque_Iac));
			Iqref_2_5krpm_edit.setText(Integer.toString(Iqref_2_5krpm));
			Over_heat_point_edit.setText(Integer.toString(Over_heat_point));
			Iqref_3krpm_edit.setText(Integer.toString(Iqref_3krpm));
			Over_heat_recover_edit.setText(Integer.toString(Over_heat_recover));
			Iqref_3_5krpm_edit.setText(Integer.toString(Iqref_3_5krpm));
			Temp_of_Iac_limit_edit.setText(Integer.toString(Temp_of_Iac_limit));
			Iqref_4krpm_edit.setText(Integer.toString(Iqref_4krpm));
			Hall_calib_Iac_edit.setText(Integer.toString(Hall_calib_Iac));
			Iqref_4_5krpm_edit.setText(Integer.toString(Iqref_4_5krpm));
			Flux_comp_to_Vdc_edit.setText(Integer.toString(Flux_comp_to_Vdc));

		}
	};
	
			
	public static Handler protection_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.PROTECTION_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.protection);
		toast = Toast.makeText(protection_config.this,"protection_config写入成功",Toast.LENGTH_LONG);
		 Big_torque_time_edit = (EditText)findViewById(R.id.editText_btt);
		 Iqref_1krpm_edit = (EditText)findViewById(R.id.editText_i1);
		 Motor_lock_time_edit = (EditText)findViewById(R.id.editText_mlt);
		 Iqref_1_5krpm_edit = (EditText)findViewById(R.id.editText_i1dot5);
		 Motor_lock_Iac_edit = (EditText)findViewById(R.id.editText_mli);
		 Iqref_2krpm_edit = (EditText)findViewById(R.id.editText_i2);
		 Big_torque_Iac_edit = (EditText)findViewById(R.id.editText_bti);
		 Iqref_2_5krpm_edit = (EditText)findViewById(R.id.editText_i2dot5);
		 Over_heat_point_edit = (EditText)findViewById(R.id.editText_ohp);
		 Iqref_3krpm_edit = (EditText)findViewById(R.id.editText_i3);
		 Over_heat_recover_edit = (EditText)findViewById(R.id.editText_ohr);
		 Iqref_3_5krpm_edit = (EditText)findViewById(R.id.editText_i3dot5);
		 Temp_of_Iac_limit_edit = (EditText)findViewById(R.id.editText_toil);
		 Iqref_4krpm_edit = (EditText)findViewById(R.id.editText_i4);
		 Hall_calib_Iac_edit = (EditText)findViewById(R.id.editText_hci);
		 Iqref_4_5krpm_edit = (EditText)findViewById(R.id.editText_i4dot5);
		 Flux_comp_to_Vdc_edit = (EditText)findViewById(R.id.editText_fctv);

		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.PROTECTION_READ));
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
				Protection protection_write = new Protection();
				try
				{
				protection_write.Big_torque_time = Integer.parseInt(Big_torque_time_edit.getText().toString());
				protection_write.Iqref_1krpm = Integer.parseInt(Iqref_1krpm_edit.getText().toString());
				protection_write.Motor_lock_time = Integer.parseInt(Motor_lock_time_edit.getText().toString());
				protection_write.Iqref_1_5krpm = Integer.parseInt(Iqref_1_5krpm_edit.getText().toString());
				protection_write.Motor_lock_Iac = Integer.parseInt(Motor_lock_Iac_edit.getText().toString());
				protection_write.Iqref_2krpm = Integer.parseInt(Iqref_2krpm_edit.getText().toString());
				protection_write.Big_torque_Iac = Integer.parseInt(Big_torque_Iac_edit.getText().toString());
				protection_write.Iqref_2_5krpm = Integer.parseInt(Iqref_2_5krpm_edit.getText().toString());
				protection_write.Over_heat_point = Integer.parseInt(Over_heat_point_edit.getText().toString());
				protection_write.Iqref_3krpm = Integer.parseInt(Iqref_3krpm_edit.getText().toString());
				protection_write.Over_heat_recover = Integer.parseInt(Over_heat_recover_edit.getText().toString());
				protection_write.Iqref_3_5krpm = Integer.parseInt(Iqref_3_5krpm_edit.getText().toString());
				protection_write.Temp_of_Iac_limit = Integer.parseInt(Temp_of_Iac_limit_edit.getText().toString());
				protection_write.Iqref_4krpm = Integer.parseInt(Iqref_4krpm_edit.getText().toString());
				protection_write.Hall_calib_Iac = Integer.parseInt(Hall_calib_Iac_edit.getText().toString());
				protection_write.Iqref_4_5krpm = Integer.parseInt(Iqref_4_5krpm_edit.getText().toString());
				protection_write.Flux_comp_to_Vdc = Integer.parseInt(Flux_comp_to_Vdc_edit.getText().toString());
				NAN_error = 0;
			}
			
			catch(NumberFormatException e)
			{
				Toast NAN = Toast.makeText(protection_config.this,"请输入有效的值",Toast.LENGTH_LONG);
				NAN.show();
				NAN_error = 1;
			}
			
			if(NAN_error == 0)
			{
				
				try {
					StartActivity.myblueTooth.write(protection_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
}
}
