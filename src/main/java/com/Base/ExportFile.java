
package com.Base;

import java.io.File;

public class ExportFile {

	public static String csvFileName;

	public ExportFile() throws InterruptedException {
		Thread.sleep(5000);
		String downloadPath = "C:\\Users\\Swapnja\\Downloads";
		File file = getLatestFilefromDir(downloadPath);
		csvFileName = file.getName();
		System.out.println("Export File Functionality is working fine :" + csvFileName);
	}

	public static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
}