package Pages;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;

import Connector.DatabaseConnector;
import Controller.Greet;
import Controller.Showpassword;
import Exceptions.PasswordDonotMatch;
import Models.Usermodel;
import Validator.Valid;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JCheckBox;

public class StudentDashboard extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField newPasswordField;
	private JPasswordField cPasswordfield;

	/**
	 * Create the panel.
	 */
	public StudentDashboard(JFrame frame,Usermodel user) {
		String name=user.getFirstName();
		 name=name.substring(0, 1).toUpperCase()+name.substring(1);
		setLayout(null);
		frame.setBounds(100, 100, 808, 480);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(203, 235, 240));
		mainPanel.setBounds(6, 0, 808, 480);
		add(mainPanel);
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(116, 192, 67));
		panel.setBounds(0, 0, 269, 480);
		mainPanel.add(panel);
		panel.setLayout(null);
		JLabel wName = new JLabel();
		wName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		Greet greet=new Greet();
		wName.setText(greet.greetUser(name));
		wName.setBounds(108, 20, 173, 32);
		panel.add(wName);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentDashboard.class.getResource("/images/logo_good.png")));
		lblNewLabel.setBounds(6, 0, 96, 107);
		panel.add(lblNewLabel);
		
		JButton dashboardButton = new JButton("Dashboard");
		dashboardButton.setBorderPainted(false);
		dashboardButton.setBounds(31, 168, 207, 29);
		panel.add(dashboardButton);
		
		JButton settingButton = new JButton("setting");
		settingButton.setBounds(31, 213, 207, 29);
		panel.add(settingButton);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(268, 0, 540, 480);
		mainPanel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel dashboardPannel = new JPanel();
		layeredPane.add(dashboardPannel, "name_76657310817167");
		dashboardPannel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Dashboard");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(166, 5, 177, 43);
		dashboardPannel.add(lblNewLabel_1);
		
		JPanel settingPannel = new JPanel();
		layeredPane.add(settingPannel, "name_76750832556583");
		settingPannel.setLayout(null);
		settingButton.setBorderPainted(false);
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.setForeground(new Color(255, 38, 0));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0 )
				{
					new LoginPage(frame);
					mainPanel.setVisible(false);
					
				}

			}
		});
		logoutButton.setBorderPainted(false);
		logoutButton.setBounds(31, 394, 207, 29);
		panel.add(logoutButton);
		JLabel lblNewLabel_2 = new JLabel("Settings");
		lblNewLabel_2.setBounds(21, 20, 106, 26);
		settingPannel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Change Password");
		lblNewLabel_3.setBounds(21, 93, 129, 16);
		settingPannel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(26, 137, 173, 33);
		settingPannel.add(passwordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(26, 185, 173, 33);
		settingPannel.add(newPasswordField);
		
		cPasswordfield = new JPasswordField();
		cPasswordfield.setBounds(26, 230, 173, 33);
		settingPannel.add(cPasswordfield);
		
		JLabel lblNewLabel_4 = new JLabel("old password");
		lblNewLabel_4.setFont(new Font("Lao MN", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(31, 125, 96, 16);
		settingPannel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("new password");
		lblNewLabel_4_1.setFont(new Font("Lao MN", Font.PLAIN, 11));
		lblNewLabel_4_1.setBounds(31, 173, 96, 16);
		settingPannel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("confirm password");
		lblNewLabel_4_2.setFont(new Font("Lao MN", Font.PLAIN, 11));
		lblNewLabel_4_2.setBounds(31, 218, 96, 16);
		settingPannel.add(lblNewLabel_4_2);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.setForeground(new Color(255, 38, 0));
		btnNewButton.setBackground(new Color(255, 38, 0));
		btnNewButton.setFont(new Font("Lucida Grande", Font.ITALIC, 9));
		btnNewButton.setBounds(64, 285, 138, 29);
		settingPannel.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("show password");
		chckbxNewCheckBox.setFont(new Font("Lucida Grande", Font.ITALIC, 9));
		chckbxNewCheckBox.setBounds(26, 261, 128, 23);
		
		settingPannel.add(chckbxNewCheckBox);
		settingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(settingPannel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		dashboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(dashboardPannel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
		     
			public void actionPerformed(ActionEvent e) {	
				String oldPassword=new String(passwordField.getPassword());
				String newPassword=new String(newPasswordField.getPassword());
				String cPassword=new String(cPasswordfield.getPassword());
				try {
					 System.out.println(user.getPassword());
					 System.out.println(oldPassword+"old"); 
					 System.out.println(newPassword+"nee"); 
					 
					if(oldPassword.equals(user.getPassword()))
					{
						Valid valid=new Valid();
						if(valid.checkPassword(newPassword))
						{
							if(newPassword.equals(cPassword))
							{
								DatabaseConnector dc=new DatabaseConnector();
								Connection con=dc.connection("jdbc:mysql://localhost:3306/coursemanagementsystem");
								String query="UPDATE users SET password=? WHERE username=?";
								PreparedStatement pst=con.prepareStatement(query);
								pst.setString(1, newPassword);
								pst.setString(2,user.getEmail());
								pst.execute();
								JOptionPane.showMessageDialog(null, "Password changed sucessfully");
								passwordField.setText("");
								newPasswordField.setText("");
								cPasswordfield.setText("");
							}
							else
							{
								throw new PasswordDonotMatch("Please match the new and confirm password");
							}
						}
						else
						{
							throw new PasswordDonotMatch("Password must be valid i.e one uppercase,lowercase,special character and must be atleast 8 character");
						}
					}
					else {
						throw new PasswordDonotMatch("Yout old password donot match");
					}
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				}
		});
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Showpassword().showPassword(chckbxNewCheckBox, passwordField, newPasswordField, cPasswordfield);
				}});
			}
	}


