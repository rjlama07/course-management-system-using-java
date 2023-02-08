package Pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Auth.Auth;
import Connector.DatabaseConnector;
import Controller.Showpassword;

import javax.swing.JCheckBox;

public class LoginPage extends JPanel {
	private JPasswordField passwordField;

	private static final long serialVersionUID = 1L;
	private JTextField usernameField;

	/**
	 * Create the panel.
	 */
	public LoginPage(final JFrame frame,DatabaseConnector dc) {
		final Auth auth=new Auth(dc);
		setLayout(null);
		final JPanel mainPanel = new JPanel();
		frame.setBounds(100, 100, 668, 406);
		mainPanel.setBackground(SystemColor.window);
		mainPanel.setLayout(null);
		JButton button = new JButton("Login");
		button.setBounds(273, 272, 278, 44);
		
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.setForeground(new Color(3, 248, 217));
		button.setFont(new Font("Courier New", Font.BOLD, 12));
		button.setBackground(new Color(116, 192, 67));
		mainPanel.add(button);
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(273, 109, 78, 17);

		lblNewLabel.setFont(new Font("Baghdad", Font.BOLD, 14));
		mainPanel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(273, 187, 69, 17);
		lblPassword.setFont(new Font("Baghdad", Font.BOLD, 14));
		mainPanel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(272, 200, 279, 49);
		mainPanel.add(passwordField);

		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Lao Sangam MN", Font.PLAIN, 10));
		lblNewLabel_2.setForeground(new Color(255, 69, 51));
		lblNewLabel_2.setBounds(366, 19, 0, 0);
		mainPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Not a member?");
		lblNewLabel_3.setBounds(312, 325, 94, 16);
		mainPanel.add(lblNewLabel_3);

		JButton textbutton = new JButton("Sign up");
		textbutton.setBackground(new Color(0, 255, 235));
		textbutton.setForeground(new Color(10, 1, 255));
		textbutton.setBorderPainted(false);
		textbutton.setBounds(391, 320, 91, 29);
		mainPanel.add(textbutton);
		mainPanel.setBounds(100, 100, 711, 380);

		usernameField = new JTextField();
		usernameField.setBounds(273, 126, 279, 49);
		mainPanel.add(usernameField);
		usernameField.setColumns(10);

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(116, 192, 67));
		panel.setBounds(0, 0, 241, 380);
		mainPanel.add(panel);
		panel.setLayout(null);
		frame.getContentPane().add(mainPanel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/logo_good.png")));
		lblNewLabel_1.setBounds(6, 136, 223, 112);
		panel.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("show password");
		chckbxNewCheckBox.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		chckbxNewCheckBox.setBounds(443, 247, 128, 23);
		
		mainPanel.add(chckbxNewCheckBox);
		passwordField.setEchoChar('*');
		
		chckbxNewCheckBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				new Showpassword().showPassword(chckbxNewCheckBox, passwordField);
				
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText().toLowerCase();
				String password = new String(passwordField.getPassword());
				auth.login(username, password, mainPanel, frame);
			}
		});
		textbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignupPannel(frame,dc);
				mainPanel.setVisible(false);
			}
		});

	}
}

