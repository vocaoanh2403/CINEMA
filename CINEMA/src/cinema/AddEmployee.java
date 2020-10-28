package cinema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JLabel lable;
	private JButton btnSave;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private int xx,xy;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AddEmployee frame = new AddEmployee();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AddEmployee() {
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
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setBounds(320, 80, 300, 300);
		getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setBounds(10, 26, 46, 14);
		getContentPane().add(lblID);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(10, 102, 60, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(80, 23, 115, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 58, 115, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 99, 115, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email :");
		lblNewLabel_2_1.setBounds(10, 141, 46, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(80, 138, 115, 20);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Age :");
		lblNewLabel_2_1_1.setBounds(10, 178, 46, 14);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(80, 175, 115, 20);
		getContentPane().add(textField_4);
		
//		JLabel lblNewLabel_2_1_1_1 = new JLabel("Age :");
//		lblNewLabel_2_1_1_1.setBounds(10, 214, 46, 14);
//		getContentPane().add(lblNewLabel_2_1_1_1);
//		
//		textField_5 = new JTextField();
//		textField_5.setColumns(10);
//		textField_5.setBounds(80, 211, 115, 20);
//		getContentPane().add(textField_5);
//		
		JButton btnNewButton = new JButton("Come Back");
		btnNewButton.setBounds(10, 255, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(128, 255, 89, 23);
		getContentPane().add(btnNewButton_1);
		
	}
}
