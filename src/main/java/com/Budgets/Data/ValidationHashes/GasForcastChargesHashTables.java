package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class GasForcastChargesHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Valid");
		htEleFC.put("Missing MPRN", "Valid");
		htEleFC.put("Invalid MPRN", "Valid");
		htEleFC.put("Missing Contract ref", "Valid");
		htEleFC.put("Invalid/Missing Supplier", "Valid");
		htEleFC.put("Invalid Start Date", "Valid");
		htEleFC.put("Invalid End Date", "Valid");
		htEleFC.put("Invalid Pay Month", "Valid");
		htEleFC.put("Pay Term Not valid", "Valid");
		htEleFC.put("Price Point not valid", "Valid");
		htEleFC.put("Rates not numeric", "Valid");
		htEleFC.put("Commodity price and hedged prices missing", "Valid");
		htEleFC.put("Standing charge price point not valid", "Valid");
		htEleFC.put("Duplicate meter for the same period", "Valid");
		return htEleFC;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Error");
		htEleFC.put("Missing MPRN", "Valid");
		htEleFC.put("Invalid MPRN", "Error");
		htEleFC.put("Missing Contract ref", "Error");
		htEleFC.put("Invalid/Missing Supplier", "Error");
		htEleFC.put("Invalid Start Date", "Error");
		htEleFC.put("Invalid End Date", "Error");
		htEleFC.put("Invalid Pay Month", "Valid");
		htEleFC.put("Pay Term Not valid", "Error");
		htEleFC.put("Price Point not valid", "Error");
		htEleFC.put("Rates not numeric", "Error");
		htEleFC.put("Commodity price and hedged prices missing", "Error");
		htEleFC.put("Standing charge price point not valid", "Error");
		htEleFC.put("Duplicate meter for the same period", "Warning");
		return htEleFC;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Valid");
		htEleFC.put("Missing MPRN", "Valid");
		htEleFC.put("Invalid MPRN", "Valid");
		htEleFC.put("Missing Contract ref", "Valid");
		htEleFC.put("Invalid/Missing Supplier", "Valid");
		htEleFC.put("Invalid Start Date", "Valid");
		htEleFC.put("Invalid End Date", "Valid");
		htEleFC.put("Invalid Pay Month", "Valid");
		htEleFC.put("Pay Term Not valid", "Valid");
		htEleFC.put("Price Point not valid", "Valid");
		htEleFC.put("Rates not numeric", "Valid");
		htEleFC.put("Commodity price and hedged prices missing", "Valid");
		htEleFC.put("Standing charge price point not valid", "Valid");
		htEleFC.put("Duplicate meter for the same period", "Warning");
		return htEleFC;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Valid");
		htEleFC.put("Missing MPRN", "Valid");
		htEleFC.put("Invalid MPRN", "Valid");
		htEleFC.put("Missing Contract ref", "Error");
		htEleFC.put("Invalid/Missing Supplier", "Error");
		htEleFC.put("Invalid Start Date", "Error");
		htEleFC.put("Invalid End Date", "Error");
		htEleFC.put("Invalid Pay Month", "Error");
		htEleFC.put("Pay Term Not valid", "Valid");
		htEleFC.put("Price Point not valid", "Valid");
		htEleFC.put("Rates not numeric", "Valid");
		htEleFC.put("Commodity price and hedged prices missing", "Valid");
		htEleFC.put("Standing charge price point not valid", "Valid");
		htEleFC.put("Duplicate meter for the same period", "Valid");
		return htEleFC;
	}

}
