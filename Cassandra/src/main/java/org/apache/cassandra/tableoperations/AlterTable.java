package org.apache.cassandra.tableoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class AlterTable {

	public static void main(String[] args) throws IOException {
    
		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	
		// Creating session object
		
		Session session = cluster.connect("test");
		
		//Query adding column
		
		String query_AddColumn ="ALTER TABLE emp ADD email text";
		
		//Query drop column
		String query_DropColumn ="ALTER TABLE emp DROP email ";
		
		System.out.println("Enter you optoin!!");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String ip=reader.readLine();
		Integer option = 0;
		//Scanner input = new Scanner(System.in);
		try{
			option = Integer.parseInt(ip);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		 
		//Executing query
		if(option == 0){
			session.execute(query_AddColumn);
		}else{
		session.execute(query_DropColumn);
		}
		System.out.println("Table altered!!!!");
		
		
	}

}
