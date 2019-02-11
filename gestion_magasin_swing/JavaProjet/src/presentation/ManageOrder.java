package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.Connexion;

import metier.Command;
import metier.CommandInforma;

import metier.ProduitCommand;
import metier.ResultSetTableModel;


public class ManageOrder extends JPanel {
	JLabel a00 = new JLabel("Id Commande :");
	JLabel a1 = new JLabel("Matricule de client :");
	JLabel a01 = new JLabel("Nom de Destinateur :");
	JLabel a02 = new JLabel("Date de Commande :");
	JLabel a2 = new JLabel("Adress 1 :");
	JLabel a3 = new JLabel("Adress 2 :");
	JLabel a4 = new JLabel("Ville :");
	JLabel a5 = new JLabel("Zip Code :");
	JLabel a6 = new JLabel("Pays :");
	JLabel a7= new JLabel("Statue :");
	JLabel a8 = new JLabel("Cataloge :");
	JLabel lab12 = new JLabel("Montant General :");
	
	JTextField nom = new JTextField(30);
	JTextField datec = new JTextField(30);
	JTextField statu = new JTextField(30);
	JTextField catalo = new JTextField(30);
	JTextField clientid = new JTextField(10);
	JTextField adress1 = new JTextField(30);
	JTextField adress2 = new JTextField(30);
	JTextField ville = new JTextField(30);
	JTextField zipcode = new JTextField(30);
	JTextField countery = new JTextField(30);
	JTextField total = new JTextField(10);
	JComboBox<String> idcmd;
	
	Connection conn;
	JScrollPane scp;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel(new BorderLayout());
	JPanel p3 = new JPanel();
	JPanel ptable = new JPanel();
	
	ResultSetTableModel rstm;

	
	JButton j2 = new JButton("Supprimer");
	

	public ManageOrder() {
		try {
			conn = Connexion.getConnection();
			idcmd = new JComboBox<String>();
			
			ArrayList<Command> cmds = metier.ListCommands.getListCommand(conn);
			for (Command c : cmds) {
				idcmd.addItem("" + c.getId_commande());

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		p1.setLayout(new GridLayout(10, 1));
		p1.setBorder(BorderFactory.createTitledBorder("Information Commande"));
		JPanel s1 = new JPanel();
		JPanel s01 = new JPanel();
		JPanel s02 = new JPanel();
		JPanel s2 = new JPanel();
		JPanel s3 = new JPanel();
		JPanel s4 = new JPanel();
		JPanel s5 = new JPanel();
		JPanel s6 = new JPanel();
		JPanel s7 = new JPanel();
		JPanel s8 = new JPanel();
		JPanel s11 = new JPanel();
		s1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s01.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s02.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s6.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		s11.setLayout(new FlowLayout(FlowLayout.RIGHT));
s1.add(a00);s1.add(idcmd);
		s1.add(a1);
		s1.add(clientid);
		s01.add(a01);
		s01.add(nom);
		s02.add(a02);
		s02.add(datec);
		s2.add(a2);
		s2.add(adress1);
		s3.add(a3);
		s3.add(adress2);
		s4.add(a4);
		s4.add(ville);
		s5.add(a5);
		s5.add(zipcode);
		s6.add(a6);
		s6.add(countery);
		s7.add(a7);
		s7.add(statu);
		s8.add(a8);
		s8.add(catalo);
		s11.add(lab12);
		s11.add(total);
		
		nom.setEnabled(false);
		datec.setEnabled(false);
		statu.setEnabled(false);
		catalo.setEnabled(false);
		clientid.setEnabled(false);
		adress1.setEnabled(false);
		adress2.setEnabled(false);
		ville.setEnabled(false);
		zipcode.setEnabled(false);
		countery.setEnabled(false);
		
		p1.add(s1);
		p1.add(s01);
		p1.add(s02);
		p1.add(s2);
		p1.add(s3);
		p1.add(s4);
		p1.add(s5);
		p1.add(s6);
		p1.add(s7);
		p1.add(s8);
		
		

		if (idcmd.getItemCount()>0)
			try {
				if (scp != null){
					p2.remove(scp);
					p2.remove(s11);
				}

				rstm = ProduitCommand.getInfoPrCm(conn, Integer.parseInt(idcmd.getSelectedItem().toString()));
				JTable table = new JTable(rstm);
				scp = new JScrollPane(table);

				table.setPreferredScrollableViewportSize(new Dimension(400, 100));
				table.setFillsViewportHeight(true);
				fill();
				total.setText("" + ProduitCommand.getTotal(conn, Integer.parseInt(idcmd.getSelectedItem().toString())));
				p2.setSize(p2.getWidth(), 30);
				p2.add(scp);
				p2.add(s11, BorderLayout.SOUTH);
					
					
					
										
				} catch (NumberFormatException | SQLException exc) {

					exc.printStackTrace();
				}
		
		j2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (idcmd.getSelectedIndex()>-1){
					try {
						ProduitCommand.deleteComm(conn, idcmd.getSelectedItem().toString());
						idcmd.removeItemAt(idcmd.getSelectedIndex());
						idcmd.setSelectedIndex(-1);
						nom.setText("");
						datec.setText("");
						
						statu.setText("");
						catalo.setText("");
						clientid.setText("");
						adress1.setText("");
						adress2.setText("");
						ville.setText("");
						zipcode.setText("");
						countery.setText("");
						total.setText("");
						
if (scp!=null)p2.remove(scp);
						
						JTable table=new JTable();
						scp=new JScrollPane(table);

						table.setPreferredScrollableViewportSize(new Dimension(400, 120));
						table.setFillsViewportHeight(true);
						
						p2.setSize(p2.getWidth(), 30);
						p2.add(scp);
						validate();
						
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		
		
		idcmd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (idcmd.getItemCount()>0 && idcmd.getSelectedIndex()>-1)
				try {
					if (scp != null){
						p2.remove(scp);
						p2.remove(s11);
					}

					rstm = ProduitCommand.getInfoPrCm(conn, Integer.parseInt(idcmd.getSelectedItem().toString()));
					JTable table = new JTable(rstm);
					scp = new JScrollPane(table);

					table.setPreferredScrollableViewportSize(new Dimension(400, 100));
					table.setFillsViewportHeight(true);
					fill();
					total.setText("" + ProduitCommand.getTotal(conn, Integer.parseInt(idcmd.getSelectedItem().toString())));
					p2.setSize(p2.getWidth(), 30);
					p2.add(scp);
					p2.add(s11, BorderLayout.SOUTH);
						
						
						validate();
						
											
					} catch (NumberFormatException | SQLException exc) {

						exc.printStackTrace();
					}
			}
		});
		
		

		
	
		p2.setBorder(BorderFactory.createTitledBorder("Produit Commandé"));
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p3.add(j2);

		add(p1);
		add(p2);
		add(p3);
		
	}
	
	public void fill() throws SQLException{
		Command c=CommandInforma.getListCommand(conn, idcmd.getSelectedItem().toString());
		nom.setText(c.getNom_des());
		datec.setText(c.getDate_command());
		if (c.isStatus()== 0)
		statu.setText("En cours de Livraison");else statu.setText("Bien Livre");
		catalo.setText(CommandInforma.getCata(conn, c.getId_cataloge()).getNomCata());
		clientid.setText("" + c.getId_client());
		adress1.setText(c.getStreet1());
		adress2.setText(c.getStreet2());
		ville.setText(c.getCity());
		zipcode.setText(c.getZipcode());
		countery.setText(c.getCountry());
	}
	
}
