package dashboard;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class StudentDashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StudentDashboard(JFrame frame,String name) {
		name=name.substring(0, 1).toUpperCase()+name.substring(1);
		setLayout(null);
		frame.setBounds(100, 100, 1280, 720);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(203, 235, 240));
		mainPanel.setBounds(6, 0, 1280, 720);
		add(mainPanel);
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(116, 192, 67));
		panel.setBounds(0, 0, 222, 735);
		mainPanel.add(panel);
		panel.setLayout(null);
		JLabel wName = new JLabel();
		wName.setText("Welcome "+name);
		wName.setBounds(26, 37, 173, 32);
		panel.add(wName);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentDashboard.class.getResource("/images/account-icon-25499-Windows.ico")));
		lblNewLabel.setBounds(52, 149, 126, 119);
		panel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Student Dashboard");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lava Devanagari", Font.BOLD, 13));
		lblNewLabel_1.setBounds(537, 6, 185, 36);
		mainPanel.add(lblNewLabel_1);
	}
}
