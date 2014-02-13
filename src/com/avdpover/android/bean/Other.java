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
}
