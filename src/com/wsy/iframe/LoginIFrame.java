package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import  javax.swing.UIManager;
//import  javax.swing.plaf.synth.SynthUI;
import javax.swing.*;   

import java.awt.*;  
import java.net.URL;

import com.wsy.FireFighting;
import com.wsy.dao.Dao;
import com.wsy.model.Operater;
import com.wsy.util.CreatecdIcon;
import com.wsy.util.MyDocument;

public class LoginIFrame extends JFrame {

	private class BookResetAction implements ActionListener {
		public void actionPerformed(final ActionEvent e){
			username.setText("");
			password.setText("");
			
		}
	}
	class BookLoginAction implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			user = Dao.check(username.getText(), password.getText());
			if (user.getName() != null) {

				try {

					FireFighting frame = new FireFighting();
					frame.setVisible(true);
					LoginIFrame.this.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "ֻ�й���Ա�ſ��Ե�¼��");
				username.setText("");
				password.setText("");
			}
		}
	}
	private JPasswordField password;
	private JTextField username;
	private JButton login;
	private JButton reset;
	private static Operater user;
	/**
	 * Launch the application
	 * @param args
	 */

	/**
	 * Create the frame
	 */
	public LoginIFrame() {
	        
		super();
		
	         /////
			 URL iconURL = getClass().getResource("/logo.png");
			 ImageIcon icon = new ImageIcon(iconURL);
	         setIconImage(icon.getImage());
			////
		final BorderLayout borderLayout = new BorderLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout.setVgap(10);
		getContentPane().setLayout(borderLayout);
		setTitle("ϵͳ��¼");
		setBounds(100, 100, 285, 194);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel);

		/////
		    // setUndecorated(true);  //ȥ�������� 
		     getRootPane().setWindowDecorationStyle(JRootPane.NONE); 
		     //getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);   
			 getRootPane().setWindowDecorationStyle(JRootPane.FRAME);   
		     //setSize(400,300);   
		     setLocationRelativeTo(null);   
		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		    setVisible(true);   
		////////
		try
		{
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		//UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");	
			//String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			//UIManager.setLookAndFeel(lookAndFeel);
			
	    // String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
       	 //UIManager.setLookAndFeel(lookAndFeel);
			 //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);	
		}
		/////////
		
		
		
		
		
		
		final JPanel panel_2 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setHgap(5);
		gridLayout.setVgap(20);
		panel_2.setLayout(gridLayout);
		panel.add(panel_2);

		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(0, 0));
		label.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label);
		label.setText("��  ��  ����");

		username = new JTextField(20);
		username.setPreferredSize(new Dimension(0, 0));
		panel_2.add(username);

		final JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);
		label_1.setText("��      �룺");

		password = new JPasswordField(20);
		password.setDocument(new MyDocument(6));
		password.setEchoChar('*');//���������Ļ����ַ�
		password.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == 10)
					login.doClick();
			}
		});
		panel_2.add(password);

		final JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		login=new JButton();
		login.addActionListener(new BookLoginAction());
		
		
		login.setText("��¼");
		panel_1.add(login);
		reset=new JButton();
		reset.addActionListener(new BookResetAction());
		
		reset.setText("����");
		panel_1.add(reset);

		final JLabel tupianLabel = new JLabel();
		ImageIcon loginIcon=CreatecdIcon.add("login.jpg");
		tupianLabel.setIcon(loginIcon);
		tupianLabel.setOpaque(true);
		tupianLabel.setBackground(Color.GREEN);
		tupianLabel.setPreferredSize(new Dimension(260, 60));
		panel.add(tupianLabel, BorderLayout.NORTH);
		//
		setVisible(true);
		setResizable(false);
		//setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

	}
	public static Operater getUser() {
		return user;
	}
	public static void setUser(Operater user) {
		LoginIFrame.user = user;
	}

}
