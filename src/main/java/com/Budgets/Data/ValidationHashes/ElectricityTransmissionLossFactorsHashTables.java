package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityTransmissionLossFactorsHashTables {

	public Hashtable<String, String> getGreenHash() {
		Hashtable<String, String> htTFTLF = new Hashtable<String, String>();
		htTFTLF.put("GSP Group Invalid","Valid");     
		htTFTLF.put("Invalid Date","Valid");    
		htTFTLF.put("Period Data not numeric","Valid");    
		htTFTLF.put("Missing period data in day","Valid");    
		htTFTLF.put("Missing Days in sequence per MPAN","Valid"); 
		htTFTLF.put("Duplicate days - same GSP Group","Valid");
		return htTFTLF;
	}

	public Hashtable<String, String> getRedHash() {
		Hashtable<String, String> htTFTLF = new Hashtable<String, String>();
		htTFTLF.put("GSP Group Invalid","Error");     
		htTFTLF.put("Invalid Date","Error");    
		htTFTLF.put("Period Data not numeric","Valid");    
		htTFTLF.put("Missing period data in day","Valid");    
		htTFTLF.put("Missing Days in sequence per MPAN","Valid"); 
		htTFTLF.put("Duplicate days - same GSP Group","Valid");
		return htTFTLF;
	}

	public Hashtable<String, String> getAmberHash() {
		Hashtable<String, String> htTFTLF = new Hashtable<String, String>();
		htTFTLF.put("GSP Group Invalid","Valid");     
		htTFTLF.put("Invalid Date","Error");    
		htTFTLF.put("Period Data not numeric","Valid");    
		htTFTLF.put("Missing period data in day","Warning");    
		htTFTLF.put("Missing Days in sequence per MPAN","Warning"); 
		htTFTLF.put("Duplicate days - same GSP Group","Warning");
		return htTFTLF;
	}

	public Hashtable<String, String> getAARHash() {
		Hashtable<String, String> htTFTLF = new Hashtable<String, String>();
		htTFTLF.put("GSP Group Invalid","Error");     
		htTFTLF.put("Invalid Date","Error");    
		htTFTLF.put("Period Data not numeric","Error");    
		htTFTLF.put("Missing period data in day","Warning");    
		htTFTLF.put("Missing Days in sequence per MPAN","Valid"); 
		htTFTLF.put("Duplicate days - same GSP Group","Valid");
		return htTFTLF;
	}

}
