package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.Other;
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

public class other_config extends Activity{
	static int Filter_of_Hall = -1;
	static int Forward_enable = -1;
	static int Speed_of_flux_quit = -1;
	static int Backward_enable = -1;
	static int Backward_speed = -1;
	static int Brake_drive_stop_enable = -1;
	static int Percentage_in_mid_tref = -1;
	static int Motor_protection_enable = -1;
	static int Flux_Acc = -1;
	static int Flux_Dec = -1;
	static int hFlux_Quit = -1;
	static int hTorque_Reg_ACC = -1;
	static int Dec_of_tref = -1;
	static int hTorque_Reg_DEC = -1;
	static int ECO_Iqref_3_5krpm = -1;
	static int Motor_switch_T = -1;
	static int ECO_Iqref_4krpm = -1;
	static int ECO_Motor_protection_enable = -1;
	static int ECO_Backward_enable = -1;
	static int ECO_Flux_Dec = -1;
	static int MotorT_hysteretic = -1;
	static int ECO_Iqref_4_5krpm = -1;

	static int NAN_error = 0;
	
	static EditText Filter_of_Hall_edit;
	static CheckBox Forward_enable_edit;
	static EditText Speed_of_flux_quit_edit;
	static CheckBox Backward_enable_edit;
	static EditText Backward_speed_edit;
	static CheckBox Brake_drive_stop_enable_edit;
	static EditText Percentage_in_mid_tref_edit;
	static CheckBox Motor_protection_enable_edit;
	static EditText Flux_Acc_edit;
	static EditText Flux_Dec_edit;
	static EditText hFlux_Quit_edit;
	static EditText hTorque_Reg_ACC_edit;
	static EditText Dec_of_tref_edit;
	static EditText hTorque_Reg_DEC_edit;
	static EditText ECO_Iqref_3_5krpm_edit;
	static EditText Motor_switch_T_edit;
	static EditText ECO_Iqref_4krpm_edit;
	static EditText MotorT_hysteretic_edit;
	static EditText ECO_Iqref_4_5krpm_edit;
	
	final Activity activity = this;
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
	
