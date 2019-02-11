package boomapp;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Jihane Hemicha & mohammed doulfakar
 */
public class Spaceman extends JFrame  {

   
       public int x;
       public int y;
       public int dx;
       public int dy;
       public int width;
       public int height;
       public boolean visible;
       public JLabel image;
       public JLabel panel;
      
       Music m;
       
        public Spaceman(JLabel pan) {
     
                
                panel=pan;
                x=panel.getSize().width/2;
                y=panel.getSize().height-77;
                dx=10;
                dy=10;
		image =new JLabel( new ImageIcon("spaceman.png"));
                width = image.getWidth();
                height = image.getHeight();
                image.setBounds(x,y,51,76);// 51x76= taille de l'image
                panel.add(image);
                panel.repaint();
                visible = true;
                }
        
        
        

   public void AllerVersGauche(){
         
      Dimension dim = panel.getSize(); // dimension du panneau
      if((x+width)>0){x-=dx;}
      else x=dim.width;
          ////dessiner();
      image.setLocation(x, y);
      }
    public void AllerVersDroite(){
       Dimension dim = panel.getSize(); 
       if ((x+width)<dim.width) { x +=dx;}
       else
        x=0;
       image.setLocation(x, y);
    }
    
    
    public void AllerVersHaut(){
        Dimension dim = panel.getSize();
        if((y+height)>0){y-=dy;}
        else y=dim.height;
         // dessiner();
        image.setLocation(x, y);
      }
    
    public void AllerVersBas(){
        Dimension dim = panel.getSize(); // dimension du panneau
        if ((y+height)<dim.height) { y +=dy;}
        else
        y=0;
        image.setLocation(x, y);
    }
    public void tirer(){
        Ball1 b1 = new Ball1(panel,y,x);
        b1.start();
         m = new Music("gun_shot.wav");
       m.play();
        
        
    }
   
    
//Gestion des mouvements de clavier : gauche, droite, haut, bas
	public  void EvenementClik(KeyEvent ke) {
		int key = ke.getKeyCode();
		switch (key) {
                        case KeyEvent.VK_SPACE:
                               tirer();
                               break;
			case KeyEvent.VK_DOWN :
                               AllerVersBas();
				break;
			case KeyEvent.VK_UP:
				AllerVersHaut();
				break;
			case KeyEvent.VK_RIGHT:
				AllerVersDroite();
				break;
			case KeyEvent.VK_LEFT:
				AllerVersGauche();
				break;
                        
                        
                        case KeyEvent.VK_ESCAPE:
                               int result = JOptionPane.showConfirmDialog((Component) ke.getSource(),"Are you giving up?");
                                  if(result==JOptionPane.YES_OPTION)
                                      System.exit(0);
                               if(result==JOptionPane.NO_OPTION || result==JOptionPane.CANCEL_OPTION)
                                   return;
                                   
                                      
                                                  break;
		}

    }
         public void windowClosing(WindowEvent e) {
     
        int result = JOptionPane.showConfirmDialog((Component) e.getSource(),
            "Voulez-vous vraiment quitter le jeu?");
                                  if(result==JOptionPane.YES_OPTION)
                                      System.exit(0);
                               if(result==JOptionPane.NO_OPTION || result==JOptionPane.CANCEL_OPTION)
                                   return ;
    }
}
