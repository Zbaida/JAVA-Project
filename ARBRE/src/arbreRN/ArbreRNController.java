package arbreRN;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import application.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import test.Main;


public class ArbreRNController {
    ArbreRN arn = new ArbreRN();
    
    @FXML
    private Label label;
    @FXML
    private Label label2;

    @FXML
    private TextField champ_text1;
    @FXML
    private TextField champ_text2;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private Button btn13;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private AnchorPane pan;

    @FXML
    public Button closeButton;
    
    
    
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Main c=new Main();
    	try {
    		c.start();
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void effacerLArbreAction(ActionEvent event) {
            arn = new ArbreRN();
            pan.getChildren().clear();
            label.setText("L'arbre a bien renitialiser");
    }
    
    
    
    @FXML
    private void supprimerElem(ActionEvent event) {
               int numbre=Integer.parseInt(champ_text1.getText());
               if(arn.racine.recherche(numbre)){
                    arn.supprimer(numbre);
                    tracer_arn(arn.racine,null);
                    label.setText("Le nombre a ete bien supprime");
               }
               else label.setText("Ce nombre n'existe pas dans l'arbre");
    
        }
    
    @FXML
    private void ajouterElem(ActionEvent event) {
                int numbre=Integer.parseInt(champ_text1.getText());
                arn.ajout(numbre);
                label.setText("le nombre "+numbre+" a ete ajoute");
                tracer_arn(arn.racine,null);
    }
    
   
    @FXML
    private void chercherElem(ActionEvent event) {
               int numbre=Integer.parseInt(champ_text1.getText());
               if(arn.racine.recherche(numbre)){
                    tracer_arn(arn.racine,numbre);
                    label.setText("le nombre "+numbre+" a ete trouver ");
               }
               else label.setText("Ce nombre n'existe pas dans l'arbre");
    }
    
    
    private void tracer_arn(NoeudRN rac,Comparable o){
        if(!rac.isSentinelle()){
            pan.getChildren().clear();
            if(o==null) 
                tracer_arn(0,(float)pan.getWidth(),rac,40);
            else
                tracer_after_search(0,(float)pan.getWidth(),rac,40,o);
        }
       }
    
    
        private float tracer_arn(float x1,float x2,NoeudRN rac,float y){
        float xd=0,xg=0;
        
        int nbFeuille = GetnbFeuille(rac);
        int nbFeuilleG = GetnbFeuille(rac.gauche);
        float x = (nbFeuilleG*100/nbFeuille)*(x2-x1)/100 + x1;
        //après le calcule de la postion du noeud actuel je trace la cercle
        tracer_cercle(x,y,rac.couleur,rac.info); 
        
        if(! rac.droit.isSentinelle()){
             xd =tracer_arn(x, x2, rac.droit, y+50);
             tracer_droite(x+15, y+8, xd, y+35);
        }
        else{
            if(! rac.gauche.isSentinelle()) 
                tracer_droite(x+15, y+8, x+20, y+50);
            else
                tracer_droite(x, y+15, x+20, y+50);
                tracer_rectangle(x+13, y+40);
        } 
        
        if(! rac.gauche.isSentinelle()){
            xg =tracer_arn(x1, x, rac.gauche, y+50);
            tracer_droite(x-15, y+8, xg, y+35);
        }
        else{
            
            if(! rac.droit.isSentinelle()) tracer_droite(x-15, y+8, x-20, y+50);
            else tracer_droite(x, y+15, x-20, y+50);
            tracer_rectangle(x-27, y+40);
        }
        return x;
       
    }
    
        private float tracer_after_search(float x1,float x2,NoeudRN rac,float y,Comparable o){
         float xd=0,xg=0;
        int nbFeuille = GetnbFeuille(rac);
        int nbFeuilleG = GetnbFeuille(rac.gauche);
        float x = (nbFeuilleG*100/nbFeuille)*(x2-x1)/100 + x1;
        if(rac.info.equals(o)) {
          ImageView im = new ImageView(new Image("new.png"));
            im.setFitHeight(40);
            im.setFitWidth(40);
            im.setLayoutX(x-18);
            im.setLayoutY(y-50);
            pan.getChildren().addAll(im); 
            
        }
         tracer_cercle(x,y,rac.couleur,rac.info); 
        if(! rac.droit.isSentinelle()){
             xd =tracer_after_search(x, x2, rac.droit, y+50,o);
             tracer_droite(x+15, y+8, xd, y+35);
        }
        else{
             if(! rac.gauche.isSentinelle()) tracer_droite(x+15, y+8, x+20, y+50);
            else tracer_droite(x, y+15, x+20, y+50);
            
            tracer_rectangle(x+13, y+40);
        } 
        
        if(! rac.gauche.isSentinelle()){
            xg =tracer_after_search(x1, x, rac.gauche, y+50,o);
            tracer_droite(x-15, y+8, xg, y+35);
        }
        else{
            if(! rac.droit.isSentinelle()) tracer_droite(x-15, y+8, x-20, y+50);
            else tracer_droite(x, y+15, x-20, y+50);
            tracer_rectangle(x-27, y+40);
        }
        return x;
       
    }
    private int GetnbFeuille(NoeudRN r){
        if(r.isSentinelle()) return 1;
        else return (GetnbFeuille(r.gauche)+GetnbFeuille(r.droit));
    }
    private void tracer_cercle(float x,float y,Color c,Comparable info){
        
        Circle cercle=new Circle(x,y,15,c);
        Label label = new Label(""+info);
        if(Integer.parseInt(info.toString())<100)
        label.setLayoutX(x-6);
        else  label.setLayoutX(x-9);
        label.setLayoutY(y-9);
        label.setTextFill(Color.WHITE);
        pan.getChildren().add(cercle);
        pan.getChildren().add(label);  
    }
     private void tracer_droite(float x1,float y1,float x2,float y2){
         Line line = new Line();
            line.setStartX(x1);
            line.setStartY(y1);
            line.setEndX(x2);
            line.setEndY(y2);
            pan.getChildren().add(line);
    }
     private void tracer_rectangle(float x,float y){
         Rectangle rec = new Rectangle(14, 14, Color.BLACK);
         rec.setLayoutX(x);
         rec.setLayoutY(y);
         pan.getChildren().add(rec);
    }
    
}
