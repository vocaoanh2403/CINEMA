package cinema;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.*;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField addFieldUserName;
	private JPasswordField addpwField;
	int xx,xy;
	Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx = arg0.getX();
				xy = arg0.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				frame.setLocation(x-xx, y-xy);
			}
		});
		panel.setBounds(0, 0, 450, 40);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel labelLogo = new JLabel("CINEMA");
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setLocation(188, 6);
		labelLogo.setSize(69, 24);
		labelLogo.setFont(new Font("Time News Roman", Font.BOLD, 14));
		panel.add(labelLogo);
		
		JLabel labelButtonX = new JLabel("X");
		labelButtonX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelButtonX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		labelButtonX.setLocation(421, 5);
		labelButtonX.setSize(11, 24);
		labelButtonX.setFont(new Font("Sohora", Font.BOLD, 16));
		panel.add(labelButtonX);
		
		
		JPanel panelBody = new JPanel();
		panelBody.setBackground(Color.PINK);
		panelBody.setBounds(0, 40, 450, 260);
		frame.getContentPane().add(panelBody);
		panelBody.setLayout(null);
		addTextFieldUserName(panelBody);
		addTextFieldPass(panelBody);
		
		JLabel labelLogin = new JLabel("\u0110\u0103ng nh\u1EADp");
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogin.setSize(116, 40);
		labelLogin.setFont(new Font("Time News Roman", Font.BOLD, 21));
		labelLogin.setLocation(168, 11);
		panelBody.add(labelLogin);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 76, 111, 31);
		panelBody.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 122, 70, 14);
		panelBody.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(111, 178, 89, 23);
		panelBody.add(btnNewButton);
		
		JButton btnLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setBounds(260, 178, 89, 23);
		panelBody.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				jButtonPerformed(event);
			}
		});
	}
	
	public void addTextFieldUserName(JPanel panel1) {
		addFieldUserName = new JTextField();
		addFieldUserName.setSize(150, 22);
		addFieldUserName.setLocation(168, 80);
		//addFieldUserName.setBounds(100, 100, 200, 20);
		panel1.add(addFieldUserName);
	}
	public void addTextFieldPass(JPanel panel) {
		addpwField = new JPasswordField();
		addpwField.setBounds(168, 118, 150, 22);
		panel.add(addpwField);
	}
	
	private void jButtonPerformed(ActionEvent event) {
			try {
			String textField = addFieldUserName.getText();
			String textPasspwd =addpwField.getText();
			String query= "select * from manager where name_manager='"+textField+"'and password_manager='"+textPasspwd+"'";
			conn = new MyConnect().getcn();
			if(conn == null) {
				JOptionPane.showMessageDialog(frame, "Connect with database failed!");
				return;
			}
				Statement state= conn.createStatement();
				state.execute(query);
				ResultSet result = state.executeQuery(query);
				if(result.next())
				{
					String db_username = result.getString("name_manager");
					String db_password = result.getString("password_manager");
					if(textField.equals(db_username) && textPasspwd.equals(db_password)) {
						//JOptionPane.showConfirmDialog(frame, "Welcome");
						EmployeeManager m = new EmployeeManager();
						m.main();
						frame.dispose();
					}else {
						JOptionPane.showConfirmDialog(frame, "Error");
					}
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
	}
	
}
