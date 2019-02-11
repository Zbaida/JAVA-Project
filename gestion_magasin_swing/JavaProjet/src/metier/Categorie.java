package metier;

public class Categorie {

	private int idCate;
	private String nomCate;

	public Categorie(int idCate, String nomCate) {
		super();
		this.idCate = idCate;
		this.nomCate = nomCate;
	}

	public int getIdCate() {
		return idCate;
	}

	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}

	public String getNomCate() {
		return nomCate;
	}

	public void setNomCate(String nomCate) {
		this.nomCate = nomCate;
	}

}
