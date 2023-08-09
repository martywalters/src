package com.src;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		var db = Database.instance();

		try {
			db.connect();
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
		} else {
			System.out.println("no user retrieved");
		}
		userOpt = userDao.findById(25);
		if (userOpt.isPresent()) {
			System.out.println("retrived: " + userOpt.get());
		} else {
			System.out.println("no user retrieved");
		}

		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Close filed");
		}
		System.out.println("DB closed");
	}
}
