package com.javafullstackfeb.airlinereservationsystemhibernate.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;

public class JDBCUtility {
private static Connection connection = null;
	
	public static Connection getConnection() throws AirLineReservationSystemException {
		
		File file = null;
		FileInputStream inputStream = null;
		
		file = new File("dbconnection.properties");
		try {
			inputStream = new FileInputStream(file);
			
			Properties properties = new Properties();
			properties.load(inputStream);
			
			String path = properties.getProperty("path");
			String dburl = properties.getProperty("dburl");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
			Class.forName(path);
			connection = DriverManager.getConnection(dburl, user, password);
			
		} catch (FileNotFoundException e) {
			throw new AirLineReservationSystemException("File not exists");
		} catch (IOException e) {
			throw new AirLineReservationSystemException("Unable to read the data from the file");
		} catch (ClassNotFoundException e) {
			throw new AirLineReservationSystemException("Class not loaded");
		} catch (SQLException e) {
			throw new AirLineReservationSystemException("Connection issue");
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new AirLineReservationSystemException("Unable to close the file");
			}
			}
			return connection;
		}
	public String getQuery(String baseQuery) {
			String query = null;
			FileInputStream inputStream;
			try {
				inputStream = new FileInputStream("airline.properties");
				Properties properties = new Properties();
				properties.load(inputStream);
				query = properties.getProperty(baseQuery);

				return query;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
	
}
