package metier;

public class Produit {

	private int idProduit;
	private String nomProduit;
	private int idCate;

	public Produit(int idProduit, String nomCate, int idCate) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomCate;
		this.idCate = idCate;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomP() {
		return nomProduit;
	}

	public void setNomP(String nomCate) {
		this.nomProduit = nomCate;
	}

	public int getIdCate() {
		return idCate;
	}

	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}
}
