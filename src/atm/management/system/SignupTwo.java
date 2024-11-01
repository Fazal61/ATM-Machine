package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener{


	JTextField txtaadhar,txtpan;
	JButton btnnext;
	JRadioButton seniorCitizen,notSeniorCitizen,yes,no;
	JComboBox<String> occupation ,religion,category,income,education;
	String formno;
	public SignupTwo(String formno){
		this.formno=formno;
		setLayout(null);

		//Generating Random form Number using random class

		setTitle("New Account Application Form - Page 2");

		JLabel detailstxt=new JLabel("Page 2:Additional Details");
		detailstxt.setFont(new Font("Arial",Font.BOLD,40));
		detailstxt.setBounds(150,40,600,50);
		add(detailstxt);

		JLabel name=new JLabel("Religion:");
		name.setFont(new Font("Arial",Font.BOLD,20));
		name.setBounds(150,130,600,40);
		add(name);

		String[] religionoption = {"Others", "Muslim", "Hindu", "Sikkh","Christian"};
		religion = new JComboBox<>(religionoption);
		religion.setFont(new Font("Arial",Font.BOLD,15));
		religion.setBackground(Color.WHITE);
		religion.setBounds(350, 130, 300, 30);
        add(religion);

		JLabel fname=new JLabel("Category:");
		fname.setFont(new Font("Arial",Font.BOLD,20));
		fname.setBounds(150,180,600,40);
		add(fname);
		
		String[] categoryOption = {"General", "OBC", "SC", "ST","Other"};
		category = new JComboBox<>(categoryOption);
		category.setFont(new Font("Arial",Font.BOLD,15));
		category.setBackground(Color.WHITE);
		category.setBounds(350, 180, 300, 30);
        add(category);

		JLabel Dob=new JLabel("Income:");
		Dob.setFont(new Font("Arial",Font.BOLD,20));
		Dob.setBounds(150,230,600,40);
		add(Dob);

		String[] incomeOption = {"Null","<2,50,000", "<5,00,000", "<7,50,000","Upto 100000"};
		income = new JComboBox<>(incomeOption);
		income.setFont(new Font("Arial",Font.BOLD,15));
		income.setBackground(Color.WHITE);
		income.setBounds(350, 230, 300, 30);
        add(income);

		JLabel gender=new JLabel("Education");
		gender.setFont(new Font("Arial",Font.BOLD,20));
		gender.setBounds(150,300,300,40);
		add(gender);

		String[] eduactionOption = {"10th","12th", "Diploma", "Graduation","Masters"};
		education = new JComboBox<>(eduactionOption);
		education.setFont(new Font("Arial",Font.BOLD,15));
		education.setBackground(Color.WHITE);
		education.setBounds(350,320,300,30);
        add(education);

		JLabel email=new JLabel("Qualification:");
		email.setFont(new Font("Arial",Font.BOLD,20));
		email.setBounds(150,320,600,40);
		add(email);

		JLabel ms=new JLabel("Occupation:");
		ms.setFont(new Font("Arial",Font.BOLD,20));
		ms.setBounds(150,380,600,40);
		add(ms);

		String[] occupationOption = {"Other","Student","Salaried","Self-Employed", "Business", "Retired"};
		occupation = new JComboBox<>(occupationOption);
		occupation.setFont(new Font("Arial",Font.BOLD,15));
		occupation.setBackground(Color.WHITE);
		occupation.setBounds(350, 380, 300, 30);
        add(occupation);

		JLabel address=new JLabel("Pan_No:");
		address.setFont(new Font("Arial",Font.BOLD,20));
		address.setBounds(150,430,600,40);
		add(address);

		txtaadhar=new JTextField();
		txtaadhar.setFont(new Font("Arial",Font.BOLD,15));
		txtaadhar.setBounds(350, 430, 300, 30);
		add(txtaadhar);

		JLabel city=new JLabel("Aadhar_No:");
		city.setFont(new Font("Arial",Font.BOLD,20));
		city.setBounds(150,480,600,40);
		add(city);

		txtpan=new JTextField();
		txtpan.setFont(new Font("Arial",Font.BOLD,15));
		txtpan.setBounds(350, 480, 300, 30);
		add(txtpan);

		JLabel state=new JLabel("Senoir Citizen:");
		state.setFont(new Font("Arial",Font.BOLD,20));
		state.setBounds(150,530,600,40);
		add(state);

		seniorCitizen=new JRadioButton("Yes");
		seniorCitizen.setBounds(350, 530, 100, 30);
		seniorCitizen.setBackground(Color.WHITE);
		seniorCitizen.setFont(new Font("Arial",Font.BOLD,15));
		add(seniorCitizen);

		notSeniorCitizen=new JRadioButton("No");
		notSeniorCitizen.setBounds(500, 530, 100, 30);
		notSeniorCitizen.setBackground(Color.WHITE);
		notSeniorCitizen.setFont(new Font("Arial",Font.BOLD,15));
		add(notSeniorCitizen);
		
		ButtonGroup citizen=new ButtonGroup();
		citizen.add(seniorCitizen);
		citizen.add(notSeniorCitizen);
		
		JLabel pin=new JLabel("Exisiting Account:");
		pin.setFont(new Font("Arial",Font.BOLD,20));
		pin.setBounds(150,580,600,40);
		add(pin);

		yes=new JRadioButton("Yes");
		yes.setBounds(350, 580, 100, 30);
		yes.setBackground(Color.WHITE);
		yes.setFont(new Font("Arial",Font.BOLD,15));
		add(yes);

		no=new JRadioButton("No");
		no.setBounds(500, 580, 100, 30);
		no.setBackground(Color.WHITE);
		no.setFont(new Font("Arial",Font.BOLD,15));
		add(no);

		ButtonGroup exisiting=new ButtonGroup();
		exisiting.add(yes);
		exisiting.add(no);
		
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

		new SignupTwo("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String dif_religion=(String) religion.getSelectedItem();
		String dif_category=(String) category.getSelectedItem();
		String dif_income=(String) income.getSelectedItem();
		String dif_education=(String) education.getSelectedItem();
		String dif_occupation=(String) occupation.getSelectedItem();
		String pan_no=txtpan.getText();
		String aadhar_no=txtaadhar.getText();
		//String issenior=seniorCitizen.isSelected() ? "Yes":"No";
		String existing_account=yes.isSelected() ? "Yes":"No";
		String issenior=null;
		if(seniorCitizen.isSelected()) {
			issenior="Yes";
		}else if(notSeniorCitizen.isSelected()){
			issenior="No";
		}
		
		
		/*Add Validation later
		if(dif_religion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Select Religion");
		}else if(dif_category.equals("")) {
			JOptionPane.showMessageDialog(this, "Select Category ");
		}else if(dif_income.equals("")) {
			JOptionPane.showMessageDialog(this, "Select Income");
		}else if(dif_education=="") {
			JOptionPane.showMessageDialog(this, "Select Education");
		}else if(dif_occupation.equals("")) {
			JOptionPane.showMessageDialog(this, "Select Occupation");
		}else if(pan_no=="") {
			JOptionPane.showMessageDialog(this, "Enter Pan_No");
		}else if(aadhar_no.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter Aadhar_no");
		}else if(seniorCitizen.equals("")) {
			JOptionPane.showMessageDialog(this, "Select Senior or Not");
		}else if(existing_account.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Select Existing Account or not");
		}else{}
		*/
			try {
				Conn con=new Conn();
				String q="insert into signuptwo values('"+formno+"','"+dif_religion+"','"+dif_category+"','"+dif_education+"','"+dif_occupation+"','"+dif_income+"','"+pan_no+"','"+aadhar_no+"','"+issenior+"','"+existing_account+"')";
				con.s.executeUpdate(q);

				setVisible(false);
				new SignupThree(formno).setVisible(true);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}

}
