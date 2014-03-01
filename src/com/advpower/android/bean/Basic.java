package com.advpower.android.bean;

import com.advpower.android.utilities.DESUtil;

public class Basic extends adv_message_base_bean {
	/*
	 * 0 ֡ͷ1 1 ֡ͷ2 2 ���ѹ���ֽ� �޷��16λ�� ��λ���� 3 ���ѹ���ֽ� 4 ���ѹ�ָ����ֽ� 5 ���ѹ�ָ����ֽ� 6 Ƿ��ѹ���ֽ�
	 * 7 Ƿ��ѹ���ֽ� 8 Ƿ��ѹ�ָ����ֽ� 9 Ƿ��ѹ�ָ����ֽ� 10 ��������������������ֽ� �޷��16λ��, ��λ������ 11
	 * ��������������������ֽ� 12 ������ֱ�������趨 �޷��8λ�� ��λ������ 13 ���ٵ����ٵ��ֽ� �޷��16λ�� ��λ��rpm 14
	 * ���ٵ����ٸ��ֽ� 15 ת����Ч�ͷ�ֵ���ֽ� �޷��16λ�� ��λ��0.0001V 16 ת����Ч�ͷ�ֵ���ֽ� 17 ת����Ч�߷�ֵ���ֽ� 18
	 * ת����Ч�߷�ֵ���ֽ� 19 ��Ť������ת�ѵ�λ���ֽ� 20 ��Ť������ת�ѵ�λ���ֽ� 21 ���ٵ����ٵ��ֽ� �޷��16λ�� ��λ��rpm 22
	 * ���ٵ����ٸ��ֽ� 23 ֡β
	 */

	public int DC_current;
	public int Phase_current;
	public int High_voltage;
	public int High_voltage_recover;
	public int Low_voltage;
	public int Low_voltage_recover;
	public int Throttle_low;
	public int Throttle_mid;
	public int Throttle_high;
	public int Max_speed;
	public int ECO_speed;

	// public byte [] bytes;

	public Basic(byte[] bytes) {

		initial(bytes);
	}

	public Basic() {
		start1 = (byte)0xF0;
		start2 = (byte)0xE1;
		end= (byte)0xDA;
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		DC_current = DESUtil.bytesToUnSignInt8(bytes[12]);
		Phase_current = DESUtil.bytesToInt(bytes, 16, 10);
		High_voltage = DESUtil.bytesToUnSignInt16(bytes[2], bytes[3]);
		High_voltage_recover = DESUtil.bytesToUnSignInt16(bytes[4], bytes[5]);
		Low_voltage = DESUtil.bytesToUnSignInt16(bytes[6], bytes[7]);
		Low_voltage_recover = DESUtil.bytesToUnSignInt16(bytes[8], bytes[9]);

		Throttle_low = DESUtil.bytesToUnSignInt16(bytes[13], bytes[14]);
		Throttle_mid = DESUtil.bytesToUnSignInt16(bytes[15], bytes[16]);
		Throttle_high = DESUtil.bytesToUnSignInt16(bytes[17], bytes[18]);

		Max_speed = DESUtil.bytesToUnSignInt16(bytes[19], bytes[20]);
		ECO_speed = DESUtil.bytesToUnSignInt16(bytes[21], bytes[22]);

		end = bytes[23];
	}

	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xF0;
		
		bytes[1]=(byte)0xE1;
		
		DESUtil.create_bytes(bytes, DC_current, 8, 12);
		DESUtil.create_bytes(bytes, Phase_current, 16, 10);
		DESUtil.create_bytes(bytes, High_voltage, 16, 2);
		DESUtil.create_bytes(bytes, High_voltage_recover, 16, 4);
		DESUtil.create_bytes(bytes, Low_voltage, 16, 6);
		DESUtil.create_bytes(bytes, Low_voltage_recover, 16, 8);
		DESUtil.create_bytes(bytes, Throttle_low, 16, 13);
		DESUtil.create_bytes(bytes, Throttle_mid, 16, 15);
		DESUtil.create_bytes(bytes, Throttle_high, 16, 17);
		DESUtil.create_bytes(bytes, Max_speed, 16, 19);
		DESUtil.create_bytes(bytes, ECO_speed, 16, 21);
		
		bytes[23]=end;
		return bytes;
	}
}