	public static Handler other_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{
			Other other_received = (Other)msg.obj;
			Filter_of_Hall = other_received.Filter_of_Hall;
			Forward_enable= other_received.Forward_enable;
			Speed_of_flux_quit= other_received.Speed_of_flux_quit;
			Backward_enable= other_received.Backward_enable;
			Backward_speed= other_received.Backward_speed;
			Brake_drive_stop_enable= other_received.Brake_drive_stop_enable;
			Percentage_in_mid_tref= other_received.Percentage_in_mid_tref;
			Motor_protection_enable= other_received.Motor_protection_enable;
			Flux_Acc= other_received.Flux_Acc;
			Flux_Dec= other_received.Flux_Dec;
			hFlux_Quit= other_received.hFlux_Quit;
			hTorque_Reg_ACC= other_received.hTorque_Reg_ACC;
			Dec_of_tref= other_received.Dec_of_tref;
			hTorque_Reg_DEC = other_received.hTorque_Reg_DEC;
			ECO_Iqref_3_5krpm = other_received.ECO_Iqref_3_5krpm;
			Motor_switch_T = other_received.Motor_switch_T;
			ECO_Iqref_4krpm = other_received.ECO_Iqref_4krpm;
			MotorT_hysteretic = other_received.MotorT_hysteretic;
			ECO_Iqref_4_5krpm = other_received.ECO_Iqref_4_5krpm;
			
			Filter_of_Hall_edit.setText(Integer.toString(Filter_of_Hall));
			Forward_enable_edit.setChecked(castInt(Forward_enable));
			Speed_of_flux_quit_edit.setText(Integer.toString(Speed_of_flux_quit));
			Backward_enable_edit.setChecked(castInt(Backward_enable));
			Backward_speed_edit.setText(Integer.toString(Backward_speed));
			Brake_drive_stop_enable_edit.setChecked(castInt(Brake_drive_stop_enable));
			Percentage_in_mid_tref_edit.setText(Integer.toString(Percentage_in_mid_tref));
			Motor_protection_enable_edit.setChecked(castInt(Motor_protection_enable));
			Flux_Acc_edit.setText(Integer.toString(Flux_Acc));
			Flux_Dec_edit.setText(Integer.toString(Flux_Dec));
			hFlux_Quit_edit.setText(Integer.toString(hFlux_Quit));
			hTorque_Reg_ACC_edit.setText(Integer.toString(hTorque_Reg_ACC));
			Dec_of_tref_edit.setText(Integer.toString(Dec_of_tref));
			hTorque_Reg_DEC_edit.setText(Integer.toString(hTorque_Reg_DEC));
			ECO_Iqref_3_5krpm_edit.setText(Integer.toString(ECO_Iqref_3_5krpm));
			Motor_switch_T_edit.setText(Integer.toString(Motor_switch_T));
			ECO_Iqref_4krpm_edit.setText(Integer.toString(ECO_Iqref_4krpm));
			MotorT_hysteretic_edit.setText(Integer.toString(MotorT_hysteretic));
			ECO_Iqref_4_5krpm_edit.setText(Integer.toString(ECO_Iqref_4_5krpm));
		}
	};
	
			
	public static Handler other_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.OTHER_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		toast = Toast.makeText(other_config.this,"other_config写入成功",Toast.LENGTH_LONG);
		 Filter_of_Hall_edit = (EditText)findViewById(R.id.editText_foh);
		 Forward_enable_edit = (CheckBox)findViewById(R.id.checkBox_fe);
		 Speed_of_flux_quit_edit = (EditText)findViewById(R.id.editText_sofq);
		 Backward_enable_edit = (CheckBox)findViewById(R.id.checkBox_be);
		 Backward_speed_edit = (EditText)findViewById(R.id.editText_bs);
		 Brake_drive_stop_enable_edit = (CheckBox)findViewById(R.id.checkBox_bdse);
		 Percentage_in_mid_tref_edit = (EditText)findViewById(R.id.editText_pimt);
		 Motor_protection_enable_edit = (CheckBox)findViewById(R.id.checkBox_mpe);
		 Flux_Acc_edit = (EditText)findViewById(R.id.editText_fa);
		 Flux_Dec_edit = (EditText)findViewById(R.id.editText_fd);
		 hFlux_Quit_edit = (EditText)findViewById(R.id.editText_hq);
		 hTorque_Reg_ACC_edit = (EditText)findViewById(R.id.editText_hra);
		 Dec_of_tref_edit = (EditText)findViewById(R.id.editText_dot);
		 hTorque_Reg_DEC_edit = (EditText)findViewById(R.id.editText_hrd);
		 ECO_Iqref_3_5krpm_edit = (EditText)findViewById(R.id.editText_ei3dot5);
		 Motor_switch_T_edit = (EditText)findViewById(R.id.editText_mst);
		 ECO_Iqref_4krpm_edit = (EditText)findViewById(R.id.editText_ei4);
		 MotorT_hysteretic_edit = (EditText)findViewById(R.id.editText_mh);
		 ECO_Iqref_4_5krpm_edit = (EditText)findViewById(R.id.editText_ei4dot5);
		
		
		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.OTHER_READ));
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
				Other other_write = new Other();
				try
				{
				other_write.Filter_of_Hall = Integer.parseInt(Filter_of_Hall_edit.getText().toString());
				other_write.Forward_enable = castBoolean(Forward_enable_edit.isChecked());
				other_write.Speed_of_flux_quit = Integer.parseInt(Speed_of_flux_quit_edit.getText().toString());
				other_write.Backward_enable = castBoolean(Backward_enable_edit.isChecked());
				other_write.Backward_speed = Integer.parseInt(Backward_speed_edit.getText().toString());
				other_write.Brake_drive_stop_enable = castBoolean(Brake_drive_stop_enable_edit.isChecked());
				other_write.Percentage_in_mid_tref = Integer.parseInt(Percentage_in_mid_tref_edit.getText().toString());
				other_write.Motor_protection_enable = castBoolean(Motor_protection_enable_edit.isChecked());
				other_write.Flux_Acc = Integer.parseInt(Flux_Acc_edit.getText().toString());
				other_write.Flux_Dec = Integer.parseInt(Flux_Dec_edit.getText().toString());
				other_write.hFlux_Quit = Integer.parseInt(hFlux_Quit_edit.getText().toString());
				other_write.hTorque_Reg_ACC = Integer.parseInt(hTorque_Reg_ACC_edit.getText().toString());
				other_write.Dec_of_tref = Integer.parseInt(Dec_of_tref_edit.getText().toString());
				other_write.hTorque_Reg_DEC = Integer.parseInt(hTorque_Reg_DEC_edit.getText().toString());
				other_write.ECO_Iqref_3_5krpm = Integer.parseInt(ECO_Iqref_3_5krpm_edit.getText().toString());
				other_write.Motor_switch_T = Integer.parseInt(Motor_switch_T_edit.getText().toString());
				other_write.ECO_Iqref_4krpm = Integer.parseInt(ECO_Iqref_4krpm_edit.getText().toString());
				other_write.MotorT_hysteretic = Integer.parseInt(MotorT_hysteretic_edit.getText().toString());
				other_write.ECO_Iqref_4_5krpm = Integer.parseInt(ECO_Iqref_4_5krpm_edit.getText().toString());
				NAN_error = 0;
			}
			
			catch(NumberFormatException e)
			{
				Toast NAN = Toast.makeText(other_config.this,"请输入有效的值",Toast.LENGTH_LONG);
				NAN.show();
				NAN_error = 1;
			}
			
			if(NAN_error == 0)
			{
				
				
				try {
					StartActivity.myblueTooth.write(other_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		});
	}
}
