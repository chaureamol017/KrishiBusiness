package com.mycomp.krishi.persistence.type;

public enum Gender {
	MALE,
	FEMALE,
	OTHER,
	INVALID;

	public static Gender get(String value) {
		try {
			if (null != value) {
				return valueOf(value);
			}
		} catch (Exception e) {
		}
		return null;
	}
}
