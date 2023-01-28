package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Connector.DatabaseConnector;

public class ChangeData {
	DatabaseConnector dc;
	
	public ChangeData(DatabaseConnector dc){
		this.dc=dc;
	}
	
	
   //function to change pannel in layered pannel
	public void changePanne(JLayeredPane layeredPane,JPanel panel ) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	
	//delete users
	public void deleteData() {
		String a = JOptionPane.showInputDialog(null, "Enter ID you want to delete");
		int id = Integer.parseInt(a);

		String query = "DELETE FROM users WHERE id = ?";
		try {
			PreparedStatement pst = dc.pst(query);
			pst.setInt(1, id);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Sucessfully deleted. Refresh to see changes");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}
	}
	
	//edit from users
	public void editData()
	{
		try {
			JTextField firstname = new JTextField();
			JTextField lastname = new JTextField();
			JTextField id = new JTextField();
			Object[] fields = { "ID", id, "firstname", firstname, "lastname", lastname,

			};
			int result = JOptionPane.showConfirmDialog(null, fields, "Edit",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {

				String query = "UPDATE users SET firstname = ?, lastname = ? WHERE id = ?";
				PreparedStatement pst = dc.pst(query);
				pst.setString(1, firstname.getText());
				pst.setString(2, lastname.getText());
				pst.setString(3, id.getText());
				pst.execute();
				JOptionPane.showMessageDialog(null, "Sucessfully edited teacher. Refresh to see changes");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}
	}
	
	
	///view Data from database
	public void viewData(JTable table,String role,DefaultTableModel model) {
		try {
			String query = "SELECT ID,email,firstname,lastname FROM `users` WHERE role=?";
			PreparedStatement pst = dc.pst(query);
			pst.setString(1, role);
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			 model = (DefaultTableModel) table.getModel();
			model.setRowCount(0); // Clear the table model
			int column = rsmd.getColumnCount();
			String[] columnName = new String[column];

			for (int i = 0; i < column; i++) {
				columnName[i] = rsmd.getColumnName(i + 1);

			}
			model.setColumnIdentifiers(columnName);
			String firstname, lastname, email, id;

			List<String> myList = new ArrayList<>();

			while (rs.next()) {
				id = rs.getString(1);
				email = rs.getString(2);
				firstname = rs.getString(3);
				lastname = rs.getString(4);
				myList = new ArrayList<>();
				myList.add(id);
				myList.add(email);
				myList.add(firstname);
				myList.add(lastname);
				Vector<String> row = new Vector<String>(myList);
				model.addRow(row);
			}
			pst.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	///make first letter capital
	public String makeCapital(String a) {
		return a.substring(0,1).toUpperCase()+a.substring(1);
	}
	
	

}
