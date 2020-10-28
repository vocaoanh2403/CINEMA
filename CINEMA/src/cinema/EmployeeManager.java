package cinema;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.ObjectInputStream.GetField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.Scrollable;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class EmployeeManager {

	private JFrame frame;
	int xx,xy;
	private String username;
	private JTable table;
	private Connection conn;
	DefaultTableModel model = new DefaultTableModel();
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManager window = new EmployeeManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public EmployeeManager() {
		initialize();
		conn =new MyConnect().getcn();
		if(conn == null){
			JOptionPane.showConfirmDialog(frame, "Ket noi that bai");
			return;
		}
		
		//loadTable();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 100, 850, 500);
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
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 850, 30);
		panel.getBackground();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.ORANGE);
		panel1.setLayout(null);
		panel1.setBounds(0, 30, 840, 470);
		
		frame.getContentPane().add(panel1);
		JLabel lblCloseWindow = new JLabel(" X");
		lblCloseWindow.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCloseWindow.setLocation(813, -4);
		lblCloseWindow.setSize(40, 40);
		lblCloseWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		panel.add(lblCloseWindow);
		
		JLabel lblNewLabel_1 = new JLabel("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(363, 0, 210, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Danh s\u00E1ch:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(177, 11, 89, 36);
		panel1.add(lblNewLabel);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(20, 47, 670, 298);
		panel1.add(scroll);
		table = new JTable();
		Object[] colums = {"ID","Name","Email","Password","Age","NumberPhone","type"};
		model.setColumnIdentifiers(colums);
		table.setSize(670, 298);
		table.setModel(model);
		table.removeColumn(table.getColumnModel().getColumn(0));
		scroll.setViewportView(table);
		
		
		JButton btnAdd = new JButton("Th\u00EAm");
		btnAdd.setBounds(721, 48, 89, 23);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddEmployee addemp= new AddEmployee();
				addemp.setVisible(true);
			}
		});
		panel1.add(btnAdd);
		
		JButton btnDelete = new JButton("X\u00F3a");
		btnDelete.setBounds(721, 122, 89, 23);
		panel1.add(btnDelete);
		
		JButton btnUpdate = new JButton("S\u1EEDa");
		btnUpdate.setBounds(721, 202, 89, 23);
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EditEmployee editemp= new EditEmployee();
				editemp.setVisible(true);
				frame.dispose();
			}
		});
		panel1.add(btnUpdate);
	}
	
	public void loadTable() {
		conn = new MyConnect().getcn();
		Object row[]= new Object[7];
		try {
			String sql = "select (user_id_emp,name_emp,email_emp,password_emp,age,phonenumber_emp,ty_pe) from employee";
			PreparedStatement pes = conn.prepareStatement(sql);
			ResultSet res = pes.executeQuery();
			model.setRowCount(0);
			while(res.next()) {
				row[0]=res.getString(1);
				row[1]=res.getString(2);
				row[2]=res.getString(3);
				row[3]=res.getString(4);
				row[4]=res.getString(5);
				row[5]=res.getString(6);
				row[6]=res.getString(7);
				model.addColumn(row);
			}
			res.close();
			pes.close();
			conn.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
}
