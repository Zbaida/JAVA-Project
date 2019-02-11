


package boomapp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Jihane HEMICHA & Mohammed DOULFAKAR
 */
public class Avion extends Thread{
   public int xAvion;
   public int yAvion;
   public int dx=10;
   public int width;
   public int height;
   public boolean visible;
   public JLabel image;
   public JLabel panel;
   int speed;
   
  
  ActionListener lancement= new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          
        }
    };
 Timer timer =  new Timer((int)(Math.random()*(2000+1-1000))+1000,lancement);/*à chaque "(int)(Math.random()*(6000+1-1000))+1000" secondes*/


   public Avion(JLabel pan,int s) {
       speed=s;
                xAvion=0;
                yAvion=(int)(Math.random()*(50+1-5) + 5);
		
                panel=pan;
                image=new JLabel(new ImageIcon("spacecraft.gif"));
                 image.setBounds(xAvion,yAvion,140,45);
                  width = image.getWidth();
                 height = image.getHeight();
                 panel.add(image) ;
                 panel.repaint();
                visible = true;
                //dessiner();
	}
  

 synchronized   public void deplacer() {
            
           
            xAvion+=dx;
            Dimension d = panel.getSize();
        if (xAvion + width > d.width)
             xAvion=0;
            
            image.setLocation(xAvion,yAvion);

    }

	public void run() {
            
           
            timer.start();
            while(visible==true){
                
                deplacer();
                try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {}
           
		
                }
                timer.stop();
                panel.remove(image);
                panel.repaint();
                
	}

	

    public int getX() {
        return xAvion;
    }

    public int getY() {
        return yAvion;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public JLabel getImage() {
        return image;
    }

  //Pour faire disparaitre l'avion avec l'explosion 
    public void disapear(){
    ImageIcon a = new ImageIcon("7.gif");
    this.image.setIcon(a);
    }
}
