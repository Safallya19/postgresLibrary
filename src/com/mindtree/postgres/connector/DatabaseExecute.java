package com.mindtree.postgres.connector;
import java.lang.reflect.*;
import java.sql.DriverManager;


/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;*/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.data.jpa.repository.Query;
 

public class DatabaseExecute {
	
	/*
	 * @Autowired private Environment env;
	 */
	
	public ResultSet executeQuery(Object c) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
		
		System.out.println("Entering the Library Class");
		
		Class<?>  cl = c.getClass();
		System.out.println(cl.getDeclaredMethod("pgDatabase"));
		Method m = cl.getDeclaredMethod("pgDatabase");
		MTLibPostgresConnect mtLibPostgresConnect = m.getAnnotation(MTLibPostgresConnect.class);
		String customMethod = mtLibPostgresConnect.processingMethod();
		System.out.println("JDBC_URL--> " +mtLibPostgresConnect.datasourceUrl()+ " : QUERY--> " +mtLibPostgresConnect.query());
		ResultSet rs = null;	 
		  try (Connection connection = DriverManager.getConnection(mtLibPostgresConnect.datasourceUrl(), mtLibPostgresConnect.datasourceUsername(), mtLibPostgresConnect.datasourcePassword())) {
			  System.out.println("PostgreSQL connection successfull!"); 
			  Statement s = connection.createStatement();
			 
			  if (mtLibPostgresConnect.query().contains("Select") || mtLibPostgresConnect.query().contains("SELECT") || mtLibPostgresConnect.query().contains("select")) { 
				  rs = s.executeQuery(mtLibPostgresConnect.query());
				  
					/*
					 * m = cl.getDeclaredMethod(customMethod, ResultSet.class);
					 * 
					 * m.invoke(c, rs);
					 */
			  } else {
				  s.execute(mtLibPostgresConnect.query());
				
				  System.out.println("Table Data Inserted or Deleted!! ");
			  }		 
				 
		  } catch(Exception e) { 
			  System.out.println("Connection failure.");
		  	  e.printStackTrace();
		  	 
		  }
		return rs;
		 
		 
	}
	
	public void executeQueryInsert(Object c,String query) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
		
		System.out.println("Entering the Library Class");
		
		Class<?>  cl = c.getClass();
	//	System.out.println(cl.getDeclaredMethod("pgDatabaseInsert"));
		Method m = cl.getDeclaredMethod("pgDatabaseInsert", new Class[] {String.class});
		MTLibPostgresInsertConnect mtLibPostgresInsertConnect = m.getAnnotation(MTLibPostgresInsertConnect.class);
		String customMethod = mtLibPostgresInsertConnect.processingMethod();
		//System.out.println("JDBC_URL--> " +mtLibPostgresInsertConnect.datasourceUrl()+ " : QUERY--> " +mtLibPostgresConnect.query());
		ResultSet rs = null;	 
		  try (Connection connection = DriverManager.getConnection(mtLibPostgresInsertConnect.datasourceUrl(), mtLibPostgresInsertConnect.datasourceUsername(), mtLibPostgresInsertConnect.datasourcePassword())) {
			  System.out.println("PostgreSQL connection successfull!"); 
			  Statement s = connection.createStatement();
			 
			 
				  s.executeQuery(query);
				
				  System.out.println("Table Data Inserted or Deleted!! ");
			  		 
				 
		  } catch(Exception e) { 
			  System.out.println("Connection failure.");
		  	  e.printStackTrace();
		  	 
		  }
		 
		 
		 
	}
}
