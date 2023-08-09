package com.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		Properties p=new Properties(); 
		try {
			FileReader reader=new FileReader("db.properties");
		    //Properties p=new Properties();  
		    p.load(reader);  
		      
		    System.out.println(p.getProperty("user"));  
		    System.out.println(p.getProperty("password"));  
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		
		
		
		var db = Database.instance();

		try {
			db.connect(p);
		} catch (SQLException e) {
			System.out.println("Connot connect to database");
		}
		System.out.println("Connected");
		UserDao userDao = new UserDaoImpl();
		// userDao.save(new User("Mars"));

		var users = userDao.getAll();
		users.forEach(System.out::println);

		var userOpt = userDao.findById(5);
		if (userOpt.isPresent()) {
			System.out.println("retrived: " + userOpt.get());
			User user = userOpt.get();
			user.setName("Marty");
			userDao.update(user);
		} else {
			System.out.println("no user retrieved");
		}
		userOpt = userDao.findById(25);
		if (userOpt.isPresent()) {
			System.out.println("retrived: " + userOpt.get());
		} else {
			System.out.println("no user retrieved");
		}
		
		userDao.delete(new User(9,null));
		
		
		
		

		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Close filed");
		}
		System.out.println("DB closed");
	}
}
