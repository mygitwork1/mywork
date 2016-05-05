package org.apache.cassandra.tableoperations;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CreatingIndex {

	public static void main(String[] args) {

		//Creating cluster
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object
		Session session = cluster.connect("test");
		
		//Index query
		String query = "CREATE INDEX name ON emp(emp_name);";
		
		//Executing query
		session.execute(query);
		
		System.out.println("Index created!!!!");
	}

}
