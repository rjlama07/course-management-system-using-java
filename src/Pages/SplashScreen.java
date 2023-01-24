package Pages;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.SwingConstants;

public class SplashScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	private static JProgressBar progressBar;
	private int i;
	private static Timer timer;

	/**
	 * Create the panel.
	 */
	public SplashScreen(final JFrame frame) {
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(243, 242, 241));
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(195, 36, 215, 155);
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/HCK.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		panel.setVisible(true);
		progressBar = new JProgressBar();
		progressBar.setBounds(219, 227, 172, 20);
		progressBar.setForeground(new Color(45, 242, 40));
		panel.add(progressBar);
		i = 0;

		timer = new Timer(3, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				progressBar.setValue((int) ((i / (float) progressBar.getMaximum()) * 100));
				if (i == 100) {
					timer.stop();
					new LoginPage(frame);
					panel.setVisible(false);
				}
			}
		});
		timer.start();

	}

}
