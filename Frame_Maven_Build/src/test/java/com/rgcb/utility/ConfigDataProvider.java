/**
 * 
 */
package com.rgcb.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

/**
 * @author Jabir Jaleel
 *
 */
public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider() {
		File src = new File(".//Config//config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
		    pro=new Properties();
			pro.load(fis);//load config file
		} catch (Exception e) {
			System.out.println("Not Able To Load Config File" + e.getMessage());
	
		}
	
	}
	
	public String Browser() {
		
		return pro.getProperty("Browser");
		
	}
	
	public String RgcbLoginUrl() {
		
		return pro.getProperty("RgcbLoginUrl");
		
	}

}
