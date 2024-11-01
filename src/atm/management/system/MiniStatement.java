package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class MiniStatement extends JFrame{

	String pinno;
	int bal=0;
	public MiniStatement(String pinno) {
		 
		this.pinno=pinno;
		setLayout(null);
		
		JLabel BankName=new JLabel("MY Bank");
		BankName.setFont(new Font("System",Font.BOLD,16));
		BankName.setBounds(160,20,100,30);
		add(BankName);
		
		JLabel cardno=new JLabel("Card No:");
		cardno.setBounds(20, 100, 250, 30);
		cardno.setFont(new Font("System",Font.BOLD,16));
		add(cardno);
		
	
		try {
			Conn con=new Conn();
			
			String q="select *from login where Pin_No='1234'";
			ResultSet rs=con.s.executeQuery(q);
			
			while(rs.next()) {
				cardno.setText("Card No:"+ rs.getString("Card_No").substring(0, 4)
							   +"XXXXXXXX"+rs.getString("Card_No").substring(12));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel statement=new JLabel();
		statement.setBounds(20, 150, 600, 300);
		statement.setFont(new Font("System",Font.BOLD,16));
		add(statement);
	
		try {
			Conn con=new Conn();
			
			String q2="select *from transaction where Pin_No='"+pinno+"'";
			ResultSet rs=con.s.executeQuery(q2);
			while(rs.next()) {
				if(rs.getString("Transaction_Type").equals("Deposite")) {
				bal += Integer.parseInt(rs.getString("Amount"));
			}else {
				bal -= Integer.parseInt(rs.getString("Amount"));
				}	
			
				statement.setText(statement.getText()+"<html>"+rs.getString("Date")+
							  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							  +rs.getString("Amount")
							  +"<br><br><html>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		JLabel balance=new JLabel("Your current balance is Rs:"+bal);
		balance.setBounds(20, 450, 250, 30);
		balance.setFont(new Font("System",Font.BOLD,16));
		add(balance);
		
		getContentPane().setBackground(Color.WHITE);
		setLocation(20,40);
		setSize(400,600);
		setVisible(true);

	}

	public static void main(String[] args) {

		new MiniStatement("");
	}

}
