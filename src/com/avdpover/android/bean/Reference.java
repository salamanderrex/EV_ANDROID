package com.avdpover.android.bean;

import android.sax.TextElementListener;

import com.avdpower.android.utilities.DESUtil;

public class Reference extends avd_message_base_bean {
	public int Squ_angle_step_int;
	public int Angle_offset_FDIR;
	public int HALL_60_360_Switch;
	public float Vdc_of_Regen_stop;
	public float Vdc_of_full_regen;

	public int StepSquareStart;
	public int Class_of_Iac;
	public int Acc_of_Tref;
	public float Vdc_of_Idc_limit;
	public float  Vdc_of_Idc_min;
	public int Idc_percent_min;
	public int StartupPercentage_Fast;
	public int Temperature_limit;

	public Reference() {

	}

	public Reference(byte[] bytes) {
		initial(bytes);
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];
		Squ_angle_step_int = DESUtil.bytesToSignInt16(bytes[21], bytes[22]);
		Angle_offset_FDIR = DESUtil.bytesToSignInt16(bytes[5], bytes[4]);
		HALL_60_360_Switch = DESUtil.bytesToUnSignInt8(bytes[6]);
		Vdc_of_Regen_stop = ((float)DESUtil.bytesToUnSignInt16(bytes[8], bytes[9]))/100;
		Vdc_of_full_regen = ((float)DESUtil.bytesToUnSignInt16(bytes[10], bytes[11]))/100;
		StepSquareStart = DESUtil.bytesToUnSignInt8(bytes[18]);
		Class_of_Iac = DESUtil.bytesToUnSignInt8(bytes[12]);
		Acc_of_Tref = DESUtil.bytesToUnSignInt16(bytes[19], bytes[20]);
		Vdc_of_Idc_limit = ((float)DESUtil.bytesToUnSignInt16(bytes[14], bytes[15]))/100;
		Vdc_of_Idc_min = ((float)DESUtil.bytesToUnSignInt16(bytes[16], bytes[17]))/100;
		Idc_percent_min = DESUtil.bytesToUnSignInt8(bytes[3]);
		StartupPercentage_Fast = DESUtil.bytesToUnSignInt8(bytes[13]);
		Temperature_limit = DESUtil.bytesToUnSignInt8(bytes[2]);
		end = bytes[23];
	}
}
