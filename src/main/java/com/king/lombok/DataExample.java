package com.king.lombok;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data public class DataExample {

	@Getter @Setter private int age = 10;
	
	@Setter(AccessLevel.PROTECTED) private String name;
	
	@Override public String toString() {
		return String.format("%s(age:%d)", name,age);
	}
}
