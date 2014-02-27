package com.advpower.android.utilities.messagefactory;

import com.advpower.android.bean.Basic;
import com.advpower.android.bean.Control;
import com.advpower.android.bean.DC_Current_Calibration;
import com.advpower.android.bean.Flux_weaken;
import com.advpower.android.bean.Motor;
import com.advpower.android.bean.Other;
import com.advpower.android.bean.Protection;
import com.advpower.android.bean.Reference;
import com.advpower.android.bean.SYS_RealTimeInfo;
import com.advpower.android.bean.Torque_PID;
import com.advpower.android.bean.adv_message_base_bean;
import com.advpower.android.*;
import com.advpower.android.utilities.CONSTANT;
import com.advpower.android.utilities.CONSTANT.EVENT;

public class messageFactory_receiver {

	public static int get_respose_type(byte[] bytes) {

		if (bytes[0] == (byte) 0xDF && bytes[1] == (byte) 0xEF) {
			System.out.println("flag1");
			return CONSTANT.SYS_REALTIMEINFO;
		}

		else if (bytes[0] == (byte) 0xF0 && bytes[1] == (byte) 0xE0) {
			return CONSTANT.EVENT.BASIC_READ;
		}

		else if (bytes[0] == (byte) 0xF0 && bytes[1] == (byte) 0xE1) {
			return CONSTANT.EVENT.BASIC_MODIFY;
		}

		else if (bytes[0] == (byte) 0xF2 && bytes[1] == (byte) 0xE2) {
			return CONSTANT.EVENT.REFERENCE_READ;
		
		} else if (bytes[0] == (byte) 0xF2 && bytes[1] == (byte) 0xE3) {
			return CONSTANT.EVENT.REFERENCE_MODIFY;
		}

		else if (bytes[0] == (byte) 0xF6 && bytes[1] == (byte) 0xE6) {
			return CONSTANT.EVENT.MOTOR_READ;
		} else if (bytes[0] == (byte) 0xF6 && bytes[1] == (byte) 0xE7) {
			return CONSTANT.EVENT.MOTOR_MODIFY;
		}

		else if (bytes[0] == (byte) 0xF4 && bytes[1] == (byte) 0xE4) {
			return CONSTANT.EVENT.CONTROL_READ;
		} else if (bytes[0] == (byte) 0xF4 && bytes[1] == (byte) 0xE5) {
			return CONSTANT.EVENT.CONTROL_MODIFY;
		}

		else if (bytes[0] == (byte) 0xF2 && bytes[1] == (byte) 0xE2) {
			return CONSTANT.EVENT.REFERENCE_READ;
		} else if (bytes[0] == (byte) 0xF2 && bytes[1] == (byte) 0xE3) {
			return CONSTANT.EVENT.REFERENCE_MODIFY;
		}

		else if (bytes[0] == (byte) 0xD2 && bytes[1] == (byte) 0xC2) {
			return CONSTANT.EVENT.TORQUE_READ;
		} else if (bytes[0] == (byte) 0xD2 && bytes[1] == (byte) 0xC3) {
			return CONSTANT.EVENT.TORQUE_MODIFY;
		}

		else if (bytes[0] == (byte) 0xF8 && bytes[1] == (byte) 0xE8) {
			return CONSTANT.EVENT.PROTECTION_READ;
		} else if (bytes[0] == (byte) 0xF8 && bytes[1] == (byte) 0xE9) {
			return CONSTANT.EVENT.PROTECTION_MODIFY;
		}

		else if (bytes[0] == (byte) 0xFE && bytes[1] == (byte) 0xEE) {
			return CONSTANT.EVENT.OTHER_READ;
		}

		else if (bytes[0] == (byte) 0xFE && bytes[1] == (byte) 0xEF) {
			return CONSTANT.EVENT.OTHER_MODIFY;
		}

		else if (bytes[0] == (byte) 0xD6 && bytes[1] == (byte) 0xC6) {
			return CONSTANT.EVENT.FLUX_WEAKEN_READ;
		} else if (bytes[0] == (byte) 0xD6 && bytes[1] == (byte) 0xC7) {
			return CONSTANT.EVENT.FLUX_WEAKEN_MODIFY;
		}

		else if (bytes[0] == (byte) 0xFB && bytes[1] == (byte) 0xED) {
			return CONSTANT.EVENT.DC_CURRENT_CALIBRATION_READ;
		} else if (bytes[0] == (byte) 0xFB && bytes[1] == (byte) 0xEE) {
			return CONSTANT.EVENT.DC_CURRENT_CALIBRATION_MODIFY;
		}

		return 0;
	}

	public static adv_message_base_bean get_bean(byte[] bytes, int type)
			throws Exception
	/*
	 * if nothing, return null
	 */
	{
		adv_message_base_bean bean = null;

		if (type == CONSTANT.SYS_REALTIMEINFO) {
			bean = new SYS_RealTimeInfo(bytes);

		}

		else if (type == EVENT.BASIC_READ || type == EVENT.BASIC_MODIFY) {
			bean = new Basic(bytes);

		}

		else if (type == EVENT.REFERENCE_READ || type == EVENT.REFERENCE_MODIFY) {
			bean = new Reference(bytes);
		}

		else if (type == EVENT.MOTOR_READ || type == EVENT.MOTOR_MODIFY) {
			bean = new Motor(bytes);
		}

		else if (type == EVENT.CONTROL_MODIFY || type == EVENT.CONTROL_READ) {
			bean = new Control(bytes);
		} 
		
		else if (type == EVENT.TORQUE_READ || type == EVENT.TORQUE_MODIFY) {
			bean = new Torque_PID(bytes);
		}
		
		else if (type == EVENT.PROTECTION_READ
				|| type == EVENT.PROTECTION_MODIFY) {
			bean = new Protection(bytes);
		} 
		
		else if (type == EVENT.OTHER_READ || type == EVENT.OTHER_MODIFY) {
			bean = new Other(bytes);
		}

		else if (type == EVENT.FLUX_WEAKEN_READ	|| type == EVENT.FLUX_WEAKEN_MODIFY) {
			bean = new Flux_weaken(bytes);
		}

		else if (type == EVENT.DC_CURRENT_CALIBRATION_READ
				|| type == EVENT.DC_CURRENT_CALIBRATION_MODIFY) {
			bean = new DC_Current_Calibration(bytes);
		}
		
		
		
		// needing more
		return bean;
	}
}
