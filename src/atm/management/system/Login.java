package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{


	JLabel CardNo,Pin;
	JTextField cardtxt;
	JPasswordField pintxt;
	JButton btnsignup,btnlogin,btnclear;

	public Login() {

		setLayout(null);
		//Setting Background image
		ImageIcon  b1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image	   b2=b1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon  b3=new ImageIcon(b2);
		JLabel blabel=new JLabel(b3);
		blabel.setBounds(150,10,100,100);
		add(blabel);

		JLabel label=new JLabel("Welcome to ATM 💰");
		label.setBounds(300,45,600,40);
		label.setFont(new Font("aerial", Font.BOLD, 40));
		add(label);

		JLabel CardNo=new JLabel("Card No:");
		CardNo.setBounds(100,150,200,40);
		CardNo.setFont(new Font("aerial", Font.BOLD, 35));
		add(CardNo);

		JLabel Pin=new JLabel("Pin:");
		Pin.setBounds(100,230,200,40);
		Pin.setFont(new Font("aerial", Font.BOLD, 35));
		add(Pin);

		cardtxt=new JTextField();
		cardtxt.setBounds(300,150,300,40);
		cardtxt.setFont(new Font("Arial", Font.BOLD, 30));
		add(cardtxt);

		pintxt=new JPasswordField();
		pintxt.setBounds(300,230,300,40);
		pintxt.setFont(new Font("Arial", Font.BOLD, 30));

		add(pintxt);

		//Making Buttons
		btnsignup=new JButton("Sign Up");
		btnsignup.setBounds(300,350,300,40);
		btnsignup.setBackground(Color.black);
		btnsignup.setForeground(Color.WHITE);
		add(btnsignup);

		btnclear=new JButton("Clear");
		btnclear.setBounds(470,300,130,40);
		btnclear.setBackground(Color.black);
		btnclear.setForeground(Color.WHITE);
		add(btnclear);

		btnlogin=new JButton("Login");
		btnlogin.setBounds(300,300,130,40);
		btnlogin.setBackground(Color.black);
		btnlogin.setForeground(Color.WHITE);
		add(btnlogin);


		//Adding functionality to buttons
		btnlogin.addActionListener(this);
		btnsignup.addActionListener(this);
		btnclear.addActionListener(this);


		setTitle("Automated Teller Machine");
		setSize(800, 500);
		setVisible(true);
		setLocation(350, 200);

		//Setting background color
		getContentPane().setBackground(Color.WHITE);
	}
	public static void main(String[] args) {

		new Login();

	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnclear) {

			cardtxt.setText("");
			pintxt.setText("");

		}else if(e.getSource()==btnlogin) {

			String cardno=cardtxt.getText();
			String pinno=pintxt.getText();
			
			try {
				Conn con=new Conn();
				String q="select *from login where Card_No='"+cardno+"' and Pin_No='"+pinno+"'";
				
				ResultSet rs=con.s.executeQuery(q);
				if(rs.next()) {
				
					setVisible(false);
					new Transaction(pinno).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(this, "Incorrect Card_No or Pin");
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}else if(e.getSource()==btnsignup) {

			setVisible(false);
			new SignupOne().setVisible(true);
		}

	}

}
