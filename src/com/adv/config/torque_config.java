package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.Torque_PID;
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

public class torque_config extends Activity{
	static int Iq_Kp_Gain_0_Pre = -1;
	static int Id_Kp_Gain_0_Pre = -1;
	static int Iq_Ki_Gain_0_Pre = -1;
	static int Id_Ki_Gain_0_Pre = -1;
	static int Iq_Kp_Gain_0 = -1;
	static int Id_Kp_Gain_0 = -1;
	static int Iq_Ki_Gain_0 = -1;
	static int Id_Ki_Gain_0 = -1;
	static int Iq_Kp_Gain_2 = -1;
	static int Id_Kp_Gain_2 = -1;
	static int Iq_Ki_Gain_2 = -1;
	static int Id_Ki_Gain_2 = -1;
	static int Iq_Kp_Gain_3 = -1;
	static int Id_Kp_Gain_3 = -1;
	static int Iq_Ki_Gain_3 = -1;
	static int Id_Ki_Gain_3 = -1;

	static int NAN_error = 0;
	
	static EditText Iq_Kp_Gain_0_Pre_edit;
	static EditText Id_Kp_Gain_0_Pre_edit;
	static EditText Iq_Ki_Gain_0_Pre_edit;
	static EditText Id_Ki_Gain_0_Pre_edit;
	static EditText Iq_Kp_Gain_0_edit;
	static EditText Id_Kp_Gain_0_edit;
	static EditText Iq_Ki_Gain_0_edit;
	static EditText Id_Ki_Gain_0_edit;
	static EditText Iq_Kp_Gain_2_edit;
	static EditText Id_Kp_Gain_2_edit;
	static EditText Iq_Ki_Gain_2_edit;
	static EditText Id_Ki_Gain_2_edit;
	static EditText Iq_Kp_Gain_3_edit;
	static EditText Id_Kp_Gain_3_edit;
	static EditText Iq_Ki_Gain_3_edit;
	static EditText Id_Ki_Gain_3_edit;
	
	final Activity activity = this;
	static Toast toast;
	
