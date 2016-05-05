package org.apache.cassandra.keyspace;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class KeySpaceCreation {

	public static void main(String[] args) {

		// Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		String query ="CREATE KEYSPACE test1 WITH replication ="+
		              "{'class':'SimpleStrategy','replication_factor':1};";
		
		// Creating session object
		Session session = cluster.connect();
		ResultSet set=session.execute(query);
		System.out.println("Keyspace created!!!");
		
	}

}
