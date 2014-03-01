package com.adv.config;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adv.StartActivity;
import com.advpower.android.bean.Motor;
import com.advpower.android.utilities.CONSTANT;
import com.advpower.android.utilities.PrintUtility;
import com.advpower.android.utilities.messagefactory.messageFactory_maker;
import com.krislq.sliding.R;

public class motor_config extends Activity{
	static int Pole_pair_num = -1;
	static int Hall_A_1_remap = -1;
	static int Iac_limit_level = -1;
	static int Hall_A_2_remap = -1;
	static int Angle_degree_BDir = -1;
	static int Hall_A_3_remap = -1;
	static int Angle_offset_square = -1;
	static int Hall_A_4_remap = -1;
	static int Vdc_filter = -1;
	static int Hall_A_5_remap = -1;
	static int Idc_filter = -1;
	static int Hall_A_6_remap = -1;
	static int Tref_filter = -1;
	static int Hall_group = -1;
	static int Temperature_filter = -1;
	static int ECO_Iqref_2krpm = -1;
	static int ECO_Iqref_1krpm = -1;
	static int ECO_Iqref_2_5krpm = -1;
	static int ECO_Iqref_1_5krpm = -1;
	static int ECO_Iqref_3krpm = -1;
	
	static int NAN_error = 0;
	
	static EditText Pole_pair_num_edit;
	static EditText Hall_A_1_remap_edit;
	static EditText Iac_limit_level_edit ;
	static EditText Hall_A_2_remap_edit;
	static EditText Angle_degree_BDir_edit;
	static EditText Hall_A_3_remap_edit;
	static EditText Angle_offset_square_edit;
	static EditText Hall_A_4_remap_edit;
	static EditText Vdc_filter_edit;
	static EditText Hall_A_5_remap_edit;
	static EditText Idc_filter_edit;
	static EditText Hall_A_6_remap_edit;
	static EditText Tref_filter_edit;
	static EditText Hall_group_edit;
	static EditText Temperature_filter_edit;
	static EditText ECO_Iqref_2krpm_edit;
	static EditText ECO_Iqref_1krpm_edit;
	static EditText ECO_Iqref_2_5krpm_edit;
	static EditText ECO_Iqref_1_5krpm_edit;
	static EditText ECO_Iqref_3krpm_edit;
	
	final Activity activity = this;
	
	static Toast toast; 
	
