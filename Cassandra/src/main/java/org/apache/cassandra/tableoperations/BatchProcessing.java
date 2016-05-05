package org.apache.cassandra.tableoperations;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class BatchProcessing {

	public static void main(String[] args) {

		//Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object
		Session session = cluster.connect("test");
		
		//Query
		String query ="BEGIN BATCH "
				      + "INSERT INTO EMP(emp_id,country_name,emp_email,emp_name,emp_sal) VALUES(5,'INDIA','SUBBU.VARSITH1@GMAIL.COM','CHITTI',40000);"
				      + "UPDATE EMP SET emp_sal=80000 where emp_id=4; "
				      + "DELETE country_name from emp where emp_id=3;"
				      + "APPLY BATCH";
	   //Executing query
		session.execute(query);
		
		System.out.println("Batch processing success!!!!");
	
	}

}
