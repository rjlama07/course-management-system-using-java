package courseManagement.Pages;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Connector.DatabaseConnector;
import Validator.Valid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPasswordField;

public class SignupPannel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public SignupPannel(final JFrame frame) {
		setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(6, 6, 654, 410);
		add(panel);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(407, -13, 260, 423);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-67, 6, 343, 470);
		lblNewLabel.setIcon(new ImageIcon(SignupPannel.class.getResource("/images/back.png")));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(25, 96, 121, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("first name");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(28, 82, 74, 16);
		panel.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 96, 155, 34);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("last name");
		lblNewLabel_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(145, 82, 74, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("password");
		lblNewLabel_1_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(25, 183, 93, 16);
		panel.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(22, 153, 275, 34);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("username");
		lblNewLabel_1_2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(25, 130, 130, 16);
		panel.add(lblNewLabel_1_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(22, 199, 275, 34);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("confirm password");
		lblNewLabel_1_2_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(25, 245, 93, 16);
		panel.add(lblNewLabel_1_2_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(22, 260, 275, 34);
		panel.add(passwordField_1);
		JLabel lblNewLabel_3 = new JLabel("Already a member?");
		lblNewLabel_3.setBounds(25, 351, 121, 16);
		panel.add(lblNewLabel_3);
		
		JButton textbutton = new JButton("Login");
		textbutton.setBackground(new Color(0, 255, 235));
		textbutton.setForeground(new Color(10, 1, 255));
		textbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage(frame);
				panel.setVisible(false);
			}
		});
		textbutton.setBorderPainted(false);
		textbutton.setBounds(121, 346, 91, 29);
		panel.add(textbutton);
		final Valid validator=new Valid();

		JButton button = new JButton("Submit");
		button.setBounds(25, 306, 163, 33);
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.setForeground(new Color(3, 248, 217));
		button.setFont(new Font("Courier New", Font.BOLD, 12));
		button.setBackground(new Color(116, 192, 67));
		final DatabaseConnector dc=new DatabaseConnector();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName=textField.getText().toLowerCase();
				String lastName=textField_3.getText().toLowerCase();
				String username=textField_1.getText().toLowerCase();
				String cPassword=new String(passwordField_1.getPassword());
				String password=new String(passwordField.getPassword());
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
							pst.setString(2,password);
							pst.setString(3, "student");
							pst.setString(4, firstName);
							pst.setString(5, lastName);
							
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "You are registered.Login to continue");
							new LoginPage(frame);
							panel.setVisible(false);
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
		panel.add(button);
		
		

	}
}
