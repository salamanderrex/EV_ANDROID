package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.Control;
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

public class control_config extends Activity{
	static int Torque_Kp_G = -1;
	static int Speed_limit_kp_G = -1;
	static int Torque_Kp_D = -1;
	static int Speed_limit_kp_D = -1;
	static int Torque_Ki_G_LS = -1;
	static int Speed_limit_ki_G = -1;
	static int Flux_Kp_G = -1;
	static int Idc_limit_kp_G = -1;
	static int Flux_Kp_D = -1;
	static int Idc_limit_kp_D = -1;
	static int Flux_Ki_G_Ls = -1;
	static int Idc_limit_ki_G = -1;
	static int Eco_speed_kp_G = -1;
	static int Eco_speed_ki_G = -1;
	static int Eco_speed_kp_D = -1;

	static int NAN_error = 0;
	
	static EditText Torque_Kp_G_edit;
	static EditText Speed_limit_kp_G_edit;
	static EditText Torque_Kp_D_edit;
	static EditText Speed_limit_kp_D_edit;
	static EditText Torque_Ki_G_LS_edit;
	static EditText Speed_limit_ki_G_edit;
	static EditText Flux_Kp_G_edit;
	static EditText Idc_limit_kp_G_edit;
	static EditText Flux_Kp_D_edit;
	static EditText Idc_limit_kp_D_edit;
	static EditText Flux_Ki_G_Ls_edit;
	static EditText Idc_limit_ki_G_edit;
	static EditText Eco_speed_kp_G_edit;
	static EditText Eco_speed_ki_G_edit;
	static EditText Eco_speed_kp_D_edit;
	
	final Activity activity = this;
	static Toast toast;
	
