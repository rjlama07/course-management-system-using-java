package dashboard;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StudentDashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StudentDashboard(JFrame frame,String name) {
		setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(6, 0, 675, 352);
		add(mainPanel);
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel);
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 185, 340);
		mainPanel.add(panel);
		panel.setLayout(null);
		JLabel wName = new JLabel();
		wName.setText("Welcome "+name);
		wName.setBounds(6, 6, 173, 32);
		panel.add(wName);
		JLabel lblNewLabel_1 = new JLabel("Student Dashboard");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lava Devanagari", Font.BOLD, 13));
		lblNewLabel_1.setBounds(331, 6, 185, 36);
		mainPanel.add(lblNewLabel_1);
	}
}