	public static Handler torque_receiver = new Handler()
	{
		public void handleMessage(Message msg)
		{
			
			Torque_PID reference_received = (Torque_PID)msg.obj;
			Iq_Kp_Gain_0_Pre = reference_received.Iq_Kp_Gain_0_Pre;
			Id_Kp_Gain_0_Pre= reference_received.Id_Kp_Gain_0_Pre;
			Iq_Ki_Gain_0_Pre= reference_received.Iq_Ki_Gain_0_Pre;
			Id_Ki_Gain_0_Pre= reference_received.Id_Ki_Gain_0_Pre;
			Iq_Kp_Gain_0= reference_received.Iq_Kp_Gain_0;
			Id_Kp_Gain_0= reference_received.Id_Kp_Gain_0;
			Iq_Ki_Gain_0= reference_received.Iq_Ki_Gain_0;
			Id_Ki_Gain_0= reference_received.Id_Ki_Gain_0;
			Iq_Kp_Gain_2= reference_received.Iq_Kp_Gain_2;
			Id_Kp_Gain_2= reference_received.Id_Kp_Gain_2;
			Iq_Ki_Gain_2= reference_received.Iq_Ki_Gain_2;
			Id_Ki_Gain_2= reference_received.Id_Ki_Gain_2;
			Iq_Kp_Gain_3= reference_received.Iq_Kp_Gain_3;
			Id_Kp_Gain_3 = reference_received.Id_Kp_Gain_3;
			Iq_Ki_Gain_3 = reference_received.Iq_Ki_Gain_3;
			Id_Ki_Gain_3 = reference_received.Id_Ki_Gain_3;
			
			Iq_Kp_Gain_0_Pre_edit.setText(Integer.toString(Iq_Kp_Gain_0_Pre));
			Id_Kp_Gain_0_Pre_edit.setText(Integer.toString(Id_Kp_Gain_0_Pre));
			Iq_Ki_Gain_0_Pre_edit.setText(Integer.toString(Iq_Ki_Gain_0_Pre));
			Id_Ki_Gain_0_Pre_edit.setText(Integer.toString(Id_Ki_Gain_0_Pre));
			Iq_Kp_Gain_0_edit.setText(Integer.toString(Iq_Kp_Gain_0));
			Id_Kp_Gain_0_edit.setText(Integer.toString(Id_Kp_Gain_0));
			Iq_Ki_Gain_0_edit.setText(Integer.toString(Iq_Ki_Gain_0));
			Id_Ki_Gain_0_edit.setText(Integer.toString(Id_Ki_Gain_0));
			Iq_Kp_Gain_2_edit.setText(Integer.toString(Iq_Kp_Gain_2));
			Id_Kp_Gain_2_edit.setText(Integer.toString(Id_Kp_Gain_2));
			Iq_Ki_Gain_2_edit.setText(Integer.toString(Iq_Ki_Gain_2));
			Id_Ki_Gain_2_edit.setText(Integer.toString(Id_Ki_Gain_2));
			Iq_Kp_Gain_3_edit.setText(Integer.toString(Iq_Kp_Gain_3));
			Id_Kp_Gain_3_edit.setText(Integer.toString(Id_Kp_Gain_3));
			Iq_Ki_Gain_3_edit.setText(Integer.toString(Iq_Ki_Gain_3));
			Id_Ki_Gain_3_edit.setText(Integer.toString(Id_Ki_Gain_3));

		}
	};
	
			
	public static Handler torque_writer = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == CONSTANT.EVENT.TORQUE_MODIFY)
			{
				toast.show();
			}
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.torque_pid);
		toast = Toast.makeText(torque_config.this,"torque_config写入成功",Toast.LENGTH_LONG);
		 Iq_Kp_Gain_0_Pre_edit = (EditText)findViewById(R.id.editText_iqkpg0p);
		 Id_Kp_Gain_0_Pre_edit = (EditText)findViewById(R.id.editText_idkpg0p);
		 Iq_Ki_Gain_0_Pre_edit = (EditText)findViewById(R.id.editText_iqkig0p);
		 Id_Ki_Gain_0_Pre_edit = (EditText)findViewById(R.id.editText_idkig0p);
		 Iq_Kp_Gain_0_edit = (EditText)findViewById(R.id.editText_iqkpg0);
		 Id_Kp_Gain_0_edit = (EditText)findViewById(R.id.editText_idkpg0);
		 Iq_Ki_Gain_0_edit = (EditText)findViewById(R.id.editText_iqkig0);
		 Id_Ki_Gain_0_edit = (EditText)findViewById(R.id.editText_idkig0);
		 Iq_Kp_Gain_2_edit = (EditText)findViewById(R.id.editText_iqkpg2);
		 Id_Kp_Gain_2_edit = (EditText)findViewById(R.id.editText_idkpg2);
		 Iq_Ki_Gain_2_edit = (EditText)findViewById(R.id.editText_iqkig2);
		 Id_Ki_Gain_2_edit = (EditText)findViewById(R.id.editText_idkig2);
		 Iq_Kp_Gain_3_edit = (EditText)findViewById(R.id.editText_iqkpg3);
		 Id_Kp_Gain_3_edit = (EditText)findViewById(R.id.editText_idkpg3);
		 Iq_Ki_Gain_3_edit = (EditText)findViewById(R.id.editText_iqkig3);
		 Id_Ki_Gain_3_edit = (EditText)findViewById(R.id.editText_idkig3);

		
		
		Button read = (Button)findViewById(R.id.button1);
		Button write = (Button)findViewById(R.id.button2);
		
		read.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg)
			{
				try {
					StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.TORQUE_READ));
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
				Torque_PID torque_write = new Torque_PID();
				try
				{
				torque_write.Iq_Kp_Gain_0_Pre = Integer.parseInt(Iq_Kp_Gain_0_Pre_edit.getText().toString());
				torque_write.Id_Kp_Gain_0_Pre = Integer.parseInt(Id_Kp_Gain_0_Pre_edit.getText().toString());
				torque_write.Iq_Ki_Gain_0_Pre = Integer.parseInt(Iq_Ki_Gain_0_Pre_edit.getText().toString());
				torque_write.Id_Ki_Gain_0_Pre = Integer.parseInt(Id_Ki_Gain_0_Pre_edit.getText().toString());
				torque_write.Iq_Kp_Gain_0 = Integer.parseInt(Iq_Kp_Gain_0_edit.getText().toString());
				torque_write.Id_Kp_Gain_0 = Integer.parseInt(Id_Kp_Gain_0_edit.getText().toString());
				torque_write.Iq_Ki_Gain_0 = Integer.parseInt(Iq_Ki_Gain_0_edit.getText().toString());
				torque_write.Id_Ki_Gain_0 = Integer.parseInt(Id_Ki_Gain_0_edit.getText().toString());
				torque_write.Iq_Kp_Gain_2 = Integer.parseInt(Iq_Kp_Gain_2_edit.getText().toString());
				torque_write.Id_Kp_Gain_2 = Integer.parseInt(Id_Kp_Gain_2_edit.getText().toString());
				torque_write.Iq_Ki_Gain_2 = Integer.parseInt(Iq_Ki_Gain_2_edit.getText().toString());
				torque_write.Id_Ki_Gain_2 = Integer.parseInt(Id_Ki_Gain_2_edit.getText().toString());
				torque_write.Iq_Kp_Gain_3 = Integer.parseInt(Iq_Kp_Gain_3_edit.getText().toString());
				torque_write.Id_Kp_Gain_3 = Integer.parseInt(Id_Kp_Gain_3_edit.getText().toString());
				torque_write.Iq_Ki_Gain_3 = Integer.parseInt(Iq_Ki_Gain_3_edit.getText().toString());
				torque_write.Id_Ki_Gain_3 = Integer.parseInt(Id_Ki_Gain_3_edit.getText().toString());
				NAN_error = 0;
			}
			
			catch(NumberFormatException e)
			{
				Toast NAN = Toast.makeText(torque_config.this,"请输入有效的值",Toast.LENGTH_LONG);
				NAN.show();
				NAN_error = 1;
			}
			
			if(NAN_error == 0)
			{
				
				try {
					StartActivity.myblueTooth.write(torque_write.reverse2bytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
}
}
