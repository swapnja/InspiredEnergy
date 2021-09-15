package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityMetersHashTables {
	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Missing Location Code", "Valid");
		ht.put("Missing Country", "Valid");
		ht.put("Missing MPAN", "Valid");
		ht.put("Invalid MPAN/MPRN", "Valid");
		ht.put("Missing Energy Type", "Valid");
		ht.put("Energy Type Invalid", "Valid");
		ht.put("KVA not numeric", "Valid");
		ht.put("Missing VAT Details", "Valid");
		ht.put("Invalid VAT Type", "Valid");
		ht.put("Split Rate <> numeric", "Valid");
		ht.put("VAT split provided where VAT type not Split - Visa Versa", "Valid");
		ht.put("Custom VAT % provided where VAT type not Custom - Visa Versa", "Valid");
		ht.put("CCA Exemption not numeric", "Valid");
		ht.put("Duplicate Meter for same period", "Valid");
		ht.put("Invalid Power Factor", "Valid");
		ht.put("Missing Start Date", "Valid");
		ht.put("Invalid Start Date", "Valid");
		ht.put("Invalid End Date", "Valid");
		ht.put("Invalid EII Relief - should be Y/N", "Valid");
		ht.put("Missing Building Name", "Valid");
		ht.put("Missing KVA", "Valid");
		return ht;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Missing Location Code", "Error");
		ht.put("Missing Country", "Error");
		ht.put("Missing MPAN/MPRN", "Error");
		ht.put("Invalid MPAN/MPRN", "Error");
		ht.put("Missing Energy Type", "Error");
		ht.put("Energy Type Invalid", "Error");
		ht.put("KVA not numeric", "Error");
		ht.put("Missing VAT Details", "Error");
		ht.put("Invalid VAT Type", "Error");
		ht.put("Split Rate <> numeric", "Valid");
		ht.put("VAT split provided where VAT type not Split - Visa Versa", "Error");
		ht.put("Custom VAT % provided where VAT type not Custom - Visa Versa", "Error");
		ht.put("CCA Exemption not numeric", "Error");
		ht.put("Duplicate Meter for same period", "Valid");
		ht.put("Invalid Power Factor", "Error");
		ht.put("Missing Start Date", "Error");
		ht.put("Invalid Start Date", "Valid");
		ht.put("Invalid End Date", "Valid");
		ht.put("Invalid EII Relief - should be Y/N", "Valid");
		ht.put("Missing Building Name", "Valid");
		ht.put("Missing KVA", "Valid");
		return ht;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Missing Location Code", "Valid");
		ht.put("Missing Country", "Valid");
		ht.put("Missing MPAN/MPRN", "Valid");
		ht.put("Invalid MPAN/MPRN", "Valid");
		ht.put("Missing Energy Type", "Valid");
		ht.put("Energy Type Invalid", "Valid");
		ht.put("KVA not numeric", "Valid");
		ht.put("Missing VAT Details", "Valid");
		ht.put("Invalid VAT Type", "Valid");
		ht.put("Split Rate <> numeric", "Valid");
		ht.put("VAT split provided where VAT type not Split - Visa Versa", "Valid");
		ht.put("Custom VAT % provided where VAT type not Custom - Visa Versa", "Valid");
		ht.put("CCA Exemption not numeric", "Valid");
		ht.put("Duplicate Meter for same period", "Valid");
		ht.put("Invalid Power Factor", "Valid");
		ht.put("Missing Start Date", "Valid");
		ht.put("Invalid Start Date", "Valid");
		ht.put("Invalid End Date", "Valid");
		ht.put("Invalid EII Relief - should be Y/N", "Valid");
		ht.put("Missing Building Name", "Warning");
		ht.put("Missing KVA", "Warning");
		return ht;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Missing Location Code", "Error");
		ht.put("Missing Country", "Error");
		ht.put("Missing MPAN/MPRN", "Error");
		ht.put("Invalid MPAN/MPRN", "Error");
		ht.put("Missing Energy Type", "Error");
		ht.put("Energy Type Invalid", "Error");
		ht.put("KVA not numeric", "Error");
		ht.put("Missing VAT Details", "Error");
		ht.put("Invalid VAT Type", "Error");
		ht.put("Split Rate <> numeric", "Valid");
		ht.put("VAT split provided where VAT type not Split - Visa Versa", "Error");
		ht.put("Custom VAT % provided where VAT type not Custom - Visa Versa", "Error");
		ht.put("CCA Exemption not numeric", "Error");
		ht.put("Duplicate Meter for same period", "Valid");
		ht.put("Invalid Power Factor", "Error");
		ht.put("Missing Start Date", "Error");
		ht.put("Invalid Start Date", "Valid");
		ht.put("Invalid End Date", "Valid");
		ht.put("Invalid EII Relief - should be Y/N", "Valid");
		ht.put("Missing Building Name", "Warning");
		ht.put("Missing KVA", "Warning");
		return ht;
	}

}
