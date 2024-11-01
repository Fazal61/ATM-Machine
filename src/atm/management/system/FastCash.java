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

public class FastCash extends JFrame implements ActionListener {

	JButton btn100,btn200,btn500,btn1000,btn2000,btn10000,
			btnPinChange,btnBalanceEnquery,btnBack;
	String pinno;
	public FastCash(String pinno) {
		
		this.pinno=pinno;
		
		setLayout(null);
		//Setting background Image (ATM)
		ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
		Image m2=m1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon m3=new ImageIcon(m2);
		JLabel backGgroundImage=new JLabel(m3);
		backGgroundImage.setBounds(0, 0, 900, 900);
		add(backGgroundImage);
			
		JLabel message=new JLabel("Select Withdrawl amount");
		message.setBounds(225, 300, 700, 30);
		message.setForeground(Color.WHITE);
		message.setFont(new Font("System",Font.BOLD,16));
		backGgroundImage.add(message);
		
		
		btn100=new JButton("Rs 100");
		btn100.setBounds(170, 415, 150, 30);
		btn100.addActionListener(this);
		backGgroundImage.add(btn100);
		
		btn200=new JButton("Rs 200");
		btn200.setBounds(350, 415, 150, 30);
		btn200.addActionListener(this);
		backGgroundImage.add(btn200);
		
		btn500=new JButton("Rs 500");
		btn500.setBounds(170, 450, 150, 30);
		btn500.addActionListener(this);
		backGgroundImage.add(btn500);
		
		btn1000=new JButton("Rs 1000");
		btn1000.setBounds(350, 450, 150, 30);
		btn1000.addActionListener(this);
		backGgroundImage.add(btn1000);
		
		btn2000=new JButton("Rs 2000");
		btn2000.setBounds(170, 485, 150, 30);
		btn2000.addActionListener(this);
		backGgroundImage.add(btn2000);
		
		btn10000=new JButton("Rs 10000");
		btn10000.setBounds(350, 485, 150, 30);
		btn10000.addActionListener(this);
		backGgroundImage.add(btn10000);
		
		btnBack=new JButton("Back");
		btnBack.setBounds(350, 520, 150, 30);
		btnBack.addActionListener(this);
		backGgroundImage.add(btnBack);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new FastCash("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==btnBack) {
			
			setVisible(false);
			new Transaction(pinno).setVisible(true);
			
		}else{
			
			String amount=((JButton)e.getSource()).getText().substring(3); 
			try {
				Conn con=new Conn();
				
				
				ResultSet rs= con.s.executeQuery("select * from transaction where Pin_No='"+pinno+"'");
				
				int balance=0;
				
				while(rs.next()) {
					if(rs.getString("Transaction_Type").equals("Deposite")) {
						
						balance += Integer.parseInt(rs.getString("Amount"));	
					}else {
						balance -= Integer.parseInt(rs.getString("Amount"));
					}
				}
					
				if(balance < Integer.parseInt(amount)) {
					
					JOptionPane.showMessageDialog(this, "Insufficient Balance");
					return;
					
				}else{
				
				Date date=new Date();
				String q2="insert into transaction values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
				con.s.executeUpdate(q2);
				
				JOptionPane.showMessageDialog(this, "Rs "+amount+" Debited Successfully");
				
				setVisible(false);
				new Transaction(pinno).setVisible(true);
				}
			
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		}
	}

}
