package org.apache.cassandra.tableoperations;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class DeleteData {

	public static void main(String[] args) {

		//Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//creating session object
		Session sessoin = cluster.connect("test");
		
		//Delete query
		String query = "DELETE FROM EMP WHERE EMP_ID=5";
		
		//Executing query
		
		sessoin.execute(query);
		
		System.out.println("Deleted.....");
		
	}

}
