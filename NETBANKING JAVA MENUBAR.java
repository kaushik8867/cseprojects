package net;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.image.ColorModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Menubar extends LR{

	LR l=new LR();
	 Menubar()
	 {
		createMenuBar();
	 }
	
	 void createMenuBar()
	 {
		JFrame f=new JFrame(" USER INFORMATION");
		JLabel b=new JLabel("WELCOME TO NET BANKING");
		b.setBounds(50,50,300,100);
		b.setForeground(Color.BLACK);
		b.setFont(new Font("Serif", Font.BOLD,20));
		p=new JPanel();
		pic=new JLabel();
		pic.setBounds(0,0,400,400);
		ImageIcon icon=new ImageIcon("C:\\Users\\Kaushik\\Pictures\\th0AFRA1U6.jpg");
		Image img=icon.getImage();
		Image newimg=img.getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newicon=new ImageIcon(newimg);
		pic.setIcon(newicon);
		p.setBounds(0,0,400,400);
		p.add(pic);
		
		JMenuBar menu=new JMenuBar();
		JMenu file=new JMenu("welcome: "+n1);
		JMenuItem mit=new JMenuItem("Bank Account");
		JMenuItem mit1=new JMenuItem("Moblile number");
		JMenuItem mit2=new JMenuItem("Transfer");
		JMenuItem mit3=new JMenuItem("Loan");
		JMenuItem mit4=new JMenuItem("EXIT");
		mit4.addActionListener((event)->System.exit(0));
		file.add(mit);
		file.add(mit1);
		file.add(mit2);
		file.add(mit3);
		file.add(mit4);
		menu.add(file);
		f.add(menu);
		f.add(b);
		f.setJMenuBar(menu);
		
		mit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				l.bankregister();
			}	
		});
		
		mit1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				l.mobileinfo();
			}	
		});
		
		mit2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				l.transfer();
			}	
		});
		
		mit3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				l.Loan();
			}	
		});
		f.add(p);
		//f.add(b);
		f.setSize(400,400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}