
package com.Base;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadFormulaEvalutor {

	static String Excel_File = "D:/BudgetTestResult/demo.xls";

	public static File readXLSFile(String excel_File) {
		try {
			InputStream ExcelFileToRead = new FileInputStream(Excel_File);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
			HSSFSheet sheet = wb.getSheetAt(0);
			System.out.println("*********************************************");
			System.out.println(sheet.getRow(8).getCell(3).getStringCellValue());
			System.out.println(sheet.getRow(10).getCell(3).getNumericCellValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