	public static Handler motor_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{
			Motor reference_received = (Motor)msg.obj;
			Pole_pair_num = reference_received.Pole_pair_num;
			Hall_A_1_remap= reference_received.Hall_A_1_remap;
			Iac_limit_level= reference_received.Iac_limit_level;
			Hall_A_2_remap= reference_received.Hall_A_2_remap;
			Angle_degree_BDir= reference_received.Angle_degree_BDir;
			Hall_A_3_remap= reference_received.Hall_A_3_remap;
			Angle_offset_square= reference_received.Angle_offset_square;
			Hall_A_4_remap= reference_received.Hall_A_4_remap;
			Vdc_filter= reference_received.Vdc_filter;
			Hall_A_5_remap= reference_received.Hall_A_5_remap;
			Idc_filter= reference_received.Idc_filter;
			Hall_A_6_remap= reference_received.Hall_A_6_remap;
			Tref_filter= reference_received.Tref_filter;
			Hall_group = reference_received.Hall_group;
			Temperature_filter = reference_received.Temperature_filter;
			ECO_Iqref_2krpm = reference_received.ECO_Iqref_2krpm;
			ECO_Iqref_1krpm = reference_received.ECO_Iqref_1krpm;
			ECO_Iqref_2_5krpm = reference_received.ECO_Iqref_2_5krpm;
			ECO_Iqref_1_5krpm = reference_received.ECO_Iqref_1_5krpm;
			ECO_Iqref_3krpm = reference_received.ECO_Iqref_3krpm;
			
			Pole_pair_num_edit.setText(Integer.toString(Pole_pair_num));
			Hall_A_1_remap_edit.setText(Integer.toString(Hall_A_1_remap));
			Iac_limit_level_edit.setText(Integer.toString(Iac_limit_level));
			Hall_A_2_remap_edit.setText(Integer.toString(Hall_A_2_remap));
			Angle_degree_BDir_edit.setText(Integer.toString(Angle_degree_BDir));
			Hall_A_3_remap_edit.setText(Integer.toString(Hall_A_3_remap));
			Angle_offset_square_edit.setText(Integer.toString(Angle_offset_square));
			Hall_A_4_remap_edit.setText(Integer.toString(Hall_A_4_remap));
			Vdc_filter_edit.setText(Integer.toString(Vdc_filter));
			Hall_A_5_remap_edit.setText(Integer.toString(Hall_A_5_remap));
			Idc_filter_edit.setText(Integer.toString(Idc_filter));
			Hall_A_6_remap_edit.setText(Integer.toString(Hall_A_6_remap));
			Tref_filter_edit.setText(Integer.toString(Tref_filter));
			Hall_group_edit.setText(Integer.toString(Hall_group));
			Temperature_filter_edit.setText(Integer.toString(Temperature_filter));
			ECO_Iqref_2krpm_edit.setText(Integer.toString(ECO_Iqref_2krpm));
			ECO_Iqref_1krpm_edit.setText(Integer.toString(ECO_Iqref_1krpm));
			ECO_Iqref_2_5krpm_edit.setText(Integer.toString(ECO_Iqref_2_5krpm));
			ECO_Iqref_1_5krpm_edit.setText(Integer.toString(ECO_Iqref_1_5krpm));
			ECO_Iqref_3krpm_edit.setText(Integer.toString(ECO_Iqref_3krpm));
		}
	};
	
			
	public static Handler motor_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.MOTOR_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.motor);
		toast = Toast.makeText(motor_config.this,"motor_config写入成功",Toast.LENGTH_LONG);
		 Pole_pair_num_edit = (EditText)findViewById(R.id.editText_ppn);
		 Hall_A_1_remap_edit = (EditText)findViewById(R.id.editText_ha1r);
		 Iac_limit_level_edit = (EditText)findViewById(R.id.editText_ill);
		 Hall_A_2_remap_edit = (EditText)findViewById(R.id.editText_ha2r);
		 Angle_degree_BDir_edit = (EditText)findViewById(R.id.editText_adb);
		 Hall_A_3_remap_edit = (EditText)findViewById(R.id.editText_ha3r);
		 Angle_offset_square_edit = (EditText)findViewById(R.id.editText_aos);
		 Hall_A_4_remap_edit = (EditText)findViewById(R.id.editText_ha4r);
		 Vdc_filter_edit = (EditText)findViewById(R.id.editText_vf);
		 Hall_A_5_remap_edit = (EditText)findViewById(R.id.editText_ha5r);
		 Idc_filter_edit = (EditText)findViewById(R.id.editText_if);
		 Hall_A_6_remap_edit = (EditText)findViewById(R.id.editText_ha6r);
		 Tref_filter_edit = (EditText)findViewById(R.id.editText_tf);
		 Hall_group_edit = (EditText)findViewById(R.id.editText_hg);
		 Temperature_filter_edit = (EditText)findViewById(R.id.editText_tempf);
		 ECO_Iqref_2krpm_edit = (EditText)findViewById(R.id.editText_ei2);
		 ECO_Iqref_1krpm_edit = (EditText)findViewById(R.id.editText_ei1);
		 ECO_Iqref_2_5krpm_edit = (EditText)findViewById(R.id.editText_ei2dot5);
		 ECO_Iqref_1_5krpm_edit = (EditText)findViewById(R.id.editText_ei1dot5);
		 ECO_Iqref_3krpm_edit = (EditText)findViewById(R.id.editText_ei3);
		
		
		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.MOTOR_READ));
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
				Motor motor_write = new Motor();
				try
				{
			
				motor_write.Pole_pair_num = Integer.parseInt(Pole_pair_num_edit.getText().toString());
				motor_write.Hall_A_1_remap = Integer.parseInt(Hall_A_1_remap_edit.getText().toString());
				motor_write.Iac_limit_level = Integer.parseInt(Iac_limit_level_edit.getText().toString());
				motor_write.Hall_A_2_remap = Integer.parseInt(Hall_A_2_remap_edit.getText().toString());
				motor_write.Angle_degree_BDir = Integer.parseInt(Angle_degree_BDir_edit.getText().toString());
				motor_write.Hall_A_3_remap = Integer.parseInt(Hall_A_3_remap_edit.getText().toString());
				motor_write.Angle_offset_square = Integer.parseInt(Angle_offset_square_edit.getText().toString());
				motor_write.Hall_A_4_remap = Integer.parseInt(Hall_A_4_remap_edit.getText().toString());
				motor_write.Vdc_filter = Integer.parseInt(Vdc_filter_edit.getText().toString());
				motor_write.Hall_A_5_remap = Integer.parseInt(Hall_A_5_remap_edit.getText().toString());
				motor_write.Idc_filter = Integer.parseInt(Idc_filter_edit.getText().toString());
				motor_write.Hall_A_6_remap = Integer.parseInt(Hall_A_6_remap_edit.getText().toString());
				motor_write.Tref_filter = Integer.parseInt(Tref_filter_edit.getText().toString());
				motor_write.Hall_group = Integer.parseInt(Hall_group_edit.getText().toString());
				motor_write.Temperature_filter = Integer.parseInt(Temperature_filter_edit.getText().toString());
				motor_write.ECO_Iqref_2krpm = Integer.parseInt(ECO_Iqref_2krpm_edit.getText().toString());
				motor_write.ECO_Iqref_1krpm = Integer.parseInt(ECO_Iqref_1krpm_edit.getText().toString());
				motor_write.ECO_Iqref_2_5krpm = Integer.parseInt(ECO_Iqref_2_5krpm_edit.getText().toString());
				motor_write.ECO_Iqref_1_5krpm = Integer.parseInt(ECO_Iqref_1_5krpm_edit.getText().toString());
				motor_write.ECO_Iqref_3krpm = Integer.parseInt(ECO_Iqref_3krpm_edit.getText().toString());
				NAN_error = 0;
			}
			
			catch(NumberFormatException e)
			{
				Toast NAN = Toast.makeText(motor_config.this,"请输入有效的值",Toast.LENGTH_LONG);
				NAN.show();
				NAN_error = 1;
			}
			
			if(NAN_error == 0)
			{
				
				try {
					StartActivity.myblueTooth.write(motor_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
}
}
