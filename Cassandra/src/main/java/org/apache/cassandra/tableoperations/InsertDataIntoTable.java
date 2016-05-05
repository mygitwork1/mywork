package org.apache.cassandra.tableoperations;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class InsertDataIntoTable {

	public static void main(String[] args) {

		//Creating cluster object
		Cluster cluster  = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object
		Session session = cluster.connect("test");
		
		//Insert query
		String query ="INSERT INTO EMP(emp_id,country_name,emp_email,emp_name,emp_sal)"
		              +"VALUES(0004,'india','neelima.mukkala@gmail.com','sunnu',60000);";
		
		//Executing query
		
		session.execute(query);
		session.close();
		System.out.println("Data inserted!!!");
		
	}

}
