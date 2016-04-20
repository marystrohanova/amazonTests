package framework.configuration;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	private static final String CONFIG_FILE = "/config.properties";
	private static Properties prop = new Properties();
	
	private static void openFile(String file){
		InputStream inpStream = Properties.class.getResourceAsStream(file);
		
		try {
			prop.load(inpStream);
		} catch (Exception e) {
			System.out.println("Error opening file: " + file);
			throw new RuntimeException(e);
		}
	}
	
	public static String getValue(String key){
		String value = null;
		openFile(CONFIG_FILE);
		
		value = prop.getProperty(key);
		
		if (value == null){
			String msg = "Value not found for: " + key;
			System.out.println(msg);
			
			throw new RuntimeException(msg);
		}
		
		return value;
	}
}
