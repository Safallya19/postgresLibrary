package com.mindtree.postgres.connector;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface MTLibPostgresConnect {
	
	  //public String hostName() default "localhost";
	  public String jpaDatabase() default "POSTGRES";
	  public String jpaShowSql() default "true";
	  public String jpaGenerateDdl() default "true";
	  public String serverPort() default "8080"; 
	  public String datasourcePlatform() default "postgres";
	  public String datasourceUrl() default "jdbc:postgresql://localhost:5432/postgres";
	  public String datasourceUsername() default "username";
	  public String datasourcePassword() default "password";
	  public String datasourceDriverClassName() default "org.postgresql.Driver";
	  public String query() default "Select * from Emp";
	  public String processingMethod() default "method";

}
