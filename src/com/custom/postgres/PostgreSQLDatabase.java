package com.custom.postgres;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.data.jpa.repository.Query;

import com.mindtree.postgres.connector.DatabaseExecute;
import com.mindtree.postgres.connector.MTLibPostgresConnect;
import com.mindtree.postgres.connector.MTLibPostgresInsertConnect;
public  class  PostgreSQLDatabase  {
	
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
	
	//PostgresQuery
	//Q1 : Select * from public.\"TBL_EMPLOYEES\" (Give with escape char for quotations if Table name is case sensitive. Without escape char it reads table name in all lower case)
	//Q2 : INSERT INTO \"TBL_EMPLOYEES\" (id, first_name, last_name, email) VALUES (3,'Aks', 'R', 'abr@gmail.com')
	ResultSet rs = null;
	 @MTLibPostgresConnect(query = "Select * from tbl_emp", datasourceUrl = "jdbc:postgresql://localhost:5432/postgres", datasourcePassword = "admin", datasourceUsername = "postgres", processingMethod = "processing")
	 public void pgDatabase() throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		
		System.out.println("FLow Control: Custom code : Invoking connector library API");
		//Library class
		DatabaseExecute dbExecute = new DatabaseExecute();
		rs = dbExecute.executeQuery(this);
		processing(rs);

	}
	 
	 @MTLibPostgresInsertConnect(datasourceUrl = "jdbc:postgresql://localhost:5432/postgres", datasourcePassword = "admin", datasourceUsername = "postgres", processingMethod = "processing")
	 public void pgDatabaseInsert(String q) throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		
		System.out.println("FLow Control: Custom code : Invoking connector library API");
		//Library class
		DatabaseExecute dbExecute = new DatabaseExecute();
		dbExecute.executeQueryInsert(this,q);
		//ocessing(rs);

	}
	 
	public void processing(ResultSet rs) throws SQLException {
		System.out.printf("%-30.30s  %-30.30s    %-30.30s%n", "ID", "NAME", "EMAIL");
		while(rs.next()) {
//1st table TBL_EMPLOYEES
			System.out.printf("%-30.30s   %-30.30s  %-30.30s%n",
					 rs.getString("id"), rs.getString("name"),
					 rs.getString("email"));
	
//2nd Table PERSONS			
			//System.out.printf("%-30.30s  %-30.30s  %-30.30s%n",
				//	 rs.getString(1), rs.getString(2), rs.getString(3));
		}
	}
     
	  
		
		  


}
