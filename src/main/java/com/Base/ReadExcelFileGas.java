
package com.Base;

import com.Budgets.AbstractTestNg;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcelFileGas extends AbstractTestNg {

	public static String strGasSites;
	public static double dblGasSites;
	public static String strGasEstConsumption;
	public static double dblGasEstConsumption;
	public static String strGasEstAverageRate;
	public static double dblGasEstAverageRate;
	public static String strGasEstAnnualSpend;
	public static double dblGasEstAnnualSpend;

	public ReadExcelFileGas() throws IOException {
	}

	static String Excel_File_Gas = "BudgetTestResult//Automation Final Calculation Gas.xls";

	public static File readSummary(String excel_File_Gas) {
		try {
			InputStream ExcelFileToReadGas = new FileInputStream(Excel_File_Gas);
			HSSFWorkbook wbGas = new HSSFWorkbook(ExcelFileToReadGas);
			HSSFSheet sheetGas = wbGas.getSheetAt(0);
			strGasSites = sheetGas.getRow(8).getCell(3).getStringCellValue();
			dblGasSites = sheetGas.getRow(9).getCell(3).getNumericCellValue();
			strGasEstConsumption = sheetGas.getRow(8).getCell(15).getStringCellValue();
			dblGasEstConsumption = sheetGas.getRow(9).getCell(13).getNumericCellValue();
			strGasEstAverageRate = sheetGas.getRow(1).getCell(15).getStringCellValue();
			dblGasEstAverageRate = sheetGas.getRow(2).getCell(14).getNumericCellValue();
			strGasEstAnnualSpend = sheetGas.getRow(8).getCell(21).getStringCellValue();
			dblGasEstAnnualSpend = sheetGas.getRow(9).getCell(19).getNumericCellValue();
			System.out.println("*********************************************");
			System.out.println(strGasSites + "-" + dblGasSites);
			System.out.println();
			System.out.println(strGasEstConsumption + "-" + dblGasEstConsumption);
			System.out.println();
			System.out.println(strGasEstAverageRate + "-" + dblGasEstAverageRate);
			System.out.println();
			System.out.println(strGasEstAnnualSpend + "-" + dblGasEstAnnualSpend);
			System.out.println();
			System.out.println("*********************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}