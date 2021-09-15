package com.Pricecast.PageObjects.Tariffs;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelUtilities {

    public Object[][] readExcel(String filePath) throws IOException {
        FileInputStream fs = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fs);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = row.getLastCellNum();
        Object data[][] = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
            //   data[i][j] = sheet.getRow(i+1).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            	   data[i][j] = sheet.getRow(i+1).getCell(j, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
            }
        }
        return data;
    }

    public Object[][] statusUpdate(String filePath) throws IOException {
        FileInputStream fs = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fs);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        Object data[][] = new Object[rowCount][2];
        for (int i = 0; i < rowCount; i++) {
              //  data[i][0] = sheet.getRow(i + 1).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
        	  data[i][0] = sheet.getRow(i + 1).getCell(0, Row.CREATE_NULL_AS_BLANK).getStringCellValue();    
        	data[i][1] = i+1;
        }
        fs.close();
        return data;
    }

    public void writeExcel (String filePath, int rowno , int colno, String value) throws IOException {
        FileInputStream fs = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fs);
        Sheet sheet = workbook.getSheetAt(0);
        try
        {
            Row row = sheet.getRow(rowno);
            Cell cell = row.createCell(colno);
            cell.setCellValue(value);
        }
        catch (Exception e){
            Row row = sheet.createRow(rowno);
            Cell cell = row.createCell(colno);
            cell.setCellValue(value);
        }
        fs.close();
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
    }
}
