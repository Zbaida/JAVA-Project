package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProduitCommand {

public static ResultSetTableModel getInfoPrCm(Connection conn, int id_command) throws SQLException{
		
		Statement st = conn.createStatement();
		
		
		
		String q2 ="SELECT p.id_Pro, p.nom, l.Quantitie, pc.prix_unit FROM commande c, list_produit l, prix_catalog pc, produit p WHERE c.idCmd = "+id_command+" AND c.idCmd = l.idCmd AND l.id_Produit = p.id_Pro AND p.id_Pro = pc.idPro AND pc.id_Cataloge = c.id_Cataloge " ;
		ResultSet rs2=st.executeQuery(q2);
		ResultSetTableModel model=new ResultSetTableModel(rs2);
		
		
		return model;}

public static void deleteComm(Connection conn, String string) throws SQLException{
	
	Statement st = conn.createStatement();
	String q1 ="delete from list_produit where idCmd="+ string;
	st.executeUpdate(q1);
	
	String q2 ="delete from Commande where idCmd="+ string;
	st.executeUpdate(q2);
		
	}

public static int getTotal(Connection conn, int id_command) throws SQLException{
	int i = 0;
	Statement st = conn.createStatement();
	String Q = "SELECT (l.Quantitie)*(pc.prix_unit) as 'Sous-Prix' FROM commande c, list_produit l, prix_catalog pc, produit p WHERE c.idCmd = "
			+ id_command
			+ " AND c.idCmd = l.idCmd AND l.id_Produit = p.id_Pro AND p.id_Pro = pc.idPro AND pc.id_Cataloge = c.id_Cataloge ";
	ResultSet rs = st.executeQuery(Q);
	while (rs.next()) {
		i += rs.getInt(1);	
	}
	return i;
}

	
}
