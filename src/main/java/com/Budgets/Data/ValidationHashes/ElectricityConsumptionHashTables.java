package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityConsumptionHashTables {
	
	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htConsumption = new Hashtable<String, String>();
		htConsumption.put("MPAN/MPRN Invalid", "Valid");
		htConsumption.put("Invalid Date", "Valid");
		htConsumption.put("Period Data not numeric", "Valid");
		htConsumption.put("Missing Period data in day", "Valid");
		htConsumption.put("Missing Days in sequence per MPAN", "Warning");
		htConsumption.put("Duplicate days - same MPAN", "Valid");
		htConsumption.put("Period Exception", "Valid");
		return htConsumption;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htConsumption = new Hashtable<String, String>();
		htConsumption.put("MPAN/MPRN Invalid", "Error");
		htConsumption.put("Invalid Date", "Valid");
		htConsumption.put("Period Data not numeric", "Error");
		htConsumption.put("Missing Period data in day", "Valid");
		htConsumption.put("Missing Days in sequence per MPAN", "Valid");
		htConsumption.put("Duplicate days - same MPAN", "Valid");
		htConsumption.put("Period Exception", "Valid");
		return htConsumption;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htConsumption = new Hashtable<String, String>();
		htConsumption.put("MPAN/MPRN Invalid", "Valid");
		htConsumption.put("Invalid Date", "Valid");
		htConsumption.put("Period Data not numeric", "Valid");
		htConsumption.put("Missing Period data in day", "Warning");
		htConsumption.put("Missing Days in sequence per MPAN", "Warning");
		htConsumption.put("Duplicate days - same MPAN", "Warning");
		htConsumption.put("Period Exception", "Valid");
		return htConsumption;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htConsumption = new Hashtable<String, String>();
		htConsumption.put("MPAN/MPRN Invalid", "Error");
		htConsumption.put("Invalid Date", "Valid");
		htConsumption.put("Period Data not numeric", "Error");
		htConsumption.put("Missing Period data in day", "Warning");
		htConsumption.put("Missing Days in sequence per MPAN", "Valid");
		htConsumption.put("Duplicate days - same MPAN", "Valid");
		htConsumption.put("Period Exception", "Valid");
		return htConsumption;
	}

}
