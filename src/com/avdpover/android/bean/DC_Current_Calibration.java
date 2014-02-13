package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class DC_Current_Calibration extends avd_message_base_bean {

	public int Idc_gain;
	public int Idc_D2_power;
	public int Iac_ADC_Value_128A;
	public int Flux_period;
	public int Mot_over_heat;
	public int Mot_oh_recover;
	public int Reference_period;
	public int Mot_high_temperature;
	public int Forward_level;
	public int Backward_level;
	public int Brake_high_level;
	public int Brake_low_level;
	public int BHA;
	public int BLA;
	public int Serial_num_project;
	public int Serial_num_year;
	public int Serial_num_week;
	public int Serial_num_serial_num;
	public int Serial_num_customer_code;
	
	public DC_Current_Calibration()
	{
		
	}
	public DC_Current_Calibration(byte[] bytes) {
		initial(bytes);
	}

	public void initial(byte[] bytes) {

		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		Idc_gain = DESUtil.bytesToInt(bytes, 16, 19);
		Idc_D2_power = DESUtil.bytesToInt(bytes, 8, 21);
		Iac_ADC_Value_128A = DESUtil.bytesToInt(bytes, 16, 16);
		Flux_period = DESUtil.bytesToInt(bytes, 8, 15);
		Mot_over_heat = DESUtil.bytesToInt(bytes, 8, 5);
		Mot_oh_recover = DESUtil.bytesToInt(bytes, 8, 7);
		Reference_period = DESUtil.bytesToInt(bytes, 8, 18);
		Mot_high_temperature = DESUtil.bytesToInt(bytes, 8, 6);

		Forward_level = DESUtil.boolean2int(DESUtil.getBit(bytes[4], 0));
		Backward_level = DESUtil.boolean2int(DESUtil.getBit(bytes[4], 1));
		Brake_high_level = DESUtil.boolean2int(DESUtil.getBit(bytes[4], 2));
		Brake_low_level = DESUtil.boolean2int(DESUtil.getBit(bytes[4], 4));
		BHA = DESUtil.boolean2int(DESUtil.getBit(bytes[4], 3));
		BLA = DESUtil.boolean2int(DESUtil.getBit(bytes[4], 6));
		Serial_num_project = DESUtil.bytesToInt(bytes, 16, 8);
		Serial_num_year = DESUtil.bytesToInt(bytes, 8, 10);
		Serial_num_week = DESUtil.bytesToInt(bytes, 8, 11);
		Serial_num_serial_num = DESUtil.bytesToInt(bytes, 16, 12);
		Serial_num_customer_code = DESUtil.bytesToInt(bytes, 8, 14);

		end = bytes[23];
	}
}
