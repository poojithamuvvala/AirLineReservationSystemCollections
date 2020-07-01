package com.javafullstack.airlinereservationsystemjdbc.utility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.javafullstackfeb.airlinereservationsystemjdbc.exception.AirLineReservationSystemException;

public class JDBCUtility {

	
	public static Connection getConnection() throws AirLineReservationSystemException {
		
		Connection connection = null;
		try {
			FileInputStream inputStream = new FileInputStream("dbconnection.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			Class.forName(properties.getProperty("path"));
			connection =  DriverManager.getConnection(properties.getProperty("dburl"));
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	public static String getQuery(String baseQuery) {
			String query = null;
			FileInputStream inputStream;
			try {
				inputStream = new FileInputStream("dbconnection.properties");
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
