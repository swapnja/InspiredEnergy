
package com.Base;

import com.Budgets.AbstractTestNg;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcelFileElectricity extends AbstractTestNg {

	public static String strElectricitySites;
	public static double dblElectricitySites;
	public static String strElectricityEstConsumption;
	public static double dblElectricityEstConsumption;
	public static String strElectricityEstAverageRate;
	public static double dblElectricityEstAverageRate;
	public static String strElectricityEstAnnualSpend;
	public static double dblElectricityEstAnnualSpend;

	static String Excel_File_Electricity = "BudgetTestResult/Automation Final Calculation Electricity.xls";
	static String Excel_File_Gas = "BudgetTestResult/Automation Final Calculation Gas.xls";

	public ReadExcelFileElectricity() throws IOException {
	}

	public static File readSummary(String excel_File) {
		try {
			InputStream ExcelFileToReadElectricity = new FileInputStream(Excel_File_Electricity);
			HSSFWorkbook wbElectricity = new HSSFWorkbook(ExcelFileToReadElectricity);
			HSSFSheet sheetElectricity = wbElectricity.getSheetAt(0);
			strElectricitySites = sheetElectricity.getRow(8).getCell(3).getStringCellValue();
			dblElectricitySites = sheetElectricity.getRow(9).getCell(3).getNumericCellValue();
			strElectricityEstConsumption = sheetElectricity.getRow(8).getCell(15).getStringCellValue();
			dblElectricityEstConsumption = sheetElectricity.getRow(9).getCell(13).getNumericCellValue();
			strElectricityEstAverageRate = sheetElectricity.getRow(1).getCell(15).getStringCellValue();
			dblElectricityEstAverageRate = sheetElectricity.getRow(2).getCell(14).getNumericCellValue();
			strElectricityEstAnnualSpend = sheetElectricity.getRow(8).getCell(21).getStringCellValue();
			dblElectricityEstAnnualSpend = sheetElectricity.getRow(9).getCell(19).getNumericCellValue();
			System.out.println("*********************************************");
			System.out.println(strElectricitySites + "-" + dblElectricitySites);
			System.out.println();
			System.out.println(strElectricityEstConsumption + "-" + dblElectricityEstConsumption);
			System.out.println();
			System.out.println(strElectricityEstAverageRate + "-" + dblElectricityEstAverageRate);
			System.out.println();
			System.out.println(strElectricityEstAnnualSpend + "-" + dblElectricityEstAnnualSpend);
			System.out.println();
			System.out.println("*********************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}