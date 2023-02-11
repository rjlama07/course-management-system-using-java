package Pages;




import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Connector.DatabaseConnector;
import Controller.ChangeData;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ViewProgess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ViewProgess() {
		DatabaseConnector dc=new DatabaseConnector();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 664, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 652, 374);
		contentPane.add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 87, 608, 281);
		panel.add(scrollPane);
		JLabel studentNamelable = new JLabel("");
		table = new JTable();
		scrollPane.setViewportView(table);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(411, 35, 183, 23);
		panel.add(textArea);
		final DefaultTableModel model=null;
		ChangeData cd=new ChangeData(dc);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			cd.getReasult(table, model, textArea.getText(), studentNamelable);
			}
		});
		btnNewButton.setBounds(514, 62, 87, 23);
		panel.add(btnNewButton);
		JLabel lblNewLabel = new JLabel("Student name:");
		lblNewLabel.setBounds(26, 35, 110, 16);
		panel.add(lblNewLabel);
		studentNamelable.setBounds(127, 35, 236, 16);
		panel.add(studentNamelable);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(388, 35, 39, 16);
		panel.add(lblNewLabel_1);
		
	}
}
