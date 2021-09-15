package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityReferencePricesHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htEleRP = new Hashtable<String, String>();
		htEleRP.put("Invalid Date", "Valid");
		htEleRP.put("Reference prices not numeric", "Valid");
		htEleRP.put("Duplicate Periods", "Valid");
		return htEleRP;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htEleRP = new Hashtable<String, String>();
		htEleRP.put("Invalid Date", "Error");
		htEleRP.put("Reference prices not numeric", "Error");
		htEleRP.put("Duplicate Periods", "Warning");
		return htEleRP;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htEleRP = new Hashtable<String, String>();
		htEleRP.put("Invalid Date", "Valid");
		htEleRP.put("Reference prices not numeric", "Valid");
		htEleRP.put("Duplicate Periods", "Warning");
		return htEleRP;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htEleRP = new Hashtable<String, String>();
		htEleRP.put("Invalid Date", "Error");
		htEleRP.put("Reference prices not numeric", "Error");
		htEleRP.put("Duplicate Periods", "Warning");
		return htEleRP;
	}

}
