import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FactureList {
	private Map<Integer,Facture> liste=new HashMap<>();
	
	public void menuGestionFacture(){
		System.out.println("---------------MENU-------------");
		System.out.println("1:Gestion De Produits --------------------------|");
		System.out.println("2:Gestion de Clients-------------------------------|");
		System.out.println("3:Gestion de Commandes----------------------------|");
		System.out.println("4:Gestion de Facture----------------------------|");
		System.out.println("0:exit----------------------------|");
		System.out.println("------------------------------------------------|");
	}
	
	public void add(Facture f){
		liste.put(f.getNumero(), f);
		
	}
	
	public void Delete(int numero){
		liste.remove(numero);
	}

	public void Update(Facture f){
		if(liste.containsKey(f.getNumero())){
			liste.put(f.getNumero(), f);
		}
	}
	public Collection<Facture> getAllFcature(){
		return liste.values();
	}
	public Facture getOne(int numero){
		return liste.get(numero);
	}
	public void afficheFacture(Facture f)
	{
		f.toString();
	}
    

}
