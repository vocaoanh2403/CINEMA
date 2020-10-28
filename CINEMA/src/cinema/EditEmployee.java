package cinema;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.SwingConstants;

public class EditEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textName;
	private JTextField textPassword;
	private JTextField textEmail;
	private JTextField textAge;
	private JTextField textType;
	private int xx,xy;
	Connection conn;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditEmployee() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx = arg0.getX();
				xy = arg0.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				setLocation(x-xx, y-xy);
			}
		});
		getContentPane().setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(320, 80, 300, 300);
		getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setBounds(24, 26, 46, 14);
		getContentPane().add(lblID);
		textID = new JTextField();
		textID.setBounds(80, 23, 153, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblName = new JLabel("T\u00EAn :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(24, 61, 46, 14);
		getContentPane().add(lblName);
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(80, 58, 153, 20);
		getContentPane().add(textName);
		
		JLabel lblPassword = new JLabel("M\u1EADt kh\u1EA9u:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 102, 60, 14);
		getContentPane().add(lblPassword);
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(80, 99, 153, 20);
		getContentPane().add(textPassword);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(24, 141, 46, 14);
		getContentPane().add(lblEmail);
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(80, 138, 153, 20);
		getContentPane().add(textEmail);
		
		JLabel lblAge = new JLabel("Tu\u1ED5i :");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(24, 178, 46, 14);
		getContentPane().add(lblAge);
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(80, 175, 153, 20);
		getContentPane().add(textAge);
		
		
//		JLabel lblNewLabel_2_1_1_1 = new JLabel("Age :");
//		lblNewLabel_2_1_1_1.setBounds(10, 214, 46, 14);
//		getContentPane().add(lblNewLabel_2_1_1_1);
//		
//		textType = new JTextField();
//		textType.setColumns(10);
//		textType.setBounds(80, 211, 115, 20);
//		getContentPane().add(textType);
		
		JButton btnNewButton = new JButton("Tr\u1EDF l\u1EA1i");
		btnNewButton.setBounds(10, 255, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EmployeeManager m = new EmployeeManager();
				m.main();
				dispose();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("L\u01B0u");
		btnSave.setBounds(201, 255, 89, 23);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textID.getText();
				String name = textName.getText();
				String pwd = textPassword.getText();
				String email = textEmail.getText();
				String Age = textAge.getText();
				String query = "";
				try {
					conn = new MyConnect().getcn();
					Statement state = conn.createStatement();
				}catch(Exception ex) {
					
				}
			}
		});
		getContentPane().add(btnSave);
	}

}
