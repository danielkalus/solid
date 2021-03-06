package com.flopska.singleresponsibility.bad;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import lombok.extern.java.Log;

@Log
public class Customer {

	public void add() {
		try {
			// do some database stuff here
		} catch (Exception e) {
			handleError("database error");
		}
	}

	public void handleError(String error) {
		FileHandler fh;

		try {
			fh = new FileHandler("MyLogFile.log");
			log.addHandler(fh);

			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			log.info(error);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
