package Pages;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Connector.DatabaseConnector;
import Exceptions.NoRecordFound;

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
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean isData=false;
				try {
					String query = "SELECT * from studentresult WHERE student_id=?;";
					String query1 = "SELECT firstname,lastname FROM `users` WHERE id=?";
					PreparedStatement pst = dc.pst(query);
					pst.setString(1,textArea.getText());
					ResultSet rs = pst.executeQuery(); 
						ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0); // Clear the table model
						int column = rsmd.getColumnCount();
						String[] columnName = new String[column];
						for (int i = 0; i < column; i++) {
							columnName[i] = rsmd.getColumnName(i + 1);

						}
						model.setColumnIdentifiers(columnName);
						String student_id, moduleName, gpa, grade;

						List<String> myList = new ArrayList<>();
						while (rs.next()) {
							isData=true;
							student_id = rs.getString(1);
							moduleName = rs.getString(2);
							gpa = rs.getString(3);
							grade = rs.getString(4);
							myList.add(student_id);
							myList.add(moduleName);
							myList.add(gpa);
							myList.add(grade);
							Vector<String> row = new Vector<String>(myList);
							myList = new ArrayList<>();
							model.addRow(row);
						}
						if(!isData)
						{
							throw new NoRecordFound("No record found for the given id");
						}
					PreparedStatement pst1=dc.pst(query1);
					pst1.setString(1,textArea.getText());
					ResultSet rs1=pst1.executeQuery();
					if(rs1.next()) {
						   String username=rs1.getString("firstname")+" "+rs1.getString("lastname");
						   studentNamelable.setText(username);
						}
					pst.close();

				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
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
