
public class Produit {
private long code;
private String designation;
private double prixVente;
public long getCode() {
	return code;
}
public void setCode(long code) {
	this.code = code;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public double getPrixVente() {
	return prixVente;
}
public void setPrixVente(double prixVente) {
	this.prixVente = prixVente;
}
public Produit(long code, String designation, double prixVente) {
	this.code = code;
	this.designation = designation;
	this.prixVente = prixVente;
}

public Produit(){
	this.code=0;
	this.designation="";
	this.prixVente=0;
}
@Override
public String toString() {
	return "Produit [code=" + code + ", designation=" + designation + ", prixVente=" + prixVente + "]";
}



}
