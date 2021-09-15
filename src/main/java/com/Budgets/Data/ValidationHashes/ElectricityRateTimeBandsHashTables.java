package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityRateTimeBandsHashTables {
	
	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htRTB = new Hashtable<String, String>();
		htRTB.put("Missing Contract Reference", "Valid");
		htRTB.put("Missing Description", "Valid");
		htRTB.put("Invalid Start Time", "Valid");
		htRTB.put("Invalid End Time", "Valid");
		htRTB.put("Full Period Covered for all Rates", "Valid");
		return htRTB;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htRTB = new Hashtable<String, String>();
		htRTB.put("Missing Contract Reference", "Error");
		htRTB.put("Missing Description", "Error");
		htRTB.put("Invalid Start Time", "Error");
		htRTB.put("Invalid End Time", "Error");
		htRTB.put("Full Period Covered for all Rates", "Error");
		return htRTB;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htRTB = new Hashtable<String, String>();
		htRTB.put("Missing Contract Reference", "Valid");
		htRTB.put("Missing Description", "Valid");
		htRTB.put("Invalid Start Time", "Valid");
		htRTB.put("Invalid End Time", "Valid");
		htRTB.put("Full Period Covered for all Rates", "Warning");
		return htRTB;
	}
}
