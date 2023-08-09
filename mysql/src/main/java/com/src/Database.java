package com.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Database db = new Database();
	private static final String URI = "jdbc:mysql://localhost:3306/people";
	private static Connection conn;
	public static Database instance() {
		return db;
	}
	private Database() {
		
	}
	public void connect() throws SQLException {
		conn = DriverManager.getConnection(URI,"root","password");
		
	}
	public void close() throws SQLException {
		conn.close();
		
	}
	public Connection getConnection() {
		return conn;
	}
}
