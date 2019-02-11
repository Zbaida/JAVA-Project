import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientListe {
	private Map<String,Client> liste=new HashMap<>();
	
	public void addClient(Client c){
		liste.put(c.getMatricule(),c);
	}
	
	public void DeleteClient(String Matricule){
		liste.remove(Matricule);
		
	}
	
	public void Update(Client c){
		if(liste.containsKey(c.getMatricule())){
			liste.put(c.getMatricule(), c);
		}
	}
	public Collection<Client> getAllClient(){
		return liste.values();
	}
	public Client getOneClient(String Matricule){
		return liste.get(Matricule);
	}
	public void afficheClient(Client Pr)
	{
		System.out.println("Client Matricule :"+Pr.getMatricule()+"\t\t Client last-name:"+Pr.getNom()+"\t\t Client first-name:"+Pr.getPrenom());
	}
	public Client rechercheClient(String Matricule){
		return liste.get(Matricule);
		
	}
	
	
}
