package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class List {
	
	public static ResultSet getList(Connection con, int i) throws SQLException{
		Statement st = con.createStatement();
		String Q = null;
		switch (i) {
		case 1:
			Q = "SELECT * FROM client";
			break;
		case 2:
			Q = "SELECT * FROM categorie";
			break;
		case 3:
			Q = "SELECT p.id_Pro, p.nom, l.prix_unit, ca.nom FROM produit p, cataloge c, prix_catalog l, categorie ca WHERE p.id_Pro = l.idPro AND p.id_Categorie = c.idCata AND ca.idCate = p.id_Categorie AND l.id_Cataloge = (SELECT MAX(idCata) FROM cataloge)";
			break;
		}
		ResultSet rs = st.executeQuery(Q);
		return rs;
	}

}