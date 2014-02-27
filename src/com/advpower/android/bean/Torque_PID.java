package com.advpower.android.bean;

import com.advpower.android.utilities.DESUtil;

public class Torque_PID extends adv_message_base_bean {
	public int Iq_Kp_Gain_0_Pre;
	public int Iq_Ki_Gain_0_Pre;
	public int Iq_Kp_Gain_0;
	public int Iq_Ki_Gain_0;
	public int Iq_Kp_Gain_2;
	public int Iq_Ki_Gain_2;
	public int Iq_Kp_Gain_3;
	public int Iq_Ki_Gain_3;
	public int Id_Kp_Gain_0_Pre;
	public int Id_Ki_Gain_0_Pre;
	public int Id_Kp_Gain_0;
	public int Id_Ki_Gain_0;
	public int Id_Kp_Gain_2;
	public int Id_Ki_Gain_2;
	public int Id_Kp_Gain_3;
	public int Id_Ki_Gain_3;

	public Torque_PID(byte[] bytes) {

		initial(bytes);
	}

	public Torque_PID()
	{
		start1 = (byte)0xD2;
		start2 = (byte)0xC3;
		end= (byte)0xDA;
	}
	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		Iq_Kp_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 2);
		Iq_Ki_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 3);
		Iq_Kp_Gain_0 = DESUtil.bytesToInt(bytes, 8, 6);
		Iq_Ki_Gain_0 = DESUtil.bytesToInt(bytes, 8, 7);
		Iq_Kp_Gain_2 = DESUtil.bytesToInt(bytes, 8, 10);
		Iq_Ki_Gain_2 = DESUtil.bytesToInt(bytes, 16, 11);

		Iq_Kp_Gain_3 = DESUtil.bytesToInt(bytes, 8, 16);
		Iq_Ki_Gain_3 = DESUtil.bytesToInt(bytes, 16, 17);
		Id_Kp_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 4);
		Id_Ki_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 5);
		Id_Kp_Gain_0 = DESUtil.bytesToInt(bytes, 8, 8);
		Id_Ki_Gain_0 = DESUtil.bytesToInt(bytes, 8, 9);
		Id_Kp_Gain_2 = DESUtil.bytesToInt(bytes, 8, 13);
		Id_Ki_Gain_2 = DESUtil.bytesToInt(bytes, 16, 14);

		Id_Kp_Gain_3 = DESUtil.bytesToInt(bytes, 8, 19);
		Id_Ki_Gain_3 = DESUtil.bytesToInt(bytes, 16, 20);

		end = bytes[23];
	}
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xD2;
		bytes[1]=(byte)0xC3;
		
		DESUtil.create_bytes(bytes, Iq_Kp_Gain_0_Pre, 8, 2);
		DESUtil.create_bytes(bytes, Iq_Ki_Gain_0_Pre, 8, 3);
		DESUtil.create_bytes(bytes, Iq_Kp_Gain_0, 8, 6);
		DESUtil.create_bytes(bytes, Iq_Ki_Gain_0, 8, 7);
		DESUtil.create_bytes(bytes, Iq_Kp_Gain_2, 8,10 );
		DESUtil.create_bytes(bytes, Iq_Ki_Gain_2, 16, 11);
		DESUtil.create_bytes(bytes, Iq_Kp_Gain_3, 8, 16);
		DESUtil.create_bytes(bytes, Iq_Ki_Gain_3, 8, 4);
		DESUtil.create_bytes(bytes,Id_Kp_Gain_0_Pre, 8, 4);
		DESUtil.create_bytes(bytes, Id_Ki_Gain_0_Pre, 8, 5);
		DESUtil.create_bytes(bytes, Id_Kp_Gain_0, 8, 8);
		DESUtil.create_bytes(bytes, Id_Ki_Gain_0, 8, 9);
		DESUtil.create_bytes(bytes, Id_Kp_Gain_2, 8, 13);
		DESUtil.create_bytes(bytes, Id_Ki_Gain_2, 16, 14);
		DESUtil.create_bytes(bytes,Id_Kp_Gain_3 , 8, 19);
		DESUtil.create_bytes(bytes,Id_Ki_Gain_3 , 16, 20);

		
		bytes[23]=end;
		return bytes;
	}
}
