package presentation;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dao.Connexion;
import metier.*;

public class ListCategorie extends JPanel {

	JLabel lab2;
	ResultSetTableModel model2;
	JPanel pn2;

	Connection conn;
	Statement st2 = null;
	ResultSet rs2 = null;

	public ListCategorie() {
		setLayout(new BorderLayout());
		lab2 = new JLabel("List categorie");
		lab2.setHorizontalAlignment(JLabel.CENTER);

		if (pn2 != null)
			remove(pn2);
		
		try {
			conn = Connexion.getConnection();
			model2 = new ResultSetTableModel(List.getList(conn, 2));
			JTable table = new JTable(model2);
			JScrollPane jsp = new JScrollPane(table);
			pn2 = new JPanel();
			pn2.add(jsp);
			add(pn2, BorderLayout.CENTER);
			add(lab2, BorderLayout.NORTH);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
