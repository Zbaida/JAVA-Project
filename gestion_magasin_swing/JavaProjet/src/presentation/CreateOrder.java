package presentation;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import dao.Connexion;
import javax.swing.*;
import metier.*;

public class CreateOrder extends JPanel {

	Connection conn = null;
	JLabel label1 = new JLabel("Matricule de client :");
	JLabel label2 = new JLabel("Adress 1 :");
	JLabel label3 = new JLabel("Adress 2 :");
	JLabel label4 = new JLabel("Ville :");
	JLabel label5 = new JLabel("Zip Code :");
	JLabel label6 = new JLabel("Pays :");
	JLabel label7 = new JLabel("Id Produit :");
	JLabel label8 = new JLabel("Quantite");
	JLabel label9 = new JLabel("List Produit");
	JLabel label10 = new JLabel("Nom :");
	

	JComboBox<String> clientid;
	JTextField adress1 = new JTextField(30);
	JTextField adress2 = new JTextField(30);
	JTextField ville = new JTextField(30);
	JTextField zipcode = new JTextField(30);
	JTextField countery = new JTextField(30);
	JComboBox<String> idpro = new JComboBox<String>();
	JTextField qtt = new JTextField(30);
	JComboBox<ComboItem> list = new JComboBox<ComboItem>();
	JTextField nom1 = new JTextField(30);
	

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();

	JButton buton1 = new JButton("Vider");
	JButton buton2 = new JButton("Commander");
	JButton buton3 = new JButton("Ajouter");
	JButton buton4 = new JButton("Modifier");
	JButton buton5 = new JButton("Supprimer");
	JButton buton6 = new JButton("Vider liste produit");

	public CreateOrder() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		p1.setLayout(new GridLayout(7, 1));
		p1.setBorder(BorderFactory.createTitledBorder("Information Commande"));
		JPanel panel1 = new JPanel();
		JPanel panel7 = new JPanel();
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel6.setLayout(new FlowLayout(FlowLayout.RIGHT));

