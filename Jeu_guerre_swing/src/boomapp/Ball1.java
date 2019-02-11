
package boomapp;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;



public class Ball1 extends Thread{
 public int x;
   public int y;
   public int dx=10;
   public int dy=10;
   public int width;
   public int height;
   public boolean visible;
   public JLabel image;
   public JLabel imageBomb;
   Music m;
   public JLabel panel;
   

   
   
   public Ball1(JLabel pan , int Y,int _X) {

                
                x=_X;
                y=Y;
                panel=pan;
                
                image= new JLabel(new ImageIcon("fireball.png"));
                //image.setSize(121, 121);
                image.setOpaque(false);
                image.setBounds(x,y,18,16);
                  width = image.getWidth();
                 height = image.getHeight();
                 panel.add(image) ;
                 panel.repaint();
                visible = true;
	}


   public void deplacer() {
           
            Dimension d = panel.getSize();
             if (y + height > 0){
               y-=dy;
              }
             else
               visible=false;
            image.setLocation(x,y);

    }

	public void run() {
            
            //dessiner();
            while(visible==true){
                deplacer();
                for(Avion av :Partie.liste_avions){
                if(new Rectangle(av.xAvion,av.yAvion,av.width,av.height).contains(new Rectangle(x,y,width,height))){
                    
                    
                    m = new Music("explo.wav");
                    m.play();
                     ImageIcon a = new ImageIcon("explo.gif");
                     av.image.setIcon(a);
                     Partie.score++;
                     Partie.score_globale++;

                     
                     try {Thread.sleep(300);}
               
	      catch (InterruptedException e) {}
                    image.setLocation(3000,3000);
                 
                 av.visible=false;
                 Partie.liste_avions.remove(av);
                 
                
                 visible=false;
                
                  }
                 }
		try {Thread.sleep(80);}
               
	      catch (InterruptedException e) {}
           }
                 panel.remove(image);
                 panel.repaint();
                 
             try{
    		Class.forName("com.mysql.jdbc.Driver");
                try{
       	      	        	
                        Connection dbc;
    			dbc=DriverManager.getConnection("jdbc:mysql://localhost/tp","root","");
    			Statement stmt =dbc.createStatement();
                        String sql = ("UPDATE score  set score='"+Partie.score_globale+"'where joueur='"+LoginDialog.tfUsername.getText().trim()+"'");
                        int executeUpdate = stmt.executeUpdate(sql);
    			}catch(SQLException e1){
    		    	System.out.println(e1);
    		    } 
                }catch(ClassNotFoundException e){
                        System.out.println(e);
                }
                     
        	        
	}
     	              
}
