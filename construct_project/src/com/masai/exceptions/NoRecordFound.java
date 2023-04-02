package com.masai.exceptions;

import java.util.Arrays;

public class NoRecordFound extends Exception {

	public NoRecordFound(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
