package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChangePin extends JFrame implements ActionListener{

	JTextField txtNewPin,txtRNewPin;
	JButton btnChangePin,btnBack;
	String pinno;	
	public ChangePin(String pinno) {
		
		this.pinno=pinno;
		
		setLayout(null);
	
	ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image m2=m1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	ImageIcon m3=new ImageIcon(m2);
	JLabel backGgroundImage=new JLabel(m3);
	backGgroundImage.setBounds(0, 0, 900, 900);
	add(backGgroundImage);
	
	
	JLabel message=new JLabel("Update Pin Number");
	message.setBounds(250, 280, 700, 30);
	message.setForeground(Color.WHITE);
	message.setFont(new Font("System",Font.BOLD,20));
	backGgroundImage.add(message);
	
	
	txtNewPin=new JTextField();
	txtNewPin.setBounds(350, 325, 150, 30);
	txtNewPin.setFont(new Font("System",Font.BOLD,16));
	backGgroundImage.add(txtNewPin);
	
	txtRNewPin=new JTextField();
	txtRNewPin.setBounds(350, 370, 150, 30);
	txtRNewPin.setFont(new Font("System",Font.BOLD,16));
	backGgroundImage.add(txtRNewPin);
	
	
	JLabel ChangePin=new JLabel("Enter new Pin:");
	ChangePin.setBounds(190, 325, 150, 30);
	ChangePin.setFont(new Font("Arial",Font.BOLD,16));
	ChangePin.setForeground(Color.WHITE);
	backGgroundImage.add(ChangePin);
	
	JLabel ConfirmPin=new JLabel("Confirm new Pin:");
	ConfirmPin.setBounds(190, 370, 150, 30);
	ConfirmPin.setFont(new Font("Arial",Font.BOLD,16));
	ConfirmPin.setForeground(Color.WHITE);
	backGgroundImage.add(ConfirmPin);
	
	btnChangePin=new JButton("Change Pin");
	btnChangePin.setBounds(350, 485, 150, 30);
	btnChangePin.addActionListener(this);
	backGgroundImage.add(btnChangePin);
	
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

		new ChangePin("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnBack) {
			
			setVisible(false);
			new Transaction(pinno).setVisible(true);
			
		}else if(e.getSource()==btnChangePin) {
			
			String newPin=txtNewPin.getText();
			String ConfirmPin=txtRNewPin.getText();
			
			if(newPin.equals("")) {
				JOptionPane.showMessageDialog(this, "Enter new Pin ");
			}else if(ConfirmPin.equals("")) {
				JOptionPane.showMessageDialog(this, "Enter Confirm Pin ");

			}else if(!newPin.equals(ConfirmPin)) {
				JOptionPane.showMessageDialog(this, "Confirm Pin doesn't match Enetered Pin");
			}else {
				
				try {
					
					Conn con=new Conn();
					
					String q1="update login set Pin_No='"+ConfirmPin+"' where Pin_No='"+pinno+"'";
					String q2="update signupthree set Pin_No='"+ConfirmPin+"' where Pin_No='"+pinno+"'";
					String q3="update transaction set Pin_No='"+ConfirmPin+"' where Pin_No='"+pinno+"'";

					con.s.executeUpdate(q1);
					con.s.executeUpdate(q2);
					con.s.executeUpdate(q3);
					
					JOptionPane.showMessageDialog(this, "Pin Updated Successfully");
					
					setVisible(false);
					new Transaction(pinno).setVisible(true);
					
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				
				
			}

		}
		
	}

}
