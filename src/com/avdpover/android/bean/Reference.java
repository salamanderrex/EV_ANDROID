package com.avdpover.android.bean;

import android.sax.TextElementListener;

import com.avdpower.android.utilities.DESUtil;

public class Reference extends avd_message_base_bean {
	public int Squ_angle_step_int;
	public int Angle_offset_FDIR;
	public int HALL_60_360_Switch;
	public int Vdc_of_Regen_stop;
	public int Vdc_of_full_regen;

	public int StepSquareStart;
	public int Class_of_Iac;
	public int Acc_of_Tref;
	public int Vdc_of_Idc_limit;
	public int  Vdc_of_Idc_min;
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
		Vdc_of_Regen_stop = DESUtil.bytesToUnSignInt16(bytes[8], bytes[9]);
		Vdc_of_full_regen = DESUtil.bytesToUnSignInt16(bytes[10], bytes[11]);
		StepSquareStart = DESUtil.bytesToUnSignInt8(bytes[18]);
		Class_of_Iac = DESUtil.bytesToUnSignInt8(bytes[12]);
		Acc_of_Tref = DESUtil.bytesToUnSignInt16(bytes[19], bytes[20]);
		Vdc_of_Idc_limit = DESUtil.bytesToUnSignInt16(bytes[14], bytes[15]);
		Vdc_of_Idc_min = DESUtil.bytesToUnSignInt16(bytes[16], bytes[17]);
		Idc_percent_min = DESUtil.bytesToUnSignInt8(bytes[3]);
		StartupPercentage_Fast = DESUtil.bytesToUnSignInt8(bytes[13]);
		Temperature_limit = DESUtil.bytesToUnSignInt8(bytes[2]);
		end = bytes[23];
	}
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xF2;
		bytes[1]=(byte)0xE3;
		
		DESUtil.create_bytes(bytes, Squ_angle_step_int, 16, 21,true);
		DESUtil.create_bytes(bytes, Angle_offset_FDIR, 16, 4,true);
		DESUtil.create_bytes(bytes, HALL_60_360_Switch, 8, 6);
		DESUtil.create_bytes(bytes, Vdc_of_Regen_stop, 16, 8);
		DESUtil.create_bytes(bytes, Vdc_of_full_regen, 16,10 );
		DESUtil.create_bytes(bytes, StepSquareStart, 8, 18);
		DESUtil.create_bytes(bytes, Class_of_Iac, 8, 12);
		DESUtil.create_bytes(bytes, Acc_of_Tref, 16, 19);
		DESUtil.create_bytes(bytes, Vdc_of_Idc_limit, 16, 14);
		DESUtil.create_bytes(bytes, Vdc_of_Idc_min, 16, 16);
		DESUtil.create_bytes(bytes, Idc_percent_min, 8, 3);
		DESUtil.create_bytes(bytes, StartupPercentage_Fast, 8, 13);
		DESUtil.create_bytes(bytes, Temperature_limit, 8, 2);
		
		bytes[23]=end;
		return bytes;
	}
}
