package com.advpower.android.bean;

import android.R.string;

import com.advpower.android.utilities.DESUtil;

public class SYS_RealTimeInfo extends adv_message_base_bean {

	public float Vdc;
	public float Idc;
	public short Speed;
	public short MotorT;
	public short Mos_T;
	public short Iac_ref;
	public short Iac_actual;
	public boolean Brake;
	public boolean Backward;
	public boolean Hall_Calib;
	public boolean Alarm;
	public boolean Forward;
	public int Throttle_vdc;

	public boolean Hall;
	public boolean Under_vdc;
	public boolean Over_vdc;
	public boolean Over_heat;
	public boolean Over_iac;
	public boolean Over_load;
	public boolean Motor_lock;
	public boolean Motor_OH;

	public boolean Hall_history;
	public boolean Under_vdc_history;
	public boolean Over_vdc_history;
	public boolean Over_heat_history;
	public boolean Over_iac_history;
	public boolean Over_load_history;
	public boolean Motor_lock_history;
	public boolean Motor_OH_history;

	public boolean Input_Forward;
	public boolean Input_Backward;
	public boolean Input_Alarm;
	public boolean Input_BrakeL;
	public boolean Input_BrakeH;
	public boolean Input_Boost;

	public SYS_RealTimeInfo(byte[] bytes) {

		initial(bytes);

	}

	public SYS_RealTimeInfo() {

	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];
		Vdc = ((float) DESUtil.bytesToUnSignInt16(bytes[2], bytes[3])) / 100;
		Idc = ((float) DESUtil.bytesToSignInt16(bytes[4], bytes[5])) / 100;
		Speed = DESUtil.bytesToSignInt16(bytes[6], bytes[7]);
		Mos_T = (short) (DESUtil.bytesToSignInt8(bytes[8]) - 10);

		MotorT = (short) (DESUtil.bytesToUnSignInt8(bytes[12]) * 2);
		Iac_ref = DESUtil.bytesToSignInt16(bytes[13], bytes[14]);
		Throttle_vdc = DESUtil.bytesToUnSignInt16(bytes[15], bytes[16]);

		Iac_actual = DESUtil.bytesToSignInt16(bytes[21], bytes[22]);
		Brake = DESUtil.getBit(bytes[9], 4);
		Backward = DESUtil.getBit(bytes[9], 1);
		Hall_Calib = DESUtil.getBit(bytes[9], 2);
		Alarm = DESUtil.getBit(bytes[9], 3);
		Forward = DESUtil.getBit(bytes[9], 0);

		Hall = DESUtil.getBit(bytes[19], 1) | DESUtil.getBit(bytes[20], 2);
		Under_vdc = DESUtil.getBit(bytes[19], 3);
		Over_vdc = DESUtil.getBit(bytes[19], 2);
		Over_heat = DESUtil.getBit(bytes[19], 4);
		Over_iac = DESUtil.getBit(bytes[19], 5);
		Over_load = DESUtil.getBit(bytes[19], 6);
		Motor_lock = DESUtil.getBit(bytes[19], 7);
		Motor_OH = DESUtil.getBit(bytes[20], 4);

		Hall_history = DESUtil.getBit(bytes[10], 1)
				| DESUtil.getBit(bytes[11], 2);
		Under_vdc_history = DESUtil.getBit(bytes[10], 3);
		Over_vdc_history = DESUtil.getBit(bytes[10], 2);
		Over_heat_history = DESUtil.getBit(bytes[10], 4);
		Over_iac_history = DESUtil.getBit(bytes[10], 5);
		Over_load_history = DESUtil.getBit(bytes[10], 6);
		Motor_lock_history = DESUtil.getBit(bytes[10], 7);
		Motor_OH_history = DESUtil.getBit(bytes[11], 4);

		Input_Forward = DESUtil.getBit(bytes[17], 0);
		Input_Backward = DESUtil.getBit(bytes[17], 1);
		Input_Alarm = DESUtil.getBit(bytes[17], 3);
		Input_BrakeL = DESUtil.getBit(bytes[17], 4);
		Input_BrakeH = DESUtil.getBit(bytes[17], 5);
		Input_Boost = DESUtil.getBit(bytes[17], 7);

		end = bytes[23];

	}
	
	
	

}
