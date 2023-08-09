package com.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Profile {
	public static Properties getProperties(String name) throws IOException {
		Properties p=new Properties(); 
		try {
			
			String env = System.getProperty("env");
			if (env == null) {
				env = "dev";
			}
			String propertiesFile = String.format("db.%s.properties", env);
			System.out.println(propertiesFile);
			FileReader reader=new FileReader(propertiesFile);
		    //Properties p=new Properties();  
		    p.load(reader);  		      
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		return p;
		
	}
}
