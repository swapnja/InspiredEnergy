package com.Budgets.Data.ValidationHashes;

import java.util.Hashtable;

public class ElectricityConsumptionAdjustmentHashTables {

    public Hashtable<String, String> getGreenHash() {
	Hashtable<String, String> htCA = new Hashtable<String, String>();
	htCA.put("MPAN / MPRN not valid", "Valid");
	htCA.put("Missing Location Code", "Valid");
	htCA.put("Missing Consumption for period", "Valid");
	htCA.put("Duplicate Meters", "Valid");
	htCA.put("Invalid Start Date", "Valid");
	return htCA;
    }

    public Hashtable<String, String> getRedHash() {
	Hashtable<String, String> htCA = new Hashtable<String, String>();
	htCA.put("MPAN / MPRN not valid", "Error");
	htCA.put("Missing Location Code", "Error");
	htCA.put("Missing Consumption for period", "Error");
	htCA.put("Duplicate Meters", "Error");
	htCA.put("Invalid Start Date", "Error");
	return htCA;
    }

}
