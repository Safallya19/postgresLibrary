package com.mindtree.postgres.connector.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Properties;

import com.custom.postgres.H2Database;
import com.custom.postgres.PostgreSQLDatabase;

public class PosgresTestConnectorLibrary {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {

		// H2Database testPGDatabase = new H2Database();

		PostgreSQLDatabase testPGDatabase = new PostgreSQLDatabase();
		System.out.println("Flow Control: Invoke Custom class method from PosgresTestConnectorLibrary.main() ");

		testPGDatabase.pgDatabase();

		
		testPGDatabase.pgDatabaseInsert("insert into tbl_emp(id,name,email) values(22,'Ashok', 'ashok@mindtree.com');");
		System.out.println("Flow Control: After executing DB back in PosgresTestConnectorLibrary.main() ");
		 
		/*
		 * try (InputStream input = new FileInputStream("path/to/config.properties")) {
		 * 
		 * 
		 * Properties prop = new Properties();
		 * 
		 * // load a properties file prop.load(input);
		 * 
		 * 
		 * // get the property value and print it out
		 * System.out.println(prop.getProperty("db.url"));
		 * System.out.println(prop.getProperty("db.user"));
		 * System.out.println(prop.getProperty("db.password"));
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); }
		 */

	}
}
