package metier;

public class Cataloge {

	private int idCata;
	private String nomCata;
	
	public Cataloge(int idCata, String nomCata) {
		super();
		this.idCata = idCata;
		this.nomCata = nomCata;
	}

	public int getIdCata() {
		return idCata;
	}

	public void setIdCata(int idCata) {
		this.idCata = idCata;
	}

	public String getNomCata() {
		return nomCata;
	}

	public void setNomCata(String nomCata) {
		this.nomCata = nomCata;
	}

	
}
