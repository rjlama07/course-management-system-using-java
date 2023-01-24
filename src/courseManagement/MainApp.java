package courseManagement;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import courseManagement.Pages.SplashScreen;
import java.awt.BorderLayout;

public class MainApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
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
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.s
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Course Management System");
		frame.setResizable(false);
		frame.setBounds(100, 100, 668, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		new SplashScreen(frame);

	}

}
