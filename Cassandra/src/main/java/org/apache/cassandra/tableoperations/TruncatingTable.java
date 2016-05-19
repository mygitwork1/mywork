package org.apache.cassandra.tableoperations;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class TruncatingTable {

	public static void main(String[] args) {

		//Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object		
		Session session = cluster.connect("test");
		
		//Query
		String query ="TRUNCATE EMP;";
		
		//Executing query
		session.execute(query);
		
		System.out.println("Table truncated!!!");
		
	}

}
