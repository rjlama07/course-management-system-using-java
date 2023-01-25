package Pages;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Functions.Greet;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class StudentDashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StudentDashboard(JFrame frame,String name) {
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
		panel.setBounds(0, 0, 268, 480);
		mainPanel.add(panel);
		panel.setLayout(null);
		JLabel wName = new JLabel();
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
		JLabel lblNewLabel_2 = new JLabel("Settings");
		lblNewLabel_2.setBounds(21, 20, 106, 26);
		settingPannel.add(lblNewLabel_2);
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
	}
}

