package course_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Scrollbar;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validator validate=new Validator();
				String username=textField.getText().toLowerCase();
				String password=new String(passwordField.getPassword());
				if(validate.checkEmail(username) && validate.checkPassword(password))
				{
					new StudentDashboard();
					lblNewLabel_2.setText("");
					frame.setVisible(false);
				}
				else if(validate.checkEmail(username) && !validate.checkPassword(password))
				{
					lblNewLabel_2.setText("Invalid password");
						
				}
				else if(!validate.checkEmail(username) && validate.checkPassword(password))
				{
					lblNewLabel_2.setText("Invalid username");
						
				}
				else 
				{
					lblNewLabel_2.setText("Invalid username  password");
				}
				
				
			}
		});
		textbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignupPage();
				frame.setVisible(false);
			}});
	}
}
