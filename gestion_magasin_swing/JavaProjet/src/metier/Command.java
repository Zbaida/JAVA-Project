package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Command {
	private int id_commande;
	private String date_command;
	private String street1;
	private String street2;
	private String city;
	private String zipcode;
	private String country;
	private int status;
	private int id_client;
	private int id_cataloge;
	
	private String nom_des;
	
	
	public Command(int id_commande, String date_command, String street1, String street2, String city, String zipcode,
			String country, int status, int id_client, int id_cataloge, String nom_des) {
		this.id_commande = id_commande;
		this.date_command = date_command;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
		this.status = status;
		this.id_client = id_client;
		this.id_cataloge = id_cataloge;
		this.nom_des=nom_des;
		
	}

	public String getNom_des() {
		return nom_des;
	}

	public void setNom_des(String nom_des) {
		this.nom_des = nom_des;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public String getDate_command() {
		return date_command;
	}

	public void setDate_command(String date_command) {
		this.date_command = date_command;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int isStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_cataloge() {
		return id_cataloge;
	}

	public void setId_cataloge(int id_cataloge) {
		this.id_cataloge = id_cataloge;
	}
	
	public static void ajouterCommande(Connection conn, String date_command, String street1, String street2, String city, String zipcode,
			String country, int status, int id_client,String nom_des,JComboBox<ComboItem> prods) throws SQLException{
		Statement st = conn.createStatement();
		Statement st2=conn.createStatement();
		ResultSet rs=st.executeQuery("select max(idCata) from cataloge");
		rs.next();
		String Q = "INSERT INTO `commande` (`date_command`, `street1`, `street2`, `city`, `zipcode`, `country`, `status`, `id_Client`, `id_Cataloge`, `nom_des`) VALUES ( '"+date_command+"', '"+street1+"', '"+street2+"', '"+city+"', '"+zipcode+"', '"+country+"', "+status+", "+id_client+", "+rs.getInt(1)+", '"+nom_des+"')";
		st.executeUpdate(Q);
		ResultSet rs1=st.executeQuery("select max(idCmd) from commande");
		rs1.next();
		String q2="";
		
		for (int i = 0; i < prods.getItemCount(); i++) {
			q2="insert into list_produit values ("+prods.getItemAt(i).getValue()+","+rs1.getInt(1)+","+prods.getItemAt(i).getId()+")";
			
			
			   st2.executeUpdate(q2);
			   
		}
		rs.close();
		rs1.close();
		st.close();
	}
}