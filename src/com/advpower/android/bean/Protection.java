package com.advpower.android.bean;

import com.advpower.android.utilities.DESUtil;

public class Protection extends adv_message_base_bean {
	
	
	public int Big_torque_time;
	public int Motor_lock_time;
	public int Motor_lock_Iac;
	public int Big_torque_Iac;
	public int Over_heat_point;
	public int Over_heat_recover;
	public int Temp_of_Iac_limit;
	public int Hall_calib_Iac;
	public int Flux_comp_to_Vdc;
	public int Iqref_1krpm;
	public int Iqref_1_5krpm;
	public int Iqref_2krpm;
	public int Iqref_2_5krpm;
	public int Iqref_3krpm;
	public int Iqref_3_5krpm;
	public int Iqref_4krpm;
	public int Iqref_4_5krpm;
	
	public  Protection(byte[] bytes) {
		initial(bytes);
	}
	
	public Protection()
	{
		start1 = (byte)0xF8;
		start2 = (byte)0xE9;
		end= (byte)0xDA;
	}
	
	public void initial(byte [] bytes)
	{
		store_inner_bytes(bytes);
		start1=bytes[0];
		start2=bytes[1];
		
		Big_torque_time=DESUtil.bytesToInt(bytes, 8,2);
		Motor_lock_time=DESUtil.bytesToInt(bytes, 8,3);
		Motor_lock_Iac=DESUtil.bytesToInt(bytes, 8,4);
		Big_torque_Iac=DESUtil.bytesToInt(bytes, 8,5);
		Over_heat_point=DESUtil.bytesToInt(bytes, 8,14);
		Over_heat_recover=DESUtil.bytesToInt(bytes, 8,15);
		Temp_of_Iac_limit=DESUtil.bytesToInt(bytes, 8,16);
		Hall_calib_Iac=DESUtil.bytesToInt(bytes, 8,13);
		Flux_comp_to_Vdc=DESUtil.bytesToInt(bytes, 8,8);
		Iqref_1krpm=DESUtil.bytesToInt(bytes, 16,10);
		Iqref_1_5krpm=DESUtil.bytesToUnSignInt16(bytes[12], bytes[20]);
		Iqref_2krpm=DESUtil.bytesToInt(bytes, 8,21);
		Iqref_2_5krpm=DESUtil.bytesToInt(bytes, 8,22);
		Iqref_3krpm=DESUtil.bytesToInt(bytes, 8,17);
		Iqref_3_5krpm=DESUtil.bytesToInt(bytes, 8,18);
		Iqref_4krpm=DESUtil.bytesToInt(bytes, 8,19);
		Iqref_4_5krpm=DESUtil.bytesToInt(bytes, 8,9);
		
		end=bytes[23];
	}
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xF8;
		bytes[1]=(byte)0xE9;
		
		DESUtil.create_bytes(bytes, Big_torque_time, 8, 2);
		DESUtil.create_bytes(bytes, Motor_lock_time, 8, 3);
		DESUtil.create_bytes(bytes, Motor_lock_Iac, 8, 4);
		DESUtil.create_bytes(bytes, Big_torque_Iac, 8, 5);
		DESUtil.create_bytes(bytes, Over_heat_point, 8,14 );
		DESUtil.create_bytes(bytes, Over_heat_recover, 8, 15);
		DESUtil.create_bytes(bytes, Temp_of_Iac_limit, 8, 16);
		DESUtil.create_bytes(bytes, Hall_calib_Iac, 8, 13);
		DESUtil.create_bytes(bytes,Flux_comp_to_Vdc, 8, 8);
		DESUtil.create_bytes(bytes, Iqref_1krpm, 16, 10);
		DESUtil.create_Specific_bytes(bytes, Iqref_1_5krpm, 12, 20, false);
		DESUtil.create_bytes(bytes, Iqref_2krpm, 8, 21);
		DESUtil.create_bytes(bytes, Iqref_2_5krpm, 8, 22);
		DESUtil.create_bytes(bytes, Iqref_3krpm, 8, 17);
		DESUtil.create_bytes(bytes,Iqref_3_5krpm, 8, 18);
		DESUtil.create_bytes(bytes,Iqref_4krpm , 8, 19);
		DESUtil.create_bytes(bytes,Iqref_4_5krpm, 8, 9);

		
		bytes[23]=end;
		return bytes;
	}
}
