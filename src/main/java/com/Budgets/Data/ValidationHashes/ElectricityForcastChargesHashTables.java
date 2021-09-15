package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityForcastChargesHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Valid");
		htEleFC.put("Missing MPAN", "Valid");
		htEleFC.put("Invalid MPAN", "Valid");
		htEleFC.put("Missing Contract ref", "Valid");
		htEleFC.put("Invalid/Missing Supplier", "Valid");
		htEleFC.put("Invalid Start Date", "Valid");
		htEleFC.put("Invalid End Date", "Valid");
		htEleFC.put("Invalid Pay Month", "Valid");
		htEleFC.put("Invalid Triad Pay Month", "Valid");
		htEleFC.put("Pay Term Not valid", "Valid");
		htEleFC.put("Price Point not valid", "Valid");
		htEleFC.put("Rates not numeric", "Valid");
		htEleFC.put("Rates not numeric and not Published or Inspired View", "Valid");
		htEleFC.put("Commodity price and hedged prices missing", "Valid");
		htEleFC.put("Energy rate price point not valid", "Valid");
		htEleFC.put("Standing charge price point not valid", "Valid");
		htEleFC.put("Settlement charge price point not valid", "Valid");
		htEleFC.put("Invalid Triad MD", "Valid");
		htEleFC.put("Inspired / Published missing Rates", "Valid");
		htEleFC.put("Duplicate meter for the same period", "Valid");
		return htEleFC;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Error");
		htEleFC.put("Missing MPAN", "Valid");
		htEleFC.put("Invalid MPAN", "Error");
		htEleFC.put("Missing Contract ref", "Error");
		htEleFC.put("Invalid/Missing Supplier", "Error");
		htEleFC.put("Invalid Start Date", "Error");
		htEleFC.put("Invalid End Date", "Error");
		htEleFC.put("Invalid Pay Month", "Error");
		htEleFC.put("Invalid Triad Pay Month", "Error");
		htEleFC.put("Pay Term Not valid", "Error");
		htEleFC.put("Price Point not valid", "Error");
		htEleFC.put("Rates not numeric", "Error");
		htEleFC.put("Rates not numeric and not Published or Inspired View", "Error");
		htEleFC.put("Commodity price and hedged prices missing", "Error");
		htEleFC.put("Energy rate price point not valid", "Error");
		htEleFC.put("Standing charge price point not valid", "Error");
		htEleFC.put("Settlement charge price point not valid", "Error");
		htEleFC.put("Invalid Triad MD", "Valid");
		htEleFC.put("Inspired / Published missing Rates", "Valid");
		htEleFC.put("Duplicate meter for the same period", "Warning");
		return htEleFC;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Valid");
		htEleFC.put("Missing MPAN", "Valid");
		htEleFC.put("Invalid MPAN", "Valid");
		htEleFC.put("Missing Contract ref", "Valid");
		htEleFC.put("Invalid/Missing Supplier", "Valid");
		htEleFC.put("Invalid Start Date", "Valid");
		htEleFC.put("Invalid End Date", "Valid");
		htEleFC.put("Invalid Pay Month", "Valid");
		htEleFC.put("Invalid Triad Pay Month", "Valid");
		htEleFC.put("Pay Term Not valid", "Valid");
		htEleFC.put("Price Point not valid", "Valid");
		htEleFC.put("Rates not numeric", "Valid");
		htEleFC.put("Rates not numeric and not Published or Inspired View", "Valid");
		htEleFC.put("Commodity price and hedged prices missing", "Valid");
		htEleFC.put("Energy rate price point not valid", "Valid");
		htEleFC.put("Standing charge price point not valid", "Valid");
		htEleFC.put("Settlement charge price point not valid", "Valid");
		htEleFC.put("Invalid Triad MD", "Valid");
		htEleFC.put("Inspired / Published missing Rates", "Warning");
		htEleFC.put("Duplicate meter for the same period", "Valid");
		return htEleFC;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htEleFC = new Hashtable<String, String>();
		htEleFC.put("Duplicate Contract and Meter", "Error");
		htEleFC.put("Missing MPAN", "Valid");
		htEleFC.put("Invalid MPAN", "Error");
		htEleFC.put("Missing Contract ref", "Error");
		htEleFC.put("Invalid/Missing Supplier", "Error");
		htEleFC.put("Invalid Start Date", "Error");
		htEleFC.put("Invalid End Date", "Error");
		htEleFC.put("Invalid Pay Month", "Error");
		htEleFC.put("Invalid Triad Pay Month", "Error");
		htEleFC.put("Pay Term Not valid", "Error");
		htEleFC.put("Price Point not valid", "Error");
		htEleFC.put("Rates not numeric", "Error");
		htEleFC.put("Rates not numeric and not Published or Inspired View", "Error");
		htEleFC.put("Commodity price and hedged prices missing", "Error");
		htEleFC.put("Energy rate price point not valid", "Error");
		htEleFC.put("Standing charge price point not valid", "Error");
		htEleFC.put("Settlement charge price point not valid", "Error");
		htEleFC.put("Invalid Triad MD", "Valid");
		htEleFC.put("Inspired / Published missing Rates", "Valid");
		htEleFC.put("Duplicate meter for the same period", "Warning");
		return htEleFC;
	}
}