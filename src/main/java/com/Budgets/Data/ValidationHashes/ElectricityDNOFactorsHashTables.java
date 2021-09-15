package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityDNOFactorsHashTables {
	
	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htTAFDF = new Hashtable<String, String>();
		htTAFDF.put("Missing DNO", "Valid");
	    htTAFDF.put("Missing LLF", "Valid");
	    htTAFDF.put("Factor not numeric or missing", "Valid");
	    htTAFDF.put("Invalid missing start time", "Valid");
	    htTAFDF.put("Invalid missing end time", "Valid");
	    htTAFDF.put("Invalid missing start date", "Valid");
	    htTAFDF.put("Invalid missing end date", "Valid");
		return htTAFDF;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htTAFDF = new Hashtable<String, String>();
		htTAFDF.put("Missing DNO", "Error");
		htTAFDF.put("Missing LLF", "Error");
		htTAFDF.put("Factor not numeric or missing", "Error");
		htTAFDF.put("Invalid missing start time", "Error");
		htTAFDF.put("Invalid missing end time", "Error");
		htTAFDF.put("Invalid missing start date", "Error");
		htTAFDF.put("Invalid missing end date", "Error");
		return htTAFDF;
	}

}
