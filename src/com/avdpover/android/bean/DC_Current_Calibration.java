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
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xFB;
		bytes[1]=(byte)0xEE;
		
		DESUtil.create_bytes(bytes, Idc_gain, 16, 19);
		DESUtil.create_bytes(bytes, Idc_D2_power, 8, 21);
		DESUtil.create_bytes(bytes, Iac_ADC_Value_128A, 16, 16);
		DESUtil.create_bytes(bytes, Flux_period, 8, 15);
		DESUtil.create_bytes(bytes, Mot_over_heat, 8,5 );
		DESUtil.create_bytes(bytes, Mot_oh_recover, 8, 7);
		DESUtil.create_bytes(bytes, Reference_period, 8, 18);
		DESUtil.create_bytes(bytes, Mot_high_temperature, 8, 6);
	

		
		byte temp=0x00;
		if(Forward_level==1)
		{
			temp=(byte)(temp|0x01);
		}
		
		if(Backward_level==1)
		{
			temp=(byte)(temp|0x02);
		}
		if(Brake_high_level==1)
		{
			temp=(byte)(temp|0x04);
		}
		if(Brake_low_level==1)
		{
			temp=(byte)(temp|0x10);
		}
		
		if(BHA==1)
		{
			temp=(byte)(temp|0x08);
		}
		
		
		if(BLA==1)
		{
			temp=(byte)(temp|0x40);
		}
		
		bytes[4]=temp;
		
		
		
		DESUtil.create_bytes(bytes, Serial_num_project, 16, 8);
		DESUtil.create_bytes(bytes,Serial_num_year, 8, 10);
		DESUtil.create_bytes(bytes, Serial_num_week, 8, 11);
		DESUtil.create_bytes(bytes,Serial_num_serial_num , 16, 12);
		DESUtil.create_bytes(bytes,Serial_num_customer_code , 8, 14);

	
		
		bytes[23]=end;
		return bytes;
	}
}
