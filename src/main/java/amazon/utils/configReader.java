package amazon.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	private Properties properties;

	public Properties initializeProperties() {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
