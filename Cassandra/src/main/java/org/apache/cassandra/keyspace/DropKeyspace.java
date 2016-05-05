package org.apache.cassandra.keyspace;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class DropKeyspace {

	public static void main(String[] args) {

		// creating cluster object
		
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		String query    = "DROP KEYSPACE test1";
		
		// Creating session object
		
		Session session = cluster.connect();
		session.execute(query);
		
		System.out.println("keyspace dropped!!");
		
	}

}
