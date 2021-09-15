package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class GasContractChargesHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htGasCC = new Hashtable<String, String>();
		htGasCC.put("Duplicate Contract and Meter", "Valid");
		htGasCC.put("Missing MPRN", "Valid");
		htGasCC.put("Invalid MPRN", "Valid");
		htGasCC.put("Missing Contract ref", "Valid");
		htGasCC.put("Invalid/ Missing Supplier", "Valid");
		htGasCC.put("Invalid Start Date", "Valid");
		htGasCC.put("Invalid End Date", "Valid");
		htGasCC.put("Invalid Pay Month", "Valid");
		htGasCC.put("Pay Term Not valid", "Valid");
		htGasCC.put("Price Point not valid", "Valid");
		htGasCC.put("Rates not numeric", "Valid");
		htGasCC.put("All energy rates missing", "Valid");
		htGasCC.put("Standing charge price point not valid","Valid");		
		htGasCC.put("Duplicate meter for the same period", "Valid");
		return htGasCC;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htGasCC = new Hashtable<String, String>();
		htGasCC.put("Duplicate Contract and Meter", "Error");
		htGasCC.put("Missing MPRN", "Valid");
		htGasCC.put("Invalid MPRN", "Error");
		htGasCC.put("Missing Contract ref", "Error");
		htGasCC.put("Invalid/ Missing Supplier", "Error");
		htGasCC.put("Invalid Start Date", "Error");
		htGasCC.put("Invalid End Date", "Error");
		htGasCC.put("Invalid Pay Month", "Error");
		htGasCC.put("Pay Term Not valid", "Error");
		htGasCC.put("Price Point not valid", "Error");
		htGasCC.put("Rates not numeric", "Error");
		htGasCC.put("All energy rates missing", "Error");
		htGasCC.put("Standing charge price point not valid","Error");
		htGasCC.put("Duplicate meter for the same period", "Valid");
		return htGasCC;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htGasCC = new Hashtable<String, String>();
		htGasCC.put("Duplicate Contract and Meter", "Valid");
		htGasCC.put("Missing MPRN", "Valid");
		htGasCC.put("Invalid MPRN", "Valid");
		htGasCC.put("Missing Contract ref", "Valid");
		htGasCC.put("Invalid/ Missing Supplier", "Valid");
		htGasCC.put("Invalid Start Date", "Valid");
		htGasCC.put("Invalid End Date", "Valid");
		htGasCC.put("Invalid Pay Month", "Valid");
		htGasCC.put("Pay Term Not valid", "Valid");
		htGasCC.put("Price Point not valid", "Valid");
		htGasCC.put("Rates not numeric", "Valid");
		htGasCC.put("All energy rates missing", "Valid");
		htGasCC.put("Standing charge price point not valid","Valid");
		htGasCC.put("Duplicate meter for the same period", "Warning");
		return htGasCC;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htGasCC = new Hashtable<String, String>();
		htGasCC.put("Duplicate Contract and Meter", "Valid");
		htGasCC.put("Missing MPRN", "Valid");
		htGasCC.put("Invalid MPRN", "Valid");
		htGasCC.put("Missing Contract ref", "Error");
		htGasCC.put("Invalid/ Missing Supplier", "Error");
		htGasCC.put("Invalid Start Date", "Valid");
		htGasCC.put("Invalid End Date", "Valid");
		htGasCC.put("Invalid Pay Month", "Valid");
		htGasCC.put("Pay Term Not valid", "Valid");
		htGasCC.put("Price Point not valid", "Valid");
		htGasCC.put("Rates not numeric", "Valid");
		htGasCC.put("All energy rates missing", "Valid");
		htGasCC.put("Standing charge price point not valid","Valid");		
		htGasCC.put("Duplicate meter for the same period", "Warning");
		return htGasCC;
	}

}
