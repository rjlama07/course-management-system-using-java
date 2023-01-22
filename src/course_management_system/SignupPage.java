package course_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupPage {

	private JFrame frame;
	private JTextField uField;
	private JPasswordField pField;
	private JPasswordField cpasswordField;

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
	 */
	public SignupPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		lblNewLabel_1.setBounds(210, 78, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Mukta", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(210, 142, 61, 16);
		panel.add(lblNewLabel_1_1);
		
		uField = new JTextField();
		uField.setBounds(210, 94, 275, 38);
		panel.add(uField);
		uField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm password");
		lblNewLabel_1_1_1.setFont(new Font("Mukta", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(210, 204, 90, 16);
		panel.add(lblNewLabel_1_1_1);
		
		pField = new JPasswordField();
		pField.setBounds(210, 154, 275, 38);
		panel.add(pField);
		
		cpasswordField = new JPasswordField();
		cpasswordField.setBounds(210, 221, 275, 38);
		panel.add(cpasswordField);
		
		JButton button = new JButton("Signup");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(364, 271, 116, 29);
		button.setOpaque(true);
		button.setBorderPainted(false);
		
		button.setForeground(new Color(3, 248, 217));
		button.setFont(new Font("Courier New", Font.BOLD, 12));
		button.setBackground(new Color(116, 192, 67));
		panel.add(button);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(370, 334, 84, 21);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(10, 1, 255));
		btnNewButton.setBackground(new Color(0, 255, 235));
		btnNewButton.setBorderPainted(false);
		
		JLabel lblNewLabel_2 = new JLabel("Already a member?");
		lblNewLabel_2.setBounds(275, 335, 128, 16);
		panel.add(lblNewLabel_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
				frame.setVisible(false);
			}
		});
		

		
	}
}
