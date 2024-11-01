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

public class BalanceEnquery extends JFrame implements ActionListener {

	JButton btnBack;
	String pinno;
	public BalanceEnquery(String pinno) {
		
		this.pinno=pinno;
		
		setLayout(null);
		//Setting background Image (ATM)
		ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
		Image m2=m1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon m3=new ImageIcon(m2);
		JLabel backGgroundImage=new JLabel(m3);
		backGgroundImage.setBounds(0, 0, 900, 900);
		add(backGgroundImage);
		
		int balance=0;
		
		try {
			Conn con=new Conn();
			
			String q="select *from transaction where Pin_No='"+pinno+"'";
			ResultSet rs=con.s.executeQuery(q);
			while(rs.next()) {
			if(rs.getString("Transaction_Type").equals("Deposite")) {
				
				balance+= Integer.parseInt(rs.getString("Amount"));
			}else {
				balance-= Integer.parseInt(rs.getString("Amount"));

			}
			
		} 
		}catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		JLabel message=new JLabel("Your current Amount is Rs "+ balance);
		message.setBounds(225, 300, 700, 30);
		message.setForeground(Color.WHITE);
		message.setFont(new Font("System",Font.BOLD,16));
		backGgroundImage.add(message);
		
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

		new BalanceEnquery("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnBack) {
			
			setVisible(false);
			new Transaction(pinno).setVisible(true);
			
		}
	}

}
