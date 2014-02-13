package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Protection extends avd_message_base_bean {
	
	
	public int Big_torque_times_;
	public int Motor_lock_time_;
	public int Motor_lock_Iac_;
	public int Big_torque_Iac_;
	public int Over_heat_point_;
	public int Over_heat_recover_;
	public int Temp_of_Iac_limit__;
	public int Hall_calib_Iac_;
	public int Flux_comp_to_Vdc__;
	public int Iqref_1krpm__;
	public int Iqref_1_5_krpm_;
	public int Iqref_2_krpm_;
	public int Iqref_2_5_krpm_;
	public int Iqref_3_krpm_;
	public int Iqref_3_5_krpm_;
	public int Iqref_4_krpm_;
	public int Iqref_4_5_krpm_;
	
	public  Protection(byte[] bytes) {
		initial(bytes);
	}
	
	public void initial(byte [] bytes)
	{
		store_inner_bytes(bytes);
		start1=bytes[0];
		start2=bytes[1];
		
		Big_torque_times_=DESUtil.bytesToInt(bytes, 8,2);
		Motor_lock_time_=DESUtil.bytesToInt(bytes, 8,3);
		Motor_lock_Iac_=DESUtil.bytesToInt(bytes, 8,4);
		Big_torque_Iac_=DESUtil.bytesToInt(bytes, 8,5);
		Over_heat_point_=DESUtil.bytesToInt(bytes, 8,14);
		Over_heat_recover_=DESUtil.bytesToInt(bytes, 8,15);
		Temp_of_Iac_limit__=DESUtil.bytesToInt(bytes, 8,16);
		Hall_calib_Iac_=DESUtil.bytesToInt(bytes, 8,13);
		Flux_comp_to_Vdc__=DESUtil.bytesToInt(bytes, 8,8);
		Iqref_1krpm__=DESUtil.bytesToInt(bytes, 16,10);
		Iqref_1_5_krpm_=DESUtil.bytesToUnSignInt16(bytes[12], bytes[20]);
		Iqref_2_krpm_=DESUtil.bytesToInt(bytes, 8,21);
		Iqref_2_5_krpm_=DESUtil.bytesToInt(bytes, 8,22);
		Iqref_3_krpm_=DESUtil.bytesToInt(bytes, 8,17);
		Iqref_3_5_krpm_=DESUtil.bytesToInt(bytes, 8,18);
		Iqref_4_krpm_=DESUtil.bytesToInt(bytes, 8,19);
		Iqref_4_5_krpm_=DESUtil.bytesToInt(bytes, 8,9);
		
		end=bytes[23];
	}
}
