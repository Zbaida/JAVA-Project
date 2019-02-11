/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boomapp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.MathContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author hemic
 */
 class About extends JFrame implements ActionListener{
    JButton back_btn;
    Music m;

    public About() {
        
        this.setUndecorated(true);
    setContentPane(new JLabel(new ImageIcon("About.jpg")));
    this.setSize(800, 476);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Starwars LSI game");
        
        back_btn=new JButton(new ImageIcon("back_btn.png"));
        back_btn.setBackground(Color.BLACK);
        back_btn.setSize(77,77);
        this.add(back_btn);
        back_btn.setLocation(8, 8);
        back_btn.addActionListener(this);
        back_btn.setBorder(null);
        back_btn.setOpaque(false);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        m=new Music("button.wav");
        m.play();
        setVisible(false); //you can't see me!
                        dispose();
    }
    
    
    
}
