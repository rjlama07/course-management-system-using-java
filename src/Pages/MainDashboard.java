package Pages;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Connector.DatabaseConnector;
import Controller.ChangeData;
import Controller.Greet;
import Controller.Showpassword;
import Models.TotalData;
import Models.Usermodel;
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
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;

public class MainDashboard extends JPanel {

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
	private TotalData data;
	private String totalTeacher;
	private String totalStudent;
	private String totalCourse;

	/**
	 * Create the panel.
	 */

	public MainDashboard(JFrame frame, Usermodel user, DatabaseConnector dc, TotalData oldData) {
		data = oldData;
		totalTeacher = String.valueOf(data.totalTeacher);
		totalStudent = String.valueOf(data.totalStudent);
		totalCourse = String.valueOf(data.totalCourse);
		ChangeData cd = new ChangeData(dc);
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
		lblNewLabel.setIcon(new ImageIcon(MainDashboard.class.getResource("/images/logo_good.png")));
		lblNewLabel.setBounds(6, 0, 96, 107);
		panel.add(lblNewLabel);

		JButton dashboardButton = new JButton("   Dashboard");
		ImageIcon dashBoardIcon = new ImageIcon(
				MainDashboard.class.getResource("/images/3669363_dashboard_ic_icon.png"));
		dashBoardIcon = new ImageIcon(cd.scaleImage(dashBoardIcon, 25, 25));
		dashboardButton.setIcon(dashBoardIcon);
		dashboardButton.setBorderPainted(false);
		dashboardButton.setBounds(0, 168, 207, 29);
		panel.add(dashboardButton);

		JButton settingButton = new JButton("   Settings");

		settingButton.setBounds(-12, 326, 207, 29);
		panel.add(settingButton);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(268, 0, 540, 480);
		mainPanel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		settingButton.setBorderPainted(false);

		JButton logoutButton = new JButton("   Log Out");
		ImageIcon logoutImage = new ImageIcon(
				MainDashboard.class.getResource("/images/7853741_logout_kashifarif_exit_out_close_icon.png"));
		logoutImage = new ImageIcon(cd.scaleImage(logoutImage, 25, 25));
		logoutButton.setIcon(logoutImage);
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
		logoutButton.setBounds(-12, 391, 207, 29);
		panel.add(logoutButton);

		JButton viewTeacherButton = new JButton("    View Teacher");
		ImageIcon teacherIcon = new ImageIcon(MainDashboard.class.getResource("/images/techer.png"));
		teacherIcon = new ImageIcon(cd.scaleImage(teacherIcon, 25, 25));
		viewTeacherButton.setIcon(teacherIcon);
		viewTeacherButton.setBorderPainted(false);
		viewTeacherButton.setBounds(6, 209, 207, 29);
		panel.add(viewTeacherButton);

		JButton viewCourseButton = new JButton("   Vew Course");
		ImageIcon courseIcon = new ImageIcon(MainDashboard.class.getResource("/images/216113_book_icon.png"));
		courseIcon = new ImageIcon(cd.scaleImage(courseIcon, 25, 25));
		viewCourseButton.setIcon(courseIcon);

		viewCourseButton.setBorderPainted(false);
		viewCourseButton.setBounds(0, 250, 207, 29);
		panel.add(viewCourseButton);

		JButton viewStudentButton = new JButton("   View Student");
		ImageIcon studentIcon = new ImageIcon(MainDashboard.class.getResource("/images/graduate.png"));
		studentIcon = new ImageIcon(cd.scaleImage(studentIcon, 25, 25));
		viewStudentButton.setIcon(studentIcon);
		viewStudentButton.setBorderPainted(false);
		viewStudentButton.setBounds(0, 285, 207, 29);
		panel.add(viewStudentButton);
		JLabel roleS = new JLabel("");
		roleS.setBounds(106, 56, 61, 16);
		panel.add(roleS);
		String role = cd.makeCapital(user.getRole());
		roleS.setText(role);
		ImageIcon settingsImage = new ImageIcon(MainDashboard.class.getResource("/images/185096_settings_icon.png"));
		settingsImage = new ImageIcon(cd.scaleImage(settingsImage, 25, 25));
		settingButton.setIcon(settingsImage);
		JPanel dashboardPannel = new JPanel();
		layeredPane.add(dashboardPannel, "name_332999382465792");
		dashboardPannel.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setBounds(166, 5, 177, 43);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		dashboardPannel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(6, 170, 162, 149);
		dashboardPannel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(MainDashboard.class.getResource("/images/teacherIcon.png")));
		lblNewLabel_10.setBounds(49, 32, 76, 68);
		panel_1.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Total Teacher");
		lblNewLabel_11.setBounds(33, 20, 102, 16);
		panel_1.add(lblNewLabel_11);