	public static Handler control_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{
			
			Control reference_received = (Control)msg.obj;
			Torque_Kp_G = reference_received.Torque_Kp_G;
			Speed_limit_kp_G= reference_received.Speed_limit_kp_G;
			Torque_Kp_D= reference_received.Torque_Kp_D;
			Speed_limit_kp_D= reference_received.Speed_limit_kp_D;
			Torque_Ki_G_LS= reference_received.Torque_Ki_G_LS;
			Speed_limit_ki_G= reference_received.Speed_limit_ki_G;
			Flux_Kp_G= reference_received.Flux_Kp_G;
			Idc_limit_kp_G= reference_received.Idc_limit_kp_G;
			Flux_Kp_D= reference_received.Flux_Kp_D;
			Idc_limit_kp_D= reference_received.Idc_limit_kp_D;
			Flux_Ki_G_Ls= reference_received.Flux_Ki_G_Ls;
			Idc_limit_ki_G= reference_received.Idc_limit_ki_G;
			Eco_speed_kp_G= reference_received.Eco_speed_kp_G;
			Eco_speed_ki_G = reference_received.Eco_speed_ki_G;
			Eco_speed_kp_D = reference_received.Eco_speed_kp_D;
			
			Torque_Kp_G_edit.setText(Integer.toString(Torque_Kp_G));
			Speed_limit_kp_G_edit.setText(Integer.toString(Speed_limit_kp_G));
			Torque_Kp_D_edit.setText(Integer.toString(Torque_Kp_D));
			Speed_limit_kp_D_edit.setText(Integer.toString(Speed_limit_kp_D));
			Torque_Ki_G_LS_edit.setText(Integer.toString(Torque_Ki_G_LS));
			Speed_limit_ki_G_edit.setText(Integer.toString(Speed_limit_ki_G));
			Flux_Kp_G_edit.setText(Integer.toString(Flux_Kp_G));
			Idc_limit_kp_G_edit.setText(Integer.toString(Idc_limit_kp_G));
			Flux_Kp_D_edit.setText(Integer.toString(Flux_Kp_D));
			Idc_limit_kp_D_edit.setText(Integer.toString(Idc_limit_kp_D));
			Flux_Ki_G_Ls_edit.setText(Integer.toString(Flux_Ki_G_Ls));
			Idc_limit_ki_G_edit.setText(Integer.toString(Idc_limit_ki_G));
			Eco_speed_kp_G_edit.setText(Integer.toString(Eco_speed_kp_G));
			Eco_speed_ki_G_edit.setText(Integer.toString(Eco_speed_ki_G));
			Eco_speed_kp_D_edit.setText(Integer.toString(Eco_speed_kp_D));

		}
	};
	
			
	public static Handler control_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.CONTROL_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.control);
		toast = Toast.makeText(control_config.this,"control_config写入成功",Toast.LENGTH_LONG);				
		 Torque_Kp_G_edit = (EditText)findViewById(R.id.editText_tkg);
		 Speed_limit_kp_G_edit = (EditText)findViewById(R.id.editText_slkpg);
		 Torque_Kp_D_edit = (EditText)findViewById(R.id.editText_tkd);
		 Speed_limit_kp_D_edit = (EditText)findViewById(R.id.editText_slkd);
		 Torque_Ki_G_LS_edit = (EditText)findViewById(R.id.editText_tkgl);
		 Speed_limit_ki_G_edit = (EditText)findViewById(R.id.editText_slkig);
		 Flux_Kp_G_edit = (EditText)findViewById(R.id.editText_fkg);
		 Idc_limit_kp_G_edit = (EditText)findViewById(R.id.editText_ilkpg);
		 Flux_Kp_D_edit = (EditText)findViewById(R.id.editText_fkd);
		 Idc_limit_kp_D_edit = (EditText)findViewById(R.id.editText_ilkd);
		 Flux_Ki_G_Ls_edit = (EditText)findViewById(R.id.editText_fkgl);
		 Idc_limit_ki_G_edit = (EditText)findViewById(R.id.editText_ilkig);
		 Eco_speed_kp_G_edit = (EditText)findViewById(R.id.editText_eskpg);
		 Eco_speed_ki_G_edit = (EditText)findViewById(R.id.editText_eskig);
		 Eco_speed_kp_D_edit = (EditText)findViewById(R.id.editText_eskd);

		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.CONTROL_READ));
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
				Control control_write = new Control();
				try
				{
				control_write.Torque_Kp_G = Integer.parseInt(Torque_Kp_G_edit.getText().toString());
				control_write.Speed_limit_kp_G = Integer.parseInt(Speed_limit_kp_G_edit.getText().toString());
				control_write.Torque_Kp_D = Integer.parseInt(Torque_Kp_D_edit.getText().toString());
				control_write.Speed_limit_kp_D = Integer.parseInt(Speed_limit_kp_D_edit.getText().toString());
				control_write.Torque_Ki_G_LS = Integer.parseInt(Torque_Ki_G_LS_edit.getText().toString());
				control_write.Speed_limit_ki_G = Integer.parseInt(Speed_limit_ki_G_edit.getText().toString());
				control_write.Flux_Kp_G = Integer.parseInt(Flux_Kp_G_edit.getText().toString());
				control_write.Idc_limit_kp_G = Integer.parseInt(Idc_limit_kp_G_edit.getText().toString());
				control_write.Flux_Kp_D = Integer.parseInt(Flux_Kp_D_edit.getText().toString());
				control_write.Idc_limit_kp_D = Integer.parseInt(Idc_limit_kp_D_edit.getText().toString());
				control_write.Flux_Ki_G_Ls = Integer.parseInt(Flux_Ki_G_Ls_edit.getText().toString());
				control_write.Idc_limit_ki_G = Integer.parseInt(Idc_limit_ki_G_edit.getText().toString());
				control_write.Eco_speed_kp_G = Integer.parseInt(Eco_speed_kp_G_edit.getText().toString());
				control_write.Eco_speed_ki_G = Integer.parseInt(Eco_speed_ki_G_edit.getText().toString());
				control_write.Eco_speed_kp_D = Integer.parseInt(Eco_speed_kp_D_edit.getText().toString());
							
				NAN_error = 0;
				}
			
			catch(NumberFormatException e)
			{
				Toast NAN = Toast.makeText(control_config.this,"请输入有效的值",Toast.LENGTH_LONG);
				NAN.show();
				NAN_error = 1;
			}
			
			if(NAN_error == 0)
			{
				
				try {
					StartActivity.myblueTooth.write(control_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
}
}

