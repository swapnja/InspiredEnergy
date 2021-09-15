package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityDNORAGTimesHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htTAFDRT = new Hashtable<String, String>();
		htTAFDRT.put("Missing DNO", "Valid");
		htTAFDRT.put("Missing LLF", "Valid");
		htTAFDRT.put("RAG Type is not valid", "Valid");
		htTAFDRT.put("Invalid missing start time", "Valid");
		htTAFDRT.put("Invalid missing end time", "Valid");
		htTAFDRT.put("Invalid missing start date", "Valid");
		htTAFDRT.put("Invalid missing end date", "Valid");
		return htTAFDRT;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htTAFDRT = new Hashtable<String, String>();
		htTAFDRT.put("Missing DNO", "Error");
		htTAFDRT.put("Missing LLF", "Error");
		htTAFDRT.put("RAG Type is not valid", "Error");
		htTAFDRT.put("Invalid missing start time", "Error");
	    htTAFDRT.put("Invalid missing end time", "Error");
	    htTAFDRT.put("Invalid missing start date", "Error");
	    htTAFDRT.put("Invalid missing end date", "Error");
		return htTAFDRT;
	}
}
