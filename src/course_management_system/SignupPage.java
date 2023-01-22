package course_management_system;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;



import database.DatabaseConnector;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignupPage {

	private JFrame frame;
	private JTextField uField;
	private JPasswordField pField;
	private JPasswordField cpasswordField;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupPage window = new SignupPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public SignupPage() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 607, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(116, 192, 67));
		panel_1.setBounds(0, 6, 175, 409);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-28, -30, 224, 451);
		lblNewLabel.setIcon(new ImageIcon(SignupPage.class.getResource("/images/back.png")));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Mukta", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(210, 116, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Mukta", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(210, 174, 61, 16);
		panel.add(lblNewLabel_1_1);
		
		uField = new JTextField();
		uField.setBounds(210, 133, 275, 38);
		panel.add(uField);
		uField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm password");
		lblNewLabel_1_1_1.setFont(new Font("Mukta", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(211, 230, 90, 16);
		panel.add(lblNewLabel_1_1_1);
		
		pField = new JPasswordField();
		pField.setBounds(210, 191, 275, 38);
		panel.add(pField);
		
		cpasswordField = new JPasswordField();
		cpasswordField.setBounds(210, 247, 275, 38);
		panel.add(cpasswordField);
		final DatabaseConnector dc=new DatabaseConnector();
		final Validator validator=new Validator();
		JButton button = new JButton("Signup");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=uField.getText().toLowerCase();
				String password=new String(pField.getPassword());
				String cPassword=new String(cpasswordField.getPassword());
				if(validator.checkPassword(password) && password.equals(cPassword))
				{
					try {
						String query="INSERT INTO `users`(`username`, `password`, `role`,`firstname`,`lastname`) VALUES (?,?,?,?,?)";
						Connection con=dc.connection("jdbc:mysql://localhost:3306/coursemanagementsystem");
						String query1="SELECT role FROM `users` WHERE username=?";
						PreparedStatement pst1 ;
						pst1=con.prepareStatement(query1);
						pst1.setString(1, username);
						ResultSet rs=pst1.executeQuery();
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "Username already exists");
						}
						else
						{
							PreparedStatement pst;
							pst=con.prepareStatement(query);
							pst.setString(1, username);
							pst.setString(2,password);s
							pst.setString(3, "student");
							pst.setString(4, textField.getText());
							pst.setString(5, textField_1.getText());
							
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "You are registered.Login to continue");
							new LoginPage();
							frame.setVisible(false);
						}
						
						
						
						con.close();
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
						
					}
				}
				else if(!validator.checkPassword(password))
				{
					JOptionPane.showMessageDialog(null, "Password must have one special character,uppercase, lowercase and must be atleast 8 characters ");
				}
				else if(!password.equals(cPassword))
				{
					JOptionPane.showMessageDialog(null, "Password do not match");
				}
				
				
			}
		});
		button.setBounds(369, 297, 116, 29);
		button.setOpaque(true);
		button.setBorderPainted(false);
		
		button.setForeground(new Color(3, 248, 217));
		button.setFont(new Font("Courier New", Font.BOLD, 12));
		button.setBackground(new Color(116, 192, 67));
		panel.add(button);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(372, 350, 84, 21);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(10, 1, 255));
		btnNewButton.setBackground(new Color(0, 255, 235));
		btnNewButton.setBorderPainted(false);
		
		JLabel lblNewLabel_2 = new JLabel("Already a member?");
		lblNewLabel_2.setBounds(273, 351, 128, 16);
		panel.add(lblNewLabel_2);
		
		JLabel fname = new JLabel("first name");
		fname.setFont(new Font("Mukta", Font.PLAIN, 12));
		fname.setBounds(210, 68, 61, 16);
		panel.add(fname);
		
		JLabel lname = new JLabel("last name");
		lname.setFont(new Font("Mukta", Font.PLAIN, 12));
		lname.setBounds(357, 68, 61, 16);
		panel.add(lname);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(210, 82, 128, 29);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(350, 82, 128, 29);
		panel.add(textField_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
				frame.setVisible(false);
			}
		});
		

		
	}
}
