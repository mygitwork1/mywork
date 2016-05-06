package org.apache.cassandra.datatypes;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class UserDefinedDataType {

	public static void main(String[] args) {

		//Creating cluster object
		Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").build();
		
		//Creating session object
		Session session = cluster.connect("test");
		
		//data type creation query
		String query = "CREATE TYPE CARD_DETAILS(NUM VARINT,PIND VARINT,NAME TEXT,CVV INT,PHONE SET<VARINT>);";
		
		//Alter query
		String alter_Query = "ALTER TYPE CARD_DETAILS ADD EMAIL LIST<TEXT>";
		
		//Rename existing field in data type
		String rename_query = "ALTER TYPE CARD_DETAILS RENAME EMAIL TO MAIL;";
		
		//Drop type query
		String drop_query = "DROP TYPE card_details;";
		
		session.execute(rename_query);
		
		
		System.out.println("ALTERED!!!!");
		
		
	}

}
