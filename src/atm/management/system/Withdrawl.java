package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener{

	JTextField txtamount;
	JButton btnWithdraw,btnBack;
	String pinno;	
	public Withdrawl(String pinno) {
		
		this.pinno=pinno;
		
		setLayout(null);
	
	ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image m2=m1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	ImageIcon m3=new ImageIcon(m2);
	JLabel backGgroundImage=new JLabel(m3);
	backGgroundImage.setBounds(0, 0, 900, 900);
	add(backGgroundImage);
	
	
	JLabel message=new JLabel("Enter the amount you want to Withdrawl");
	message.setBounds(190, 300, 700, 30);
	message.setForeground(Color.WHITE);
	message.setFont(new Font("System",Font.BOLD,16));
	backGgroundImage.add(message);
	
	
	txtamount=new JTextField();
	txtamount.setBounds(190, 350, 300, 30);
	txtamount.setFont(new Font("System",Font.BOLD,16));
	backGgroundImage.add(txtamount);
	
	btnWithdraw=new JButton("Withdraw");
	btnWithdraw.setBounds(350, 485, 150, 30);
	btnWithdraw.addActionListener(this);
	backGgroundImage.add(btnWithdraw);
	
	btnBack=new JButton("Back");
	btnBack.setBounds(350, 520, 150, 30);
	btnBack.addActionListener(this);
	backGgroundImage.add(btnBack);
	
	setLocation(300,0);
	setSize(900,900);
	setUndecorated(true);
	setVisible(true);
	
	}
	
	
	public static void main(String[] args) {

		new Withdrawl("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnBack) {
			
			setVisible(false);
			new Transaction(pinno).setVisible(true);
			
		}else if(e.getSource()==btnWithdraw) {
			
			String amount=txtamount.getText();
			Date date =new Date();
			
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(this, "Enter some amount to Withdrawl");
			}else {
				
				int balance=0;
				try {
					Conn con=new Conn();
					String q="select *from transaction where Pin_No='"+pinno+"'";
					
					ResultSet rs=con.s.executeQuery(q);
					while(rs.next()) {
						if(rs.getString("Transaction_Type").equals("Deposite")) {
							balance +=Integer.parseInt(rs.getString("Amount"));
						}else {
							balance -=Integer.parseInt(rs.getString("Amount"));
						}
					}
					
					if( balance < Integer.parseInt(amount) ) {
						
						JOptionPane.showMessageDialog(this, "Insufficiant Balance");
						
					}else {
						
						con.s.executeUpdate("insert into Transaction values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')");
						JOptionPane.showMessageDialog(this, "Rs "+amount+" Withdrawl Successfully");
						setVisible(false);		
						new Transaction(pinno).setVisible(true);
					
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
		
			}
		
			/*
			try {
				Conn con=new Conn();
				String q="insert into  transaction values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
				
				con.s.executeUpdate(q);
				
				JOptionPane.showMessageDialog(this,"Rs:"+amount+" Withdrawl Successfully");
				setVisible(false);
				new Transaction(pinno).setVisible(true);
				
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			*/
		}
	}

}
