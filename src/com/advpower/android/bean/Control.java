package com.advpower.android.bean;

import com.advpower.android.utilities.DESUtil;

public class Control extends adv_message_base_bean {
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
		start1 = (byte)0xF4;
		start2 = (byte)0xE5;
		end= (byte)0xDA;
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
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
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xF4;
		bytes[1]=(byte)0xE5;
		
		DESUtil.create_bytes(bytes, Torque_Kp_G, 8, 2);
		DESUtil.create_bytes(bytes, Torque_Kp_D, 8, 3);
		DESUtil.create_bytes(bytes, Torque_Ki_G_LS, 16, 4);
		DESUtil.create_bytes(bytes, Flux_Kp_G, 8, 6);
		DESUtil.create_bytes(bytes, Flux_Kp_D, 8,7 );
		DESUtil.create_bytes(bytes, Flux_Ki_G_Ls, 16, 8);
		DESUtil.create_bytes(bytes, Eco_speed_kp_G, 8, 10);
		DESUtil.create_bytes(bytes, Eco_speed_kp_D, 8, 11);
		DESUtil.create_bytes(bytes, Speed_limit_kp_G, 8, 14);
		DESUtil.create_bytes(bytes, Speed_limit_kp_D, 8, 15);
		DESUtil.create_bytes(bytes, Speed_limit_ki_G, 16, 16);
		DESUtil.create_bytes(bytes, Idc_limit_kp_G, 8, 18);
		DESUtil.create_bytes(bytes, Idc_limit_kp_D, 8, 19);
		DESUtil.create_bytes(bytes, Idc_limit_ki_G, 16, 20);
		DESUtil.create_bytes(bytes, Eco_speed_ki_G, 16, 12);

		
		bytes[23]=end;
		return bytes;
	}
}
