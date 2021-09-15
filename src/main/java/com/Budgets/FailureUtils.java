package com.Budgets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class FailureUtils {
    static String appendDate = TimeStampPageHandler.FileNameTime();
    public static void screenshot(WebDriver driver, String scrShotPath) throws IOException {
        TakesScreenshot scrShot =  ((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File(scrShotPath+appendDate+".png"));
    }

//    public static void errorlog(String scrShotPath) throws IOException {
//        File file = new File(scrShotPath+".log");
//        FileOutputStream fos = new FileOutputStream(file);
//        PrintStream ps = new PrintStream(fos);
//        System.setOut(ps);
//        ps.close();
//    }
}