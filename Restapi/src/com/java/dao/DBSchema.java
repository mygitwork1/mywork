package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.codehaus.jettison.json.JSONArray;

import com.java.utils.ToJSON;

public class DBSchema extends DAO {
	
	
	public JSONArray getStudentDetails()throws Exception{
		System.out.println("inside getStudentDetails method....");
		PreparedStatement query = null;
		Connection connection = null;
		JSONArray array = new JSONArray();
		ToJSON converter = new ToJSON();
		try {
			connection = oracleStudentsConnection();
			query      = connection.prepareStatement("SELECT * FROM STUDENT");
			ResultSet set = query.executeQuery();
			array = converter.toJSONArray(set);
			
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}
		}
		return array;
	}
	
	
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
			  //statement.close();
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
	
	public Integer deleteStudent(Integer sid)throws Exception{
		System.out.println("Student id:::::"+sid);
		PreparedStatement query = null;
		Connection connection   = null;
		Integer returningValue= null;
		
		try {
			//DBSchema dbSchema = new DBSchema();
			connection = oracleStudentsConnection();
			query      = connection.prepareStatement("DELETE FROM STUDENT WHERE SID= ?");
			query.setInt(1,sid);
			returningValue =query.executeUpdate();
			//query.close();
			System.out.println("returningValue:::"+returningValue);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 500;//Error
		}finally{
			if(connection != null){
				connection.close();
			}
		}
		if(returningValue == 0){
			return 500;
		}
		return 200;//Success
	}
	
	
	// Update student 
	public Integer updateStudent(Integer VALUE1,String VALUE2)throws Exception{
		System.out.println("SID:::::"+VALUE1+"::::COURCE:::"+VALUE2);
		PreparedStatement query = null;
		Connection connection   = null;
		Integer returningValue= null;
		Integer SUCCESS_CODE  = 200;
		Integer ERROR_CODE    = 500;
		
		try {
			//DBSchema dbSchema = new DBSchema();
			connection = oracleStudentsConnection();
			query      = connection.prepareStatement("UPDATE STUDENT SET COURCE=? WHERE SID= ?");
			query.setString(1,VALUE2);
			query.setInt(2,VALUE1);
			returningValue =query.executeUpdate();
			//query.close();
			System.out.println("returningValue:::"+returningValue);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 500;//Error
		}finally{
			if(connection != null){
				connection.close();
			}
		}
		if(returningValue == 0){
			return ERROR_CODE;
		}
			return SUCCESS_CODE;//Success
	}

}
