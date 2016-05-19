package org.apache.cassandra.collections;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class MapCollection {

	public static void main(String[] args) {

		//Creating cluster
		Cluster cluster =Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object
		Session session = cluster.connect("test");
		
		//Table creation query
		String query = "CREATE TABLE DATA2(NAME TEXT PRIMARY KEY,ADDRESS MAP<text,text>)";
		
		//Table drop query
		String dropQuery ="drop table data2";
		
		//Data insert query
		String insertQuery ="INSERT INTO DATA2(NAME,ADDRESS)"+
		                    "VALUES('SUBBU',{'HOME':'HYD','OFFICE':'DELHI'});";
		//Select query
		String selectQuery = "select * from data2;";
		
		//Update query
		String updateQuery = "UPDATE DATA2 SET address =ADDRESS+{'OFFICE':'HYD'} where name='SUBBU';";
		
		
	    ResultSet set = session.execute(selectQuery);
	    System.out.println(set.all());
	}

}
