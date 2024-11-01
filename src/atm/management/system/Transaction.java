package atm.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {

	JButton btnDeposite,btnWithDrawl,btnFastCash,btnMiniStatement,
			btnPinChange,btnBalanceEnquery,btnExit;
	String pinno;
	public Transaction(String pinno) {
		
		this.pinno=pinno;
		
		setLayout(null);
		//Setting background Image (ATM)
		ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
		Image m2=m1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon m3=new ImageIcon(m2);
		JLabel backGgroundImage=new JLabel(m3);
		backGgroundImage.setBounds(0, 0, 900, 900);
		add(backGgroundImage);
			
		JLabel message=new JLabel("Please select your transaction");
		message.setBounds(225, 300, 700, 30);
		message.setForeground(Color.WHITE);
		message.setFont(new Font("System",Font.BOLD,16));
		backGgroundImage.add(message);
		
		
		btnDeposite=new JButton("Deposite");
		btnDeposite.setBounds(170, 415, 150, 30);
		btnDeposite.addActionListener(this);
		backGgroundImage.add(btnDeposite);
		
		btnWithDrawl=new JButton("WithDrawl");
		btnWithDrawl.setBounds(350, 415, 150, 30);
		btnWithDrawl.addActionListener(this);
		backGgroundImage.add(btnWithDrawl);
		
		btnFastCash=new JButton("Fast Cash");
		btnFastCash.setBounds(170, 450, 150, 30);
		btnFastCash.addActionListener(this);
		backGgroundImage.add(btnFastCash);
		
		btnMiniStatement=new JButton("Mini Statement");
		btnMiniStatement.setBounds(350, 450, 150, 30);
		btnMiniStatement.addActionListener(this);
		backGgroundImage.add(btnMiniStatement);
		
		btnPinChange=new JButton("Pin Change");
		btnPinChange.setBounds(170, 485, 150, 30);
		btnPinChange.addActionListener(this);
		backGgroundImage.add(btnPinChange);
		
		btnBalanceEnquery=new JButton("Balance Enquery");
		btnBalanceEnquery.setBounds(350, 485, 150, 30);
		btnBalanceEnquery.addActionListener(this);
		backGgroundImage.add(btnBalanceEnquery);
		
		btnExit=new JButton("Exit");
		btnExit.setBounds(350, 520, 150, 30);
		btnExit.addActionListener(this);
		backGgroundImage.add(btnExit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new Transaction("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnExit) {
			System.exit(0);
		}else if(e.getSource()==btnDeposite) {
			setVisible(false);
			new Deposite(pinno).setVisible(true);
		}else if(e.getSource()== btnWithDrawl) {
			setVisible(false);
			new Withdrawl(pinno).setVisible(true);
		}else if(e.getSource()==btnFastCash) {
			setVisible(false);
			new FastCash(pinno).setVisible(true);
		}else if(e.getSource()==btnPinChange) {
			setVisible(false);
			new ChangePin(pinno).setVisible(true);
		}else if(e.getSource()==btnBalanceEnquery) {
			setVisible(false);
			new BalanceEnquery(pinno).setVisible(true);
		}else if(e.getSource()==btnMiniStatement){
			new MiniStatement(pinno).setVisible(true);
		}
	}

}
