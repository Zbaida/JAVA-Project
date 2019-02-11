package presentation;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;





public class AppGest {

	public static void main(String[] args) {

		Presentation  Fen =new Presentation();
	}

}

class Presentation extends JFrame {
	private JPanel container = new JPanel();
	JMenuBar baredemenu = new JMenuBar();
	JMenu menu1 = new JMenu("File");
	JMenuItem option1 = new JMenuItem("Exit");
	JMenu menu2 = new JMenu("Order");
	JMenuItem option2 = new JMenuItem("Create Order");
	JMenuItem option3 = new JMenuItem("Manage Order");
	JMenu menu3 = new JMenu("Lists");
	JMenuItem option4 = new JMenuItem("List customers");
	JMenuItem option5 = new JMenuItem("List categories");
	JMenuItem option6 = new JMenuItem("List products");

	public Presentation(){
		
		this.setTitle("Resistance"); this.setBounds(450, 10,500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setContentPane(container);
		menu1.add(option1);
		menu2.add(option2);
		menu2.add(option3);
		menu3.add(option4);
		menu3.add(option5);
		menu3.add(option6);
		baredemenu.add(menu1);
		baredemenu.add(menu2);
		baredemenu.add(menu3);
		this.setJMenuBar(baredemenu);
		this.setVisible(true);
		
		option1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		option2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		option3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		option4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		option5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		option6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		
		option1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		
		option2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				container.removeAll();
				CreateOrder mo=new CreateOrder();
				
				container.add(mo);
				pack(); 
				validate();
				
			}
		});
		
		option3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				container.removeAll();
				ManageOrder mo=new ManageOrder();
				
				container.add(mo);
				validate();
				pack();
				
			}
		});
		
option4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				container.removeAll();
				ListCustommers mo=new ListCustommers();
				
				container.add(mo);
				validate();
				pack();
				
			}
		});

option5.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		container.removeAll();
		ListCategorie mo=new ListCategorie();
		
		container.add(mo);
		validate();
		pack();
		
	}
});



option6.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		container.removeAll();
		ListDesProduits mo=new ListDesProduits();
		
		container.add(mo);
		validate();
		pack();
		
	}
});
		

	}
	


}
