
public class Commande {
    private int numéroC;
	private int quantite;
	private double total;
	Produit p=new Produit();
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Produit getP() {
		return p;
	}
	public int getNuméroC() {
		return numéroC;
	}
	public void setNuméroC(int numéroC) {
		this.numéroC = numéroC;
	}
	public void setP(Produit p) {
		this.p = p;
	}
	public Commande(int numéroC, int quantite, double total, Produit p) {
		this.numéroC = numéroC;
		this.quantite = quantite;
		this.total = total;
		this.p = p;
	}
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Commande [numéroC=" + numéroC + ", quantite=" + quantite + ", total=" + total + ", p=" + p + "]";
	}
	
	
	
	
}
