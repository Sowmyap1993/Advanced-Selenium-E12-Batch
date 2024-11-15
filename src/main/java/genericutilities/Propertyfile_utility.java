package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Kavya
 * This class consists of generic methods related to Property file
 */
public class Propertyfile_utility {
	/**
	 * THis method is used to read data from property file and returns value
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String input) throws IOException 
	{
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(input);
		return value;
	}
}
