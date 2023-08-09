package com.src;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ProfileTest {
	
	@Test
	public void testLoadDBCofig() {
		try {
			var props = Profile.getProperties("db");
			
			Assert.assertNotNull("cannot load db properties", props);
			
			
			var dbName = props.getProperty("database");
			Assert.assertEquals("dbname incorrect","peopletest",dbName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
