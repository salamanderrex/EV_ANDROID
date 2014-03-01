package com.adv.config;

import com.adv.StartActivity;
import com.advpower.android.bean.Flux_weaken;
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

public class flux_weaken_config extends Activity{
static int Flux_Q_500rpm = -1;
static int Flux_Q_2_5_3krpm = -1;
static int Flux_Q_500_1krpm = -1;
static int Flux_Q_3_3_5krpm = -1;
static int Flux_Q_1_1_5krpm = -1;
static int Flux_Q_3_5_4krpm = -1;
static int Flux_Q_1_5_2krpm = -1;
static int Flux_Q_4_4_5krpm = -1;
static int Flux_Q_2_2_5krpm = -1;
static int Startup_speed_min = -1;
static int Hall_calib_ref_acc = -1;
static int Startup_speed_Low = -1;
static int Hall_calib_ref_dec = -1;
static int Startup_speed_High = -1;

static EditText Flux_Q_500rpm_edit;
static EditText Flux_Q_2_5_3krpm_edit;
static EditText Flux_Q_500_1krpm_edit;
static EditText Flux_Q_3_3_5krpm_edit;
static EditText Flux_Q_1_1_5krpm_edit;
static EditText Flux_Q_3_5_4krpm_edit;
static EditText Flux_Q_1_5_2krpm_edit;
static EditText Flux_Q_4_4_5krpm_edit;
static EditText Flux_Q_2_2_5krpm_edit;
static EditText Startup_speed_min_edit;
static EditText Hall_calib_ref_acc_edit;
static EditText Startup_speed_Low_edit;
static EditText Hall_calib_ref_dec_edit;
static EditText Startup_speed_High_edit;

static int NAN_error = 0;

final Activity activity = this;
static Toast toast;

public static Handler flux_weaken_receiver = new Handler()
{
	public void handleMessage(Message msg)
	{
		Flux_weaken reference_received = (Flux_weaken)msg.obj;
		Flux_Q_500rpm = reference_received.Flux_Q_500rpm;
		Flux_Q_2_5_3krpm= reference_received.Flux_Q_2_5_3krpm;
		Flux_Q_500_1krpm= reference_received.Flux_Q_500_1krpm;
		Flux_Q_3_3_5krpm= reference_received.Flux_Q_3_3_5krpm;
		Flux_Q_1_1_5krpm= reference_received.Flux_Q_1_1_5krpm;
		Flux_Q_3_5_4krpm= reference_received.Flux_Q_3_5_4krpm;
		Flux_Q_1_5_2krpm= reference_received.Flux_Q_1_5_2krpm;
		Flux_Q_4_4_5krpm= reference_received.Flux_Q_4_4_5krpm;
		Flux_Q_2_2_5krpm= reference_received.Flux_Q_2_2_5krpm;
		Startup_speed_min= reference_received.Startup_speed_min;
		Hall_calib_ref_acc= reference_received.Hall_calib_ref_acc;
		Startup_speed_Low= reference_received.Startup_speed_Low;
		Hall_calib_ref_dec= reference_received.Hall_calib_ref_dec;
		Startup_speed_High = reference_received.Startup_speed_High;
		
		Flux_Q_500rpm_edit.setText(Integer.toString(Flux_Q_500rpm));
		Flux_Q_2_5_3krpm_edit.setText(Integer.toString(Flux_Q_2_5_3krpm));
		Flux_Q_500_1krpm_edit.setText(Integer.toString(Flux_Q_500_1krpm));
		Flux_Q_3_3_5krpm_edit.setText(Integer.toString(Flux_Q_3_3_5krpm));
		Flux_Q_1_1_5krpm_edit.setText(Integer.toString(Flux_Q_1_1_5krpm));
		Flux_Q_3_5_4krpm_edit.setText(Integer.toString(Flux_Q_3_5_4krpm));
		Flux_Q_1_5_2krpm_edit.setText(Integer.toString(Flux_Q_1_5_2krpm));
		Flux_Q_4_4_5krpm_edit.setText(Integer.toString(Flux_Q_4_4_5krpm));
		Flux_Q_2_2_5krpm_edit.setText(Integer.toString(Flux_Q_2_2_5krpm));
		Startup_speed_min_edit.setText(Integer.toString(Startup_speed_min));
		Hall_calib_ref_acc_edit.setText(Integer.toString(Hall_calib_ref_acc));
		Startup_speed_Low_edit.setText(Integer.toString(Startup_speed_Low));
		Hall_calib_ref_dec_edit.setText(Integer.toString(Hall_calib_ref_dec));
		Startup_speed_High_edit.setText(Integer.toString(Startup_speed_High));
	}
};

		
public static Handler flux_weaken_writer = new Handler()
{
	public void handleMessage(Message msg)
	{
		if(msg.what == CONSTANT.EVENT.FLUX_WEAKEN_MODIFY)
		{
			toast.show();
		}
	}
};

protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.flux_weaken);
	toast = Toast.makeText(flux_weaken_config.this,"flux_weaken_config写入成功",Toast.LENGTH_LONG);
	 Flux_Q_500rpm_edit = (EditText)findViewById(R.id.editText_fq5);
	 Flux_Q_2_5_3krpm_edit = (EditText)findViewById(R.id.editText_fq23);
	 Flux_Q_500_1krpm_edit = (EditText)findViewById(R.id.editText_fq51);
	 Flux_Q_3_3_5krpm_edit = (EditText)findViewById(R.id.editText_fq33);
	 Flux_Q_1_1_5krpm_edit = (EditText)findViewById(R.id.editText_fq11);
	 Flux_Q_3_5_4krpm_edit = (EditText)findViewById(R.id.editText_fq34);
	 Flux_Q_1_5_2krpm_edit = (EditText)findViewById(R.id.editText_fq12);
	 Flux_Q_4_4_5krpm_edit = (EditText)findViewById(R.id.editText_fq44);
	 Flux_Q_2_2_5krpm_edit = (EditText)findViewById(R.id.editText_fq22);
	 Startup_speed_min_edit = (EditText)findViewById(R.id.editText_ssm);
	 Hall_calib_ref_acc_edit = (EditText)findViewById(R.id.editText_hcra);
	 Startup_speed_Low_edit = (EditText)findViewById(R.id.editText_ssl);
	 Hall_calib_ref_dec_edit = (EditText)findViewById(R.id.editText_hcrd);
	 Startup_speed_High_edit = (EditText)findViewById(R.id.editText_ssh);

	
	
	Button read = (Button)findViewById(R.id.button1);
	Button write = (Button)findViewById(R.id.button2);
	
	read.setOnClickListener(new OnClickListener()
	{
		public void onClick(View arg)
		{
			try {
				StartActivity.myblueTooth.write(messageFactory_maker.EVENT_TRIGGER_op(CONSTANT.EVENT.FLUX_WEAKEN_READ));
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
			Flux_weaken flux_weaken_write = new Flux_weaken();
			try
			{
			flux_weaken_write.Flux_Q_500rpm = Integer.parseInt(Flux_Q_500rpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_2_5_3krpm = Integer.parseInt(Flux_Q_2_5_3krpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_500_1krpm = Integer.parseInt(Flux_Q_500_1krpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_3_3_5krpm = Integer.parseInt(Flux_Q_3_3_5krpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_1_1_5krpm = Integer.parseInt(Flux_Q_1_1_5krpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_3_5_4krpm = Integer.parseInt(Flux_Q_3_5_4krpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_1_5_2krpm = Integer.parseInt(Flux_Q_1_5_2krpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_4_4_5krpm = Integer.parseInt(Flux_Q_4_4_5krpm_edit.getText().toString());
			flux_weaken_write.Flux_Q_2_2_5krpm = Integer.parseInt(Flux_Q_2_2_5krpm_edit.getText().toString());
			flux_weaken_write.Startup_speed_min = Integer.parseInt(Startup_speed_min_edit.getText().toString());
			flux_weaken_write.Hall_calib_ref_acc = Integer.parseInt(Hall_calib_ref_acc_edit.getText().toString());
			flux_weaken_write.Startup_speed_Low = Integer.parseInt(Startup_speed_Low_edit.getText().toString());
			flux_weaken_write.Hall_calib_ref_dec = Integer.parseInt(Hall_calib_ref_dec_edit.getText().toString());
			flux_weaken_write.Startup_speed_High = Integer.parseInt(Startup_speed_High_edit.getText().toString());
			NAN_error = 0;
		}
		
		catch(NumberFormatException e)
		{
			Toast NAN = Toast.makeText(flux_weaken_config.this,"请输入有效的值",Toast.LENGTH_LONG);
			NAN.show();
			NAN_error = 1;
		}
		
		if(NAN_error == 0)
		{
			
			try {
				StartActivity.myblueTooth.write(flux_weaken_write.reverse2bytes());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	});
}
}


