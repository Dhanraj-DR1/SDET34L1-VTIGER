package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectionTest {
	
	public static void main(String[] args) throws SQLException {
		
		//step1: create object for implementation class
		
		Driver driver=new Driver();
		
		//step2:Register the driver with JDBC
		
	    DriverManager.registerDriver(driver);
		
	
		//step3:Establish the database connection
		Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		//step4:create statement
		Statement statement = Connection.createStatement();
		
		//step5:Execute Query
		ResultSet result = statement.executeQuery("select * from sdet34");
		
		//step6:validate
		while(result.next())
		{
			System.out.println(result.getString(2)+" "+result.getString("address"));
		
			
		}
		
		//step7:close the connection
		Connection.close();
		
		

	
	
		
		
		
		
	}

}
