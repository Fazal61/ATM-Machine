package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposite extends JFrame implements ActionListener{

	JTextField txtamount;
	JButton btnDeposite,btnBack;
	String pinno;	
	public Deposite(String pinno) {
		
		this.pinno=pinno;
		
		setLayout(null);
	
	ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image m2=m1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	ImageIcon m3=new ImageIcon(m2);
	JLabel backGgroundImage=new JLabel(m3);
	backGgroundImage.setBounds(0, 0, 900, 900);
	add(backGgroundImage);
	
	
	JLabel message=new JLabel("Enter the amount you want to deposite");
	message.setBounds(190, 300, 700, 30);
	message.setForeground(Color.WHITE);
	message.setFont(new Font("System",Font.BOLD,16));
	backGgroundImage.add(message);
	
	
	txtamount=new JTextField();
	txtamount.setBounds(190, 350, 300, 30);
	txtamount.setFont(new Font("System",Font.BOLD,16));
	backGgroundImage.add(txtamount);
	
	btnDeposite=new JButton("Deposite");
	btnDeposite.setBounds(350, 485, 150, 30);
	btnDeposite.addActionListener(this);
	backGgroundImage.add(btnDeposite);
	
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

		new Deposite("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnBack) {
			
			setVisible(false);
			new Transaction(pinno).setVisible(true);
			
		}else if(e.getSource()==btnDeposite) {
			
			String amount=txtamount.getText();
			Date date =new Date();
			
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(this, "Enter some amount to Deposite");
			}else {
				try {
					Conn con=new Conn();
					String q="insert into  transaction values('"+pinno+"','"+date+"','Deposite','"+amount+"')";
					
					con.s.executeUpdate(q);
					
					JOptionPane.showMessageDialog(this,"Rs:"+amount+" Deposited Successfully");
					setVisible(false);
					new Transaction(pinno).setVisible(true);
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		}
	}

}
