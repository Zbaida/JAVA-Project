
package boomapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author 
 */
public class BestScore extends javax.swing.JFrame {

    final BufferedImage image;
    final BufferedImage rank1;
    final BufferedImage rank2;
    final BufferedImage rank3;
    final BufferedImage rank4;
    final BufferedImage rank5;
    final BufferedImage crown;
    File scoresFile;
    BufferedReader br;
    ArrayList scores;
    ArrayList players;
    ArrayList<BufferedImage> ranks;
    public BestScore() throws IOException {
        scores = new ArrayList<>();
        players = new ArrayList<>();
        ranks = new ArrayList<>();
        scoresFile = new File("scores.txt");
        br = new BufferedReader(new FileReader(scoresFile));
        String line = "";
        while((line = br.readLine()) != null ){
            String[] params = line.split(":");
            players.add(params[0]);
            scores.add(params[1]);
            
        }
        
        this.image = ImageIO.read(new File("src\\images\\fond.gif"));
        this.rank1 = ImageIO.read(new File("rank1.png"));
        ranks.add(rank1);
        this.rank2 = ImageIO.read(new File("rank2.png"));
        ranks.add(rank2);
        this.rank3 = ImageIO.read(new File("rank3.png"));
        ranks.add(rank3);
        this.rank4 = ImageIO.read(new File("rank4.png"));
        ranks.add(rank4);
        this.rank5 = ImageIO.read(new File("rank5.png"));
        ranks.add(rank5);
        
        this.crown = ImageIO.read(new File("crown.gif"));
        initComponents();
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(270, 400));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, null);
        g.setColor(new Color(102, 255, 51));
        g.setFont(new Font("Sagoe UI", Font.PLAIN, 30));

        g.drawImage(crown, 0, 20, this);
        
        int yScale = 190;
        for (int i = 0; i < 5; i++) {
            g.setFont(new Font("Sagoe UI", Font.BOLD, 20));
            g.setColor(Color.red);
            g.drawImage(ranks.get(i), 20,yScale-25, this);
            g.setColor(new Color(102, 255, 51));
            g.drawString(players.get(i).toString(), 80,yScale);
            g.drawString(scores.get(i).toString(), 200,yScale);
            yScale += 40;
        
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BestScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BestScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BestScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BestScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BestScore().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(BestScore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
