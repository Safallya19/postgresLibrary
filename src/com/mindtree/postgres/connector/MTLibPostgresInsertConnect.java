package com.mindtree.postgres.connector;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME) 
public @interface MTLibPostgresInsertConnect {

	  public String jpaDatabase() default "POSTGRES";
	  public String jpaShowSql() default "true";
	  public String jpaGenerateDdl() default "true";
	  public String serverPort() default "8080"; 
	  public String datasourcePlatform() default "postgres";
	  public String datasourceUrl() default "jdbc:postgresql://localhost:5432/postgres";
	  public String datasourceUsername() default "username";
	  public String datasourcePassword() default "password";
	  public String datasourceDriverClassName() default "org.postgresql.Driver"; 
	  public String processingMethod() default "method";
		/*
		 * public String table() default "table"; public String para1() default "para1";
		 * public String para2() default "para2"; public String para3() default "para3";
		 */
}
