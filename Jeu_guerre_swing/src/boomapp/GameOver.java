/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boomapp;

import static boomapp.Music.musica;
import static boomapp.Partie.liste_avions;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author hemic
 */
public class GameOver extends JFrame implements ActionListener{
JButton gameov;
Music m=new Music("gameover.wav");




    public GameOver() {
    m.play();
    this.setUndecorated(true);
    setContentPane(new JLabel(new ImageIcon("gameover.gif")));
    this.setSize(500, 275);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    
    gameov = new JButton(new ImageIcon("gameove_btn.png"));
        gameov.setSize(314,79);
         gameov.setBackground(Color.BLACK);
        this.add(gameov);
        gameov.setLocation(90,70);
        gameov.setBorderPainted(true);
        gameov.addActionListener(this);
        gameov.setBorder(null);
        gameov.setOpaque(false);
     }
    
    
    public void paint(Graphics g) {
	
	      setShape(new RoundRectangle2D.Double(0,0,
		        getWidth(), getHeight(), 50,50));
		   super.paint(g);
		   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       setVisible(false); //you can't see me!
                        dispose(); //Destroy the JFrame object
        
    }
    
    
}
