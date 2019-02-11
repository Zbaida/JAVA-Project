import java.util.ArrayList;
import java.util.Collection;

public class Facture {
	
private int numero;
private Collection<Commande> c=new ArrayList();
private Client clt=new Client();
private double Ht;
private double TTc;
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public Collection<Commande> getC() {
	return c;
}
public void setC(Collection<Commande> c) {
	this.c = c;
}
public Client getClt() {
	return clt;
}
public void setClt(Client clt) {
	this.clt = clt;
}
public double getHt() {
	return Ht;
}
public void setHt(double ht) {
	Ht = ht;
}
public double getTTc() {
	return TTc;
}
public void setTTc(double tTc) {
	TTc = tTc;
}
public Facture(int numero, Collection<Commande> c, Client clt, double ht, double tTc) {
	this.numero = numero;
	this.c = c;
	this.clt = clt;
	Ht = ht;
	TTc = tTc;
}

public Facture(){
	
}
@Override
public String toString() {
	return "Facture [numero=" + numero + ", c=" + c + ", clt=" + clt + ", Ht=" + Ht + ", TTc=" + TTc + "]";
}

}