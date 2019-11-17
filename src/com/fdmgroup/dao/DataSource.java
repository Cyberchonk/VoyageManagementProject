package com.fdmgroup.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {

	private static DataSource ds;
	private ComboPooledDataSource cpds;
	
	private DataSource(){
		cpds = new ComboPooledDataSource(); 
		Properties properties = null;
		
		FileReader reader;
		try {
			reader = new FileReader("DBConfig.properties");
			properties = new Properties();
			properties.load(reader);
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cpds.setJdbcUrl(properties.getProperty("db.connection.url")); // JDBC url
		cpds.setUser(properties.getProperty("db.username")); // UserName
		cpds.setPassword(properties.getProperty("db.password")); // password
		
		// connection pooling properties
		cpds.setMinPoolSize(3);
		cpds.setMaxPoolSize(50);
		cpds.setAcquireIncrement(3); // create 3 when resource fully occupied
		cpds.setMaxStatements(10); // 10 prepared statements in the catch
		
	}
	
	public static DataSource getInstance(){
		
		if(ds == null){
			ds = new DataSource();
		}
		
		return ds;
	}
	
	public Connection getConnection() throws SQLException{
		
		return cpds.getConnection();
	}
}
