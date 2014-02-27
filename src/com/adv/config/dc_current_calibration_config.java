package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.DC_Current_Calibration;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class dc_current_calibration_config extends Activity{

	static int Idc_gain = -1;
	static int Idc_D2_power = -1;
	static int Iac_ADC_Value_128A = -1;
	static int Flux_period = -1;
	static int Reference_period = -1;
	static int Mot_over_heat = -1;
	static int Mot_high_temperature = -1;
	static int Mot_oh_recover = -1;
	
	static int SN_p = -1;
	static int SN_y = -1;
	static int SN_w = -1;
	static int SN_sn = -1;
	static int SN_cc = -1;
	
	static int BHA = -1;
	static int BLA = -1;
	
	static int Forward_level = -1;
	static int Brake_high_level = -1;
	static int Backward_level = -1;
	static int Brake_low_level = -1;
	
	static int NAN_error = 0;
	
	static  EditText Idc_gain_edit;
	static  EditText Idc_D2_power_edit;
	static  EditText Iac_ADC_Value_128A_edit;
	static  EditText Flux_period_edit;
	static  EditText Reference_period_edit;
	static  EditText Mot_over_heat_edit;
	static  EditText Mot_high_temperature_edit;
	static  EditText Mot_oh_recover_edit;
	
	static  EditText SN_p_edit;
	static  EditText SN_y_edit;
	static  EditText SN_w_edit;
	static  EditText SN_sn_edit;
	static  EditText SN_cc_edit;
	
	static  CheckBox BHA_edit;
	static  CheckBox BLA_edit;
	
	static  Button Forward_level_edit;
	static  Button Brake_high_level_edit;
	static  Button Backward_level_edit;
	static  Button Brake_low_level_edit;
	
	final  Activity activity = this;
	static Toast toast;
	
	private static boolean castInt(int temp) {
		if(temp==1)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	private int castBoolean(boolean checked) {
		if(checked == true)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	
	
	private static String castString(int status)
	{
		if(status==1)
		{
			return "H";
		}
		else
		{
			return "L";
		}
	}
	
	private int castFromString(String status)
	{
		if(status=="H")
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static Handler dc_current_calibration_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{
			
			DC_Current_Calibration dc_current_calibration_received = (DC_Current_Calibration)msg.obj;
			Idc_gain = dc_current_calibration_received.Idc_gain;
			Idc_D2_power = dc_current_calibration_received.Idc_D2_power;
			Iac_ADC_Value_128A = dc_current_calibration_received.Iac_ADC_Value_128A;
			Flux_period = dc_current_calibration_received.Flux_period;
			Reference_period = dc_current_calibration_received.Reference_period;
			Mot_over_heat = dc_current_calibration_received.Mot_over_heat;
			Mot_high_temperature = dc_current_calibration_received.Mot_high_temperature;
			Mot_oh_recover = dc_current_calibration_received.Mot_oh_recover;
			
			SN_p = dc_current_calibration_received.Serial_num_project;
			SN_y = dc_current_calibration_received.Serial_num_year;
			SN_w = dc_current_calibration_received.Serial_num_week;
			SN_sn = dc_current_calibration_received.Serial_num_serial_num;
			SN_cc = dc_current_calibration_received.Serial_num_customer_code;
			
			BHA = dc_current_calibration_received.BHA;
			BLA = dc_current_calibration_received.BLA;
			Forward_level = dc_current_calibration_received.Forward_level;
			Brake_high_level = dc_current_calibration_received.Brake_high_level;
			Backward_level = dc_current_calibration_received.Backward_level;
			Brake_low_level = dc_current_calibration_received.Brake_low_level;
			
			Idc_gain_edit.setText(Integer.toString(Idc_gain));
			Idc_D2_power_edit.setText(Integer.toString(Idc_D2_power));
			Iac_ADC_Value_128A_edit.setText(Integer.toString(Iac_ADC_Value_128A));
			Flux_period_edit.setText(Integer.toString(Flux_period));
			Reference_period_edit.setText(Integer.toString(Reference_period));
			Mot_over_heat_edit.setText(Integer.toString(Mot_over_heat));
			Mot_high_temperature_edit.setText(Integer.toString(Mot_high_temperature));
			Mot_oh_recover_edit.setText(Integer.toString(Mot_oh_recover));
			
			SN_p_edit.setText(Integer.toString(SN_p));
			SN_y_edit.setText(Integer.toString(SN_y));
			SN_w_edit.setText(Integer.toString(SN_w));
			SN_sn_edit.setText(Integer.toString(SN_sn));
			SN_cc_edit.setText(Integer.toString(SN_cc));
			
			BHA_edit.setChecked(castInt(BHA));
			BLA_edit.setChecked(castInt(BLA));
			
			Forward_level_edit.setText(castString(Forward_level));
			Brake_high_level_edit.setText(castString(Brake_high_level));
			Backward_level_edit.setText(castString(Backward_level));
			Brake_low_level_edit.setText(castString(Brake_low_level));
			
			
		}
	};
	
			
	public static Handler dc_current_calibration_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.DC_CURRENT_CALIBRATION_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dc_current_calibration);
		toast = Toast.makeText(dc_current_calibration_config.this,"dc_current_calibration_config写入成功",Toast.LENGTH_LONG);
		 Idc_gain_edit = (EditText)findViewById(R.id.editText_ig);
		 Idc_D2_power_edit = (EditText)findViewById(R.id.editText_idp);
		 Iac_ADC_Value_128A_edit = (EditText)findViewById(R.id.editText_iav1);
		 Flux_period_edit = (EditText)findViewById(R.id.editText_fp);
		 Reference_period_edit = (EditText)findViewById(R.id.editText_rp);
		 Mot_over_heat_edit = (EditText)findViewById(R.id.editText_moh);
		 Mot_high_temperature_edit = (EditText)findViewById(R.id.editText_mht);
		 Mot_oh_recover_edit = (EditText)findViewById(R.id.editText_mor);
		
		 SN_p_edit = (EditText)findViewById(R.id.editText_snp);
		 SN_y_edit = (EditText)findViewById(R.id.editText_sny);
		 SN_w_edit = (EditText)findViewById(R.id.editText_snw);
		 SN_sn_edit = (EditText)findViewById(R.id.editText_snsn);
		 SN_cc_edit = (EditText)findViewById(R.id.editText_sncc);
		
		BHA_edit = (CheckBox)findViewById(R.id.checkBox_bha);
		BLA_edit = (CheckBox)findViewById(R.id.checkBox_bla);
		
		Forward_level_edit = (Button)findViewById(R.id.button_fl);
		Brake_high_level_edit = (Button)findViewById(R.id.button_bhl);
		Backward_level_edit = (Button)findViewById(R.id.button_bl);
		Brake_low_level_edit = (Button)findViewById(R.id.button_bll);
		
		Forward_level_edit.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				if(Forward_level_edit.getText()!="L")
				{
					Forward_level_edit.setText("L");
				}
				else
				{
					Forward_level_edit.setText("H");
				}
			}
		});
		
		Brake_high_level_edit.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				if(Brake_high_level_edit.getText()!="L")
				{
					Brake_high_level_edit.setText("L");
				}
				else
				{
					Brake_high_level_edit.setText("H");
				}
			}
		});
		
		Backward_level_edit.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				if(Backward_level_edit.getText()!="L")
				{
					Backward_level_edit.setText("L");
				}
				else
				{
					Backward_level_edit.setText("H");
				}
			}
		});
		
		Brake_low_level_edit.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				if(Brake_low_level_edit.getText()!="L")
				{
					Brake_low_level_edit.setText("L");
				}
				else
				{
					Brake_low_level_edit.setText("H");
				}
			}
		});
		
		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.DC_CURRENT_CALIBRATION_READ));
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
				DC_Current_Calibration dc_current_calibration_write = new DC_Current_Calibration();
				try
				{
				dc_current_calibration_write.Idc_gain = Integer.parseInt(Idc_gain_edit.getText().toString());
				dc_current_calibration_write.Idc_D2_power = Integer.parseInt(Idc_D2_power_edit.getText().toString());
				dc_current_calibration_write.Iac_ADC_Value_128A = Integer.parseInt(Iac_ADC_Value_128A_edit.getText().toString());
				dc_current_calibration_write.Flux_period = Integer.parseInt(Flux_period_edit.getText().toString());
				dc_current_calibration_write.Reference_period = Integer.parseInt(Reference_period_edit.getText().toString());
				dc_current_calibration_write.Mot_over_heat = Integer.parseInt(Mot_over_heat_edit.getText().toString());
				dc_current_calibration_write.Mot_high_temperature = Integer.parseInt(Mot_high_temperature_edit.getText().toString());
				dc_current_calibration_write.Mot_oh_recover = Integer.parseInt(Mot_oh_recover_edit.getText().toString());
				dc_current_calibration_write.Serial_num_project = Integer.parseInt(SN_p_edit.getText().toString());
				dc_current_calibration_write.Serial_num_year = Integer.parseInt(SN_y_edit.getText().toString());
				dc_current_calibration_write.Serial_num_week = Integer.parseInt(SN_w_edit.getText().toString());
				dc_current_calibration_write.Serial_num_serial_num = Integer.parseInt(SN_sn_edit.getText().toString());
				dc_current_calibration_write.Serial_num_customer_code = Integer.parseInt(SN_cc_edit.getText().toString());
				
				dc_current_calibration_write.BHA = castBoolean(BHA_edit.isChecked());
				dc_current_calibration_write.BLA = castBoolean(BLA_edit.isChecked());
				
				dc_current_calibration_write.Forward_level = castFromString(Forward_level_edit.getText().toString());
				dc_current_calibration_write.Brake_high_level = castFromString(Brake_high_level_edit.getText().toString());
				dc_current_calibration_write.Backward_level = castFromString(Backward_level_edit.getText().toString());
				dc_current_calibration_write.Brake_low_level = castFromString(Brake_low_level_edit.getText().toString());
				NAN_error = 0;
				}
			
				catch(NumberFormatException e)
				{
					Toast NAN = Toast.makeText(dc_current_calibration_config.this,"请输入有效的值",Toast.LENGTH_LONG);
					NAN.show();
					NAN_error = 1;
				}
				
				if(NAN_error == 0)
				{
					
				try {
					StartActivity.myblueTooth.write(dc_current_calibration_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
	}
}
