package com.mycomp.krishi.persistence.entity.type;

public enum MaritalStatus {
	UNMARRIED,
	MARRIED,
	DIVORCED;

	public static MaritalStatus get(String value) {
		try {
			if (null != value) {
				return valueOf(value);
			}
		} catch (Exception e) {
		}
		return null;
	}
}
