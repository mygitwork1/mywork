package org.apache.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class TestClass2 {

	public static void main(String[] args) {

		// Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session
		
		Session session = cluster.connect("test");
		
		// Table creation query string
		
		String query = "CREATE TABLE student(sid_id int PRIMARY KEY, "
		         + "s_name text, "
		         + "s_city text, "
		         + "s_grade text, "
		         + "s_phone varint );";
		
		session.execute(query);
		
		System.out.println("Table created");
		
	}

}
