package test;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import javax.imageio.stream.FileCacheImageInputStream;
import application.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

 
    public   void start() throws Exception {
    	Stage primaryStage=new Stage();
    	Group gr=new Group();
     	Scene s=new Scene(gr,600,600,Color.WHITE);
         primaryStage.setScene(s);
         primaryStage.setTitle("Arbres (kodad-Achraf)");
         Rectangle r3=new Rectangle();
         r3.setWidth(600);
         r3.setHeight(150);
         r3.setFill(Color.BLACK); 
         //image profille
 		InputStream f= this.getClass().getResourceAsStream("/photosStock/kodad.jpg");
 		Image img=new Image(f);
 		ImageView image =new ImageView(img);		
 		image.setFitHeight(150);
 		image.setFitWidth(200);
 		
 		Label l2=new Label();
 		l2.setText("Big Data et Cloud Computing Enset Mohammedia 2018-2019");
 		l2.setTextFill(Color.web("RED"));
 		l2.setLayoutX(240);
 		l2.setLayoutY(5);
 		
 		Label l1=new Label();
 		l1.setText("Nom de Groupe :\n\nNom d'application :");
 		l1.setTextFill(Color.web("RED"));
 		l1.setLayoutX(210);
 		l1.setLayoutY(50);
         
 		Label l3=new Label();
 		l3.setText("KODAD MOHAMMED & ZBAIDA ACHRAF \n\nLES ARBRES");
 		l3.setTextFill(Color.web("WHITE"));
 		l3.setLayoutX(325);
 		l3.setLayoutY(50);
 		
 		 Rectangle r4=new Rectangle();
 	        r4.setWidth(600);
 	        r4.setHeight(80);
 	        r4.setY(520);
 	        r4.setFill(Color.BLACK); 
 	        
 	        
 	        Label Gtitre=new Label("Menu");
 	        Gtitre.setLayoutX(270);
 	        Gtitre.setLayoutY(160);
 	        Gtitre.setTextFill(Color.DARKRED);
 	        Gtitre.setStyle("-fx-font-family: 'Courier New';"
 	        		+ "-fx-font-size: 24");
 	        
 	       Label text=new Label();
 	      text.setText("c'est un mini projet qui présente deux types des arbres \n\n          Arbre RN et Arbre AVL Voila un cour\n\n                  pour Bien compris");
 	      text.setTextFill(Color.web("BLACK"));
 	    text.setStyle("-fx-font-family: 'Courier New';"
 	    		+ "-fx-background: rgb(225, 228, 203);");
 	      text.setFont(Font.font(18));
 	      text.setLayoutX(2);
 	      text.setLayoutY(200); 
 	      
 	     Hyperlink link = new Hyperlink("Cliquer espace pour ouvrire le lien de cour"); 	  
 	     
 	     link.setOnAction(new EventHandler<ActionEvent>(){
 			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				getHostServices().showDocument("https://www.geeksforgeeks.org/red-black-tree-vs-avl-tree/");
			}
  	    });
 	    
 	    link.setStyle("-fx-font-size: 16;"
 	    		+ "-fx-font-family: 'Courier New';"
 	    		+ "-fx-background: rgb(225, 228, 203);");
 	    link.setLayoutY(330);
 	    link.setLayoutX(90);
 	  
	   
 	   
 	       Button B1=new Button();
 	       B1.setStyle(
 	    		   "-fx-background-color: black; " +
 	    	       "-fx-border-color: red;"	    				       		   
 	    		   );      
 	       B1.setShape(new Circle(1));
 	       B1.setText("     Arber\nRouge Noir");
 	       B1.setTextFill(Color.WHITE);
 	       B1.setMinWidth(120);
 	       B1.setMinHeight(120);
 	       B1.setLayoutX(130);
 	       B1.setLayoutY(380);
 	       
 	       Button B2=new Button();
 	       B2.setStyle(
 	    		   "-fx-background-color: black; " +
 	    	       "-fx-border-color: red;"	    				       		   
 	    		   );      
 	       B2.setShape(new Circle(1));
 	       B2.setText("Arber AVL");
 	       B2.setTextFill(Color.WHITE);
 	       B2.setMinWidth(120);
 	       B2.setMinHeight(120);
 	       B2.setLayoutX(330);
 	       B2.setLayoutY(380);
 	       
 	       Label l5=new Label();
 			l5.setText("Contactez-nous : ");
 			l5.setTextFill(Color.web("RED"));
 			l5.setLayoutX(40);
 			l5.setLayoutY(530);
 			Label l6=new Label();
 			l6.setText("suivez-nous : ");
 			l6.setTextFill(Color.web("RED"));
 			l6.setLayoutX(400);
 			l6.setLayoutY(530);
 			   Label l7=new Label();
 				l7.setText("Instagram | Facebook | twiter");
 				l7.setTextFill(Color.web("#4f4f4f"));
 				l7.setLayoutX(400);
 				l7.setLayoutY(550);
 	       
 	       Label l4=new Label();
 			l4.setText("    Email : -kodad120@gmail.com\n                -Achraf.zbaida@gmail.com");
 			l4.setTextFill(Color.web("WHITE"));
 			l4.setLayoutX(70);
 			l4.setLayoutY(550);
       
        gr.getChildren().add(r3);
        gr.getChildren().add(r4);
        gr.getChildren().add(image);
     	gr.getChildren().add(l1);
     	gr.getChildren().add(l2);
     	gr.getChildren().add(l3);
     	gr.getChildren().add(Gtitre);
     	gr.getChildren().add(link);     	
     	gr.getChildren().add(text);
     	gr.getChildren().add(B1);
     	gr.getChildren().add(B2);
     	gr.getChildren().add(l4);
     	gr.getChildren().add(l5);
     	gr.getChildren().add(l6);
     	gr.getChildren().add(l7);
     	primaryStage.show();
         //code
         
         
         B1.setOnMouseClicked(new EventHandler<MouseEvent>(){
             public void handle(MouseEvent me){
                 //instructions à exécuter lors de cet événement
             	
             	try {
             		primaryStage.setTitle("Arbres Rouge Noire (kodad-Achraf)");
             		gr.getChildren().add(FXMLLoader.load(getClass().getClassLoader().getResource("arn.fxml")));
             		primaryStage.show();
 				} catch (Exception e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
   }	
         });
         B2.setOnMouseClicked(new EventHandler<MouseEvent>(){
             public void handle(MouseEvent me){
                 //instructions à exécuter lors de cet événement
             	
             	try {
             		primaryStage.setTitle("Arbres AVL (kodad-Achraf)");
             		gr.getChildren().add(FXMLLoader.load(getClass().getClassLoader().getResource("aavl.fxml")));
             		primaryStage.show();
 				} catch (Exception e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
   }	
         });

     }


    public static void main(String[] args) {
        launch(args);
    }


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		start();
	}
}