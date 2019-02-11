package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CommandInforma {
	public static Command getListCommand(Connection conn, String idcom) throws SQLException{
		Command com =null;
		Statement st = conn.createStatement();
		String Q = "SELECT * FROM Commande where idCmd="+idcom;
		ResultSet rs = st.executeQuery(Q);
		rs.next();
			com=new Command(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11));
		rs.close();
		st.close();
		
		return com;}
	public static Cataloge getCata(Connection conn, int idcat) throws SQLException{
		Cataloge cat =null;
		Statement st = conn.createStatement();
		String Q = "SELECT * FROM Cataloge where idCata="+idcat;
		ResultSet rs = st.executeQuery(Q);
		rs.next();
			cat=new Cataloge(rs.getInt(1), rs.getString(2));
		rs.close();
		st.close();
		
		return cat;}
	
}
