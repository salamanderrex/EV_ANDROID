package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.Reference;
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

public class reference_config extends Activity{
	static int squ_angle_step_int = -1;
	static int Class_of_Iac = -1;
	static int Angle_offset_FDIR = -1;
	static int Acc_of_Tref = -1;
	static int HALL_60_360_Switch = -1;
	static int Vdc_of_Idc_limit = -1;
	static int Vdc_of_Regen_stop = -1;
	static int Vdc_of_Idc_min = -1;
	static int Vdc_of_full_regen = -1;
	static int Idc_percent_min = -1;
	static int StartupPercentageFast = -1;
	static int StepSquareStart = -1;
	static int Temperature_limit = -1;

	static int NAN_error = 0;
	
	static EditText squ_angle_step_int_edit;
	static EditText Class_of_Iac_edit;
	static EditText Angle_offset_FDIR_edit;
	static EditText Acc_of_Tref_edit;
	static EditText HALL_60_360_Switch_edit;
	static EditText Vdc_of_Idc_limit_edit;
	static EditText Vdc_of_Regen_stop_edit;
	static EditText Vdc_of_Idc_min_edit;
	static EditText Vdc_of_full_regen_edit;
	static EditText Idc_percent_min_edit;
	static EditText StartupPercentageFast_edit;
	static EditText StepSquareStart_edit;
	static EditText Temperature_limit_edit;
		
	final Activity activity = this;
	static Toast toast;
	
	public static Handler reference_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{	
			Reference reference_received = (Reference)msg.obj;
			squ_angle_step_int = reference_received.Squ_angle_step_int;
			Class_of_Iac= reference_received.Class_of_Iac;
			Angle_offset_FDIR= reference_received.Angle_offset_FDIR;
			Acc_of_Tref= reference_received.Acc_of_Tref;
			HALL_60_360_Switch= reference_received.HALL_60_360_Switch;
			Vdc_of_Idc_limit= reference_received.Vdc_of_Idc_limit;
			Vdc_of_Regen_stop= reference_received.Vdc_of_Regen_stop;
			Vdc_of_Idc_min= reference_received.Vdc_of_Idc_min;
			Vdc_of_full_regen= reference_received.Vdc_of_full_regen;
			Idc_percent_min= reference_received.Idc_percent_min;
			StartupPercentageFast= reference_received.StartupPercentage_Fast;
			StepSquareStart= reference_received.StepSquareStart;
			Temperature_limit= reference_received.Temperature_limit;
			
			squ_angle_step_int_edit.setText(Integer.toString(squ_angle_step_int));
			Class_of_Iac_edit.setText(Integer.toString(Class_of_Iac));
			Angle_offset_FDIR_edit.setText(Integer.toString(Angle_offset_FDIR));
			Acc_of_Tref_edit.setText(Integer.toString(Acc_of_Tref));
			HALL_60_360_Switch_edit.setText(Integer.toString(HALL_60_360_Switch));
			Vdc_of_Idc_limit_edit.setText(Integer.toString(Vdc_of_Idc_limit));
			Vdc_of_Regen_stop_edit.setText(Integer.toString(Vdc_of_Regen_stop));
			Vdc_of_Idc_min_edit.setText(Integer.toString(Vdc_of_Idc_min));
			Vdc_of_full_regen_edit.setText(Integer.toString(Vdc_of_full_regen));
			Idc_percent_min_edit.setText(Integer.toString(Idc_percent_min));
			StartupPercentageFast_edit.setText(Integer.toString(StartupPercentageFast));
			StepSquareStart_edit.setText(Integer.toString(StepSquareStart));
			Temperature_limit_edit.setText(Integer.toString(Temperature_limit));
		}
	};
	
			
	public static Handler reference_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.REFERENCE_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reference);
		toast = Toast.makeText(reference_config.this,"reference_config写入成功",Toast.LENGTH_LONG);
		 squ_angle_step_int_edit = (EditText)findViewById(R.id.editText_sasi);
		 Class_of_Iac_edit = (EditText)findViewById(R.id.editText_coi);
		 Angle_offset_FDIR_edit = (EditText)findViewById(R.id.editText_aof);
		 Acc_of_Tref_edit = (EditText)findViewById(R.id.editText_aot);
		 HALL_60_360_Switch_edit = (EditText)findViewById(R.id.editText_h63s);
		 Vdc_of_Idc_limit_edit = (EditText)findViewById(R.id.editText_voil);
		 Vdc_of_Regen_stop_edit = (EditText)findViewById(R.id.editText_vors);
		 Vdc_of_Idc_min_edit = (EditText)findViewById(R.id.editText_voim);
		 Vdc_of_full_regen_edit = (EditText)findViewById(R.id.editText_vofr);
		 Idc_percent_min_edit = (EditText)findViewById(R.id.editText_ipm);
		 StartupPercentageFast_edit = (EditText)findViewById(R.id.editText_spf);
		 StepSquareStart_edit = (EditText)findViewById(R.id.editText_sss);
		 Temperature_limit_edit = (EditText)findViewById(R.id.editText_tl);
		
		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.REFERENCE_READ));
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
				Reference reference_write = new Reference();
				try
				{
				reference_write.Squ_angle_step_int = Integer.parseInt(squ_angle_step_int_edit.getText().toString());
				reference_write.Class_of_Iac = Integer.parseInt(Class_of_Iac_edit.getText().toString());
				reference_write.Angle_offset_FDIR = Integer.parseInt(Angle_offset_FDIR_edit.getText().toString());
				reference_write.Acc_of_Tref = Integer.parseInt(Acc_of_Tref_edit.getText().toString());
				reference_write.HALL_60_360_Switch = Integer.parseInt(HALL_60_360_Switch_edit.getText().toString());
				reference_write.Vdc_of_Idc_limit = Integer.parseInt(Vdc_of_Idc_limit_edit.getText().toString());
				reference_write.Vdc_of_Regen_stop = Integer.parseInt(Vdc_of_Regen_stop_edit.getText().toString());
				reference_write.Vdc_of_Idc_min = Integer.parseInt(Vdc_of_Idc_min_edit.getText().toString());
				reference_write.Vdc_of_full_regen = Integer.parseInt(Vdc_of_full_regen_edit.getText().toString());
				reference_write.Idc_percent_min = Integer.parseInt(Idc_percent_min_edit.getText().toString());
				reference_write.StartupPercentage_Fast = Integer.parseInt(StartupPercentageFast_edit.getText().toString());
				reference_write.StepSquareStart = Integer.parseInt(StepSquareStart_edit.getText().toString());
				reference_write.Temperature_limit = Integer.parseInt(Temperature_limit_edit.getText().toString());
				NAN_error = 0;
			}
			
			catch(NumberFormatException e)
			{
				Toast NAN = Toast.makeText(reference_config.this,"请输入有效的值",Toast.LENGTH_LONG);
				NAN.show();
				NAN_error = 1;
			}
			
			if(NAN_error == 0)
			{
				try {
					StartActivity.myblueTooth.write(reference_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		});
}
}
