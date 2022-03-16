package com.Pricecast.Tariff;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.Tariffs.Tariff;
import com.Pricecast.PageObjects.Tariffs.excelUtilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC02_Tariff_BulkUpload extends AbstractTestNg{

  public PR163_TC02_Tariff_BulkUpload() throws IOException {
  }

  String path = "PricecastTestData/TariffBulkUploadData.xlsx";

  @Test(dataProvider="uploadData")
  public void UploadBulk(String FileName, String Utility, String Supplier, String TariffType, String SheetType, String StartDate, String WindowStart, String WindowEnd) {
    Tariff tariff = new Tariff(webDriverHandler);
    tariff.TariffAccess();
    tariff.waitLoad();
    tariff.UploadSheetsExcel(
            FileName,
            Utility,
            Supplier,
            TariffType,
            SheetType,
            StartDate,
            WindowStart,
            WindowEnd
    );
  }

  @Test(dataProvider="statusData")
  public void statusUpdate(String fileName, int rowNo) throws IOException {
    Tariff tariff = new Tariff(webDriverHandler);
    tariff.TariffAccess();
    tariff.waitLoad();
    tariff.search(fileName);
    String status = tariff.statusCheck();
    excelUtilities ex = new excelUtilities();
    ex.writeExcel(path, rowNo, 8, status);
  }

  @DataProvider(name="uploadData")
  public Object[][] tariffData() throws IOException {
    excelUtilities ex = new excelUtilities();
    Object [][] arrayObject = ex.readExcel(path);
    return arrayObject;
  }

  @DataProvider(name="statusData")
  public Object[] statusData() throws IOException {
    excelUtilities ex = new excelUtilities();
    Object [][] arrayObject = ex.statusUpdate(path);
    return arrayObject;
  }
}