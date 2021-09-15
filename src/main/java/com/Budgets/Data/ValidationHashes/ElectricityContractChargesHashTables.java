package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityContractChargesHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htEleCC = new Hashtable<String, String>();
		htEleCC.put("Duplicate Contract and Meter", "Valid");
		htEleCC.put("Missing MPAN", "Valid");
		htEleCC.put("Invalid MPAN", "Valid");
		htEleCC.put("Missing Contract ref", "Valid");
		htEleCC.put("Invalid/Missing Supplier", "Valid");
		htEleCC.put("Invalid Start Date", "Valid");
		htEleCC.put("Invalid End Date", "Valid");
		htEleCC.put("Invalid Pay Month", "Valid");
		htEleCC.put("Invalid Triad Pay Month", "Valid");
		htEleCC.put("Pay Term Not valid", "Valid");
		htEleCC.put("Price Point not valid", "Valid");
		htEleCC.put("Rates not numeric", "Valid");
		htEleCC.put("Rates not numeric and not Published or Inspired View", "Valid");
		htEleCC.put("All energy rates missing", "Valid");
		htEleCC.put("Energy rate price point not valid", "Valid");
		htEleCC.put("Standing charge price point not valid", "Valid");
		htEleCC.put("Settlement charge price point not valid", "Valid");
		htEleCC.put("Invalid Triad MD", "Valid");
		htEleCC.put("Inspired/Published missing Rates", "Valid");
		htEleCC.put("Duplicate meter for the same period", "Valid");
		return htEleCC;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htEleCC = new Hashtable<String, String>();
		htEleCC.put("Duplicate Contract and Meter", "Error");
		htEleCC.put("Missing MPAN", "Error");
		htEleCC.put("Invalid MPAN", "Error");
		htEleCC.put("Missing Contract ref", "Error");
		htEleCC.put("Invalid/Missing Supplier", "Error");
		htEleCC.put("Invalid Start Date", "Error");
		htEleCC.put("Invalid End Date", "Error");
		htEleCC.put("Invalid Pay Month", "Error");
		htEleCC.put("Invalid Triad Pay Month", "Error");
		htEleCC.put("Pay Term Not valid", "Error");
		htEleCC.put("Price Point not valid", "Error");
		htEleCC.put("Rates not numeric", "Error");
		htEleCC.put("Rates not numeric and not Published or Inspired View", "Error");
		htEleCC.put("All energy rates missing", "Error");
		htEleCC.put("Energy rate price point not valid", "Error");
		htEleCC.put("Standing charge price point not valid", "Error");
		htEleCC.put("Settlement charge price point not valid", "Error");
		htEleCC.put("Invalid Triad MD", "Valid");
		htEleCC.put("Inspired/Published missing Rates", "Valid");
		htEleCC.put("Duplicate meter for the same period", "Warning");
		return htEleCC;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htEleCC = new Hashtable<String, String>();
		htEleCC.put("Duplicate Contract and Meter", "Valid");
		htEleCC.put("Missing MPAN", "Valid");
		htEleCC.put("Invalid MPAN", "Valid");
		htEleCC.put("Missing Contract ref", "Valid");
		htEleCC.put("Invalid/Missing Supplier", "Valid");
		htEleCC.put("Invalid Start Date", "Valid");
		htEleCC.put("Invalid End Date", "Valid");
		htEleCC.put("Invalid Pay Month", "Valid");
		htEleCC.put("Invalid Triad Pay Month", "Valid");
		htEleCC.put("Pay Term Not valid", "Valid");
		htEleCC.put("Price Point not valid", "Valid");
		htEleCC.put("Rates not numeric", "Valid");
		htEleCC.put("Rates not numeric and not Published or Inspired View", "Valid");
		htEleCC.put("All energy rates missing", "Valid");
		htEleCC.put("Energy rate price point not valid", "Valid");
		htEleCC.put("Standing charge price point not valid", "Valid");
		htEleCC.put("Settlement charge price point not valid", "Valid");
		htEleCC.put("Invalid Triad MD", "Valid");
		htEleCC.put("Inspired/Published missing Rates", "Warning");
		htEleCC.put("Duplicate meter for the same period", "Valid");
		return htEleCC;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htEleCC = new Hashtable<String, String>();
		htEleCC.put("Duplicate Contract and Meter", "Error");
		htEleCC.put("Missing MPAN", "Error");
		htEleCC.put("Invalid MPAN", "Error");
		htEleCC.put("Missing Contract ref", "Error");
		htEleCC.put("Invalid/Missing Supplier", "Error");
		htEleCC.put("Invalid Start Date", "Error");
		htEleCC.put("Invalid End Date", "Error");
		htEleCC.put("Invalid Pay Month", "Error");
		htEleCC.put("Invalid Triad Pay Month", "Error");
		htEleCC.put("Pay Term Not valid", "Error");
		htEleCC.put("Price Point not valid", "Error");
		htEleCC.put("Rates not numeric", "Error");
		htEleCC.put("Rates not numeric and not Published or Inspired View", "Error");
		htEleCC.put("All energy rates missing", "Error");
		htEleCC.put("Energy rate price point not valid", "Error");
		htEleCC.put("Standing charge price point not valid", "Error");
		htEleCC.put("Settlement charge price point not valid", "Error");
		htEleCC.put("Invalid Triad MD", "Valid");
		htEleCC.put("Inspired/Published missing Rates", "Valid");
		htEleCC.put("Duplicate meter for the same period", "Warning");
		return htEleCC;
	}

}
