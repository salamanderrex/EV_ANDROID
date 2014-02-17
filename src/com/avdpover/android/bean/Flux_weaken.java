package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Flux_weaken extends avd_message_base_bean {

	public int Flux_Q_500rpm;
	public int Flux_Q_500_1krpm;
	public int Flux_Q_1_1_5krpm;
	public int Flux_Q_1_5_2krpm;
	public int Flux_Q_2_2_5krpm;
	public int Hall_calib_ref_acc;
	public int Hall_calib_ref_dec;
	public int Flux_Q_2_5_3krpm;
	public int Flux_Q_3_3_5krpm;
	public int Flux_Q_3_5_4krpm;
	public int Flux_Q_4_4_5krpm;
	public int Startup_speed_min;
	public int Startup_speed_low;
	public int Startup_speed_high;

	public Flux_weaken() {

	}

	public Flux_weaken(byte[] bytes) {
		initial(bytes);
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		Flux_Q_500rpm = DESUtil.bytesToInt(bytes, 8, 10);
		Flux_Q_500_1krpm = DESUtil.bytesToInt(bytes, 8, 11);
		Flux_Q_1_1_5krpm = DESUtil.bytesToInt(bytes, 8, 12);
		Flux_Q_1_5_2krpm = DESUtil.bytesToInt(bytes, 8, 13);
		Flux_Q_2_2_5krpm = DESUtil.bytesToInt(bytes, 8, 14);
		Hall_calib_ref_acc = DESUtil.bytesToInt(bytes, 16, 2);
		Hall_calib_ref_dec = DESUtil.bytesToInt(bytes, 16, 4);
		Flux_Q_2_5_3krpm = DESUtil.bytesToInt(bytes, 8, 15);
		Flux_Q_3_3_5krpm = DESUtil.bytesToInt(bytes, 8, 16);
		Flux_Q_3_5_4krpm = DESUtil.bytesToInt(bytes, 8, 17);
		Flux_Q_4_4_5krpm = DESUtil.bytesToInt(bytes, 8, 18);
		Startup_speed_min = DESUtil.bytesToInt(bytes, 16, 6);
		Startup_speed_low = DESUtil.bytesToInt(bytes, 16, 8);
		Startup_speed_high = DESUtil.bytesToInt(bytes, 16, 19);

		end = bytes[23];
	}
	
	
	
	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xD6;
		bytes[1]=(byte)0xC7;
		
		DESUtil.create_bytes(bytes, Flux_Q_500rpm, 8, 10);
		DESUtil.create_bytes(bytes, Flux_Q_500_1krpm, 8, 11);
		DESUtil.create_bytes(bytes, Flux_Q_1_1_5krpm, 8, 12);
		DESUtil.create_bytes(bytes, Flux_Q_1_5_2krpm, 8, 13);
		DESUtil.create_bytes(bytes, Flux_Q_2_2_5krpm, 8,14 );
		DESUtil.create_bytes(bytes, Hall_calib_ref_acc, 16, 2);
		DESUtil.create_bytes(bytes, Hall_calib_ref_dec, 16, 4);
		DESUtil.create_bytes(bytes, Flux_Q_2_5_3krpm, 8, 15);
		DESUtil.create_bytes(bytes,Flux_Q_3_3_5krpm, 8, 16);
		DESUtil.create_bytes(bytes, Flux_Q_3_5_4krpm, 8, 17);
		DESUtil.create_bytes(bytes, Flux_Q_4_4_5krpm, 8, 18);
		DESUtil.create_bytes(bytes, Startup_speed_min, 16, 6);
		DESUtil.create_bytes(bytes, Startup_speed_low, 16, 8);
		DESUtil.create_bytes(bytes, Startup_speed_high, 16, 19);
		

		
		bytes[23]=end;
		return bytes;
	}
}
