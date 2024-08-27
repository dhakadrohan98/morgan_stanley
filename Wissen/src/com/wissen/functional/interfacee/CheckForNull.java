package com.wissen.functional.interfacee;

public class CheckForNull implements Predicate {

	@Override
	public boolean test(Object o) {
		return o != null;
	}
	
}
