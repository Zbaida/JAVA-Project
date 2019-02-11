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

public class ListCustommers extends JPanel {

	JLabel lab1;
	ResultSetTableModel model1;
	JPanel pn1;

	Connection conn;
	Statement st1 = null;
	ResultSet rs1 = null;

	public ListCustommers() {
		setLayout(new BorderLayout());
		lab1 = new JLabel("List customers");
		lab1.setHorizontalAlignment(JLabel.CENTER);

		if (pn1 != null)
			remove(pn1);
		
		try {
			conn =Connexion.getConnection();
			model1 = new ResultSetTableModel(List.getList(conn, 1));
			JTable table = new JTable(model1);
			JScrollPane jsp = new JScrollPane(table);
			pn1 = new JPanel();
			pn1.add(jsp);
			add(pn1, BorderLayout.CENTER);
			add(lab1, BorderLayout.NORTH);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
