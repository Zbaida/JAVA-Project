package dao;

import java.sql.*;

public class Connexion {

	public static Connection getConnection() throws SQLException,ClassNotFoundException {
		String Driver="com.mysql.jdbc.Driver";
		String db="javapro";
		String url="jdbc:mysql://localhost:3306/"+db;
		String user="root";
		String pass="";
		Class.forName(Driver);
		return DriverManager.getConnection(url,user,pass);
	}
}
