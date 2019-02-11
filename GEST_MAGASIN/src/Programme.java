import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Programme {
	
	private static Scanner sc;	
	public static void AfficherP(ProduitList pm) {
		Collection<Produit> liste = pm.getAll();
		 for(Produit p:liste){
    		System.out.println(p); 
  		 }
	}

	public static void AfficherCom(CommandeListe cm) {
		Collection<Commande> liste = cm.getAllCommande();
		 for(Commande commmm:liste){
    		System.out.println(commmm); 
  		 }
	}

	public static void AfficherCli(ClientListe cli) {
		Collection<Client> liste = cli.getAllClient();
		 for(Client c:liste){
    		System.out.println(c); 
  		 }
	}
	public static void AfficherF(FactureList fm) {
		Collection<Facture> liste = fm.getAllFcature();
		 for(Facture f:liste){
    		System.out.println(f); 
  		 }
	}
  
	

	public static void main(String[] args) {
		Collection<Commande> commandeli=new ArrayList();
		ProduitList pm=new ProduitList();
		//creation des produit static
		Produit produit1=new Produit(1,"shampo",125.2);
		Produit produit2=new Produit(2,"biscuit",205);
		Produit produit3=new Produit(3,"stylo",20);
		Produit produit4=new Produit(4,"fromage",14);
		pm.add(produit1);
		pm.add(produit2);
		pm.add(produit3);
		pm.add(produit4);
		
		ClientListe cm=new ClientListe();
		//creation des clients statics
		Client client0 =new Client("1","kodad","mohammed");
		Client client2 =new Client("2","zbaida","achraf");
		Client client3 =new Client("3","kodad","bilal");
		Client client4 =new Client("4","kodad","Anoir");
		cm.addClient(client4);
		cm.addClient(client3);
		cm.addClient(client2);
		cm.addClient(client0);
		
		
		
		sc = new Scanner(System.in);		
		CommandeListe comm=new CommandeListe();		
		Collection <Commande> comma=new ArrayList();
		Commande command1=new Commande(1,10,100,produit4);
		Commande command2=new Commande(2,9,100,produit3);
		Commande command3=new Commande(3,8,100,produit2);
		Commande command4=new Commande(4,7,100,produit1);
		comm.add(command1);
		comm.add(command2);
		comm.add(command3);
		comm.add(command4);
		FactureList fm=new FactureList();
		String nom,prenom;
		long code=0;
		int quantite=0,cd=0;
		String designation;
		double prixVente=0;
		double total=0;
		int choix1=10,choix2=10,choix3=10,choix4=10,choix5=10;
		double HT=0,TTC=0;
		System.out.println("");
		while(choix1!=0){
		choix1=10;
		System.out.println("*********** Gestion de Magasine ************");
		System.out.println("");
		System.out.println("1- Gestion des Produits");
		System.out.println("2- Gestion des Clients");
		System.out.println("3- Gestion des Commandes");
		System.out.println("4- Gestion des Factures");
		System.out.println("0- Quitter !!");
		System.out.println("");
		System.out.println("Tappez le nombre de ce que vous voulez !!");
		choix1 = sc.nextInt();
		System.out.println("");
		switch(choix1){
			case 1 : 
			choix2=10;
				while(choix2!=0){
			System.out.println("");
			System.out.println("*********** Gestion des Produits ************");
			System.out.println("");
			System.out.println("1- Ajouter Un Produit");
			System.out.println("2- Modifier Un Produit");
			System.out.println("3- Afficher tous les Produits");
			System.out.println("4- Chercher Un Produit par son code");
			System.out.println("5- Chercher Des Produit par leur designation");
			System.out.println("6- Supprimer un Produit");		
			System.out.println("0- Revenir au menu principale !!");
			System.out.println("");
			System.out.println("Tappez le nombre de ce que vous voulez !!");
			choix2 = sc.nextInt();
			System.out.println("");
			switch(choix2){
				case 1 : System.out.println("Saisir un code :");
						 code=sc.nextInt();
						 System.out.println("Saisir le Designation :");
						 designation=sc.next();
						 System.out.println("Sasir le prix de vente :");
						 prixVente=sc.nextFloat();
	            		 Produit p1 = new Produit(code,designation,prixVente);
	            		 pm.add(p1); 
	            		 System.out.println("Votre Produit a été bien ajouté");
	            		 break;
				case 2 : AfficherP(pm);
						 System.out.println("Saisir un code :");
						 code=sc.nextInt();
						 System.out.println("Saisir le Designation :");
						 designation=sc.next();
						 System.out.println("Sasir le prix de vente :");
						 prixVente=sc.nextDouble();
			       		 Produit p2 = new Produit(code,designation,prixVente);
			       		 pm.Update(p2); 
			       		 System.out.println("Votre Produit a été bien modifié");
			       		 break;

				case 3 : AfficherP(pm);
						 break;
				case 4 : System.out.println("Saisir le code du Produit que vous voulez rechercher");
						 code=sc.nextInt();
						 Produit c= pm.getOne(code);
						 System.out.println(c);
						 break;
				case 5 : System.out.println("Saisir la designation des Produits que vous voulez rechercher");
				 		String designation1=sc.next();
				 		 Collection<Produit> l= pm.getAll(designation1);
				 		 for(Produit p:l){
				 		 System.out.println(p);
				 		 }
						 break;
				case 6 : AfficherP(pm);
						 System.out.println("Saisir le code du Produit que vous voulez supprimer");
				 		 code=sc.nextInt();
				 		 pm.Delete(code);
				 		 break;
				case 0 : break;
				default: System.out.println("Vous avez saisi un nombre incorrecte !!");  
					 }
				}
				 break;
			case 2 : choix3=10;
					while(choix3!=0){
						
					System.out.println("");
					System.out.println("*********** Gestion des Clients ************");
					System.out.println("");
					System.out.println("1- Ajouter Un client");
					System.out.println("2- Modifier un Client");
					System.out.println("3- Afficher tous les clients");
					System.out.println("4- Chercher Un client par son code");
					System.out.println("5- Supprimer un client");		
					System.out.println("0- Revenir au menu principale ");
					System.out.println("");
					System.out.println("Tappez le nombre de ce que vous voulez !!");
					choix3 = sc.nextInt();
					System.out.println("");
					
					switch(choix3){
						case 1 : System.out.println("Saisir un code :");
							String matricule;
							matricule=sc.next();
								 System.out.println("Saisir le nom :");
								 nom=sc.next();
								 System.out.println("Sasir le prenom :");
								 prenom=sc.next();
			            		 Client c1 = new Client(matricule,nom,prenom);
			            		 cm.addClient(c1); 
			            		 System.out.println("Votre Client a été bien ajouté");
			            		 break;
						case 2 : AfficherCli(cm);
								 System.out.println("Saisir un code :");
								 matricule=sc.next();
								 System.out.println("Saisir le nom :");
								 nom=sc.next();
								 System.out.println("Sasir le prenom :");
								 prenom=sc.next();
			            		 Client c2 = new Client(matricule,nom,prenom);
			            		 cm.Update(c2); 
			            		 System.out.println("Votre Client a été bien ajouté");
			            		 break;
						case 3 : AfficherCli(cm);
								 break;
						case 4 : System.out.println("Saisir le code du client que vous voulez rechercher");
									matricule=sc.next();
								 Client c= cm.getOneClient(matricule);
								 System.out.println(c);
								 break;
						case 5 : AfficherCli(cm);
								 System.out.println("Saisir le code du client que vous voulez supprimer");
								 matricule=sc.next();
						 		 cm.DeleteClient(matricule);
						 		 break;
						case 0 : break;
						default: System.out.println("Vous avez saisi un nombre incorrecte !!");  
							 }
					}	
					 break;
					case 3 :
						choix4=10;	
					while(choix4!=0){
					System.out.println("");
					System.out.println("*********** Gestion des Commandes ************");
					System.out.println("");
					System.out.println("1- Ajouter Une Commande");
					System.out.println("2- Modifier Une Commande");
					System.out.println("3- Afficher tous les Commandes");
					System.out.println("4- Chercher Un Commande par son code");
					System.out.println("5- Supprimer un Commande");		
					System.out.println("0- Revenir au menu principale ");
					System.out.println("");
					System.out.println("Tappez le nombre de ce que vous voulez !!");
					choix4 = sc.nextInt();
					System.out.println("");
					
					switch(choix4){
						case 1 : System.out.println("Saisir un code :");
						    	int numeroc;
						    	numeroc=sc.nextInt();
								 System.out.println("Saisir la quantité :");
								 quantite=sc.nextInt();
								 AfficherP(pm);
								 System.out.println("Saisir le code du produit que vous voulez l'associer:");
								 long cmd=sc.nextInt();
								 Produit p = new Produit();
								 p=pm.getOne(cmd);								 
								 double tota;
									tota=quantite*p.getPrixVente();
									 Commande commande1 = new Commande(numeroc,quantite,tota,p);
			            		 comm.add(commande1); 
			            		 System.out.println("Votre Commande a été bien ajouté");
			            		 break;
						case 2 : AfficherCom(comm);
								 System.out.println("Saisir un code :");
								 numeroc=sc.nextInt();
								 System.out.println("Saisir la quantité :");
								 quantite=sc.nextInt();
								 AfficherP(pm);
								 System.out.println("Saisir le code du produit que vous voulez l'associer:");
								 cd=sc.nextInt();
								 Produit p1 = new Produit();
								 p1=pm.getOne(cd);
								 double tota2;
									tota2=quantite*(p1.getPrixVente());
								 Commande commande2 = new Commande(numeroc,quantite,tota2,p1);
			            		 comm.Update(commande2); 
			            		 System.out.println("Votre Commande a été bien modifié");
			            		 break;
						case 3 : AfficherCom(comm);
								 break;
						case 4 : System.out.println("Saisir le code du Commande que vous voulez rechercher");
								numeroc=sc.nextInt();
								 Commande f= comm.getOneCommande(numeroc);
								 System.out.println(f);
								 break;
						case 5 : AfficherCom(comm);
								 System.out.println("Saisir le code du Commande que vous voulez supprimer");
								 numeroc=sc.nextInt();
						 		 comm.Delete(numeroc);
						 		 break;
						case 0 : break;
						default: System.out.println("Vous avez saisi un nombre incorrecte !!");  
							 }
					}		
					 break;
			case 4 :choix5=10; 
				while(choix5!=0){
					System.out.println("");
					System.out.println("*********** Gestion des Factures ************");
					System.out.println("");
					System.out.println("1- Ajouter Une Facture");
					System.out.println("2- Modifier Une Facture");
					System.out.println("3- Afficher tous les Factures");
					System.out.println("4- Chercher Une Facture par son code");
					System.out.println("5- Supprimer une Facture");		
					System.out.println("0- Revenir au menu principale ");
					System.out.println("");
					System.out.println("Tappez le nombre de ce que vous voulez !!");
					choix5 = sc.nextInt();
					System.out.println("");
					
					switch(choix5){
						case 1 : 
								HT=0;TTC=0;
							    System.out.println("Saisir un code :");
								int numeroc;
								numeroc=sc.nextInt();
								 AfficherCom(comm);
								 System.out.println("Saisir le nombre de commande dans cette factures:");
								 int cpt=sc.nextInt();
								 for(int i=0;i<cpt;i++){
									 System.out.println("Saisir le code du commande numero"+(i+1)+" que vous voulez l'associer:");
									 int cd1=sc.nextInt();
									 Commande com = new Commande();
									 com=comm.getOneCommande(cd1);
									 double tota4;
										tota4=com.getTotal();
										HT=HT+tota4;
									 commandeli.add(com);
								 }
								 TTC=HT+(HT*0.2);
								 AfficherCli(cm);
								 System.out.println("Saisir le code du client que vous voulez l'associer:");
								 String cd2=sc.next();
								 Client client = new Client();
								 client=cm.getOneClient(cd2);
							     Facture facture=new Facture(numeroc,commandeli,client,HT,TTC); 
								 fm.add(facture);
			            		 System.out.println("Votre Facture a été bien ajouté");
			            		 break;
						case 2 : AfficherF(fm);
						         HT=0;TTC=0;
								 System.out.println("Saisir le code de facture que vous voulez modifier :");
								 numeroc=sc.nextInt();
								 AfficherCom(comm);
									 commandeli=new ArrayList();

								 System.out.println("Saisir le nombre de commande dans cette factures:");
								 int cpt1=sc.nextInt();
								 for(int i=0;i<cpt1;i++){
									 System.out.println("Saisir le code du commande numero"+(i+1)+" que vous voulez l'associer:");
									 int cd1=sc.nextInt();
									 Commande com = new Commande();
									 com=comm.getOneCommande(cd1);	
									 double tota3;
									tota3=com.getTotal();
									HT=HT+tota3;
									 commandeli.add(com);
								 }
								 TTC=HT+(HT*0.2);
								 AfficherCli(cm);
								 System.out.println("Saisir le code du client que vous voulez l'associer:");
								 String code2=sc.next();
								 Client client1 = new Client();
								 client1=cm.getOneClient(code2);
								 Facture facture1=new Facture(numeroc,commandeli,client1,HT,TTC); 
								 fm.Update(facture1);
			            		 System.out.println("Votre Facture a été bien modifié");
			            		 break;
						case 3 : AfficherF(fm);
								 break;
						case 4 : System.out.println("Saisir le code du facture que vous voulez rechercher");
								numeroc=sc.nextInt();
								 Facture f= fm.getOne(numeroc);
								 System.out.println(f);
								 break;
						case 5 : AfficherF(fm);
								 System.out.println("Saisir le code du Facture que vous voulez supprimer");
								 numeroc=sc.nextInt();
						 		 fm.Delete(numeroc);
						 		 break;
						case 0 : break;
						default: System.out.println("Vous avez saisi un nombre incorrecte !!");  
							 }
					}		
					 break;
			case 0 : System.exit(0);
					 break;
			default: System.out.println("Vous avez saisi un nombre incorrecte !!");  
			 	 }
	}
  }
}
