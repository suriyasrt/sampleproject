package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class configreader {
	
	 static Properties prop;

	    static { //A static block executes only once when the class is loaded (before any method calls).
	        try {
	        	//open file to read values
	            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
	            //hold key-value pairs from the properties file.
	            prop = new Properties();
	            //This loads all values from the file into memory.
	            prop.load(fis);
	        }
	        catch (Exception e)
	        { 
	        	e.printStackTrace();
	        }
	    }

	  
	    public String getBrowser() {
	        return prop.getProperty("browser");
	    }

	    public String getUrl() {
	        return prop.getProperty("url");
	    }

		public static String getProperty(String string) {
			return string;
			// TODO Auto-generated method stub
			
		}
}
