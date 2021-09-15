
package com.Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		File f = new File("resources/config.properties");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		prop.load(br);
		return prop;
	}
}