		try {
			conn = Connexion.getConnection();
			clientid = new JComboBox<String>();
			idpro = new JComboBox<String>();
			ArrayList<Client> ls = metier.ListClients.getListClinet(conn);
			ArrayList<Produit> prs = metier.ListProduits.getListProduits(conn);
			for (Client l : ls) {
				clientid.addItem("" + l.getIdClt());

			}
			clientid.setSelectedIndex(-1);
			for (Produit p : prs) {
				idpro.addItem("" + p.getNomP());

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		panel1.add(label1);
		panel1.add(clientid);
		panel7.add(label10);
		panel7.add(nom1);
		panel2.add(label2);
		panel2.add(adress1);
		panel3.add(label3);
		panel3.add(adress2);
		panel4.add(label4);
		panel4.add(ville);
		panel5.add(label5);
		panel5.add(zipcode);
		panel6.add(label6);
		panel6.add(countery);
		p1.add(panel1);
		p1.add(panel7);		
		p1.add(panel2);
		p1.add(panel3);
		p1.add(panel4);
		p1.add(panel5);
		p1.add(panel6);
		
		p2.setLayout(new GridLayout(4, 1));
		p2.setBorder(BorderFactory.createTitledBorder("Produit Commandé"));
		JPanel f1 = new JPanel();
		JPanel f2 = new JPanel();
		JPanel f3 = new JPanel();
		JPanel f4 = new JPanel();

		f1.setLayout(new FlowLayout(FlowLayout.LEFT));
		f2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		f3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		f4.setLayout(new FlowLayout(FlowLayout.CENTER));

		qtt.setText("1");

		f1.add(label7);
		f1.add(idpro);
		f2.add(label8);
		f2.add(qtt);
		f3.add(label9);
		f3.add(list);
		f4.add(buton3);
		f4.add(buton4);
		f4.add(buton5);
		f4.add(buton6);
		p2.add(f1);
		p2.add(f2);
		p2.add(f3);
		p2.add(f4);

		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(buton1);
		p3.add(buton2);

		add(p1);
		add(p2);
		add(p3);

		buton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				clientid.setSelectedIndex(-1);
				nom1.setText("");
				adress1.setText("");
				adress2.setText("");
				ville.setText("");
				countery.setText("");
				zipcode.setText("");
				list.removeAllItems();
				qtt.setText("1");
				idpro.setSelectedIndex(0);
			}
		});
		
		buton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(clientid.getSelectedIndex()>-1 && nom1.getText().length()!=0 && adress1.getText().length()!=0 && adress2.getText().length()!=0 && ville.getText().length()!=0 && zipcode.getText().length()!=0 && countery.getText().length()!=0 && list.getItemCount()>0){
					if(JOptionPane.showConfirmDialog(null, "Confirmation","Confirmer la Commande",0,0)==JOptionPane.YES_OPTION){
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						Date date=new Date();
						
						
						String street1=adress1.getText();
						String street2=adress2.getText();
						String city=ville.getText();
						String zip=zipcode.getText();
						String country=countery.getText();
						int id_client=Integer.parseInt(clientid.getSelectedItem().toString());
						String nom_des=nom1.getText();
						
						try{
							Command.ajouterCommande(conn, dateFormat.format(date), street1, street2, city, zip, country, 0, id_client,  nom_des, list);
							clientid.setSelectedIndex(-1);
							nom1.setText("");
							adress1.setText("");
							adress2.setText("");
							ville.setText("");
							countery.setText("");
							zipcode.setText("");
							list.removeAllItems();
							qtt.setText("1");
							idpro.setSelectedIndex(0);
						}catch (Exception e9) {
							
						}
						
					}
					
				}
			}
		});
		
		clientid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(clientid.getSelectedIndex()!=-1){
				int idClt=Integer.parseInt(clientid.getSelectedItem().toString());
				try {
					Client cl=ListClients.getClinet(conn, idClt);
					nom1.setText(cl.getNomClt());
					adress1.setText(cl.getStreetClt());
					adress2.setText(cl.getStreet2Clt());
					ville.setText(cl.getCityClt());
					zipcode.setText(cl.getZipcClt());
					countery.setText(cl.getContryClt());
					
					
				} catch (SQLException e) {

					e.printStackTrace();
				}
				
				}

			}
		});
		
		buton3.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
				boolean existe = false;

				int quqnti = Integer.parseInt(qtt.getText());
				for (int i = 0; i < list.getItemCount(); i++) {
					if (idpro.getSelectedItem().toString().equals(list.getItemAt(i).getLabel())) {

						list.getItemAt(i).setValue(list.getItemAt(i).getValue() + quqnti);
						existe = true;
					}
				}
				if (!existe) {
					
					ComboItem en;
					try {
						en = new ComboItem(idpro.getSelectedItem().toString(), quqnti ,ListProduits.getPro(conn, idpro.getSelectedIndex()));
						list.addItem(en);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
				}

			}
		});

		buton4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int quqnti = Integer.parseInt(qtt.getText());
				for (int i = 0; i < list.getItemCount(); i++) {
					if (idpro.getSelectedItem().toString().equals(list.getItemAt(i).getLabel())) {

						list.getItemAt(i).setValue(quqnti);

					}
				}
			}
		});

		buton5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
					
				if (list.getItemCount()>0)
					list.removeItem(list.getSelectedItem());
				

				validate();
			}
		});

		buton6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				list.removeAllItems();
				idpro.setSelectedIndex(0);
				qtt.setText("1");
			}
		});

		
		list.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (list.getSelectedIndex() >= 0){
					ComboItem produi = (ComboItem) list.getSelectedItem();
				idpro.setSelectedItem(produi.getLabel());
				qtt.setText("" + produi.getValue());
				}
				
			}
		});

		
		nom1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int k = e.getKeyChar();
				if (k == 32) {
				} else if (k < 65 || (k > 90 && k < 97) || k > 122)
					e.consume();
			}
		});
		ville.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int k = e.getKeyChar();
				if (k == 32) {
				} else if (k < 65 || (k > 90 && k < 97) || k > 122)
					e.consume();
			}
		});
		countery.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int k = e.getKeyChar();
				if (k == 32) {
				} else if (k < 65 || (k > 90 && k < 97) || k > 122)
					e.consume();
			}
		});
		zipcode.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char k = e.getKeyChar();
				if (k < '0' || k > '9') {
					e.consume();
				}
			}
		});
		qtt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char k = e.getKeyChar();
				if (k < '0' || k > '9') {
					e.consume();
				}
			}
		});

	}

}
