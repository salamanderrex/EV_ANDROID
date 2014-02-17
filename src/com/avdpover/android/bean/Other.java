package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Other extends avd_message_base_bean {

	public int Filter_of_Hall__;
	public int Speed_of_flux_quit_;
	public int Backward_speed_;
	public int Percentage_in_mid_tref_;
	public int Flux_Acc_;
	public int Flux_Dec__;
	public int hFlux_Quit_;
	public int Dec_of_tref_;
	public int ECO_Iqref_3_5krpm_;
	public int ECO_Iqref__4_krpm_;
	public int ECO_Iqref_4_5krpm__;
	public int Forward_enable_;
	public int B_ackward__enable__;
	public int Brake_drive_stop_enable__;
	public int Motor_protection_enable__;
	public int hTorque_Reg_Acc_;
	public int hTorque_Reg_DEC_;
	public int Motor_switch_T_;
	public int Motor_hysteretic_;

	public Other(byte[] bytes) {
		initial(bytes);
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];
		Filter_of_Hall__ = DESUtil.bytesToInt(bytes, 8, 13);
		Speed_of_flux_quit_ = DESUtil.bytesToInt(bytes, 16, 17);
		Backward_speed_ = DESUtil.bytesToInt(bytes, 16, 6, true);
		Percentage_in_mid_tref_ = DESUtil.bytesToInt(bytes, 8, 5);
		Flux_Acc_ = DESUtil.bytesToInt(bytes, 8, 2);
		Flux_Dec__ = DESUtil.bytesToInt(bytes, 8, 9);
		hFlux_Quit_ = DESUtil.bytesToInt(bytes, 8, 10);
		Dec_of_tref_ = DESUtil.bytesToInt(bytes, 16, 21);
		ECO_Iqref_3_5krpm_ = DESUtil.bytesToInt(bytes, 8, 12);
		ECO_Iqref__4_krpm_ = DESUtil.bytesToInt(bytes, 8, 16);
		ECO_Iqref_4_5krpm__ = DESUtil.bytesToInt(bytes, 8, 13);
		Forward_enable_ = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 0));
		B_ackward__enable__  = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 1));
		Brake_drive_stop_enable__  = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 4));
		Motor_protection_enable__  = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 5));
		hTorque_Reg_Acc_ = DESUtil.bytesToInt(bytes, 8, 13);
		hTorque_Reg_DEC_ = DESUtil.bytesToInt(bytes, 8, 13);
		Motor_switch_T_ = DESUtil.bytesToInt(bytes, 8, 13);
		Motor_hysteretic_ = DESUtil.bytesToInt(bytes, 8, 13);
		end = bytes[23];
	}
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xFE;
		bytes[1]=(byte)0xEF;
		
		DESUtil.create_bytes(bytes, Filter_of_Hall__, 8, 13);
		DESUtil.create_bytes(bytes, Speed_of_flux_quit_, 16, 17);
		DESUtil.create_bytes(bytes, Backward_speed_, 16, 6);
		DESUtil.create_bytes(bytes, Percentage_in_mid_tref_, 8, 5);
		DESUtil.create_bytes(bytes, Flux_Acc_, 8,2 );
		DESUtil.create_bytes(bytes, Flux_Dec__, 8, 9);
		DESUtil.create_bytes(bytes, hFlux_Quit_, 8, 10);
		DESUtil.create_bytes(bytes, Dec_of_tref_, 16, 21);
		DESUtil.create_bytes(bytes,ECO_Iqref_3_5krpm_, 8, 12);
		DESUtil.create_bytes(bytes, ECO_Iqref__4_krpm_, 8, 16);
		DESUtil.create_bytes(bytes, ECO_Iqref_4_5krpm__, 8, 19);
		
		
		DESUtil.create_bytes(bytes, Iqref_2_krpm_, 8, 21);
		DESUtil.create_bytes(bytes, Iqref_2_5_krpm_, 8, 22);
		DESUtil.create_bytes(bytes, Iqref_3_krpm_, 8, 17);
		DESUtil.create_bytes(bytes,Iqref_3_5_krpm_ , 8, 18);
		DESUtil.create_bytes(bytes,Iqref_4_krpm_ , 8, 19);
		DESUtil.create_bytes(bytes,Iqref_4_5_krpm_ , 8, 9);

		
		bytes[23]=end;
		return bytes;
	}
}
