package course_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import database.DatabaseConnector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginPage {

	private JFrame frame;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 272, 438);
		panel.setBackground(new Color(116, 192, 67));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/logo_good.png")));
		lblNewLabel_1.setBounds(10, 115, 284, 161);
		panel.add(lblNewLabel_1);
		
		JButton button = new JButton("Login");
		button.setBounds(322, 254, 327, 44);
		button.setOpaque(true);
		button.setBorderPainted(false);
		
		button.setForeground(new Color(3, 248, 217));
		button.setFont(new Font("Courier New", Font.BOLD, 12));
		button.setBackground(new Color(116, 192, 67));
		frame.getContentPane().add(button);
		
		final TextField textField = new TextField();
		textField.setBounds(322, 135, 327, 35);
		frame.getContentPane().add(textField);
		frame.setVisible(true);
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(322, 105, 116, 23);
		
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(322, 176, 116, 29);
		lblPassword.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(322, 204, 327, 35);
		frame.getContentPane().add(passwordField);
		
		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Lao Sangam MN", Font.PLAIN, 10));
		lblNewLabel_2.setForeground(new Color(255, 69, 51));
		lblNewLabel_2.setBounds(332, 310, 164, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Not a member?");
		lblNewLabel_3.setBounds(441, 349, 101, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton textbutton = new JButton("Sign up");
		textbutton.setBackground(new Color(0, 255, 235));
		textbutton.setForeground(new Color(10, 1, 255));
		textbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textbutton.setBorderPainted(false);
		textbutton.setBounds(518, 348, 91, 21);
		frame.getContentPane().add(textbutton);
		frame.setBounds(100, 100, 729, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final DatabaseConnector dc=new DatabaseConnector();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username=textField.getText().toLowerCase();
				String password=new String(passwordField.getPassword());
				try {
					
					Connection con=dc.connection("jdbc:mysql://localhost:3306/coursemanagementsystem");
					String query="SELECT role FROM `users` WHERE username=? and password=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, username);
					pst.setString(2,password);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						
					    String role=rs.getString("role");
					    if(role.equals("student"))
					    {
					    	new StudentDashboard();
					    	frame.setVisible(false);
					    }
					    else if(role.equals("teacher"))
					    {
					    	new TeacherDashboard();
					    	frame.setVisible(false);	
					    }
					    else if(role.equals("admin"))
					    {
					    	JOptionPane.showMessageDialog(null, "Welcome admin");
					    }
					    else 
					    {
					    	JOptionPane.showMessageDialog(null, "Something went wrong!!");
					    }
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username or password do not match");
						
					}
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
				
			}
		});
		textbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new SignupPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}});
	}
}
