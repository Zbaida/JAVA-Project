package metier;

public class Client {

	private int idClt;
	private String nomClt;
	
	private String streetClt;
	private String street2Clt;
	private String cityClt;
	private String zipcClt;
	private String contryClt;

	public Client(int idClt, String nomClt, String teleClt, String streetClt, String street2Clt, String cityClt,
			String zipcClt, String contryClt) {
		
		this.idClt = idClt;
		this.nomClt = nomClt;
		
		this.streetClt = streetClt;
		this.street2Clt = street2Clt;
		this.cityClt = cityClt;
		this.zipcClt = zipcClt;
		this.contryClt = contryClt;
	}

	public int getIdClt() {
		return idClt;
	}

	public void setIdClt(int idClt) {
		this.idClt = idClt;
	}

	public String getNomClt() {
		return nomClt;
	}

	public void setNomClt(String nomClt) {
		this.nomClt = nomClt;
	}

	public String getStreetClt() {
		return streetClt;
	}

	public void setStreetClt(String streetClt) {
		this.streetClt = streetClt;
	}

	public String getStreet2Clt() {
		return street2Clt;
	}

	public void setStreet2Clt(String street2Clt) {
		this.street2Clt = street2Clt;
	}

	public String getCityClt() {
		return cityClt;
	}

	public void setCityClt(String cityClt) {
		this.cityClt = cityClt;
	}

	public String getZipcClt() {
		return zipcClt;
	}

	public void setZipcClt(String zipcClt) {
		this.zipcClt = zipcClt;
	}

	public String getContryClt() {
		return contryClt;
	}

	public void setContryClt(String contryClt) {
		this.contryClt = contryClt;
	}

}
