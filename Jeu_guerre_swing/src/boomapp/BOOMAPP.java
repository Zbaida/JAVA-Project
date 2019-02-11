
package boomapp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class welcome extends JFrame implements ActionListener{
    JButton btn_start;
    JButton btn_exit;
    JButton btn_about;
    JLabel flane;
    Music mu;
    
    welcome()
    {
    mu=new Music("button.wav");
    this.setUndecorated(true);
    setContentPane(new JLabel(new ImageIcon("acc.jpg")));
    this.setSize(800, 240);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Starwars LSI game");
        
        //Bouton de Start 
        btn_start = new JButton(new ImageIcon("Start_btn.png"));
        btn_start.setSize(70,70);
         btn_start.setBackground(Color.BLACK);
        this.add(btn_start);
        btn_start.setLocation(700, 4);
        btn_start.setBorderPainted(true);
        btn_start.addActionListener(this);
        btn_start.setBorder(null);
        btn_start.setOpaque(false);
       
        //Bouton de quitter
        btn_exit=new JButton(new ImageIcon("exit_btn.png"));
        btn_exit.setBackground(Color.BLACK);
        btn_exit.setSize(67,67);
        this.add(btn_exit);
        btn_exit.setLocation(700, 174);
        btn_exit.addActionListener(this);
        btn_exit.setBorder(null);
        btn_exit.setOpaque(false);
        
        //Butoun about
        btn_about=new JButton(new ImageIcon("about_btn.png"));
        btn_about.setBackground(Color.BLACK);
        btn_about.setSize(67,67);
        this.add(btn_about);
        btn_about.setLocation(20, 174);
        btn_about.addActionListener(this);
        btn_about.setBorder(null);
        btn_about.setOpaque(false);
       
    }
    public void paint(Graphics g) {
	
	      setShape(new RoundRectangle2D.Double(0,0,
		        getWidth(), getHeight(), 50,50));
		   super.paint(g);
		   }
    
    public void add_anim()
    {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        mu=new Music("button.wav");
        mu.play();
        if(ae.getSource()==btn_start)
        {Form2 f= new Form2();
       f.show();}
        
        else
            if(ae.getSource()==btn_exit)
            {setVisible(false); 
                        dispose();
            System.exit(0);}
        else
                if(ae.getSource()==btn_about)
                {About ab=new About();
                ab.show();}
                
    }
    
    
}
public class BOOMAPP {

    
    public static void main(String[] args) {
            final JFrame frame = new JFrame("JDialog Demo");
    	        final JButton btnLogin = new JButton("Click to login");
    	 
    	        btnLogin.addActionListener(
    	                new ActionListener(){
                                @Override
    	                    public void actionPerformed(ActionEvent e) {
    	                        LoginDialog loginDlg = new LoginDialog(frame);
    	                        loginDlg.setVisible(true);
    	                        // if login successfully
    	                        if(loginDlg.isSucceeded()){
    	                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                                    btnLogin.setVisible(false);
                                    frame.setVisible(false);
                                }
    	                    }
    	                });
    	 
    	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        frame.setSize(300, 100);
                frame.setLocationRelativeTo(null);
                frame.setAlwaysOnTop(true);              
    	        frame.setLayout(new FlowLayout());
    	        frame.getContentPane().add(btnLogin);
    	        frame.setVisible(true);
         /**/welcome w=new welcome();
       w.setAlwaysOnTop(false);
        
    }
}
