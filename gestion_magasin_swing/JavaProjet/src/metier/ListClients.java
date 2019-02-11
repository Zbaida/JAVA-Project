package metier;

import java.sql.*;
import java.util.*;
public class ListClients {
	public static ArrayList<Client> getListClinet(Connection conn) throws SQLException{
		ArrayList<Client> cli = new ArrayList<Client>();
		Statement st = conn.createStatement();
		String Q = "SELECT * FROM client";
		ResultSet rs = st.executeQuery(Q);
		while (rs.next())
			cli.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		rs.close();
		st.close();
		
		return cli;}
	
	public static Client getClinet(Connection conn,int idClt) throws SQLException{
		Client cli =null;
		Statement st = conn.createStatement();
		String Q = "SELECT * FROM client where idClt="+idClt;
		ResultSet rs = st.executeQuery(Q);
		rs.next();
			cli = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		rs.close();
		st.close();
		
		return cli;}
}
