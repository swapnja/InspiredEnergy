package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityKVArhHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htKVA = new Hashtable<String, String>();
		htKVA.put("MPAN/MPRN Invalid", "Valid");
		htKVA.put("Invalid Date", "Valid");
		htKVA.put("Period Data not numeric", "Valid");
		htKVA.put("Missing Period data in day", "Valid");
		htKVA.put("Missing Days in sequence per MPAN", "Valid");
		htKVA.put("Duplicate days - same MPAN", "Valid");
		htKVA.put("Period Exception", "Valid");
		return htKVA;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htKVA = new Hashtable<String, String>();
		htKVA.put("MPAN/MPRN Invalid", "Valid");
		htKVA.put("Invalid Date", "Error");
		htKVA.put("Period Data not numeric", "Valid");
		htKVA.put("Missing Period data in day", "Warning");
		htKVA.put("Missing Days in sequence per MPAN", "Warning");
		htKVA.put("Duplicate days - same MPAN", "Valid");
		htKVA.put("Period Exception", "Valid");
		return htKVA;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htKVA = new Hashtable<String, String>();
		htKVA.put("MPAN/MPRN Invalid", "Valid");
		htKVA.put("Invalid Date", "Valid");
		htKVA.put("Period Data not numeric", "Valid");
		htKVA.put("Missing Period data in day", "Warning");
		htKVA.put("Missing Days in sequence per MPAN", "Valid");
		htKVA.put("Duplicate days - same MPAN", "Valid");
		htKVA.put("Period Exception", "Valid");
		return htKVA;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htKVA = new Hashtable<String, String>();
		htKVA.put("MPAN/MPRN Invalid", "Valid");
		htKVA.put("Invalid Date", "Error");
		htKVA.put("Period Data not numeric", "Valid");
		htKVA.put("Missing Period data in day", "Warning");
		htKVA.put("Missing Days in sequence per MPAN", "Warning");
		htKVA.put("Duplicate days - same MPAN", "Valid");
		htKVA.put("Period Exception", "Valid");
		return htKVA;
	}

}
