public class Client {
private String matricule;
private String nom;
private String prenom;

public String getMatricule() {
	return matricule;
}
public String getNom() {
	return nom;
}
public String getPrenom() {
	return prenom;
}
public void setMatricule (String matricule) {
this.matricule = matricule;
}
public void setNom(String nom) {this.nom = nom;}
public void setPrenom(String prenom) { this.prenom = prenom;}
public Client(String matricule, String nom, String prenom) {
setMatricule(matricule);
setNom(nom);
setPrenom(prenom);
}

public Client() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
return "Client [matricule=" + matricule + ", nom=" + nom + ", prenom="
+ prenom + "]";
}
}
