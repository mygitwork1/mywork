package com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;

import com.java.utils.ToJSON;

public class DBSchema extends DAO {
	
	public JSONArray getStudentDeatils(String grade) throws Exception{
		System.out.println("grade::"+grade);
		  PreparedStatement statement = null;
		  Connection connection       = null;
		  JSONArray array = new JSONArray();
		  ToJSON converter = new ToJSON();
		  try {
			  
			  connection = oracleStudentsConnection();
			  statement  = connection.prepareStatement("SELECT SID,FNAME,LNAME,ADDRESS,COURCE,GRADE FROM STUDENT WHERE UPPER(grade)= ? ");
			  statement.setString(1, grade.toUpperCase());
			  ResultSet set = statement.executeQuery();
			  array = converter.toJSONArray(set);
			  statement.close();
		} catch(SQLException exception){
			exception.printStackTrace();
			return array;
		} 
		  catch (Exception e) {
			e.printStackTrace();
			return array;
		}finally{
			if(connection != null){
				connection.close();
			}
		}
		return array;
	}
	
	
	public JSONArray getStudentDeatilsWith2Params(String grade,String sid) throws Exception{
		System.out.println("grade::"+grade);
		  PreparedStatement statement = null;
		  Connection connection       = null;
		  JSONArray array = new JSONArray();
		  ToJSON converter = new ToJSON();
		  try {
			  
			  connection = oracleStudentsConnection();
			  statement  = connection.prepareStatement("SELECT SID,FNAME,LNAME,ADDRESS,COURCE,GRADE FROM STUDENT WHERE UPPER(grade)= ? and sid=?");
			  Integer SID = Integer.parseInt(sid);
			  statement.setString(1, grade.toUpperCase());
			  statement.setInt(2,SID);
			  ResultSet set = statement.executeQuery();
			  array = converter.toJSONArray(set);
			  statement.close();
		} catch(SQLException exception){
			exception.printStackTrace();
			return array;
		} 
		  catch (Exception e) {
			e.printStackTrace();
			return array;
		}finally{
			if(connection != null){
				connection.close();
			}
		}
		return array;
	}
	

	/**
	 * This method will insert a record into the STUDENT table. 
	 * 
	 * Note: there is no validation being done... if this was a real project you
	 * must do validation here!
	 * 
	 * @param SID
	 * @param FNAME
	 * @param LNAME
	 * @param ADDRESS
	 * @param COURSE
	 * @param GRADE
	 * @return integer 200 for success, 500 for error
	 * @throws Exception,SQLException 
	 * @throws Exception
	 */

	public Integer insertStudent(Integer sID, 
			                     String fName,
			                     String lName,
			                     String address,
			                     String cource,
			                     String grade) throws Exception,SQLException {
     PreparedStatement preparedStatement = null;
     Connection connection               = null;
     
     try {
    	 
    	 /*
			 * If this was a real application, you should do data validation here
			 * before starting to insert data into the database.
			 */
    	 
    	 connection = oracleStudentsConnection();
    	 preparedStatement = connection.prepareStatement("insert into student"+"(SID,FNAME,LNAME,ADDRESS,COURCE,GRADE)"+" VALUES(?,?,?,?,?,?)");
    	 preparedStatement.setInt(1,sID);
    	 preparedStatement.setString(2,fName);
    	 preparedStatement.setString(3,lName);
    	 preparedStatement.setString(4,address);
    	// preparedStatement.setDate(5,dob);
    	 //preparedStatement.setDate(6, doj);
    	 preparedStatement.setString(5,cource);
    	 preparedStatement.setString(6,grade);
    	 
    	 preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
		return 500;// error
	}finally{
		if(connection != null){
			connection.close();
		}
	}
		return 200;// success
	}

}
