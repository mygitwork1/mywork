package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;

import com.java.utils.ToJSON;

public class DBSchema extends DAO {
	
	public JSONArray getStudentDeatils(String studentID) throws Exception{
		  PreparedStatement statement = null;
		  Connection connection       = null;
		  JSONArray array = new JSONArray();
		  ToJSON converter = new ToJSON();
		  try {
			  
			  connection = oracleStudentsConnection();
			  statement  = connection.prepareStatement("SELECT SID,FNAME,LNAME,ADDRESS,DOB,DOJ,COURCE,GRADE FROM STUDENT WHERE UPPER(grade)= ? ");
			  statement.setString(1, studentID.toUpperCase());
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

}
