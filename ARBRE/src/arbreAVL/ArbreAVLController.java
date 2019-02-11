
package arbreAVL;
import test.*;
import test.Main;
import arbreRN.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import application.*;
import javafx.scene.Group;
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


public class ArbreAVLController {
    
    ArbreAVL aavl=null;
    
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
   private void ajouterElem(ActionEvent event) {
       int numbre=Integer.parseInt(champ_text1.getText());
                 aavl = ArbreAVL.inserer(aavl,numbre);
                label.setText("le nombre "+numbre+" a ete ajouter");
                tracer_aAVL(aavl,null);
    }     
    @FXML
   private void chercherElem(ActionEvent event) {
               int numbre=Integer.parseInt(champ_text1.getText());
               if(ArbreAVL.chercher(aavl,numbre)){
                    tracer_aAVL(aavl,numbre);
                    label.setText("le nombre "+numbre+" a ete trouver");
               }
               else label.setText("Ce nombre n'existe pas dans l'arbre");

    }
    @FXML
   private void supprimerElem(ActionEvent event) {
        int numbre=Integer.parseInt(champ_text1.getText());
               if(ArbreAVL.chercher(aavl,numbre)){
                     aavl = ArbreAVL.supprimer(aavl,numbre);
                    tracer_aAVL(aavl,null);
                    label.setText("Le nombre a ete supprimer");
               }
               else label.setText("Ce nombre n'existe pas dans l'arbre");
            
    }
    @FXML
   private void effacerLArbreAction(ActionEvent event) {
        aavl = null;
            pan.getChildren().clear();
            label.setText("L'arbre a ete renisialiser");        
    }

   
      
    private void tracer_aAVL(ArbreAVL a,Comparable o){
        if(a != null){
            pan.getChildren().clear();
            if(o==null) 
                tracer_aAVL(0,(float)pan.getWidth()-20,a,40);
            else
                tracer_after_search(0,(float)pan.getWidth()-20,a,40,o);
        }
        
    
    }
    
       private float tracer_aAVL(float x1,float x2,ArbreAVL a,float y){
        float xd=0,xg=0;
        
        int nbFeuille = ArbreAVL.GetnbFeuille(a);
        if(nbFeuille == 0)
            nbFeuille =1;
        int nbFeuilleG = ArbreAVL.GetnbFeuille(a.filsG);
            if(nbFeuilleG == 0)
                 nbFeuilleG =1;
    
        float x = (nbFeuilleG*100/nbFeuille)*(x2-x1)/100 + x1 ;
       
        tracer_cercle(x,y,a.contenu); 
        
        if( a.filsD != null){
             xd =tracer_aAVL(x, x2, a.filsD, y+50);
             tracer_droite(x+15, y+8, xd, y+35);
            }
        
        if(a.filsG !=null){
            xg =tracer_aAVL(x1, x, a.filsG, y+50);
            tracer_droite(x-15, y+8, xg, y+35);
        }
        
        return x;
        }
    
        private float tracer_after_search(float x1,float x2,ArbreAVL a,float y,Comparable o){
         float xd=0,xg=0;
         int nbFeuille = ArbreAVL.GetnbFeuille(a);
            if(nbFeuille == 0)
              nbFeuille =1;
        int nbFeuilleG = ArbreAVL.GetnbFeuille(a.filsG);
            if(nbFeuilleG == 0)
              nbFeuilleG =1;
    
    
         float x = (nbFeuilleG*100/nbFeuille)*(x2-x1)/100 + x1;
        
        if(a.contenu.equals(o)) {
            ImageView im = new ImageView(new Image("new.png"));
            im.setFitHeight(40);
            im.setFitWidth(40);
             im.setLayoutX(x-18);
            im.setLayoutY(y-50);
            pan.getChildren().addAll(im); 
        }
         tracer_cercle(x,y,a.contenu); 
       
         
         if( a.filsD != null){
             xd =tracer_after_search(x, x2, a.filsD, y+50,o);
             tracer_droite(x+15, y+8, xd, y+35);
        }
        
        if(a.filsG !=null){
            xg =tracer_after_search(x1, x, a.filsG, y+50,o);
            tracer_droite(x-15, y+8, xg, y+35);
        }
        return x;
       
    }
  
    
    private void tracer_cercle(float x,float y,Comparable info){
        
        Circle cercle=new Circle(x,y,15);
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
    

