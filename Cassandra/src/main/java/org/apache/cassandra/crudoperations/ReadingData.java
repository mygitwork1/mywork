package org.apache.cassandra.crudoperations;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class ReadingData {

	public static void main(String[] args) {

		//Creating cluster
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object
		Session session = cluster.connect("test");
		
		//Select query
		String query = "select * from emp;";
		
		String whereClauseQuery = "select * from emp where emp_id=1";
		
		String whereClause = "select emp_name,emp_sal from emp where emp_id=3";
		
		//Executing query
		ResultSet set =session.execute(query);
		System.out.println(set.all());
	}

}
