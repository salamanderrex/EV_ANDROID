package com.advpower.android.utilities;

import java.lang.reflect.Field;

public class PrintUtility {
	public static void printFields(Object obj) throws Exception {
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName() + " : " + field.get(obj));
		}
	}
}
