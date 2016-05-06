package org.apache.cassandra.collections;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class SetCollections {

	public static void main(String[] args) {

		//Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		//Creating session object
		Session sessoin = cluster.connect("test");
		
		//Set creation query
		String query = "CREATE TABLE DATA1(NAME TEXT Primary Key, HOME TEXT, PHONE Set<varint>);";
		
		//Data Insert query
		String insertQuery ="INSERT INTO DATA1(NAME,HOME,PHONE)"+
		                     "VALUES('SUBBU','INDIA',{9378678541,6128106138})";
		//Select query
		String selectQuery = "SELECT * FROM DATA1;";
		
		//Update query
		String updateQuery = "UPDATE DATA1 SET PHONE=PHONE+{9378678542} WHERE NAME='SUBBU';";
		
		ResultSet set =sessoin.execute(selectQuery);
		
		System.out.println(set.all());
				
	}

}
