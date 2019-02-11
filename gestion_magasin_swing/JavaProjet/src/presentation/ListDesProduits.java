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
import javax.swing.table.AbstractTableModel;


import dao.Connexion;
import metier.*;

public class ListDesProduits extends JPanel {
	
	JLabel lab3;
	ResultSetTableModel model3;
	JPanel pn3;
	
	Connection conn;
	Statement st3 = null;
	ResultSet rs3 = null;
	
	public ListDesProduits() {
		setLayout(new BorderLayout());
		lab3 = new JLabel("List Produits");
		lab3.setHorizontalAlignment(JLabel.CENTER);
		if(pn3 != null)
			remove(pn3);
		
		try {
			conn = Connexion.getConnection();
			model3 = new ResultSetTableModel(List.getList(conn, 3));
			JTable table = new JTable(model3);
			JScrollPane jsp = new JScrollPane(table);
			pn3 = new JPanel();
			pn3.add(jsp);
			add(pn3, BorderLayout.CENTER);
			add(lab3, BorderLayout.NORTH);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
