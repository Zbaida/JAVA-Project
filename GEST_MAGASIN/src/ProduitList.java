import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProduitList {
private Map<Long,Produit> liste=new HashMap<>();
public void add(Produit p){
	liste.put(p.getCode(), p);
	
}

public void Delete(long code){
	liste.remove(code);
}

public void Update(Produit p){
	if(liste.containsKey(p.getCode())){
		liste.put(p.getCode(), p);
	}
}
public Collection<Produit> getAll(){
	return liste.values();
}
public Produit getOne(long code){
	return liste.get(code);
}
public void afficheProduit(Produit Pr)
{
	System.out.println("Produit code :"+Pr.getCode()+"\t\t Produit name:"+Pr.getDesignation()+"\t\tPrix de Vente:"+Pr.getPrixVente());
}

public Collection<Produit> getAll(String designation){
	Collection<Produit> liste1=new ArrayList<>();
	for(Produit p:liste.values()){
		if(p.getDesignation().contains(designation)){
			liste1.add(p);
		}
	}
	return liste1;
}

}
