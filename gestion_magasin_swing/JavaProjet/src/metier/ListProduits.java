package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListProduits {
	public static ArrayList<Produit> getListProduits(Connection conn) throws SQLException{
		ArrayList<Produit> cli = new ArrayList<Produit>();
		Statement st = conn.createStatement();
		String Q = "SELECT * FROM Produit";
		ResultSet rs = st.executeQuery(Q);
		while (rs.next())
			cli.add(new Produit(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		rs.close();
		st.close();
		
		return cli;}
	
	public static int getPro(Connection conn, int index) throws SQLException{
		
		Statement st = conn.createStatement();
		String Q = "SELECT id_Pro FROM Produit limit 1 OFFSET "+index;
		ResultSet rs = st.executeQuery(Q);
		rs.next();
		
		return rs.getInt(1);}
	
	
	
	
}
