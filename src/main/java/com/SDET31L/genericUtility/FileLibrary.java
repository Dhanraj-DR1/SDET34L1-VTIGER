package com.SDET31L.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only property file specific common methods
 * @author Dhanraj
 *
 */

public class FileLibrary {
	
	static Properties property;
	/**
	 * This method is used to open property file
	 * @throws IOException 
	 */
	public static void openPropertyFile(String filepath) throws IOException
	{

	FileInputStream fis=new FileInputStream(filepath);
	property = new Properties();
	property.load(fis);
	}
    /**
     * This method is used tho get key values
     * @param key
     * @return
     * @throws IOException
     */
	
    public static String fetchDataFromPropertyFile(String key) throws IOException
    {
    	
    	String value=property.getProperty(key);
    	return value;
    }
}