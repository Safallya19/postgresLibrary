package com.custom.postgres;

import com.mindtree.postgres.connector.DatabaseExecute;
import com.mindtree.postgres.connector.MTLibPostgresConnect;
import org.springframework.core.env.Environment;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
public  class  H2Database  {
	
	/*
	 * @Autowired private Environment env;
	 * 
	 * @Value("${spring.datasource.url}") private String url;
	 */
	
	//Query1 : Select * from TBL_EMPLOYEES
	//Query2 : Select * from TBL_EMPLOYEES where ID = 1
	//Query3 : Select * from TBL_EMPLOYEES order by first_name ASC
	//Query4 : Select * from TBL_EMPLOYEES OFFSET 1 
	//Query5 : Select * from TBL_EMPLOYEES LIMIT 2 OFFSET 1
	//Query6 : INSERT INTO TBL_EMPLOYEES (id, first_name, last_name, email) VALUES (4,'Aks', 'R', 'abr@gmail.com')
	//Query7 : Update TBL_EMPLOYEES set first_name= 'AKSHATHA' where id=4
	//Query8 : Delete from TBL_EMPLOYEES where first_name='AKSHATHA'
	private static ResultSet rs = null;
	 @MTLibPostgresConnect(query = "Select * from Persons", datasourceUrl = "jdbc:h2:file:C:/H2/data", datasourcePassword = "password", datasourceUsername = "sa", processingMethod = "processing")
	 public void pgDatabase() throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		
		System.out.println("FLow Control: Custom code : Invoking connector library API");
		//Library class
		DatabaseExecute dbExecute = new DatabaseExecute();
		dbExecute.executeQuery(this);
		

	}
	 
	public void processing(ResultSet rs) throws SQLException {
		System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", "ID", "FIRST_NAME", "LAST_NAME", "EMAIL");
		while(rs.next()) {
//1st table TBL_EMPLOYEES
//			System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n",
//					 rs.getString("id"), rs.getString("first_name"), rs.getString("last_name"),
//					 rs.getString("email"));
	
//2nd Table PERSONS			
			System.out.printf("%-30.30s  %-30.30s  %-30.30s%n",
					 rs.getString(1), rs.getString(2), rs.getString(3));
		}
	}
     
	  
		
		  


}
