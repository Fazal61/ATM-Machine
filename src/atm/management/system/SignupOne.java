package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{

	int formno;
	JTextField txtname,txtfname,txtemail,txtadd,txtcity,txtstate,txtpin;
	JButton btnnext;
	JRadioButton male,female,marrid,unmarrid;
	JDateChooser jdate;


	public SignupOne(){
		setLayout(null);

		//Generating Random form Number using random class
		Random ran=new Random();
		formno=Math.abs((ran.nextInt() %9000)+ 1000);
		JLabel formtxt=new JLabel("Application No :"+ formno);
		formtxt.setFont(new Font("Arial",Font.BOLD,40));
		formtxt.setBounds(225, 20, 600, 40);
		add(formtxt);

		JLabel detailstxt=new JLabel("Page 1:Personal Details");
		detailstxt.setFont(new Font("Arial",Font.BOLD,20));
		detailstxt.setBounds(300,80,600,40);
		add(detailstxt);

		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Arial",Font.BOLD,20));
		name.setBounds(150,130,600,40);
		add(name);

		txtname=new JTextField();
		txtname.setFont(new Font("Arial",Font.BOLD,15));
		txtname.setBounds(350, 130, 300, 30);
		add(txtname);

		JLabel fname=new JLabel("Fathers's Name:");
		fname.setFont(new Font("Arial",Font.BOLD,20));
		fname.setBounds(150,180,600,40);
		add(fname);

		txtfname=new JTextField();
		txtfname.setFont(new Font("Arial",Font.BOLD,15));
		txtfname.setBounds(350, 180, 300, 30);
		add(txtfname);

		JLabel Dob=new JLabel("Date Of Birth:");
		Dob.setFont(new Font("Arial",Font.BOLD,20));
		Dob.setBounds(150,230,600,40);
		add(Dob);

		jdate=new JDateChooser();
		jdate.setBounds(350, 230, 300, 30);
		jdate.setFont(new Font("Arial",Font.BOLD,15));
		add(jdate);

		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Arial",Font.BOLD,20));
		gender.setBounds(150,280,600,40);
		add(gender);

		male=new JRadioButton("Male");
		male.setBounds(350,280,120,20);
		male.setBackground(Color.WHITE);
		add(male);

		female=new JRadioButton("Female");
		female.setBounds(500,280,120,20);
		female.setBackground(Color.WHITE);
		add(female);

		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);

		JLabel email=new JLabel("Email Address:");
		email.setFont(new Font("Arial",Font.BOLD,20));
		email.setBounds(150,330,600,40);
		add(email);

		txtemail=new JTextField();
		txtemail.setFont(new Font("Arial",Font.BOLD,15));
		txtemail.setBounds(350, 330, 300, 30);
		add(txtemail);

		JLabel ms=new JLabel("Marital Status:");
		ms.setFont(new Font("Arial",Font.BOLD,20));
		ms.setBounds(150,380,600,40);
		add(ms);

		marrid=new JRadioButton("Marrid");
		marrid.setBounds(350, 380, 100, 30);
		marrid.setBackground(Color.WHITE);
		add(marrid);

		unmarrid=new JRadioButton("Single");
		unmarrid.setBounds(500, 380, 100, 30);
		unmarrid.setBackground(Color.WHITE);
		add(unmarrid);

		ButtonGroup maridStatus=new ButtonGroup();
		maridStatus.add(marrid);
		maridStatus.add(unmarrid);

		JLabel address=new JLabel("Address:");
		address.setFont(new Font("Arial",Font.BOLD,20));
		address.setBounds(150,430,600,40);
		add(address);

		txtadd=new JTextField();
		txtadd.setFont(new Font("Arial",Font.BOLD,15));
		txtadd.setBounds(350, 430, 300, 30);
		add(txtadd);

		JLabel city=new JLabel("City:");
		city.setFont(new Font("Arial",Font.BOLD,20));
		city.setBounds(150,480,600,40);
		add(city);

		txtcity=new JTextField();
		txtcity.setFont(new Font("Arial",Font.BOLD,15));
		txtcity.setBounds(350, 480, 300, 30);
		add(txtcity);

		JLabel state=new JLabel("State:");
		state.setFont(new Font("Arial",Font.BOLD,20));
		state.setBounds(150,530,600,40);
		add(state);

		txtstate=new JTextField();
		txtstate.setFont(new Font("Arial",Font.BOLD,15));
		txtstate.setBounds(350, 530, 300, 30);
		add(txtstate);

		JLabel pin=new JLabel("Pin Code:");
		pin.setFont(new Font("Arial",Font.BOLD,20));
		pin.setBounds(150,580,600,40);
		add(pin);

		txtpin=new JTextField();
		txtpin.setFont(new Font("Arial",Font.BOLD,15));
		txtpin.setBounds(350, 580, 300, 30);
		add(txtpin);


		btnnext=new JButton("Next");
		btnnext.setBackground(Color.black);
		btnnext.setForeground(Color.white);
		btnnext.setBounds(550, 650, 100, 40);
		add(btnnext);

		btnnext.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);
		setLocation(350, 10);
		setSize(800,800);
		setVisible(true);

	}


	public static void main(String[] args) {

		new SignupOne();
	}


	@Override
	public void actionPerformed(ActionEvent e) {


		String form= ""+ formno;
		String name=txtname.getText();
		String fname=txtfname.getText();
		String dob=((JTextField)jdate.getDateEditor().getUiComponent()).getText();
		String gender=null;

		if(male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}

		String email=txtemail.getText();
		String ismarrid=null;

		if(marrid.isSelected()) {
			ismarrid="Marrid";
		}else if(unmarrid.isSelected()) {
			ismarrid="Single";
		}

		String address=txtadd.getText();
		String city=txtcity.getText();
		String state=txtstate.getText();
		String pincode=txtpin.getText();

		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "Name Field Required");
		}else if(fname.equals("")) {
			JOptionPane.showMessageDialog(this, "Father's Name Field Required");
		}else if(dob.equals("")) {
			JOptionPane.showMessageDialog(this, "Date_Of_Birth Field Required");
		}else if(gender.equals("")) {
			JOptionPane.showMessageDialog(this, "Gender Field Required");
		}else if(email.equals("")) {
			JOptionPane.showMessageDialog(this, "Email Field Required");
		}else if(ismarrid.equals("")) {
			JOptionPane.showMessageDialog(this, "Marital_Status Field Required");
		}else if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "Address Field Required");
		}else if(city.equals("")) {
			JOptionPane.showMessageDialog(this, "City Field Required");
		}else if(state.equals("")) {
			JOptionPane.showMessageDialog(this, "State Field Required");
		}else if(pincode.equals("")) {
			JOptionPane.showMessageDialog(this, "Pin_Code Field Required");
		}else{
			try {
				Conn con=new Conn();
				String q="insert into signup values('"+form+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+ismarrid+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				con.s.executeUpdate(q);
				
				setVisible(false);
				new SignupTwo(form).setVisible(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	}

}
