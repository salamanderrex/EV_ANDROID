package com.advpower.android.bean;

import com.advpower.android.utilities.DESUtil;

public class Other extends adv_message_base_bean {

	public int Filter_of_Hall;
	public int Speed_of_flux_quit;
	public int Backward_speed;
	public int Percentage_in_mid_tref;
	public int Flux_Acc;
	public int Flux_Dec;
	public int hFlux_Quit;
	public int Dec_of_tref;
	public int ECO_Iqref_3_5krpm;
	public int ECO_Iqref_4krpm;
	public int ECO_Iqref_4_5krpm;
	public int Forward_enable;
	public int Backward_enable;
	public int Brake_drive_stop_enable;
	public int Motor_protection_enable;
	public int hTorque_Reg_ACC;
	public int hTorque_Reg_DEC;
	public int Motor_switch_T;
	public int MotorT_hysteretic;

	public Other(byte[] bytes) {
		initial(bytes);
	}
	
	public Other()
	{
		start1 = (byte)0xFE;
		start2 = (byte)0xEF;
		end= (byte)0xDA;
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];
		Filter_of_Hall = DESUtil.bytesToInt(bytes, 8, 13);
		Speed_of_flux_quit = DESUtil.bytesToInt(bytes, 16, 17);
		Backward_speed = DESUtil.bytesToInt(bytes, 16, 6, true);
		Percentage_in_mid_tref = DESUtil.bytesToInt(bytes, 8, 5);
		Flux_Acc = DESUtil.bytesToInt(bytes, 8, 2);
		Flux_Dec = DESUtil.bytesToInt(bytes, 8, 9);
		hFlux_Quit = DESUtil.bytesToInt(bytes, 8, 10);
		Dec_of_tref = DESUtil.bytesToInt(bytes, 16, 21);
		ECO_Iqref_3_5krpm = DESUtil.bytesToInt(bytes, 8, 12);
		ECO_Iqref_4krpm = DESUtil.bytesToInt(bytes, 8, 16);
		ECO_Iqref_4_5krpm = DESUtil.bytesToInt(bytes, 8, 13);
		Forward_enable = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 0));
		Backward_enable  = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 1));
		Brake_drive_stop_enable  = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 4));
		Motor_protection_enable  = DESUtil.boolean2int(DESUtil.getBit(bytes[8], 5));
		hTorque_Reg_ACC = DESUtil.bytesToInt(bytes, 8, 13);
		hTorque_Reg_DEC = DESUtil.bytesToInt(bytes, 8, 13);
		Motor_switch_T = DESUtil.bytesToInt(bytes, 8, 13);
		MotorT_hysteretic = DESUtil.bytesToInt(bytes, 8, 13);
		end = bytes[23];
	}
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xFE;
		bytes[1]=(byte)0xEF;
		
		DESUtil.create_bytes(bytes, Filter_of_Hall, 8, 13);
		DESUtil.create_bytes(bytes, Speed_of_flux_quit, 16, 17);
		DESUtil.create_bytes(bytes, Backward_speed, 16, 6);
		DESUtil.create_bytes(bytes, Percentage_in_mid_tref, 8, 5);
		DESUtil.create_bytes(bytes, Flux_Acc, 8,2 );
		DESUtil.create_bytes(bytes, Flux_Dec, 8, 9);
		DESUtil.create_bytes(bytes, hFlux_Quit, 8, 10);
		DESUtil.create_bytes(bytes, Dec_of_tref, 16, 21);
		DESUtil.create_bytes(bytes,ECO_Iqref_3_5krpm, 8, 12);
		DESUtil.create_bytes(bytes, ECO_Iqref_4krpm, 8, 16);
		DESUtil.create_bytes(bytes, ECO_Iqref_4_5krpm, 8, 19);
		
		byte temp=0x00;
		if(Forward_enable==1)
		{
			temp=(byte)(temp|0x01);
		}
		
		if(Backward_enable==1)
		{
			temp=(byte)(temp|0x02);
		}
		if(Brake_drive_stop_enable==1)
		{
			temp=(byte)(temp|0x10);
		}
		if(Motor_protection_enable==1)
		{
			temp=(byte)(temp|0x20);
		}
		
		bytes[8]=temp;
		
		
		
		DESUtil.create_bytes(bytes, hTorque_Reg_ACC, 16, 3);
		DESUtil.create_bytes(bytes,hTorque_Reg_DEC, 16, 14);
		DESUtil.create_bytes(bytes, Motor_switch_T, 8, 20);
		DESUtil.create_bytes(bytes,MotorT_hysteretic , 8, 11);
	
		
		bytes[23]=end;
		return bytes;
	}
}
