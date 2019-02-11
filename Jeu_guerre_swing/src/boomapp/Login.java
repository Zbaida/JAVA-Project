
package boomapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
	public static boolean authenticate(String username, String password) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
			try{
				Connection dbc;
				dbc=DriverManager.getConnection("jdbc:mysql://localhost/tp","root","");
				Statement stmt =dbc.createStatement();		
				ResultSet rs = stmt.executeQuery("SELECT * from user where Login='"+username+"'and password='"+password+"'");
		    if (rs.next()){
		    	return true; 
		    }
		    else{
		    	return false;
		    }
			}catch(SQLException e1){
		    	System.out.println(e1);
		    	return false;
		    }
		}
}
