
package com.Base;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExcelFileExtra extends ExportFile {

	public ReadExcelFileExtra() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	static String Excel_File = "D:/BudgetTestResult/demo.xls";

	public static File readXLSFile(String excel_File) {
		try {
			InputStream ExcelFileToRead = new FileInputStream(Excel_File);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
			HSSFSheet sheet = wb.getSheetAt(0);
			/*
			 * HSSFRow row; HSSFCell cell; Iterator rows = sheet.rowIterator();
			 */
			// wb.getCreationHelper().createFormulaEvaluator().evaluateAll();
			System.out.println("*********************************************");
			System.out.println(sheet.getRow(5).getCell(1).getStringCellValue());
			System.out.println(sheet.getRow(9).getCell(13).getNumericCellValue());
			/*
			 * while (rows.hasNext()) { row = (HSSFRow) rows.next(); Iterator cells = row.cellIterator();
			 * 
			 * 
			 * while (cells.hasNext()) { cell = (HSSFCell) cells.next(); System.out.println(cell.toString()); } System.out.println();
			 * 
			 * 
			 * 
			 * 
			 * }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}