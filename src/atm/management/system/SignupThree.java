package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener{

	JRadioButton btnSaving,btnFixed,btncurrent,btnRecurring;
	ButtonGroup acc_group;
	JCheckBox Atm,Internet,Mobile,Email,Cheque,Statement,Decalration;
	JButton btnSubmit,btncancel;
	String formno;

	public SignupThree(String formno) {
		this.formno=formno;
		setLayout(null);
		
		JLabel label=new JLabel("Page 3:Account Details");
		label.setFont(new Font("Arial",Font.BOLD,22));
		label.setBounds(280,40,400,40);
		add(label);
		
		JLabel account=new JLabel("Account Type:");
		account.setFont(new Font("Arial",Font.BOLD,22));
		account.setBounds(100,140,200,30);
		add(account);
		
		btnSaving=new JRadioButton("Saving");
		btnSaving.setBackground(Color.white);
		btnSaving.setFont(new Font("Arial",Font.BOLD,18));
		btnSaving.setBounds(100, 180, 150, 20);
		add(btnSaving);
		
		btncurrent=new JRadioButton("Current");
		btncurrent.setBackground(Color.white);
		btncurrent.setFont(new Font("Arial",Font.BOLD,18));
		btncurrent.setBounds(350, 180, 150, 20);
		add(btncurrent);
		
		btnFixed=new JRadioButton("Fixed Deposite");
		btnFixed.setBackground(Color.white);
		btnFixed.setFont(new Font("Arial",Font.BOLD,18));
		btnFixed.setBounds(100, 220, 200, 20);
		add(btnFixed);
		
		btnRecurring=new JRadioButton("Recurring");
		btnRecurring.setBackground(Color.white);
		btnRecurring.setFont(new Font("Arial",Font.BOLD,18));
		btnRecurring.setBounds(350, 220, 150, 20);
		add(btnRecurring);
		
		acc_group=new ButtonGroup();
		acc_group.add(btncurrent);
		acc_group.add(btnFixed);
		acc_group.add(btnRecurring);
		acc_group.add(btnSaving);
		
		JLabel cardNo=new JLabel("Card Nnumber:");
		cardNo.setFont(new Font("Arial",Font.BOLD,22));
		cardNo.setBounds(100,300,200,30);
		add(cardNo);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-1234");
		number.setFont(new Font("Arial",Font.BOLD,22));
		number.setBounds(350,300,290,30);
		add(number);
		
		JLabel card_info=new JLabel("Your 16 digit Card No");
		card_info.setFont(new Font("Arial",Font.BOLD,14));
		card_info.setBounds(100,320,290,30);
		add(card_info);
		
		JLabel pin=new JLabel("Pin:");
		pin.setFont(new Font("Arial",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pin_info=new JLabel("Your 4 digit Password");
		pin_info.setFont(new Font("Arial",Font.BOLD,14));
		pin_info.setBounds(100,390,290,30);
		add(pin_info);
		
		JLabel pno=new JLabel("XXXX");
		pno.setFont(new Font("Arial",Font.BOLD,22));
		pno.setBounds(350,370,290,30);
		add(pno);
		
		JLabel Services=new JLabel("Services:");
		Services.setFont(new Font("Arial",Font.BOLD,22));
		Services.setBounds(100,450,200,30);
		add(Services);
		
		Atm=new JCheckBox("ATM CARD");	
		Atm.setBackground(Color.white);
		Atm.setFont(new Font("Arial",Font.BOLD,18));
		Atm.setBounds(100, 500, 200, 30);
		add(Atm);
		
		Internet=new JCheckBox("Internet Banking");	
		Internet.setBackground(Color.white);
		Internet.setFont(new Font("Arial",Font.BOLD,18));
		Internet.setBounds(350, 500, 200, 30);
		add(Internet);
		
		Mobile=new JCheckBox("Mobile Banking");	
		Mobile.setBackground(Color.white);
		Mobile.setFont(new Font("Arial",Font.BOLD,18));
		Mobile.setBounds(100, 550, 200, 30);
		add(Mobile);
		
		Cheque=new JCheckBox("Cheque Book");	
		Cheque.setBackground(Color.white);
		Cheque.setFont(new Font("Arial",Font.BOLD,18));
		Cheque.setBounds(100, 600, 200, 30);
		add(Cheque);
		
		Statement=new JCheckBox("E-Statement");	
		Statement.setBackground(Color.white);
		Statement.setFont(new Font("Arial",Font.BOLD,18));
		Statement.setBounds(350, 550, 200, 30);
		add(Statement);
		
		Decalration=new JCheckBox("I here by declare all above information provided by me is best of my knowledge.");	
		Decalration.setBackground(Color.white);
		Decalration.setFont(new Font("Arial",Font.BOLD,14));
		Decalration.setBounds(100, 650, 600, 30);
		add(Decalration);
		
		btnSubmit=new JButton("Submit");
		btnSubmit.setBounds(200,720 ,100 ,40);
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		add(btnSubmit);
		
		btncancel=new JButton("Cancel");
		btncancel.setBounds(450,720 ,100 ,40);
		btncancel.setBackground(Color.BLACK);
		btncancel.setForeground(Color.WHITE);
		add(btncancel);
		
		btnSubmit.addActionListener(this);
		btncancel.addActionListener(this);
		
		setSize(800, 820);
		setVisible(true);
		setLocation(350, 10);
		getContentPane().setBackground(Color.WHITE);
	}
	
	
	public static void main(String[] args) {

		new SignupThree("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		JRadioButton btnSaving,btnFixed,btncurrent,btnRecurring;
		ButtonGroup acc_group;
		JCheckBox Atm,Internet,Mobile,Email,Cheque,Statement,Decalration;
		JButton btnnext,btncancel;
		*/
		String acc_Type=null;
		
		if(btnSaving.isSelected()) {
			acc_Type="Saving Account";
		}else if(btnFixed.isSelected()) {
			acc_Type="Fixed Deposite";
		}else if(btncurrent.isSelected()) {
			acc_Type="Current Account";
		}else if(btnRecurring.isSelected()) {
			acc_Type="Recurring Account";
		}
		
		Random ran=new Random();
		String cardno= "" + Math.abs((ran.nextLong() % 90000000L) + 5098276000000000L);
		String pinno= "" + Math.abs((ran.nextInt() % 9000) + 1000);
		
		String Facility="";
		if(Atm.isSelected()) {
			Facility=Facility + "ATM Card";
		}else if(Internet.isSelected()) {
			Facility=Facility + "Internet Banking";
		}else if(Mobile.isSelected()) {
			Facility=Facility + "Mobile Banking";
		}else if(Email.isSelected()) {
			Facility=Facility + "Email Alert";
		}else if(Cheque.isSelected()) {
			Facility=Facility + "Cheque Book";
		}else if(Statement.isSelected()) {
			Facility=Facility + "E-Statement";
		}
		
		
		if(e.getSource()==btnSubmit) {
			
			try {
				Conn con=new Conn();
				String q1="insert into signupthree values('"+formno+"','"+acc_Type+"','"+cardno+"','"+pinno+"','"+Facility+"')";
				String q2="insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";

				con.s.executeUpdate(q1);
				con.s.executeUpdate(q2);
				
				JOptionPane.showMessageDialog(this, "Card Number:" + cardno + "\nPin:" + pinno);
				
				setVisible(false);
				new Deposite(pinno).setVisible(true);;
				
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			
		}else if(e.getSource()==btncancel){
			
			setVisible(false);
			new Login().setVisible(true);
		}
	}

}
