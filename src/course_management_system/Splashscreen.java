package course_management_system;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Splashscreen {

	private static JFrame frame;
	private static JProgressBar progressBar;
	private static JLabel label_1;
	 private int i;
	 private static Timer timer;
	
	
	

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					Splashscreen window = new Splashscreen();
					Splashscreen.frame.setVisible(true);
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Splashscreen() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(243, 242, 241));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Splashscreen.class.getResource("/images/HCK.png")));
		lblNewLabel.setBounds(188, 44, 200, 146);
		panel.add(lblNewLabel);
		
		 progressBar = new JProgressBar();
		progressBar.setForeground(new Color(45, 242, 40));
		progressBar.setBounds(199, 261, 172, 20);
		panel.add(progressBar);
		
		 label_1 = new JLabel();
		label_1.setBounds(268, 233, 61, 16);
		panel.add(label_1);
		i = 0;

		timer = new Timer(3, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				progressBar.setValue((int) ((i / (float) progressBar.getMaximum()) * 100));
				if (i == 100) {
					timer.stop();
					new LoginPage();
					Splashscreen.frame.setVisible(false);
				}
			}
		});
		timer.start();
		
	}
}
