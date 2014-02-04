package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Motor extends avd_message_base_bean {
	public int Pole_pair_num;
	public int Iac_limit_level;
	public int Angle_degree_BDir;
	public int Angle_offset_square;
	public int Vdc_filter;
	public int Idc_filter;
	public int Tref_filter;
	public int Temperature_filter;
	public int ECO_Iqref_1krpm;
	public int ECO_Iqref_1_5krpm;
	public int Hall_A_1_remap;
	public int Hall_A_2_remap;
	public int Hall_A_3_remap;
	public int Hall_A_4_remap;
	public int Hall_A_5_remap;
	public int Hall_A_6_remap;
	public int Hall_group;
	public int ECO_Iqref_2krpm;
	public int ECO_Iqref_2_5krpm;
	public int ECO_Iqref_3krpm;

	public Motor() {

	}

	public Motor(byte[] bytes) {
		initial(bytes);
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];
		Pole_pair_num = DESUtil.bytesToInt(bytes, 8, 2);
		Iac_limit_level = DESUtil.bytesToInt(bytes, 8, 19);
		Angle_degree_BDir = DESUtil.bytesToInt(bytes, 16, 6,true);
		Angle_offset_square = DESUtil.bytesToInt(bytes, 8, 8);
		Vdc_filter = DESUtil.bytesToInt(bytes, 8, 15);
		Idc_filter = DESUtil.bytesToInt(bytes, 8, 16);
		Tref_filter = DESUtil.bytesToInt(bytes, 8, 17);
		Temperature_filter = DESUtil.bytesToInt(bytes, 8, 18);
		ECO_Iqref_1krpm = DESUtil.bytesToInt(bytes, 8,3);
		ECO_Iqref_1_5krpm = DESUtil.bytesToInt(bytes, 8, 4);
		Hall_A_1_remap = DESUtil.bytesToInt(bytes, 8, 9);
		Hall_A_2_remap = DESUtil.bytesToInt(bytes, 8, 10);
		Hall_A_3_remap = DESUtil.bytesToInt(bytes, 8, 11);
		Hall_A_4_remap = DESUtil.bytesToInt(bytes, 8, 12);
		Hall_A_5_remap = DESUtil.bytesToInt(bytes, 8, 13);
		Hall_A_6_remap = DESUtil.bytesToInt(bytes, 8, 14);
		Hall_group = DESUtil.bytesToInt(bytes, 8, 5);
		ECO_Iqref_2krpm = DESUtil.bytesToInt(bytes, 8, 3);
		ECO_Iqref_2_5krpm = DESUtil.bytesToInt(bytes, 8, 4);
		ECO_Iqref_3krpm = DESUtil.bytesToInt(bytes, 8, 5);
		
		end=bytes[23];

	}
}
