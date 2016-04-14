package com.java.spring.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
 public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
    ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/com/java/spring/resource/SpringConfiguration.xml"
    		                                                        ,"classpath:/com/java/spring/resource/dao.xml"});
    Service service = context.getBean("service",Service.class);
    service.test();
    System.out.println("args::"+service.name);
    
    SetterInjection injection = context.getBean("setterInjection",SetterInjection.class);
    injection.foo.test();
    
    BasicDataSource bd= context.getBean("dataSource1",BasicDataSource.class);
   Connection conn = bd.getConnection();
  PreparedStatement statement= conn.prepareStatement("select * from student");
   
   Integer http_code = statement.executeUpdate();
   System.out.println("http_code:::"+http_code);
		
		
		
	}

}
