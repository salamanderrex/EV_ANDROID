package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Control extends avd_message_base_bean {
	public int Torque_Kp_G;
	public int Torque_Kp_D;
	public int Torque_Ki_G_LS;
	public int Flux_Kp_G;
	public int Flux_Kp_D;
	public int Flux_Ki_G_Ls;
	public int Eco_speed_kp_G;
	public int Eco_speed_kp_D;
	public int Speed_limit_kp_G;
	public int Speed_limit_kp_D;
	public int Speed_limit_ki_G;
	public int Idc_limit_kp_G;
	public int Idc_limit_kp_D;
	public int Idc_limit_ki_G;
	public int Eco_speed_ki_G;

	public Control(byte[] bytes) {

		initial(bytes);
	}
	
	public Control()
	{
		
	}

	public void initial(byte[] bytes) {

		start1 = bytes[0];
		start2 = bytes[1];

		Torque_Kp_G = DESUtil.bytesToInt(bytes, 8, 2);
		Torque_Kp_D = DESUtil.bytesToInt(bytes, 8, 3);
		Torque_Ki_G_LS = DESUtil.bytesToInt(bytes, 16, 4);
		Flux_Kp_G = DESUtil.bytesToInt(bytes, 8, 6);
		Flux_Kp_D = DESUtil.bytesToInt(bytes, 8, 7);
		Flux_Ki_G_Ls = DESUtil.bytesToInt(bytes, 16, 8);
		Eco_speed_kp_G = DESUtil.bytesToInt(bytes, 8, 10);
		Eco_speed_kp_D = DESUtil.bytesToInt(bytes, 8, 11);
		Speed_limit_kp_G = DESUtil.bytesToInt(bytes, 8, 14);
		Speed_limit_kp_D = DESUtil.bytesToInt(bytes, 8, 15);
		Speed_limit_ki_G = DESUtil.bytesToInt(bytes, 16, 16);
		Idc_limit_kp_G = DESUtil.bytesToInt(bytes, 8, 18);
		Idc_limit_kp_D = DESUtil.bytesToInt(bytes, 8, 19);
		Idc_limit_ki_G = DESUtil.bytesToInt(bytes, 8, 20);
		Eco_speed_ki_G = DESUtil.bytesToInt(bytes, 8, 12);

		end = bytes[23];
	}
}
