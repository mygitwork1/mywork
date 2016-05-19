package org.apache.cassandra.keyspace;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class AlterKeySpace {

	public static void main(String[] args) {

		// Creating Cluster Object
		
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		String query    = "ALTER KEYSPACE test1 WITH replication ="+
		                  "{'class':'NetworkTopologyStrategy','datacenter1':3};";
		
		// Creating session object
		
		Session session = cluster.connect();
		session.execute(query);
		
		System.out.println("keyspace altered");
				     
		
	}

}
