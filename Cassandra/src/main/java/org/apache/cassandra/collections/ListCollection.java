package org.apache.cassandra.collections;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class ListCollection {

	public static void main(String[] args) {
	 //Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
	 //Creating session object
	 Session sessoin = cluster.connect("test");
	 
	 //Insert query
	 String query = "INSERT INTO DATA(NAME,CITY,EMAILS) "
	 		           + "VALUES('SUBBU','INDIA',['SUBBU.VARSITH1@GMAIL.COM','SUBBU.VARSITH@GMAIL.COM'])";
	 //Updating query
	 String updateQuery ="UPDATE DATA SET EMAILS=EMAILS+['TEST@ABC.COM'] where name='SUBBU';";
	 
	 //Executing query
	 sessoin.execute(updateQuery);
	 sessoin.close();
	 System.out.println("data inserted!!");
	}

}
