package reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {
	
	static Properties prop = new Properties();

	public static String getPropertyValue(String key) throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		String value = prop.get(key).toString();

		return value;
	}

}
