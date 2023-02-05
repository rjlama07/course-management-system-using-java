package Pages;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



import Connector.DatabaseConnector;
import Controller.ChangeData;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentDashboard extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField newPasswordField;
	private JPasswordField cPasswordfield;
	private JTable table;
	private JTable table_course;
	private JTable studentTable;
	private JTextField textField;
	private JTextField teacherSearch;
	private JTextField course_search;

	/**
	 * Create the panel.
	 */
	
	public void search(DefaultTableModel model,JTable table,String str) {
		model=(DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs =new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
		
	}
	public StudentDashboard(JFrame frame, Usermodel user, DatabaseConnector dc) {
		ChangeData cd=new ChangeData(dc);
		String name = user.getFirstName();
		name = cd.makeCapital(name);
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
		Greet greet = new Greet();
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

		JButton settingButton = new JButton("Settings");
		settingButton.setBounds(31, 291, 207, 29);
		panel.add(settingButton);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(268, 0, 540, 480);
		mainPanel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		settingButton.setBorderPainted(false);

		JButton logoutButton = new JButton("Log Out");
		logoutButton.setForeground(new Color(255, 38, 0));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Select",
						JOptionPane.YES_NO_OPTION);
				if (a == 0) {
					new LoginPage(frame, dc);
					mainPanel.setVisible(false);
					JOptionPane.showMessageDialog(null, "Log out sucessfully");
				}

			}
		});
		logoutButton.setBorderPainted(false);
		logoutButton.setBounds(31, 394, 207, 29);
		panel.add(logoutButton);

		JButton viewTeacherButton = new JButton("View Teacher");
		viewTeacherButton.setBorderPainted(false);
		viewTeacherButton.setBounds(31, 209, 207, 29);
		panel.add(viewTeacherButton);

		JButton viewCourseButton = new JButton("View Course");

		viewCourseButton.setBorderPainted(false);
		viewCourseButton.setBounds(31, 250, 207, 29);
		panel.add(viewCourseButton);
		
		JButton viewStudentButton = new JButton("View Student");
		viewStudentButton.setBorderPainted(false);
		viewStudentButton.setBounds(31, 328, 207, 29);
		panel.add(viewStudentButton);
		
		JLabel roleS = new JLabel("");
		roleS.setBounds(106, 56, 61, 16);
		panel.add(roleS);
		String role=cd.makeCapital(user.getRole());
        roleS.setText(role);
		
				JPanel dashboardPannel = new JPanel();
				layeredPane.add(dashboardPannel, "name_332999382465792");
				dashboardPannel.setLayout(null);
				

				JLabel lblNewLabel_1 = new JLabel("Student Dashboard");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(166, 5, 177, 43);
				dashboardPannel.add(lblNewLabel_1);
		
		JPanel viewStudentPanel = new JPanel();
		layeredPane.add(viewStudentPanel, "name_140162294566916");
		viewStudentPanel.setLayout(null);
		
		JLabel Students = new JLabel("Students");
		Students.setFont(new Font("Dialog", Font.PLAIN, 16));
		Students.setBounds(25, 49, 92, 16);
		viewStudentPanel.add(Students);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(29, 149, 494, 290);
		viewStudentPanel.add(scrollPane_2);
		
		studentTable = new JTable();
		scrollPane_2.setViewportView(studentTable);
		
		textField = new JTextField();
		
		
		textField.setBounds(369, 80, 154, 34);
		viewStudentPanel.add(textField);
		textField.setColumns(10);
		
		
		JButton progessButtton = new JButton("See Result");
		progessButtton.setBounds(254, 84, 117, 29);
		
		
		JButton editStudentButton = new JButton("Edit");
		editStudentButton.setBounds(25, 84, 117, 29);
		
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		
		btnNewButton_1_1.setBounds(139, 84, 117, 29);
		editStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.editData();
			}
		});
		studentTable.setEnabled(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.deleteData();
			}
		});
		progessButtton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProgess vp= new ViewProgess();
			    vp.setVisible(true);
			}
		});
		
		viewStudentPanel.add(editStudentButton);
		viewStudentPanel.add(btnNewButton_1_1);
		viewStudentPanel.add(progessButtton);
		JLabel lblNewLabel_7_1 = new JLabel("seach");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7_1.setFont(new Font("Krub", Font.PLAIN, 12));
		lblNewLabel_7_1.setBounds(373, 69, 61, 16);
		viewStudentPanel.add(lblNewLabel_7_1);
		JPanel teacherPannel = new JPanel();
		layeredPane.add(teacherPannel, "name_100663201273375");
		teacherPannel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Module Teahcers");
		lblNewLabel_5.setBounds(6, 26, 118, 28);
		teacherPannel.add(lblNewLabel_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 119, 528, 342);
		teacherPannel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel settingPannel = new JPanel();
		layeredPane.add(settingPannel, "name_129136911037625");
		settingPannel.setLayout(null);
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

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String oldPassword = new String(passwordField.getPassword());
				String newPassword = new String(newPasswordField.getPassword());
				String cPassword = new String(cPasswordfield.getPassword());
				try {
					System.out.println(user.getPassword());

					if (oldPassword.equals(user.getPassword())) {
						Valid valid = new Valid();
						if (valid.checkPassword(newPassword)) {
							if (newPassword.equals(cPassword)) {
								String query = "UPDATE users SET password=? WHERE email=?";
								PreparedStatement pst = dc.pst(query);
								pst.setString(1, newPassword);
								pst.setString(2, user.getEmail());
								pst.execute();
								JOptionPane.showMessageDialog(null, "Password changed sucessfully");
								passwordField.setText("");
								newPasswordField.setText("");
								cPasswordfield.setText("");
							} else {
								throw new PasswordDonotMatch("Please match the new and confirm password");
							}
						} else {
							throw new PasswordDonotMatch(
									"Password must be valid i.e one uppercase,lowercase,special character and must be atleast 8 character");
						}
					} else {
						throw new PasswordDonotMatch("Yout old password donot match");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Showpassword().showPassword(chckbxNewCheckBox, passwordField, newPasswordField, cPasswordfield);
			}
		});

		JPanel viewCoursePannel = new JPanel();
		layeredPane.add(viewCoursePannel, "name_115470404469625");
		viewCoursePannel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Cources Available");
		lblNewLabel_6.setBounds(25, 35, 126, 30);
		viewCoursePannel.add(lblNewLabel_6);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 114, 498, 360);
		viewCoursePannel.add(scrollPane_1);

		table_course = new JTable();
		scrollPane_1.setViewportView(table_course);
		
		JButton addStudentReport = new JButton("Generate Report");
		
		addStudentReport.setBounds(25, 113, 160, 29);
		

		JButton editCourseButton = new JButton("Edit");
		editCourseButton.setBounds(147, 77, 117, 29);

		JButton addCourseButton = new JButton("Add");
		addCourseButton.setBounds(25, 77, 117, 29);

		JButton deleteCourseButton = new JButton("Delete");
		deleteCourseButton.setBounds(269, 77, 117, 29);

		JButton addTeacherButton = new JButton("Add");
		addTeacherButton.setBounds(6, 66, 117, 29);
		settingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.changePanne(layeredPane, settingPannel);
			}
		});
		
		dashboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.changePanne(layeredPane, dashboardPannel);
			}
		});
		DefaultTableModel viewTeacherModel = null;
		viewTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.changePanne(layeredPane, teacherPannel);
				cd.viewData(table, "teacher",viewTeacherModel);

			}
		});
		table.setEnabled(false);
		
		teacherSearch = new JTextField();
		teacherSearch.setBounds(385, 65, 130, 28);
		teacherPannel.add(teacherSearch);
		teacherSearch.setColumns(10);
		
		JLabel lblSearch = new JLabel("search");
		lblSearch.setFont(new Font("Krub", Font.PLAIN, 12));
		lblSearch.setBounds(389, 52, 61, 16);
		teacherPannel.add(lblSearch);
		table_course.setEnabled(false);
		DefaultTableModel courseModel=null;
		viewCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.changePanne(layeredPane, viewCoursePannel);
				cd.viewCourse(table_course, courseModel);

			}
		});

		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(131, 66, 117, 29);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(249, 66, 117, 29);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.deleteData();
			}
		});
		addTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JTextField firstname = new JTextField();
					JTextField lastname = new JTextField();
					JTextField password = new JTextField();
					JTextField email = new JTextField();
					String role = "teacher";
					Object[] fields = { "firstname", firstname, "lastname", lastname, "Email", email, "Set Password",
							password };
					int result = JOptionPane.showConfirmDialog(null, fields, "Add teacher",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {

						String query = "INSERT INTO `users` (`ID`, `email`, `password`, `role`, `firstname`, `lastname`) VALUES (NULL, ?, ?, ?, ?, ?)";
						PreparedStatement pst = dc.pst(query);
						pst.setString(1, email.getText());
						pst.setString(2, password.getText());
						pst.setString(3, role);
						pst.setString(4, firstname.getText());
						pst.setString(5, lastname.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Sucessfully added teacher. Refresh to see changes");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cd.editData();
			}
		});
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JTextField courseName = new JTextField();
					JTextField totalYear = new JTextField();
					JTextField seats = new JTextField();
					Object[] fields = { "CourseName", courseName, "Total Year", totalYear, "Seats", seats,

					};
					int result = JOptionPane.showConfirmDialog(null, fields, "Add Course",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {

						String query = "INSERT INTO `cources` ( `ID`,`courseName`, `totalyear`, `seats`) VALUES (NULL,?, ?, ?)";
						PreparedStatement pst = dc.pst(query);
						pst.setString(1, courseName.getText());
						pst.setString(2, totalYear.getText());
						pst.setString(3, seats.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Sucessfully added course. Refresh to see changes");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		editCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JTextField courseName = new JTextField();
					JTextField id = new JTextField();
					JTextField totalYear = new JTextField();
					JTextField seats = new JTextField();
					Object[] fields = { "Enter ID of course", id, "CourseName", courseName, "Total Year", totalYear,
							"Seats", seats,

					};

					int result = JOptionPane.showConfirmDialog(null, fields, "Edit Course",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {

						String query = "UPDATE cources SET courseName = ?, totalyear = ?,seats=? WHERE id = ?";
						PreparedStatement pst = dc.pst(query);
						pst.setString(1, courseName.getText());
						pst.setString(2, totalYear.getText());
						pst.setString(3, seats.getText());
						pst.setString(4, id.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Sucessfully edited course. Refresh to see changes");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}

			}
		});
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = JOptionPane.showInputDialog(null, "Enter ID you want to delete");
				int id = Integer.parseInt(a);

				String query = "DELETE FROM cources WHERE id = ?";
				try {
					PreparedStatement pst = dc.pst(query);
					pst.setInt(1, id);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully deleted. Refresh to see changes");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		DefaultTableModel viewStudentmodel = null;
		
		viewStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.changePanne(layeredPane, viewStudentPanel);
				cd.viewData(studentTable, "student",viewStudentmodel );	
			}
		});
		addStudentReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField gpa = new JTextField();
				JTextField id = new JTextField();
				JTextField grade = new JTextField();
				JTextField moduleName = new JTextField();
				Object[] fields = { "Enter Student id",id,"Module Name",moduleName, "GPA", gpa,
						"Grade", grade

				};
				int result = JOptionPane.showConfirmDialog(null, fields, "Generate Report",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
				try {
						String query = "INSERT INTO `studentresult` (`GPA`, `ModuleName`, `GRADE`, `student_id`) VALUES ( ?, ?, ?, ?)";
						PreparedStatement pst = dc.pst(query);
						pst.setString(1, gpa.getText());
						pst.setString(2, moduleName.getText());
						pst.setString(3, grade.getText());
						pst.setString(4, id.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Report recorded");
					}
					

				 catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
				}
			}
		});
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cd.search(viewStudentmodel, studentTable, textField.getText());
			}
		});
		teacherSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cd.search(viewTeacherModel, table, teacherSearch.getText());
			}
		});
	   if(user.getRole().equals("teacher"))
	   {
			viewStudentPanel.add(addStudentReport);
	   }
		
		course_search = new JTextField();
		course_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cd.search(courseModel, table_course, course_search.getText().toUpperCase());
			}
		});
		course_search.setBounds(398, 77, 130, 26);
		viewCoursePannel.add(course_search);
		course_search.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Search");
		lblNewLabel_8.setFont(new Font("Krub", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(398, 62, 61, 16);
		viewCoursePannel.add(lblNewLabel_8);
	
		if (user.getRole().equals("admin")) {
			teacherPannel.add(addTeacherButton);
			teacherPannel.add(btnEdit);
			teacherPannel.add(btnDelete);
			viewCoursePannel.add(addCourseButton);
			viewCoursePannel.add(editCourseButton);
			viewCoursePannel.add(deleteCourseButton);
			viewStudentPanel.add(editStudentButton);
			viewStudentPanel.add(btnNewButton_1_1);
			viewStudentPanel.add(progessButtton);
			JLabel lblNewLabel_7 = new JLabel("seach");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_7.setFont(new Font("Krub", Font.PLAIN, 12));
			lblNewLabel_7.setBounds(373, 69, 61, 16);
			viewStudentPanel.add(lblNewLabel_7);
		}
	}
}