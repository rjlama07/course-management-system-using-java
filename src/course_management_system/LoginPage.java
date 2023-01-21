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
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(116, 192, 67));
		panel.setBounds(0, 0, 272, 410);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/logo_good.png")));
		lblNewLabel_1.setBounds(10, 115, 284, 161);
		panel.add(lblNewLabel_1);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("Courier New", Font.BOLD, 12));
		button.setBackground(new Color(116, 192, 67));
		button.setBounds(322, 254, 327, 44);
		frame.getContentPane().add(button);
		
		TextField textField = new TextField();
		textField.setBounds(322, 135, 327, 35);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(322, 105, 116, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		lblPassword.setBounds(322, 163, 116, 35);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(322, 204, 327, 35);
		frame.getContentPane().add(passwordField);
		frame.setBounds(100, 100, 729, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