		JLabel totalTeacherLabel = new JLabel("32");
		totalTeacherLabel.setForeground(new Color(255, 38, 0));
		totalTeacherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalTeacherLabel.setFont(new Font("Lao Sangam MN", Font.BOLD, 32));
		totalTeacherLabel.setBounds(45, 91, 61, 52);
		panel_1.add(totalTeacherLabel);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(180, 170, 162, 149);
		dashboardPannel.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_11_1 = new JLabel("Total Student");
		lblNewLabel_11_1.setBounds(35, 17, 102, 16);
		panel_1_1.add(lblNewLabel_11_1);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(MainDashboard.class.getResource("/images/3099383_student_man_icon.png")));
		lblNewLabel_12.setBounds(55, 35, 61, 58);
		panel_1_1.add(lblNewLabel_12);

		JLabel totalStudentlabel = new JLabel("32");
		totalStudentlabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalStudentlabel.setForeground(new Color(147, 32, 146));
		totalStudentlabel.setFont(new Font("Lao Sangam MN", Font.BOLD, 32));
		totalStudentlabel.setBounds(55, 91, 61, 52);
		panel_1_1.add(totalStudentlabel);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1_1.setBounds(354, 170, 162, 149);
		dashboardPannel.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);

		JLabel lblNewLabel_11_1_1 = new JLabel("Total Courses");
		lblNewLabel_11_1_1.setBounds(33, 16, 102, 16);
		panel_1_1_1.add(lblNewLabel_11_1_1);

		JLabel imageCourse = new JLabel("");
		imageCourse.setIcon(new ImageIcon(
				MainDashboard.class.getResource("/images/5269088_book_education_leisure_library_magazine_icon.png")));
		imageCourse.setBounds(53, 44, 61, 48);
		panel_1_1_1.add(imageCourse);

		JLabel totalCourseLabel = new JLabel("");
		totalCourseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalCourseLabel.setForeground(new Color(255, 146, 0));
		totalCourseLabel.setFont(new Font("Lao Sangam MN", Font.BOLD, 32));
		totalCourseLabel.setBounds(53, 91, 61, 52);
		panel_1_1_1.add(totalCourseLabel);

		JLabel lblNewLabel_9 = new JLabel("Welcome");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(6, 93, 177, 50);
		dashboardPannel.add(lblNewLabel_9);

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
				ViewProgess vp = new ViewProgess();
				vp.setVisible(true);
			}
		});

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
				cd.changePassword(user, newPassword, cPassword, oldPassword);
				passwordField.setText("");
				newPasswordField.setText("");
				cPasswordfield.setText("");	

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
				TotalData newData = cd.totalUsers();
				data = newData;
				totalTeacher = String.valueOf(data.totalTeacher);
				totalStudent = String.valueOf(data.totalStudent);
				totalCourse = String.valueOf(data.totalCourse);
				totalStudentlabel.setText(totalStudent);
				totalTeacherLabel.setText(totalTeacher);
				totalCourseLabel.setText(totalCourse);

			}
		});
		DefaultTableModel viewTeacherModel = null;
		viewTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.changePanne(layeredPane, teacherPannel);
				cd.viewData(table, "teacher", viewTeacherModel);

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
		DefaultTableModel courseModel = null;
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
				cd.addUser("teacher");
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.editData();
			}
		});
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cd.addCourse();
			}
		});
		editCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.editCourse();

			}
		});
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.deleteCourse();
			}
		});
		DefaultTableModel viewStudentmodel = null;

		viewStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.changePanne(layeredPane, viewStudentPanel);
				cd.viewData(studentTable, "student", viewStudentmodel);
			}
		});
		addStudentReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.addStudentReport();
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
		if (user.getRole().equals("teacher")) {
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
		totalStudentlabel.setText(totalStudent);
		totalTeacherLabel.setText(totalTeacher);
		totalCourseLabel.setText(totalCourse);
		JLabel lblNewLabel_13 = new JLabel("@copyrights herald college kathmandu");
		lblNewLabel_13.setFont(new Font("Apple LiSung", Font.PLAIN, 10));
		lblNewLabel_13.setBounds(378, 458, 162, 16);
		dashboardPannel.add(lblNewLabel_13);
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