import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddNewUser {

	JFrame frmAddNewUser = new JFrame();
	JTextField textField;
	JPasswordField Userpassword;
	JLabel lblNewLabel;
	JLabel lblPassword;
	JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	AddNewUser(HashMap<String,String> loginInfoOrg2) {
		frmAddNewUser.setType(Type.UTILITY);
		frmAddNewUser.setVisible(true);
		frmAddNewUser.setTitle("Add new user");
		frmAddNewUser.setResizable(false);
		
		frmAddNewUser.setBounds(100, 100, 667, 399);
		frmAddNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNewUser.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(146, 59, 144, 20);
		frmAddNewUser.getContentPane().add(textField);
		textField.setColumns(10);
		
		Userpassword = new JPasswordField();
		Userpassword.setColumns(10);
		Userpassword.setBounds(146, 116, 144, 20);
		frmAddNewUser.getContentPane().add(Userpassword);
		
		lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(21, 56, 115, 20);
		frmAddNewUser.getContentPane().add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(21, 113, 115, 20);
		frmAddNewUser.getContentPane().add(lblPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 11, 314, 338);
		frmAddNewUser.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User Name ", "Password"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		for(String i: loginInfoOrg2.keySet()) {
			String name = i;
			String pass = loginInfoOrg2.get(i);
			DefaultTableModel model = new DefaultTableModel();
			model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {
					name,
					pass
			});
		}
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userID = textField.getText();
				String userpas = String.valueOf(Userpassword.getPassword());
				if(!userID.isEmpty() && !userpas.isEmpty()) {
					loginInfoOrg2.put(userID, userpas);
					
						String name = userID;
						String pass = userpas;
						DefaultTableModel model = new DefaultTableModel();
						model = (DefaultTableModel) table.getModel();
						model.addRow(new Object[] {
								name,
								pass
						});
					
				}
			}
		});
		btnNewButton.setBounds(21, 189, 89, 23);
		frmAddNewUser.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("reset");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				Userpassword.setText("");
			}
		});
		btnNewButton_1.setBounds(171, 189, 89, 23);
		frmAddNewUser.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(94, 261, 89, 23);
		frmAddNewUser.getContentPane().add(btnNewButton_2);
	}
}
