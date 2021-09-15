package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityPublishedViewHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htPC = new Hashtable<String, String>();
		htPC.put("Rates not numeric", "Valid");
		htPC.put("Invalid Start date", "Valid");
		htPC.put("Invalid End date", "Valid");
		htPC.put("DNO not numeric", "Valid");
		htPC.put("LLF not alpha numeric", "Valid");
		htPC.put("Missing rates", "Valid");
		htPC.put("Missing DNOs", "Valid");
		htPC.put("Duplicate DNO/LLF Combo for same period", "Valid");
		return htPC;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htPC = new Hashtable<String, String>();
		htPC.put("Rates not numeric", "Error");
		htPC.put("Invalid Start date", "Error");
		htPC.put("Invalid End date", "Error");
		htPC.put("DNO not numeric", "Error");
		htPC.put("LLF not alpha numeric", "Error");
		htPC.put("Missing rates", "Valid");
		htPC.put("Missing DNOs", "Valid");
		htPC.put("Duplicate DNO/LLF Combo for same period", "Valid");
		return htPC;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htPC = new Hashtable<String, String>();
		htPC.put("Rates not numeric", "Valid");
		htPC.put("Invalid Start date", "Valid");
		htPC.put("Invalid End date", "Valid");
		htPC.put("DNO not numeric", "Valid");
		htPC.put("LLF not alpha numeric", "Valid");
		htPC.put("Missing rates", "Warning");
		htPC.put("Missing DNOs", "Warning");
		htPC.put("Duplicate DNO/LLF Combo for same period", "Warning");
		return htPC;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htPC = new Hashtable<String, String>();
		htPC.put("Rates not numeric", "Error");
		htPC.put("Invalid Start date", "Error");
		htPC.put("Invalid End date", "Error");
		htPC.put("DNO not numeric", "Error");
		htPC.put("LLF not alpha numeric", "Error");
		htPC.put("Missing rates", "Warning");
		htPC.put("Missing DNOs", "Warning");
		htPC.put("Duplicate DNO/LLF Combo for same period", "Valid");
		return htPC;
	}

}
