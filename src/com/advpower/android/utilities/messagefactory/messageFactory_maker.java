package com.advpower.android.utilities.messagefactory;

import com.advpower.android.utilities.CONSTANT;

public class messageFactory_maker {

	public static byte[] TIME_ROBORT_op() {
		byte bytes[] = new byte[3];
		bytes[0] = (byte) 0xFD;
		bytes[1] = (byte) 0x48;
		bytes[2] = (byte) 0x55;
		return bytes;

	}

	public static byte[] EVENT_TRIGGER_op(int event_type) {
		//seems no longer needed
		byte bytes[] = new byte[3];

		switch (event_type) {
		case CONSTANT.EVENT.BASIC_MODIFY: {

			bytes[0] = (byte) 0xF0;
			bytes[1] = (byte) 0xE1;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.BASIC_READ: {
			bytes[0] = (byte) 0xF0;
			bytes[1] = (byte) 0xE0;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.REFERENCE_MODIFY: {

			bytes[0] = (byte) 0xF2;
			bytes[1] = (byte) 0xE3;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.REFERENCE_READ: {
			bytes[0] = (byte) 0xF2;
			bytes[1] = (byte) 0xE2;
			bytes[2] = (byte) 0xDA;
			break;

		}

		case CONSTANT.EVENT.MOTOR_MODIFY: {

			bytes[0] = (byte) 0xF6;
			bytes[1] = (byte) 0xE7;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.MOTOR_READ: {
			bytes[0] = (byte) 0xF6;
			bytes[1] = (byte) 0xE6;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.CONTROL_MODIFY: {

			bytes[0] = (byte) 0xF4;
			bytes[1] = (byte) 0xE5;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.CONTROL_READ: {
			bytes[0] = (byte) 0xF4;
			bytes[1] = (byte) 0xE4;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.TORQUE_MODIFY: {

			bytes[0] = (byte) 0xD2;
			bytes[1] = (byte) 0xC3;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.TORQUE_READ: {
			bytes[0] = (byte) 0xD2;
			bytes[1] = (byte) 0xC2;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.PROTECTION_READ: {

			bytes[0] = (byte) 0xF8;
			bytes[1] = (byte) 0xE8;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.PROTECTION_MODIFY: {
			bytes[0] = (byte) 0xF8;
			bytes[1] = (byte) 0xE9;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.OTHER_MODIFY: {

			bytes[0] = (byte) 0xFE;
			bytes[1] = (byte) 0xEF;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.OTHER_READ: {
			bytes[0] = (byte) 0xFE;
			bytes[1] = (byte) 0xEE;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.FLUX_WEAKEN_READ: {

			bytes[0] = (byte) 0xD6;
			bytes[1] = (byte) 0xC6;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.FLUX_WEAKEN_MODIFY: {
			bytes[0] = (byte) 0xD6;
			bytes[1] = (byte) 0xC7;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.DC_CURRENT_CALIBRATION_READ: {

			bytes[0] = (byte) 0xFB;
			bytes[1] = (byte) 0xED;
			bytes[2] = (byte) 0xDA;
			break;
		}

		case CONSTANT.EVENT.DC_CURRENT_CALIBRATION_MODIFY: {
			bytes[0] = (byte) 0xFB;
			bytes[1] = (byte) 0xEE;
			bytes[2] = (byte) 0xDA;
			break;
		}

		}
		return bytes;
	}
}
