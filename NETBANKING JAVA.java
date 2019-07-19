package net;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LR extends JFrame{
	
	JButton b,b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,pic;
	JPanel p;
	JTextField tf,tf1,tf2,tf3;
	JPasswordField ps,ps1;
	static String n1;
	static int n2;
	public  void loginform () throws SQLException, ClassNotFoundException{
			JFrame f=new JFrame("LOGIN1 FORM");
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
			//ImageIcon img=new ImageIcon("8cbd005a556ccd4211ce43f309bc0eac.jpg");
			//f.setIconImage(img.getImage());
			l1=new JLabel("LOGIN FORM");
			l1.setForeground(Color.DARK_GRAY);
			l1.setFont(new Font("Serif", Font.BOLD,20));
			
			l2=new JLabel("USERNAME");
			l3=new JLabel("PASSWORD");
			
			tf=new JTextField();
			tf1=new JTextField();
			ps =new JPasswordField();
			b=new JButton("LOGIN");
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					try{
						String name=tf.getText();
						n1=name;
						String pass=ps.getText();
						if(name.isEmpty()||pass.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password");	
						}
						else {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
							Statement st=con.createStatement();
							String sql="select *from login where name='"+name+"'and password='"+ps.getText()+"'";
							ResultSet r=st.executeQuery(sql);
							if(r.next())
							{	n2=r.getInt(3);
								JOptionPane.showMessageDialog(null, "login successful");
								new Menubar();
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "login unsuccessful");
							}
						}
						
					}
						catch(Exception e){
						System.out.println(e);
					}
				}
			});
			b1=new JButton("Click here to Register");
			b1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					 register();	}	
			});
			b2=new JButton("Exit");
			b2.addActionListener((event)->System.exit(0));
			
			l1.setBounds(100,30,400,30);
			l2.setBounds(50,80,200,30);
			l3.setBounds(50,120,200,30);
			tf.setBounds(150,80,200,30);
			ps.setBounds(150,120,200,30);
			b.setBounds(200,180,100,20);
			b1.setBounds(100,220,180,20);
			b2.setBounds(80,180,80,20);
			
			f.getContentPane().setBackground(Color.DARK_GRAY);
			l2.setForeground(Color.BLACK);
			l3.setForeground(Color.BLACK);
			b.setBackground(Color.lightGray);
			b1.setBackground(Color.lightGray);
			b2.setBackground(Color.lightGray);
			
			f.add(l1);
			f.add(l2);
			f.add(tf);
			f.add(l3);
			f.add(ps);
			f.add(b);
			f.add(b1);
			f.add(b2);
			f.add(p);
			
			f.setSize(400,400);
			f.setLayout(null);
			f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true);
		}
		
		public   void register() {
			
				JFrame f=new JFrame("REGISTRATION FORM");
				l1=new JLabel("REGISTRATION FORM");
				l1.setForeground(Color.DARK_GRAY);
				l1.setFont(new Font("Serif", Font.BOLD,20));
				
				l2=new JLabel("Name");
				l5=new JLabel("ACCOUNT NUMBER");
				l3=new JLabel("Password");
				l4=new JLabel("Confirm Password");
				tf1=new JTextField();
				tf2=new JTextField();
				ps =new JPasswordField();
				ps1 =new JPasswordField();
				b=new JButton("REGISTER");
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
				b.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						try{
								String name=tf1.getText();
								String Ac=tf2.getText();
								String pass=ps.getText();
								String cpass=ps1.getText();
								if(name.isEmpty()||pass.isEmpty()|| cpass.isEmpty())
								{
									JOptionPane.showMessageDialog(null, "Invalid Username or Password");	
								}
								else if(pass.equals(cpass)){
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
							Statement st=con.createStatement();
							String sql="insert into login  values('"+name+"','"+pass+"','"+Ac+"')";
							int r=st.executeUpdate(sql);
							if(r!=0){
								
								JOptionPane.showMessageDialog(null, "Registered successful");
								 loginform();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Registered unsuccessful");
							}
							con.close();
						}
							
						}catch(Exception e){
							System.out.println(e); }
							}
				});
				l1.setBounds(50,30,400,30);
				l2.setBounds(50,80,200,30);
				l5.setBounds(50,120,200,30);
				l3.setBounds(50,160,200,30);
				tf1.setBounds(180,80,200,30);
				tf2.setBounds(180,120,200,30);
				l4.setBounds(50,200,200,30);
				ps.setBounds(180,160,200,30);
				ps1.setBounds(180,200,200,30);
				b.setBounds(150,270,100,30);
				
				
				Container c=f.getContentPane();
				c.setBackground(Color.LIGHT_GRAY);
				l2.setForeground(Color.BLACK);
				l5.setForeground(Color.BLACK);
				l3.setForeground(Color.BLACK);
				l4.setForeground(Color.BLACK);
				b.setBackground(Color.LIGHT_GRAY);
				
				f.add(l1);
				f.add(l2);
				f.add(l5);
				f.add(tf1);
				f.add(tf2);
				f.add(l3);
				f.add(ps);
				f.add(l4);
				f.add(ps1);
				f.add(b);
				f.add(p);
				f.setSize(400,400);
				f.setLayout(null);
				f.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true);

			}
		
		
	public void bankregister(){
		JFrame f=new JFrame("Account info");
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
		
		int a=0,bal=0;
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		Statement st=con.createStatement();
		String sql="select *from login where name='"+n1+"'";
		ResultSet r=st.executeQuery(sql);
		if(r.next())
		{
			 a=r.getInt("Ac");
			 bal=r.getInt("balance");
		}
		con.close();
		}catch(Exception e){
				System.out.println(e);
			}
		
		 l3=new JLabel();
		 l4=new JLabel();
		 l3.setText(": "+a);
		 l4.setText(": "+bal); 
		 f.getContentPane().setBackground(Color.lightGray);
		 l1=new JLabel("ACCOUNT NUMBER");
		 l2=new JLabel("BALANCE");
		 l1.setForeground(Color.BLACK);
		 l2.setForeground(Color.BLACK);
		 l3.setForeground(Color.BLACK);
		 l4.setForeground(Color.BLACK);
				
		 l1.setFont(new Font("Serif", Font.BOLD,15));
		 l2.setFont(new Font("Serif", Font.BOLD,15));
			
			l1.setBounds(50,30,400,100);
			l2.setBounds(50,60,400,100);
			l3.setBounds(210,30,40,100);
			l4.setBounds(210,60,40,100);
			
			f.add(l1);
			f.add(l2);
			f.add(l3);					
			f.add(l4);
			//f.add(p);
			f.setSize(400,400);
			f.setLayout(null);
			f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true);
	}

	public void mobileinfo(){
		JFrame f=new JFrame("mobile info");
		b=new JButton("UPDATE");
		b.setBounds(150,120,100,20);
		b.setForeground(Color.DARK_GRAY);
		String a=null;
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
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		Statement st=con.createStatement();
		String sql="select *from login where name='"+n1+"'";
		ResultSet r=st.executeQuery(sql);
		if(r.next())
		{
			 a=r.getString("mobile");
		}
		}catch(Exception e){
				System.out.println(e);
			}
		 JLabel mb=new JLabel();
		 mb.setText(": "+a);
		 f.getContentPane().setBackground(Color.lightGray);
		 l1=new JLabel("MOBILE NUMBER");
		 l1.setForeground(Color.BLACK);
		 mb.setForeground(Color.BLACK);
		 l1.setFont(new Font("Serif", Font.BOLD,15));
		 l1.setBounds(50,30,400,100);
			
			mb.setBounds(210,30,100,100);
			
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					String num = null;
					num=JOptionPane.showInputDialog(null,"Enter Phone Number",num);
					if(num.isEmpty()){
						JOptionPane.showMessageDialog(null, "Invalid Phone Number");	
					}
					else
					{
						Connection con;
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
							Statement st=con.createStatement();
							String sql="update login set mobile='"+num+"'where name='"+n1+"'";
							int r=st.executeUpdate(sql);
							if(r!=0)
							{
								JOptionPane.showMessageDialog(null, "Mobile number updated successfully ");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Mobile number updated was unsuccessful");
							}
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						
					}
					
				}
				
			});
			f.add(l1);
			f.add(mb);	
			f.add(b);
		//	f.add(p);
			f.setSize(400,400);
			f.setLayout(null);
			f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true);
}
public void transfer(){
	JFrame f=new JFrame("TRANSFER FORM");
	l2=new JLabel("Name");
	l3=new JLabel("ACCOUNT NUMBER");
	l4=new JLabel("AMOUNT");
	tf1=new JTextField();
	tf2=new JTextField();
	tf3=new JTextField();
	b=new JButton("TRANSFER");
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
	
	b.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			try{
					String name=tf1.getText();
					int Ac=Integer.parseInt(tf2.getText());
					int amt=Integer.parseInt(tf3.getText());
					if(name.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or account or amt");	
					}
					else
					{
						Random ran=new Random();
						int num=ran.nextInt(10000);
						String otp1 = null;
						JOptionPane.showMessageDialog(null,"OTP IS: "+num);
						int otp=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter OTP",otp1));
						if(otp==num)
						{
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
							Statement st=con.createStatement();
							String sql="select *from login where Ac='"+n2+"'";
							ResultSet r=st.executeQuery(sql);
							if(r.next())
							{
								int amt1=r.getInt(4);
								if(amt<=amt1)
								{
									String sql1="update login set balance=balance+'"+amt+"' where Ac='"+Ac+"'";
									int r1=st.executeUpdate(sql1);
									String sql2="update login set balance=balance-'"+amt+"' where Ac='"+n2+"'";
									int r2=st.executeUpdate(sql2);
									if(r1!=0)
									{
										JOptionPane.showMessageDialog(null, "Transfered successful to Ac: "+Ac+" amt: "+amt);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, " unsuccessful Transcation");
								}
								con.close();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid OTP");
						}
				}
			}catch(Exception e){
				System.out.println(e); }
		}
	});
	
	l2.setBounds(50,100,150,30);
	l3.setBounds(50,150,150,30);
	l4.setBounds(50,200,150,30);
	tf1.setBounds(200,100,150,30);
	tf2.setBounds(200,150,150,30);
	tf3.setBounds(200,200,150,30);
	
	b.setBounds(150,270,100,30);
	
	Container c=f.getContentPane();
	c.setBackground(Color.LIGHT_GRAY);
	l2.setForeground(Color.BLACK);
	l3.setForeground(Color.BLACK);
	l4.setForeground(Color.BLACK);
	b.setForeground(Color.DARK_GRAY);
	
	f.add(l2);
	f.add(tf1);
	f.add(tf2);
	f.add(tf3);
	f.add(l3);
	f.add(l4);
	f.add(b);
	//f.add(p);
	f.setSize(400,400);
	f.setLayout(null);
	f.setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	f.setVisible(true);
}
public void Loan(){
	JFrame f=new JFrame("Loan FORM");
	JLabel s1,s2,s3,s4;
	l2=new JLabel("Name");
	l3=new JLabel("ACCOUNT NUMBER");
	l4=new JLabel("Loan AMOUNT");
	l5=new JLabel("Interest");
	s1=new JLabel();
	s2=new JLabel();
	s3=new JLabel();
	s4=new JLabel();
	b=new JButton("PAY");
	String a;
	int l,ac;
	float per;
	try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		Statement st=con.createStatement();
		String sql="select *from login where name='"+n1+"'";
		ResultSet r=st.executeQuery(sql);
		if(r.next())
		{
			 a=r.getString("name");
			 l=r.getInt("loan");
			 ac=r.getInt("Ac");
			 per=r.getFloat("percentage");
			 s1.setText(a);
			 s2.setText(""+l);
			 s3.setText(""+ac);
			 s4.setText(""+per);
		}
		}catch(Exception e){
				System.out.println(e);
			}
	b.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int a,bal = 0,per = 0;
			try{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
				Statement st=con.createStatement();
				String sql="select *from login where name='"+n1+"'";
				ResultSet r=st.executeQuery(sql);
				if(r.next())
				{
					 a=r.getInt("Ac");
					 bal=r.getInt("balance");
					 per=r.getInt("amtpay");
				}
				if(bal>per){
					Random ran=new Random();
					int num=ran.nextInt(10000);
					String otp1 = null;
					JOptionPane.showMessageDialog(null,"OTP IS: "+num);
					int otp=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter OTP",otp1));
					if(otp==num)
					{
					
					try{
						
						Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
						Statement st1=con1.createStatement();
						String sql1="update login set balance=balance-'"+per+"'where name='"+n1+"'";
						int r1=st1.executeUpdate(sql1);
						if(r1!=0)
						{
							
							JOptionPane.showMessageDialog(null, "successful transaction");
						}
						else{
							JOptionPane.showMessageDialog(null, "unsuccessful transaction");
						}
					}catch(Exception e){
						System.out.println(e);
					}
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid otp");
					}
					}
				else{
					JOptionPane.showMessageDialog(null, "No Balance to pay loan");
				}
				
			}catch(Exception e){
				System.out.println(e);
			}
					
		}
		
	});
		
			l2.setBounds(50,50,150,30);
			l3.setBounds(50,100,150,30);
			l4.setBounds(50,150,150,30);
			l5.setBounds(50,200,150,30);
			s1.setBounds(220,50,150,30);
			s3.setBounds(220,100,150,30);
			s2.setBounds(220,150,150,30);
			s4.setBounds(220,200,150,30);
			b.setBounds(100,250,80,30);
			
			l2.setForeground(Color.BLACK);
			l3.setForeground(Color.BLACK);
			l4.setForeground(Color.BLACK);
			b.setForeground(Color.DARK_GRAY);
			l5.setForeground(Color.BLACK);
			s1.setForeground(Color.red);
			s2.setForeground(Color.RED);
			s3.setForeground(Color.red);
			s4.setForeground(Color.red);
			
			f.add(l2);
			f.add(l3);
			f.add(l4);
			f.add(l5);
			f.add(s1);
			f.add(s2);
			f.add(s3);
			f.add(s4);
			f.add(b);
			f.setSize(400,400);
			f.setLayout(null);
			f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true);
}
public static void main(String[] args) throws ClassNotFoundException, SQLException {		
					LR l=new LR();
					l.loginform();
		}
}
