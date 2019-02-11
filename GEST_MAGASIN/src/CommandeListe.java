import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandeListe {

	private Map<Integer,Commande> liste=new HashMap<>();
	
	public void add(Commande c){
		
		liste.put(c.getNuméroC(), c);
		
	}

	public void Delete(int numéroC){
		liste.remove(numéroC);
	}

	public void Update(Commande c){
		if(liste.containsKey(c.getNuméroC())){
			liste.put(c.getNuméroC(), c);
		}
	}
	public Collection<Commande> getAllCommande(){
		
		return liste.values();
	}
	public Commande getOneCommande(int numéroC){
		return liste.get(numéroC);
	}
	
	
}
