package org.apache.cassandra.crudoperations;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class UpdatingData {

	public static void main(String[] args) {
		
        //Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object
		Session session = cluster.connect("test");
		
		//Update query
		String query = "UPDATE EMP SET EMP_SAL=230000 WHERE EMP_ID=1";
		
		//Executing query
		session.execute(query);
		
		System.out.println("data updated!!");
		
	}

}
