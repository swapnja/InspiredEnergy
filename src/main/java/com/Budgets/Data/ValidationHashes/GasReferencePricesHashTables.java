package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class GasReferencePricesHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htGasRP = new Hashtable<String, String>();
		htGasRP.put("Invalid Date","Valid");
		htGasRP.put("Reference prices not numeric","Valid");
		htGasRP.put("Duplicate Periods","Valid");
		return htGasRP;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htGasRP = new Hashtable<String, String>();
		htGasRP.put("Invalid Date","Error");
		htGasRP.put("Reference prices not numeric","Error");
		htGasRP.put("Duplicate Periods","Valid");
		return htGasRP;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htGasRP = new Hashtable<String, String>();
		htGasRP.put("Invalid Date","Valid");
		htGasRP.put("Reference prices not numeric","Valid");
		htGasRP.put("Duplicate Periods","Warning");
		return htGasRP;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htGasRP = new Hashtable<String, String>();
		htGasRP.put("Invalid Date","Error");
		htGasRP.put("Reference prices not numeric","Error");
		htGasRP.put("Duplicate Periods","Warning");
		return htGasRP;
	}

}
