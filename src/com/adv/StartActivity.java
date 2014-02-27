package com.adv;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import com.adv.config.basic_config;
import com.adv.config.control_config;
import com.adv.config.dc_current_calibration_config;
import com.adv.config.flux_weaken_config;
import com.adv.config.motor_config;
import com.adv.config.other_config;
import com.adv.config.protection_config;
import com.adv.config.reference_config;
import com.adv.config.torque_config;
import com.adv.panel.PanelCarInfo;
import com.advpower.android.utilities.CONSTANT;
import com.advpower.android.utilities.PrintUtility;
import com.advpower.android.utilities.bluetooth.MyBlueTooth;
import com.advpower.android.utilities.messagefactory.messageFactory_maker;
import com.krislq.sliding.MainActivity;
import com.krislq.sliding.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;


public class StartActivity extends Activity {

	public Handler blue_tooth_handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			switch(msg.what)
			{
			case CONSTANT.SYS_REALTIMEINFO:
				break;
			case CONSTANT.EVENT.BASIC_READ:
				Message msg_basic_read = new Message();
				msg_basic_read.what = msg.what;
				msg_basic_read.obj = msg.obj;
				basic_config.basic_receiver.sendMessage(msg_basic_read);
				break;
			case CONSTANT.EVENT.BASIC_MODIFY:
				Message msg_basic_write = new Message();
				msg_basic_write.what = msg.what;
				msg_basic_write.obj = msg.obj;
				basic_config.basic_writer.sendMessage(msg_basic_write);
				break;
			case CONSTANT.EVENT.REFERENCE_READ:
				Message msg_reference_read = new Message();
				msg_reference_read.what = msg.what;
				msg_reference_read.obj = msg.obj;
				reference_config.reference_receiver.sendMessage(msg_reference_read);
				break;
			case CONSTANT.EVENT.REFERENCE_MODIFY:
				Message msg_reference_write = new Message();
				msg_reference_write.what = msg.what;
				msg_reference_write.obj = msg.obj;
				reference_config.reference_writer.sendMessage(msg_reference_write);
				break;
			case CONSTANT.EVENT.MOTOR_READ:
				Message msg_motor_read = new Message();
				msg_motor_read.what = msg.what;
				msg_motor_read.obj = msg.obj;
				motor_config.motor_receiver.sendMessage(msg_motor_read);
				break;
			case CONSTANT.EVENT.MOTOR_MODIFY:
				Message msg_motor_write = new Message();
				msg_motor_write.what = msg.what;
				msg_motor_write.obj = msg.obj;
				motor_config.motor_writer.sendMessage(msg_motor_write);
				break;
			case CONSTANT.EVENT.CONTROL_READ:
				Message msg_control_read = new Message();
				msg_control_read.what = msg.what;
				msg_control_read.obj = msg.obj;
				control_config.control_receiver.sendMessage(msg_control_read);
				break;
			case CONSTANT.EVENT.CONTROL_MODIFY:
				Message msg_control_write = new Message();
				msg_control_write.what = msg.what;
				msg_control_write.obj = msg.obj;
				control_config.control_writer.sendMessage(msg_control_write);
				break;
			case CONSTANT.EVENT.TORQUE_READ:
				Message msg_torque_read = new Message();
				msg_torque_read.what = msg.what;
				msg_torque_read.obj = msg.obj;
				torque_config.torque_receiver.sendMessage(msg_torque_read);
				break;
			case CONSTANT.EVENT.TORQUE_MODIFY:
				Message msg_torque_write = new Message();
				msg_torque_write.what = msg.what;
				msg_torque_write.obj = msg.obj;
				torque_config.torque_writer.sendMessage(msg_torque_write);
				break;
			case CONSTANT.EVENT.PROTECTION_READ:
				Message msg_protection_read = new Message();
				msg_protection_read.what = msg.what;
				msg_protection_read.obj = msg.obj;
				protection_config.protection_receiver.sendMessage(msg_protection_read);
				break;
			case CONSTANT.EVENT.PROTECTION_MODIFY:
				Message msg_protection_write = new Message();
				msg_protection_write.what = msg.what;
				msg_protection_write.obj = msg.obj;
				protection_config.protection_writer.sendMessage(msg_protection_write);
				break;
			case CONSTANT.EVENT.OTHER_READ:
				Message msg_other_read = new Message();
				msg_other_read.what = msg.what;
				msg_other_read.obj = msg.obj;
				other_config.other_receiver.sendMessage(msg_other_read);
				break;
			case CONSTANT.EVENT.OTHER_MODIFY:
				Message msg_other_write = new Message();
				msg_other_write.what = msg.what;
				msg_other_write.obj = msg.obj;
				other_config.other_writer.sendMessage(msg_other_write);
				break;
			case CONSTANT.EVENT.FLUX_WEAKEN_READ:
				Message msg_flux_weaken_read = new Message();
				msg_flux_weaken_read.what = msg.what;
				msg_flux_weaken_read.obj = msg.obj;
				flux_weaken_config.flux_weaken_receiver.sendMessage(msg_flux_weaken_read);
				break;
			case CONSTANT.EVENT.FLUX_WEAKEN_MODIFY:
				Message msg_flux_weaken_write = new Message();
				msg_flux_weaken_write.what = msg.what;
				msg_flux_weaken_write.obj = msg.obj;
				flux_weaken_config.flux_weaken_writer.sendMessage(msg_flux_weaken_write);
				break;
			case CONSTANT.EVENT.DC_CURRENT_CALIBRATION_READ:
				Message msg_dc_current_calibration_read = new Message();
				msg_dc_current_calibration_read.what = msg.what;
				msg_dc_current_calibration_read.obj = msg.obj;
				dc_current_calibration_config.dc_current_calibration_receiver.sendMessage(msg_dc_current_calibration_read);
				break;
			case CONSTANT.EVENT.DC_CURRENT_CALIBRATION_MODIFY:
				Message msg_dc_current_calibration_write = new Message();
				msg_dc_current_calibration_write.what = msg.what;
				msg_dc_current_calibration_write.obj = msg.obj;
				dc_current_calibration_config.dc_current_calibration_writer.sendMessage(msg_dc_current_calibration_write);
				break;
			}
		}
	};
	
	public static MyBlueTooth myblueTooth;
	Set<BluetoothDevice> bluetoothdevices = null;
	final Activity activity = this;
		
	private Handler jump = new Handler()
	{
		public void handleMessage(Message msg)
		{
			
			
			try {
				myblueTooth = new MyBlueTooth(blue_tooth_handler);
				if (!myblueTooth.getMbluetoothAdapter().isEnabled()) {
					Intent intent = new Intent(
							BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivity(intent);
				}
				bluetoothdevices = myblueTooth.getBondedtBluetoothDevice();
				myblueTooth.Setpaireddevice(CONSTANT.BT_SERVER_NAME);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			//第一步若未开蓝牙再一次Initial
			try {
				myblueTooth = new MyBlueTooth(blue_tooth_handler);
				if (!myblueTooth.getMbluetoothAdapter().isEnabled()) {
					Intent intent = new Intent(
							BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivity(intent);
				}
				bluetoothdevices = myblueTooth.getBondedtBluetoothDevice();
				myblueTooth.Setpaireddevice(CONSTANT.BT_SERVER_NAME);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//第二步client
			try {

				myblueTooth.bond();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//第三步connectsocket
			try {
				// System.out.println("closing the connection");
				myblueTooth.connect();
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
			
			
//			
//			//第四步write
//			try {
//				myblueTooth.write(messageFactory_maker.TIME_ROBORT_op());
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			System.out.println("这里是"+myblueTooth.sys_RealTimeInfo.MotorT);
		try
		{
			if(myblueTooth.isconnected()==false)
			{
				Toast error = Toast.makeText(StartActivity.this,"蓝牙初始化或配对连接失败！",Toast.LENGTH_LONG);
				error.show();
			}
		}
		catch(Exception e)
		{
			System.out.println("检测连接情况时发生异常");
		}
			
		Intent intent = new Intent(StartActivity.this,MainActivity.class);
		startActivity(intent);
		activity.finish();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.panel_fragment);
		
		Toast initial = Toast.makeText(StartActivity.this,"请稍等，正在执行蓝牙的初始化",Toast.LENGTH_LONG);
		initial.show();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				jump.sendMessage(new Message());
			}
		},500);
		//System.out.println(myblueTooth.isconnected());
		
		
	}
}


